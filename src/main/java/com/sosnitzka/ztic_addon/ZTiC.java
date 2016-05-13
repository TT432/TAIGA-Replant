package com.sosnitzka.ztic_addon;

import com.google.common.collect.Lists;
import com.sosnitzka.ztic_addon.proxy.ClientProxy;
import com.sosnitzka.ztic_addon.recipes.Crafting;
import com.sosnitzka.ztic_addon.recipes.Smelting;
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
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

import java.util.List;

import static com.sosnitzka.ztic_addon.Fluids.*;
import static com.sosnitzka.ztic_addon.Materials.*;
import static com.sosnitzka.ztic_addon.util.Utils.registerTinkerAlloys;

@Mod(modid = ZTiC.MODID, version = ZTiC.VERSION)
public class ZTiC {

    static final String MODID = "ztic_addon";
    static final String VERSION = "@VERSION@";

    @SidedProxy(clientSide = "com.sosnitzka.ztic_addon.proxy.ClientProxy", serverSide = "com.sosnitzka.ztic_addon.proxy.ServerProxy")
    private static ClientProxy proxy;
    private List<MaterialIntegration> integrateList = Lists.newArrayList();

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Items.register();
        Blocks.register();
        Fluids.register();

        // TConstruct Alloys
        registerTinkerAlloys(astriumFluid, 1, arcaniteFluid, 3, karmesineFluid, 2);
        registerTinkerAlloys(instableNitroniteFluid, 1, tiberiumFluid, 5, vibraniumFluid, 3);
        registerTinkerAlloys(proxideumFluid, 1, prometheumFluid, 3, axiidianFluid, 2);
        registerTinkerAlloys(instablePolyniumFluid, 1, yrdeanFluid, 3, meteoriteFluid, 2);
        registerTinkerAlloys(imperomiteFluid, 2, aardiumFluid, 3, prometheumFluid, 3);
        registerTinkerAlloys(cryptogenFluid, 1, meteoriteFluid, 3, mythrilFluid, 2);
        registerTinkerAlloys(fractoryteFluid, 1, adamantiteFluid, 4, arcaniteFluid, 2);
        registerTinkerAlloys(seismodiumFluid, 1, vibraniumFluid, 4, palladiumFluid, 4);
        registerTinkerAlloys(terramiteFluid, 2, axiidianFluid, 4, eterniteFluid, 2);
        registerTinkerAlloys(instablePrysociteFluid, 1, bismuthFluid, 3, yrdeanFluid, 2);
        registerTinkerAlloys(blazingXylititeFluid, 1, karmesineFluid, 3, ignititeFluid, 2);
        registerTinkerAlloys(instableDyoniteFluid, 1, mindoriteFluid, 4, tiberiumFluid, 2);
        registerTinkerAlloys(ultraniteFluid, 1, ignititeFluid, 5, adamantiteFluid, 3);
        registerTinkerAlloys(radiantPliniumFluid, 1, palladiumFluid, 3, mindoriteFluid, 3);
        registerTinkerAlloys(dysprosaniumFluid, 1, eterniteFluid, 3, aardiumFluid, 3);
        registerTinkerAlloys(refractiveBysmuidFluid, 1, mythrilFluid, 4, bismuthFluid, 2);


        // Material from ores
        registerTinkerMaterial("Arcanite", arcanite, arcaniteFluid, 1, 5, 6, 7, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Tiberium", tiberium, tiberiumFluid, 1, 5, 6, 6, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Prometheum", prometheum, prometheumFluid, 1, 5, 6, 5, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Yrdean", yrdean, yrdeanFluid, 1, 5, 6, 4, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Axiidian", axiidian, axiidianFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Bismuth", bismuth, bismuthFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Karmesine", karmesine, karmesineFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Mindorite", mindorite, mindoriteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Aardium", aardium, aardiumFluid, 1, 5, 6, 3, 0.8f, 0, 100, true, true);
        registerTinkerMaterial("Meteorite", meteorite, meteoriteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Adamantite", adamantite, adamantiteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Vibranium", vibranium, vibraniumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Ignitite", ignitite, ignititeFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Palladium", palladium, palladiumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Eternite", eternite, eterniteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Mythril", mythril, mythrilFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);

        // Material from alloys
        registerTinkerMaterial("Astrium", astrium, astriumFluid, 1, 5, 6, 7, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstableNitronite", instableNitronite, instableNitroniteFluid, 1, 5, 6, 6, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Proxideum", proxideum, proxideumFluid, 1, 5, 6, 5, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstablePolynium", instablePolynium, instablePolyniumFluid, 1, 5, 6, 4, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Imperomite", imperomite, imperomiteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Cryptogen", cryptogen, cryptogenFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Fractoryte", fractoryte, fractoryteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Seismodium", seismodium, seismodiumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Terramite", terramite, terramiteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstablePrysocite", instablePrysocite, instablePrysociteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("BlazingXylitite", blazingXylitite, blazingXylititeFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Ultranite", ultranite, ultraniteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("RadiantPlinium", radiantPlinium, radiantPliniumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Dysprosanium", dysprosanium, dysprosaniumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("RefractiveBysmuid", refractiveBysmuid, refractiveBysmuidFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("InstableDyonite", instableDyonite, instableDyoniteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100);
        GameRegistry.registerFuelHandler(new FuelHandler());
        Smelting.register();
        Crafting.register();

        for (MaterialIntegration m : integrateList) {
            m.integrateRecipes();
        }
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }

    private void registerTinkerMaterial(String name, slimeknights.tconstruct.library.materials.Material material, Fluid fluid, int headDura, int headSpeed, int headAttack, int headLevel, float handleMod, int handleDura, int extra, boolean craft, boolean cast) {
        material.addStats(new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel)).addStats(new HandleMaterialStats(handleMod, handleDura)).addStats(new ExtraMaterialStats(extra)).setFluid(fluid).setCraftable(craft).setCastable(cast).setRenderInfo(fluid.getColor());
        MaterialIntegration integration = new MaterialIntegration(material, fluid, name);
        integration.integrate();
        integrateList.add(integration);
    }
}