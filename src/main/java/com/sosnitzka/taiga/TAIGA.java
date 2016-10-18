package com.sosnitzka.taiga;

import com.google.common.collect.Lists;
import com.sosnitzka.taiga.proxy.CommonProxy;
import com.sosnitzka.taiga.recipes.CraftingRegistry;
import com.sosnitzka.taiga.recipes.SmeltingRegistry;
import com.sosnitzka.taiga.util.FuelHandler;
import com.sosnitzka.taiga.world.ZWorldGen;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.tools.TinkerMaterials;

import java.lang.reflect.Field;
import java.util.List;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.TAIGAConfiguration.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = TAIGA.MODID, version = TAIGA.VERSION, guiFactory = TAIGA.GUIFACTORY, dependencies = "required-after:tconstruct@[1.10.2-2.5.0,);" + "required-after:mantle@[1.10.2-1.0.0,)")
public class TAIGA {

    public static final String MODID = "taiga";
    public static final String VERSION = "@VERSION@";
    public static final String GUIFACTORY = "com.sosnitzka.taiga.TAIGAGuiFactory";

    @SidedProxy(clientSide = "com.sosnitzka.taiga.proxy.ClientProxy", serverSide = "com.sosnitzka.taiga.proxy.CommonProxy")
    public static CommonProxy proxy;

    private List<MaterialIntegration> integrateList = Lists.newArrayList(); // List of materials needed to be integrated

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.initConfig();

        Items.register(); // Registers items and its oreDict
        Blocks.register(); // Registers blocks and its items form a long with its oreDict
        Fluids.register(); // Registers all fluids and its buckets
        Fluids.registerfromItem(); // Registers some special smeltery recipes (not alloying)
        Alloys.register(); // Registers alloying recipes

