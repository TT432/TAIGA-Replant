package com.sosnitzka.taiga;

import com.google.common.collect.Lists;
import com.sosnitzka.taiga.proxy.CommonProxy;
import com.sosnitzka.taiga.recipes.CraftingRegistry;
import com.sosnitzka.taiga.recipes.SmeltingRegistry;
import com.sosnitzka.taiga.world.WorldGen;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.BowMaterialStats;

import java.util.List;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.util.Utils.integrateMaterial;
import static com.sosnitzka.taiga.util.Utils.integrateOre;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

@Mod(modid = TAIGA.MODID, version = TAIGA.VERSION, guiFactory = TAIGA.GUIFACTORY, dependencies =
        "required-after:tconstruct@[1.10.2-2.5.0,);" + "required-after:mantle@[1.10.2-1.0.0,)")
public class TAIGA {

    public static final String MODID = "taiga";
    public static final String VERSION = "@VERSION@";
    public static final String GUIFACTORY = "com.sosnitzka.taiga.TAIGAGuiFactory";
    public static Logger logger;

    @SidedProxy(clientSide = "com.sosnitzka.taiga.proxy.ClientProxy", serverSide = "com.sosnitzka.taiga.proxy" +
            ".CommonProxy")
    public static CommonProxy proxy;

    public static List<MaterialIntegration> integrateList = Lists.newArrayList(); // List of materials needed to be integrated

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        logger = e.getModLog();

        Fluids.register();
        Blocks.register(false);
        Blocks.registerItems();
        Items.register();

        proxy.initConfig();

        registerTinkerMaterials();
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.registerModels(); // Registers models on the client side

        Fluids.registerfromItem(); // Registers some special smeltery recipes (not alloying)
        GameRegistry.registerWorldGenerator(WorldGen.getInstance(), 100); // Generates ores
        // GameRegistry.registerFuelHandler(new FuelHandler());  Registeres fuels' burn times

        // Adds new harvest levels' names
        harvestLevelNames.put(DURANITE, TextFormatting.DARK_GREEN + "Duranite");
        harvestLevelNames.put(VALYRIUM, TextFormatting.GOLD + "Valyrium");
        harvestLevelNames.put(VIBRANIUM, TextFormatting.DARK_PURPLE + "Vibranium");

        Blocks.register(true);

        Alloys.register(); // Registers alloying recipes
        registerTinkerMaterials(); // Registers materials and associated fluids and stats into tconstruct

        SmeltingRegistry.register(); // Registers smelting recipes
        CraftingRegistry.register(); // Registers crafting recipes

        for (MaterialIntegration m : integrateList) {
            m.integrate();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.registerBookPages();
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        proxy.registerServerCommands(event);
    }


