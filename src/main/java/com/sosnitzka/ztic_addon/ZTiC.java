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
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.tools.TinkerMaterials;

import java.util.List;

import static com.sosnitzka.ztic_addon.Fluids.*;
import static com.sosnitzka.ztic_addon.Materials.*;
import static com.sosnitzka.ztic_addon.util.Utils.registerTinkerAlloys;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = ZTiC.MODID, version = ZTiC.VERSION)
public class ZTiC {

    public static final int METEORITE = 5;
    public static final int VIBRANIUM = 6;
    public static final int ADAMANTITE = 7;
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


        // Material from ores
        registerTinkerMaterial("Arcanite", arcanite, arcaniteFluid, 1, 5, 6, ADAMANTITE, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Tiberium", tiberium, tiberiumFluid, 1, 5, 6, VIBRANIUM, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Prometheum", prometheum, prometheumFluid, 1, 5, 6, METEORITE, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Rubium", rubium, rubiumFluid, 1, 5, 6, COBALT, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Violium", violium, violiumFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Bismuth", bismuth, bismuthFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Karmesine", karmesine, karmesineFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Mindorite", mindorite, mindoriteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Titanite", titanite, titaniteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, true, true);
        registerTinkerMaterial("Meteorite", meteorite, meteoriteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Adamantite", adamantite, adamantiteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Vibranium", vibranium, vibraniumFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Ignitite", ignitite, ignititeFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Palladium", palladium, palladiumFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Eternite", eternite, eterniteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Mythril", mythril, mythrilFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);

        // Material from alloys
        registerTinkerMaterial("Astrium", astrium, astriumFluid, 1, 5, 6, ADAMANTITE, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstableNitronite", nitronite, nitroniteFluid, 1, 5, 6, VIBRANIUM, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Proxideum", proxideum, proxideumFluid, 1, 5, 6, METEORITE, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstableNoctunyx", noctunyx, noctunyxFluid, 1, 5, 6, COBALT, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Imperomite", imperomite, imperomiteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Cryptogen", cryptogen, cryptogenFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Fractoryte", fractoryte, fractoryteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Seismodium", seismodium, seismodiumFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Terramite", terramite, terramiteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstableLumixyl", lumixyl, lumixylFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("BlazingSolarium", solarium, solariumFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Ultranite", ultranite, ultraniteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("RadiantNucleum", nucleum, nucleumFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Aegisalt", aegisalt, aegisaltFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("RefractiveBysmuid", bysmuid, bysmuidFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstableDyonite", dyonite, dyoniteFluid, 1, 5, 6, OBSIDIAN, 0.8f, 0, 100, false, true);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerStuff();
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100);
        GameRegistry.registerFuelHandler(new FuelHandler());
        Smelting.register();
        Crafting.register();

        harvestLevelNames.put(METEORITE, TinkerMaterials.bone.getTextColor() + "Meteorite");
        harvestLevelNames.put(VIBRANIUM, TinkerMaterials.silver.getTextColor() + "Vibranium");
        harvestLevelNames.put(ADAMANTITE, TinkerMaterials.ardite.getTextColor() + "Adamantite");

        for (MaterialIntegration m : integrateList) {
            m.integrateRecipes();
        }
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }

    private void registerTinkerMaterial(String oreSuffix, slimeknights.tconstruct.library.materials.Material material, Fluid fluid, int headDura, int headSpeed, int headAttack, int headLevel, float handleMod, int handleDura, int extra, boolean craft, boolean cast) {
        material.addStats(new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel))
                .addStats(new HandleMaterialStats(handleMod, handleDura))
                .addStats(new ExtraMaterialStats(extra)).setFluid(fluid)
                .setCraftable(craft).setCastable(cast);

        proxy.setRenderInfo(material, fluid);
        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        integrateList.add(integration);
    }
}