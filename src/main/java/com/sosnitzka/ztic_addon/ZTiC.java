package com.sosnitzka.ztic_addon;

import com.google.common.collect.Lists;
import com.sosnitzka.ztic_addon.proxy.ServerProxy;
import com.sosnitzka.ztic_addon.recipes.Crafting;
import com.sosnitzka.ztic_addon.recipes.Smelting;
import com.sosnitzka.ztic_addon.traits.*;
import com.sosnitzka.ztic_addon.util.FuelHandler;
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
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerMaterials;

import java.util.List;

import static com.sosnitzka.ztic_addon.Fluids.*;
import static com.sosnitzka.ztic_addon.Materials.*;
import static com.sosnitzka.ztic_addon.Materials.arcanite;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = ZTiC.MODID, version = ZTiC.VERSION)
public class ZTiC {

    public static final int TITANITE = 5;
    public static final int METEORITE = 6;
    public static final int VIBRANIUM = 7;
    public static final int ADAMANTITE = 8;
    public static final AbstractTrait instable = new TraitInstable();
    public static final AbstractTrait naturebound = new TraitNatureBound();
    public static final AbstractTrait uncertain = new TraitUncertain();
    public static final AbstractTrait softy = new TraitSofty();
    public static final AbstractTrait curvature = new TraitCurvature();
    public static final AbstractTrait resonance = new TraitResonance();
    public static final AbstractTrait fracture = new TraitFracture();
    public static final AbstractTrait glimmer = new TraitGlimmer();
    public static final AbstractTrait garishly = new TraitGarishly();
    public static final AbstractTrait pulverizing = new TraitPulverizing();
    public static final AbstractTrait analysing = new TraitAnalysing();
    public static final AbstractTrait cascade = new TraitCascade();
    public static final AbstractTrait blind = new TraitBlind();
    public static final AbstractTrait dark = new TraitDark();
    public static final AbstractTrait bright = new TraitBright();
    public static final AbstractTrait slaughtering = new TraitSlaughtering();
    public static final AbstractTrait haunted = new TraitHaunted();
    public static final AbstractTrait fragile = new TraitFragile();
    public static final AbstractTrait dissolving = new TraitDissolving();
    public static final AbstractTrait bentonite = new TraitBentonite();
    public static final AbstractTrait arcane = new TraitArcane();
    public static final AbstractTrait heroic = new TraitHeroic();
    public static final AbstractTrait hollow = new TraitHollow();
    public static final AbstractTrait diffuse = new TraitDiffuse();
    public static final AbstractTrait randomize = new TraitRandomize();

    public static final String MODID = "ztic_addon";
    public static final String VERSION = "@VERSION@";
    @SidedProxy(clientSide = "com.sosnitzka.ztic_addon.proxy.ClientProxy", serverSide = "com.sosnitzka.ztic_addon.proxy.ServerProxy")
    public static ServerProxy proxy;
    private List<MaterialIntegration> integrateList = Lists.newArrayList();


    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Items.register();
        Fluids.register();
        Blocks.register();
        Fluids.registerfromItem();
        Alloys.register();

        // # Head Durability, Speed, Attack, Modifier, Handle Durability, Extra Durability

