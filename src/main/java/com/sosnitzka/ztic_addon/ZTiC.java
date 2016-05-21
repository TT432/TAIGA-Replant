package com.sosnitzka.ztic_addon;

import com.google.common.collect.Lists;
import com.sosnitzka.ztic_addon.proxy.ServerProxy;
import com.sosnitzka.ztic_addon.recipes.Crafting;
import com.sosnitzka.ztic_addon.recipes.Smelting;
import com.sosnitzka.ztic_addon.util.FuelHandler;
import com.sosnitzka.ztic_addon.util.traits.TraitInstable;
import com.sosnitzka.ztic_addon.util.traits.TraitResonance;
import com.sosnitzka.ztic_addon.world.ZWorldGen;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerMaterials;

import java.util.List;

import static com.sosnitzka.ztic_addon.Fluids.*;
import static com.sosnitzka.ztic_addon.Materials.*;
import static com.sosnitzka.ztic_addon.util.Utils.registerTinkerAlloys;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = ZTiC.MODID, version = ZTiC.VERSION)
public class ZTiC {

    public static final int TITANITE = 5;
    public static final int METEORITE = 6;
    public static final int VIBRANIUM = 7;
    public static final int ADAMANTITE = 8;
    public static final AbstractTrait instable = new TraitInstable();
    public static final AbstractTrait resonance = new TraitResonance();
    static final String MODID = "ztic_addon";
    static final String VERSION = "@VERSION@";
    @SidedProxy(clientSide = "com.sosnitzka.ztic_addon.proxy.ClientProxy", serverSide = "com.sosnitzka.ztic_addon.proxy.ServerProxy")
    private static ServerProxy proxy;
    private List<MaterialIntegration> integrateList = Lists.newArrayList();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Items.register();
        Blocks.register();
        Fluids.register();
        Fluids.registerToo();

        // TConstruct Alloys
        registerTinkerAlloys(astriumFluid, 1, arcaniteFluid, 3, karmesineFluid, 2);
        registerTinkerAlloys(nitroniteFluid, 1, tiberiumFluid, 5, vibraniumFluid, 3);
        registerTinkerAlloys(proxideumFluid, 1, prometheumFluid, 3, violiumFluid, 2);
        registerTinkerAlloys(noctunyxFluid, 1, rubiumFluid, 3, meteoriteFluid, 2);
        registerTinkerAlloys(imperomiteFluid, 2, titaniteFluid, 3, prometheumFluid, 3);
        registerTinkerAlloys(cryptogenFluid, 1, meteoriteFluid, 3, mythrilFluid, 2);
        registerTinkerAlloys(fractoryteFluid, 1, adamantiteFluid, 4, arcaniteFluid, 2);
        registerTinkerAlloys(seismodiumFluid, 1, vibraniumFluid, 4, palladiumFluid, 4);
        registerTinkerAlloys(terramiteFluid, 2, violiumFluid, 4, eterniteFluid, 2);
        registerTinkerAlloys(lumixylFluid, 1, bismuthFluid, 3, rubiumFluid, 2);
        registerTinkerAlloys(solariumFluid, 1, karmesineFluid, 3, ignititeFluid, 2);
        registerTinkerAlloys(dyoniteFluid, 1, mindoriteFluid, 4, tiberiumFluid, 2);
        registerTinkerAlloys(ultraniteFluid, 1, ignititeFluid, 5, adamantiteFluid, 3);
        registerTinkerAlloys(nucleumFluid, 1, palladiumFluid, 3, mindoriteFluid, 3);
        registerTinkerAlloys(aegisaltFluid, 1, eterniteFluid, 3, titaniteFluid, 3);
        registerTinkerAlloys(bysmuidFluid, 1, mythrilFluid, 4, bismuthFluid, 2);

