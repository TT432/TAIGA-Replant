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
    public static final String CATEGORY_NAME_ORE_GEN = "category_ore_gen";
    public static final String CATEGORY_NAME_ORE_VAL = "category_ore_val";
    public static double oreResistenceFactor;
    public static boolean slagIronGen;
    public static boolean slagGoldGen;
    public static boolean ironGen;
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

        final double RESMUT_MIN_VALUE = 0;
        final double RESMUT_MAX_VALUE = 9999;
        final double RESMUT_DEFAULT_VALUE = 1.0;

        Property resMultiplier = config.get(CATEGORY_NAME_ORE_GEN, "Percentage resource multiplier", RESMUT_DEFAULT_VALUE,
                "Resistance multiplier", RESMUT_MIN_VALUE, RESMUT_MAX_VALUE);
        resMultiplier.setLanguageKey("gui.taiga_configuration.res_multiplier");


        final boolean IRONGEN_DEFAULT_VALUE = true;
        final boolean SLAGIRONGEN_DEFAULT_VALUE = true;
        final boolean SLAGGOLDGEN_DEFAULT_VALUE = true;
        Property ironSwitch = config.get(CATEGORY_NAME_GENERAL, "switch_iron", IRONGEN_DEFAULT_VALUE);
        Property slagIronSwitch = config.get(CATEGORY_NAME_GENERAL, "switch_slagiron", SLAGIRONGEN_DEFAULT_VALUE);
        Property slagGoldSwitch = config.get(CATEGORY_NAME_GENERAL, "switch_slaggold", SLAGGOLDGEN_DEFAULT_VALUE);
        ironSwitch.setComment("Switch extra iron on/off");
        slagGoldSwitch.setComment("Switch slaggold on/off");
        slagIronSwitch.setComment("Switch slagiron on/off");
        ironSwitch.setLanguageKey("gui.taiga_configuration.gen_iron");
        slagIronSwitch.setLanguageKey("gui.taiga_configuration.gen_slagiron");
        slagGoldSwitch.setLanguageKey("gui.taiga_configuration.gen_slaggold");

        List<String> propOrderGeneral = new ArrayList<String>();
        propOrderGeneral.add(ironSwitch.getName());
        propOrderGeneral.add(slagIronSwitch.getName());
        propOrderGeneral.add(slagGoldSwitch.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_GENERAL, propOrderGeneral);

        List<String> propOrderOre = new ArrayList<String>();
        propOrderOre.add(resMultiplier.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_ORE_GEN, propOrderOre);


        if (readFieldsFromConfig) {
            oreResistenceFactor = resMultiplier.getDouble(RESMUT_DEFAULT_VALUE);
            if (oreResistenceFactor > RESMUT_MAX_VALUE || oreResistenceFactor < RESMUT_MIN_VALUE) {
                oreResistenceFactor = RESMUT_DEFAULT_VALUE;
            }

            ironGen = ironSwitch.getBoolean(IRONGEN_DEFAULT_VALUE);
            slagIronGen = slagIronSwitch.getBoolean(SLAGIRONGEN_DEFAULT_VALUE);
            slagGoldGen = slagGoldSwitch.getBoolean(SLAGGOLDGEN_DEFAULT_VALUE);

        }

        resMultiplier.set(oreResistenceFactor);
        ironSwitch.set(ironGen);
        slagIronSwitch.set(slagIronGen);
        slagGoldSwitch.set(slagGoldGen);

        if (config.hasChanged()) {
            config.save();
        }
    }

    public static class ConfigEventHandler {
        @SubscribeEvent(priority = EventPriority.NORMAL)
        public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (TAIGA.MODID.equals(event.getModID()) && !event.isWorldRunning()) {
                if (event.getConfigID().equals(CATEGORY_NAME_GENERAL) || event.getConfigID().equals(CATEGORY_NAME_ORE_GEN) || event.getConfigID().equals(CATEGORY_NAME_ORE_VAL)) {
                    syncFromGUI();
                }
            }
        }
    }
}