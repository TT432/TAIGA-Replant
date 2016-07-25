package com.sosnitzka.taiga;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TAIGAConfiguration {
    public static final String CATEGORY_NAME_GENERAL = "category_general";
    public static final String CATEGORY_NAME_ORE = "category_ore";
    public static int oreResistenceFactor;
    public static boolean slagIronGen;
    private static Configuration config = null;

    public static void preInit() {
        File configFile = new File(Loader.instance().getConfigDir(), "TAIGA.cfg");
        config = new Configuration(configFile);

        syncFromFile();
    }

    public static void clientPreInit() {
        MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
    }

    public static Configuration getConfig() {
        return config;
    }

    public static void syncFromFile() {
        syncConfig(true, true);
    }

    public static void syncFromGUI() {
        syncConfig(false, true);
    }

    public static void syncFromFields() {
        syncConfig(false, false);
    }

    private static void syncConfig(boolean loadConfigFromFile, boolean readFieldsFromConfig) {
        if (loadConfigFromFile) {
            config.load();
        }

        final int RESMUT_MIN_VALUE = 0;
        final int RESMUT_MAX_VALUE = 9999;
        final int RESMUT_DEFAULT_VALUE = 1;
        Property resMultiplier = config.get(CATEGORY_NAME_ORE, "res_multiplier", RESMUT_DEFAULT_VALUE,
                "Resistance multiplier", RESMUT_MIN_VALUE, RESMUT_MAX_VALUE);
        resMultiplier.setLanguageKey("gui.taiga_configuration.res_multiplier");

        final boolean SLAGIRONGEN_DEFAULT_VALUE = true;
        Property slagIronSwitch = config.get(CATEGORY_NAME_GENERAL, "switch_slagiron", SLAGIRONGEN_DEFAULT_VALUE);
        slagIronSwitch.setComment("Switch slagiron on/off");
        slagIronSwitch.setLanguageKey("gui.taiga_configuration.gen_slagiron");

        List<String> propOrderGeneral = new ArrayList<String>();
        propOrderGeneral.add(slagIronSwitch.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_GENERAL, propOrderGeneral);

        List<String> propOrderOre = new ArrayList<String>();
        propOrderOre.add(resMultiplier.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_ORE, propOrderOre);


        if (readFieldsFromConfig) {
            //If getInt cannot get an integer value from the config file value of myInteger (e.g. corrupted file)
            // it will set it to the default value passed to the function
            oreResistenceFactor = resMultiplier.getInt(RESMUT_DEFAULT_VALUE);
            if (oreResistenceFactor > RESMUT_MAX_VALUE || oreResistenceFactor < RESMUT_MIN_VALUE) {
                oreResistenceFactor = RESMUT_DEFAULT_VALUE;
            }

            slagIronGen = slagIronSwitch.getBoolean(SLAGIRONGEN_DEFAULT_VALUE);
        }

        resMultiplier.set(oreResistenceFactor);
        slagIronSwitch.set(slagIronGen);

        if (config.hasChanged()) {
            config.save();
        }
    }

    public static class ConfigEventHandler {
        @SubscribeEvent(priority = EventPriority.NORMAL)
        public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (TAIGA.MODID.equals(event.getModID()) && !event.isWorldRunning()) {
                if (event.getConfigID().equals(CATEGORY_NAME_GENERAL) || event.getConfigID().equals(CATEGORY_NAME_ORE)) {
                    syncFromGUI();
                }
            }
        }
    }
}