        // # Head Durability, Speed, Attack, Modifier, Handle Durability, Extra Durability
        // ARCANE ORES
        registerTinkerMaterial("Prometheum", prometheum, prometheumFluid, 355, 3.6f, 3.8f, 0.9f, 50, 50, COBALT, false, true);
        registerTinkerMaterial("Rubium", rubium, rubiumFluid, 555, 3.5f, 6, 1.1f, -50, 50, TITANITE, false, true);
        registerTinkerMaterial("Tiberium", tiberium, tiberiumFluid, 100, 7.2f, 5f, 0.7f, 0, 100, METEORITE, true, false);
        registerTinkerMaterial("Arcanite", arcanite, arcaniteFluid, 600, 4.3f, 3.3f, 0.8f, 150, -150, VIBRANIUM, false, true);
        // SOLIDE ORES
        registerTinkerMaterial("Titanite", titanite, titaniteFluid, 1000, 4.3f, 4.5f, 1f, 0, 100, TITANITE, false, true);
        registerTinkerMaterial("Meteorite", meteorite, meteoriteFluid, 1100, 4.7f, 5f, 0.9f, -150, 50, METEORITE, false, true);
        registerTinkerMaterial("Vibranium", vibranium, vibraniumFluid, 1200, 6.1f, 6f, 0.8f, 150, 150, VIBRANIUM, false, true);
        registerTinkerMaterial("Adamantite", adamantite, adamantiteFluid, 1350, 8.5f, 7.3f, 1f, 150, 50, ADAMANTITE, false, true);
        // ETHERE ORES
        registerTinkerMaterial("Eternite", eternite, eterniteFluid, 450, 4.1f, 1f, 1.1f, -100, 200, COBALT, false, true);
        registerTinkerMaterial("Mythril", mythril, mythrilFluid, 560, 4.3f, 1.2f, 0.95f, 50, 150, TITANITE, false, true);
        registerTinkerMaterial("Palladium", palladium, palladiumFluid, 500, 4f, 2.5f, 0.9f, -50, 250, METEORITE, false, true);
        registerTinkerMaterial("Ignitite", ignitite, ignititeFluid, 550, 3.8f, 5.4f, 1.1f, -100, 300, VIBRANIUM, false, true);
        // RATIO ORES
        registerTinkerMaterial("Violium", violium, violiumFluid, 435, 2.8f, 4f, 0.75f, 200, 100, COBALT, false, true);
        registerTinkerMaterial("Bismuth", bismuth, bismuthFluid, 125, 1.8f, 7f, 0.9f, -50, 350, TITANITE, false, true);
        registerTinkerMaterial("Mindorite", mindorite, mindoriteFluid, 475, 3.3f, 3.3f, 0.8f, 110, 100, METEORITE, false, true);
        registerTinkerMaterial("Karmesine", karmesine, karmesineFluid, 650, 5, 6, 0.8f, 25, 100, VIBRANIUM, false, true);

        // Material from alloys
        registerTinkerMaterial("Astrium", astrium, astriumFluid, 600, 5, 6, 0.8f, 0, 100, ADAMANTITE, false, true);
        registerTinkerMaterial("Nitronite", nitronite, nitroniteFluid, 1, 5, 6, 0.8f, 0, 100, VIBRANIUM, false, true);
        registerTinkerMaterial("Proxideum", proxideum, proxideumFluid, 1, 5, 6, 0.8f, 0, 100, METEORITE, false, true);
        registerTinkerMaterial("Noctunyx", noctunyx, noctunyxFluid, 1, 5, 6, 0.8f, 0, 100, COBALT, false, true);
        registerTinkerMaterial("Imperomite", imperomite, imperomiteFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Cryptogen", cryptogen, cryptogenFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Fractoryte", fractoryte, fractoryteFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Seismodium", seismodium, seismodiumFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Terramite", terramite, terramiteFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Lumixyl", lumixyl, lumixylFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Solarium", solarium, solariumFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Ultranite", ultranite, ultraniteFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Nucleum", nucleum, nucleumFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Aegisalt", aegisalt, aegisaltFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Bysmuid", bysmuid, bysmuidFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
        registerTinkerMaterial("Dyonite", dyonite, dyoniteFluid, 1, 5, 6, 0.8f, 0, 100, OBSIDIAN, false, true);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerStuff();
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100);
        GameRegistry.registerFuelHandler(new FuelHandler());
        Smelting.register();
        Crafting.register();

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

    private void registerTinkerMaterial(String oreSuffix, slimeknights.tconstruct.library.materials.Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, boolean craft, boolean cast) {
        TinkerRegistry.addMaterialStats(material, new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel));
        TinkerRegistry.addMaterialStats(material, new HandleMaterialStats(handleMod, handleDura));
        TinkerRegistry.addMaterialStats(material, new ExtraMaterialStats(extra));
        material.setFluid(fluid).setCraftable(craft).setCastable(cast);
        if (material.isCraftable()) {
            material.addItem(Blocks.tiberiumBlock, Material.VALUE_Block);
            material.setRepresentativeItem(Blocks.tiberiumBlock);
        }

        proxy.setRenderInfo(material, fluid);
        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        integrateList.add(integration);

    }
}