        // ARCANE ORES
        registerTinkerMaterial("Tiberium", tiberium, tiberiumFluid, 223, 6.2f, 8.35f, 0.63f, 50, 50, OBSIDIAN, false, true);
        registerTinkerMaterial("Rubium", rubium, rubiumFluid, 351, 5.15f, 7.00f, 1.05f, -100, 250, COBALT, false, true);
        registerTinkerMaterial("Prometheum", prometheum, prometheumFluid, 539, 3.6f, 6.60f, 0.90f, 0, 150, TITANITE, false, true);
        registerTinkerMaterial("Arcanite", arcanite, arcaniteFluid, 698, 4.3f, 7.88f, 0.85f, -50, 150, METEORITE, false, true);
        // SOLIDE ORES
        registerTinkerMaterial("Titanite", titanite, titaniteFluid, 811, 4.8f, 4.00f, 1.00f, -50, 150, TITANITE, false, true);
        registerTinkerMaterial("Meteorite", meteorite, meteoriteFluid, 823, 6.1f, 4.33f, 1.20f, -50, 200, METEORITE, false, true);
        registerTinkerMaterial("Vibranium", vibranium, vibraniumFluid, 917, 7.45f, 5.17f, 1.15f, 50, 150, VIBRANIUM, false, true);
        registerTinkerMaterial("Adamantite", adamantite, adamantiteFluid, 981, 8.9f, 7.00f, 1.20f, -200, 300, ADAMANTITE, false, true);
        // ETHERE ORES
        registerTinkerMaterial("Eternite", eternite, eterniteFluid, 592, 7.35f, 1.95f, 1.10f, 150, 150, COBALT, false, true);
        registerTinkerMaterial("Mythril", mythril, mythrilFluid, 552, 8.75f, 2.87f, 0.98f, -100, 200, TITANITE, false, true);
        registerTinkerMaterial("Palladium", palladium, palladiumFluid, 578, 10.4f, 3.13f, 1.09f, 0, 100, METEORITE, false, true);
        registerTinkerMaterial("Ignitite", ignitite, ignititeFluid, 673, 12.1f, 4.10f, 1.15f, -50, 150, VIBRANIUM, false, true);
        // RATIO ORES
        registerTinkerMaterial("Bismuth", bismuth, bismuthFluid, 235, 5.33f, 3.80f, 1.15f, 17, 117, OBSIDIAN, false, true);
        registerTinkerMaterial("Violium", violium, violiumFluid, 427, 4.2f, 3.30f, 1.00f, 133, 150, COBALT, false, true);
        registerTinkerMaterial("Mindorite", mindorite, mindoriteFluid, 458, 6.41f, 4.40f, 0.90f, 83, 100, TITANITE, false, true);
        registerTinkerMaterial("Karmesine", karmesine, karmesineFluid, 627, 6.75f, 5.10f, 0.99f, 0, 200, METEORITE, false, true);
        // Material from alloys
        registerTinkerMaterial("Nitronite", nitronite, nitroniteFluid, 745, 6.74f, 8.74f, 0.85f, 75, 93, TITANITE, false, true);
        registerTinkerMaterial("Bysmuid", bysmuid, bysmuidFluid, 305, 5.22f, 6.47f, 1.09f, -80, 197, COBALT, false, true);
        registerTinkerMaterial("Ultranite", ultranite, ultraniteFluid, 1016, 5.72f, 6.76f, 1.02f, -120, 210, VIBRANIUM, false, true);
        registerTinkerMaterial("Astrium", astrium, astriumFluid, 670, 5.28f, 9.14f, 0.91f, -45, 170, VIBRANIUM, false, true);
        registerTinkerMaterial("Imperomite", imperomite, imperomiteFluid, 770, 11.60f, 3.57f, 1.05f, -38, 125, METEORITE, false, true);
        registerTinkerMaterial("Dyonite", dyonite, dyoniteFluid, 733, 6.14f, 7.69f, 0.97f, -15, 140, TITANITE, false, true);
        registerTinkerMaterial("Solarium", solarium, solariumFluid, 1020, 13.78f, 4.64f, 1.15f, 0, 150, ADAMANTITE, false, true);
        registerTinkerMaterial("Fractoryte", fractoryte, fractoryteFluid, 1071, 7.65f, 7.75f, 1.15f, -250, 283, METEORITE, false, true);
        registerTinkerMaterial("Aegisalt", aegisalt, aegisaltFluid, 355, 8.88f, 3.18f, 1.00f, 175, 125, TITANITE, false, true);
        registerTinkerMaterial("Noctunyx", noctunyx, noctunyxFluid, 713, 10.43f, 3.25f, 0.99f, -125, 183, METEORITE, false, true);
        registerTinkerMaterial("Nucleum", nucleum, nucleumFluid, 503, 11.30f, 3.22f, 1.05f, 100, 125, TITANITE, false, true);
        registerTinkerMaterial("Seismodium", seismodium, seismodiumFluid, 879, 13.85f, 4.19f, 1.17f, -75, 169, VIBRANIUM, false, true);
        registerTinkerMaterial("Lumixyl", lumixyl, lumixylFluid, 357, 4.64f, 5.92f, 1.05f, 15, 130, COBALT, false, true);
        registerTinkerMaterial("Terramite", terramite, terramiteFluid, 482, 7.25f, 2.85f, 1.03f, 208, 150, TITANITE, false, true);
        registerTinkerMaterial("Cryptogen", cryptogen, cryptogenFluid, 538, 5.71f, 6.93f, 0.88f, 58, 117, METEORITE, false, true);
        registerTinkerMaterial("Proxideum", proxideum, proxideumFluid, 597, 10.55f, 4.21f, 0.99f, -60, 200, METEORITE, false, true);
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
        /*
        if (material.isCraftable()) {
            material.addItem(Blocks.tiberiumBlock, Material.VALUE_Block);
            material.setRepresentativeItem(Blocks.tiberiumBlock);
        }
        */

        proxy.setRenderInfo(material);
        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        integrateList.add(integration);
    }
}