    /**
     * Registers materials and associated fluids and stats into tconstruct
     */
    private void registerTinkerMaterials() {
        BowMaterialStats shitty = new BowMaterialStats(0.2f, 0.4f, -1f);
//
        integrateMaterial("Tiberium", tiberium, tiberiumFluid, 80, 3.3f, 4f, 0.7f, -25, 50, DIAMOND, shitty, true, false);
        integrateMaterial("Aurorium", aurorium, auroriumFluid, 750, 3.6f, 3.78f, 0.77f, 25, 130, COBALT, 0.45f, 1f, 1);
        integrateMaterial("Prometheum", prometheum, prometheumFluid, 844, 4.75f, 6.6f, 1.2f, 25, 50, DURANITE, 0.2f, 0.6f, 3);
        integrateMaterial("Duranite", duranite, duraniteFluid, 1550, 3.2f, 3.2f, 1.16f, 100, 100, DURANITE, 0.3f, 1.4f, 2);
        integrateMaterial("Valyrium", valyrium, valyriumFluid, 1111, 5.37f, 4.8f, 1.30f, 100, 100, VALYRIUM, 1.1f, 1.2f, 4);
        integrateMaterial("Vibranium", vibranium, vibraniumFluid, 1235, 7.62f, 8.1f, 1.3f, 100, 100, VIBRANIUM, 1.1f, 1.8f, 4);
        integrateMaterial("Terrax", terrax, terraxFluid, 444, 4.77f, 2.9f, 0.8f, 100, 50, COBALT, shitty, true, true);
        integrateMaterial("Palladium", palladium, palladiumFluid, 797, 4.35f, 6.8f, 1.3f, 130, -50, DURANITE, .5f, .2f, 3);
        integrateMaterial("Uru", uru, uruFluid, 877, 2f, 7.2f, 1.5f, -50, 175, VALYRIUM, 1.3f, 0.8f, 6);
        integrateMaterial("Eezo", eezo, eezoFluid, 50, 23f, 3.5f, .1f, 10, 10, COBALT, shitty, true, false);
        integrateMaterial("Basalt", basalt, basaltFluid, 200, 3, 2.5f, 0.5f, -25, 25, STONE, shitty, true, false);
        integrateMaterial("Triberium", triberium, triberiumFluid, 223, 6.2f, 8.35f, 0.63f, 50, 50, DIAMOND, shitty, true, true);
        integrateMaterial("Fractum", fractum, fractumFluid, 538, 5.71f, 6.93f, 0.88f, 58, 117, DIAMOND, shitty);
        integrateMaterial("Violium", violium, violiumFluid, 925, 3.8f, 3.75f, .90f, 175, 50, COBALT, .45f, .95f, 1);
        integrateMaterial("Proxii", proxii, proxiiFluid, 625, 6.8f, 4.21f, 1.25f, 80, 25, DURANITE, .35f, .5f, 3);
        integrateMaterial("Tritonite", tritonite, tritoniteFluid, 780, 8f, 3.3f, 1.45f, -25, 150, COBALT, shitty);
        integrateMaterial("Ignitz", ignitz, ignitzFluid, 350, 2f, 6.66f, .85f, 150, 250, COBALT, .8f, .8f, 3);
        integrateMaterial("Imperomite", imperomite, imperomiteFluid, 1350, 4.65f, 5.9f, 1.15f, -100, 150, DURANITE, 1.2f, 1.8f, 2);
        integrateMaterial("Solarium", solarium, solariumFluid, 1100, 24f, 7f, 1.25f, 150, 150, VIBRANIUM, .8f, 1.5f, 5);
        integrateMaterial("Nihilite", nihilite, nihiliteFluid, 400, 2.8f, 4.50f, .77f, 350, 155, VALYRIUM, 1.5f, .8f, 3);
        integrateMaterial("Adamant", adamant, adamantFluid, 1750, 6f, 6f, 2f, 0, 0, VIBRANIUM, .35f, 1.85f, 8);
        integrateMaterial("Dyonite", dyonite, dyoniteFluid, 900, 6.45f, 5f, 0.66f, -50, 250, DURANITE, 2, .9f, -1);
        integrateMaterial("Nucleum", nucleum, nucleumFluid, 505, 17.5f, 9.5f, 1.05f, 100, 125, VALYRIUM, shitty);
        integrateMaterial("Lumix", lumix, lumixFluid, 666, 3.84f, 3.92f, 0.85f, 250, 200, COBALT, .8f, 1.3f, 1);
        integrateMaterial("Seismum", seismum, seismumFluid, 780, 3.66f, 6.05f, .95f, 250, 50, COBALT, shitty);
        integrateMaterial("Astrium", astrium, astriumFluid, 750, 8.35f, 5.4f, 0.95f, -100, 200, COBALT, .7f, .8f, 2);
        integrateMaterial("Niob", niob, niobFluid, 700, 4.5f, 4.5f, 2f, 200, 50, COBALT, shitty);
        integrateMaterial("Yrdeen", yrdeen, yrdeenFluid, 999, 9.1f, 3f, 1.35f, 150, 250, COBALT, shitty);
        integrateMaterial("Meteorite", meteorite, meteoriteFluid, 1500, 1.5f, 1.5f, .5f, 0, 0, OBSIDIAN, shitty);
        integrateMaterial("Obsidiorite", obsidiorite, obsidioriteFluid, 1500, .5f, .5f, 1, -100, 100, COBALT, shitty);

        integrateOre("Osram", osramFluid);
        integrateOre("Abyssum", abyssumFluid);
        integrateOre("Iox", ioxFluid);
        integrateOre("Karmesine", karmesineFluid);
        integrateOre("Ovium", oviumFluid);
        integrateOre("Jauxum", jauxumFluid);
        // Community Wishlist
        integrateOre("Dilithium", dilithiumFluid);
    }
}