        registerTinkerMaterials(); // Registers materials and associated fluids and stats into tconstruct
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerModels(); // Registers models on the client side
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100); // Generates ores
        GameRegistry.registerFuelHandler(new FuelHandler()); // Registeres fuels' burn times
        SmeltingRegistry.register(); // Registers smelting recipes
        CraftingRegistry.register(); // Registers crafting recipes

        // Adds new harvest levels' names
        harvestLevelNames.put(METEORITE, TinkerMaterials.bone.getTextColor() + "Meteorite");
        harvestLevelNames.put(VIBRANIUM, TinkerMaterials.blueslime.getTextColor() + "Vibranium");
        harvestLevelNames.put(ADAMANTITE, TinkerMaterials.ardite.getTextColor() + "Adamantite");
        harvestLevelNames.put(TITANITE, TinkerMaterials.silver.getTextColor() + "Titanite");

        for (MaterialIntegration m : integrateList) {
            m.integrateRecipes();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }

    /**
     * @param oreSuffix  Suffix in the oreDict, also the name. ex) the "Iron" in "ingotIron"
     * @param material   TConstruct material
     * @param fluid      material's fluid
     * @param headDura   Durability (head)
     * @param headSpeed  Mining speed (head)
     * @param headAttack Attack speed (head)
     * @param handleMod  Durability multiplier (handle)
     * @param handleDura Extra durability (handle)
     * @param extra      Extra durability (binding and more)
     * @param headLevel  Mining level (head)
     * @param craft      Can craft parts in part builder
     * @param cast       Can craft parts by casting with fluid (smeltery)
     */
    private void registerTinkerMaterial(String oreSuffix, Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, boolean craft, boolean cast) {
        TinkerRegistry.addMaterialStats(material, new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel));
        TinkerRegistry.addMaterialStats(material, new HandleMaterialStats(handleMod, handleDura));
        TinkerRegistry.addMaterialStats(material, new ExtraMaterialStats(extra));

        Item item = null;
        Field[] items = Items.class.getDeclaredFields();
        for (Field i : items) {
            if (i.getName().equals(StringUtils.uncapitalize(oreSuffix) + "Ingot")) {
                Item r = null;
                try {
                    r = (Item) i.get(i.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                item = r;
            }
        }

        material.setFluid(fluid).setCraftable(craft).setCastable(cast).addItem(item, 1, Material.VALUE_Ingot);
        material.setRepresentativeItem(item);

        proxy.setRenderInfo(material);
        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        integrateList.add(integration);
    }


    /**
     * Registers materials and associated fluids and stats into tconstruct
     */
    private void registerTinkerMaterials() {

        double d = durabilityFactorGeneral;
        System.out.println("Durability=" + d);
        float s = (float) speedFactorGeneral;
        System.out.println("Speed=" + s);
        float a = (float) attackFactorGeneral;
        System.out.println("Attack=" + a);

        // ARCANE ORES
        registerTinkerMaterial("Tiberium", tiberium, tiberiumFluid, (int) (223 * d), 6.2f * s, 8.35f * a, 0.63f, 50, 50, OBSIDIAN, false, true);
        registerTinkerMaterial("Rubium", rubium, rubiumFluid, (int) (351 * d), 5.15f * s, 7.00f * a, 1.05f, -100, 250, COBALT, false, true);
        registerTinkerMaterial("Prometheum", prometheum, prometheumFluid, (int) (539 * d), 3.6f * s, 6.60f, 0.90f, 0, 150, TITANITE, false, true);
        registerTinkerMaterial("Arcanite", arcanite, arcaniteFluid, (int) (698 * d), 4.3f * s, 7.88f * a, 0.85f, -50, 150, METEORITE, false, true);
        // SOLIDE ORES
        registerTinkerMaterial("Titanite", titanite, titaniteFluid, (int) (811 * d), 4.8f * s, 6.40f * a, 1.00f, -50, 150, TITANITE, false, true);
        registerTinkerMaterial("Meteorite", meteorite, meteoriteFluid, (int) (823 * d), 6.1f * s, 6.83f * a, 1.20f, -50, 200, METEORITE, false, true);
        registerTinkerMaterial("Vibranium", vibranium, vibraniumFluid, (int) (917 * d), 7.45f * s, 7.17f * a, 1.15f, 50, 150, VIBRANIUM, false, true);
        registerTinkerMaterial("Adamantite", adamantite, adamantiteFluid, (int) (981 * d), 8.9f * s, 9.11f * a, 1.20f, -200, 300, ADAMANTITE, false, true);
        // ETHERE ORES
        registerTinkerMaterial("Eternite", eternite, eterniteFluid, (int) (592 * d), 7.35f * s, 1.95f * a, 1.10f, 150, 150, COBALT, false, true);
        registerTinkerMaterial("Mythril", mythril, mythrilFluid, (int) (552 * d), 8.75f * s, 2.87f * a, 0.98f, -100, 200, TITANITE, false, true);
        registerTinkerMaterial("Palladium", palladium, palladiumFluid, (int) (578 * d), 10.4f * s, 3.13f * a, 1.09f, 0, 100, METEORITE, false, true);
        registerTinkerMaterial("Ignitite", ignitite, ignititeFluid, (int) (673 * d), 12.1f * s, 4.10f * a, 1.15f, -50, 150, VIBRANIUM, false, true);
        // RATIO ORES
        registerTinkerMaterial("Bismuth", bismuth, bismuthFluid, (int) (235 * d), 5.33f * s, 3.80f * a, 1.15f, 17, 117, OBSIDIAN, false, true);
        registerTinkerMaterial("Violium", violium, violiumFluid, (int) (427 * d), 4.2f * s, 3.30f * a, 1.00f, 133, 150, COBALT, false, true);
        registerTinkerMaterial("Mindorite", mindorite, mindoriteFluid, (int) (458 * d), 6.41f * s, 4.40f * a, 0.90f, 83, 100, TITANITE, false, true);
        registerTinkerMaterial("Karmesine", karmesine, karmesineFluid, (int) (627 * d), 6.75f * s, 5.10f * a, 0.99f, 0, 200, METEORITE, false, true);
        // Material from alloys
        registerTinkerMaterial("Nitronite", nitronite, nitroniteFluid, (int) (745 * d), 6.74f * s, 8.74f * a, 0.85f, 75, 93, TITANITE, false, true);
        registerTinkerMaterial("Bysmuid", bysmuid, bysmuidFluid, (int) (305 * d), 5.22f * s, 6.47f * a, 1.09f, -80, 197, COBALT, false, true);
        registerTinkerMaterial("Ultranite", ultranite, ultraniteFluid, (int) (1016 * d), 5.72f * s, 6.76f * a, 1.02f, -120, 210, VIBRANIUM, false, true);
        registerTinkerMaterial("Astrium", astrium, astriumFluid, (int) (670 * d), 5.28f * s, 9.14f * a, 0.91f, -45, 170, VIBRANIUM, false, true);
        registerTinkerMaterial("Imperomite", imperomite, imperomiteFluid, (int) (770 * d), 11.60f * s, 3.57f * a, 1.05f, -38, 125, METEORITE, false, true);
        registerTinkerMaterial("Dyonite", dyonite, dyoniteFluid, (int) (733 * d), 6.14f * s, 7.69f * a, 0.97f, -15, 140, TITANITE, false, true);
        registerTinkerMaterial("Solarium", solarium, solariumFluid, (int) (1020 * d), 13.78f * s, 4.64f * a, 1.15f, 0, 150, ADAMANTITE, false, true);
        registerTinkerMaterial("Fractoryte", fractoryte, fractoryteFluid, (int) (1071 * d), 7.65f * s, 7.75f * a, 1.15f, -250, 283, METEORITE, false, true);
        registerTinkerMaterial("Aegisalt", aegisalt, aegisaltFluid, (int) (355 * d), 8.88f * s, 3.18f * a, 1.00f, 175, 125, TITANITE, false, true);
        registerTinkerMaterial("Noctunyx", noctunyx, noctunyxFluid, (int) (713 * d), 10.43f * s, 3.25f * a, 0.99f, -125, 183, METEORITE, false, true);
        registerTinkerMaterial("Nucleum", nucleum, nucleumFluid, (int) (503 * d), 11.30f * s, 3.22f * a, 1.05f, 100, 125, TITANITE, false, true);
        registerTinkerMaterial("Seismodium", seismodium, seismodiumFluid, (int) (879 * d), 13.85f * s, 4.19f * a, 1.17f, -75, 169, VIBRANIUM, false, true);
        registerTinkerMaterial("Lumixyl", lumixyl, lumixylFluid, (int) (357 * d), 4.64f * s, 5.92f * a, 1.05f, 15, 130, COBALT, false, true);
        registerTinkerMaterial("Terramite", terramite, terramiteFluid, (int) (482 * d), 7.25f * s, 2.85f * a, 1.03f, 208, 150, TITANITE, false, true);
        registerTinkerMaterial("Cryptogen", cryptogen, cryptogenFluid, (int) (538 * d), 5.71f * s, 6.93f * a, 0.88f, 58, 117, METEORITE, false, true);
        registerTinkerMaterial("Proxideum", proxideum, proxideumFluid, (int) (597 * d), 10.55f * s, 4.21f * a, 0.99f, -60, 200, METEORITE, false, true);
    }
}