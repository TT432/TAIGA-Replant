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

    public static double RESFAC_MIN_VALUE = 0;
    public static double RESFAC_MAX_VALUE = 9999;

    public static int IRON_VAL = 20;
    public static int TIBERIUM_VAL = 15;
    public static int PROMETHEUM_VAL = 25;
    public static int VALYRIUM_VAL = 10;
    public static int OSRAM_VAL = 1;
    public static int DURANITE_VAL = 1;
    public static int BASALT_VAL = 10;
    public static int EEZO_VAL = 3;
    public static int KARMESINE_VAL = 15;
    public static int VIBRANIUM_VAL = 10;
    public static int URU_VAL = 1;
    public static int AURORIUM_VAL = 10;
    public static int PALLADIUM_VAL = 10;
    public static int ABYSSUM_VAL = 4;

    public static boolean ironGen = false;
    public static boolean endGen = true;
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

        /*
         *  Declaration of general ore generation values: <br>
         *  Activation of additional ores (iron/gold) <br>
         *  Ore generation chance multiplier
         */

        Property ironSwitch = config.get(CATEGORY_NAME_GENERAL, "Extra Iron Switch", ironGen);
        ironSwitch.setComment("Switch ore on/off");
        ironSwitch.setLanguageKey("gui.taiga_configuration.gen_iron");

        Property endSwitch = config.get(CATEGORY_NAME_GENERAL, "Extra Endstone Switch", endGen);
        endSwitch.setComment("Switch extra End on/off");
        endSwitch.setLanguageKey("gui.taiga_configuration.gen_end");

        /*
        Stuff which probably gonna come back

        Property durabilityFactorGeneralProp = config.get(CATEGORY_NAME_GENERAL, "Durability factor", RESFAC_DEFAULT_VALUE,
                "General multiplier for all TAIGA materials", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        durabilityFactorGeneralProp.setLanguageKey("gui.taiga_configuration.durability_multiplier");
        durabilityFactorGeneralProp.setRequiresMcRestart(true);

        */

        List<String> propOrderGeneral = new ArrayList<String>();
        propOrderGeneral.add(ironSwitch.getName());
        propOrderGeneral.add(endSwitch.getName());
        // propOrderGeneral.add(durabilityFactorGeneralProp.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_GENERAL, propOrderGeneral);

        /*
         *  Declaration of specific ore generation values: <br>
         *  Generation chance multiplier
         */

        Property ironValue = config.get(CATEGORY_NAME_ORE_GEN, "Iron", IRON_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        ironValue.setLanguageKey("gui.taiga_configuration.iron_multiplier");
        Property basaltValue = config.get(CATEGORY_NAME_ORE_GEN, "Basalt", BASALT_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        basaltValue.setLanguageKey("gui.taiga_configuration.basalt_multiplier");
        Property tiberiumValue = config.get(CATEGORY_NAME_ORE_GEN, "Tiberium", TIBERIUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        tiberiumValue.setLanguageKey("gui.taiga_configuration.tiberium_multiplier");
        Property auroriumValue = config.get(CATEGORY_NAME_ORE_GEN, "Aurorium", AURORIUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        auroriumValue.setLanguageKey("gui.taiga_configuration.aurorium_multiplier");
        Property prometheumValue = config.get(CATEGORY_NAME_ORE_GEN, "Prometheum", PROMETHEUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        prometheumValue.setLanguageKey("gui.taiga_configuration.prometheum_multiplier");
        Property duraniteValue = config.get(CATEGORY_NAME_ORE_GEN, "Duranite", DURANITE_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        duraniteValue.setLanguageKey("gui.taiga_configuration.duranite_multiplier");
        Property valyriumValue = config.get(CATEGORY_NAME_ORE_GEN, "Valyrium", VALYRIUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        valyriumValue.setLanguageKey("gui.taiga_configuration.valyrium_multiplier");
        Property vibraniumValue = config.get(CATEGORY_NAME_ORE_GEN, "Vibranium", VIBRANIUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        vibraniumValue.setLanguageKey("gui.taiga_configuration.vibranium_multiplier");
        Property karmesineValue = config.get(CATEGORY_NAME_ORE_GEN, "Karmesine", KARMESINE_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        karmesineValue.setLanguageKey("gui.taiga_configuration.karmesine_multiplier");
        Property palladiumValue = config.get(CATEGORY_NAME_ORE_GEN, "Palladium", PALLADIUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        palladiumValue.setLanguageKey("gui.taiga_configuration.palladium_multiplier");
        Property uruValue = config.get(CATEGORY_NAME_ORE_GEN, "Uru", URU_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        uruValue.setLanguageKey("gui.taiga_configuration.uru_multiplier");
        Property osramValue = config.get(CATEGORY_NAME_ORE_GEN, "Osram", OSRAM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        osramValue.setLanguageKey("gui.taiga_configuration.osram_multiplier");
        Property abyssumValue = config.get(CATEGORY_NAME_ORE_GEN, "Abyssum", ABYSSUM_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        abyssumValue.setLanguageKey("gui.taiga_configuration.abyssum_multiplier");
        Property eezoValue = config.get(CATEGORY_NAME_ORE_GEN, "Eezo", EEZO_VAL, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        eezoValue.setLanguageKey("gui.taiga_configuration.eezo_multiplier");


        List<String> propOrderOreGen = new ArrayList<String>();
        propOrderOreGen.add(ironValue.getName());
        propOrderOreGen.add(basaltValue.getName());
        propOrderOreGen.add(tiberiumValue.getName());
        propOrderOreGen.add(auroriumValue.getName());
        propOrderOreGen.add(prometheumValue.getName());
        propOrderOreGen.add(duraniteValue.getName());
        propOrderOreGen.add(valyriumValue.getName());
        propOrderOreGen.add(vibraniumValue.getName());
        propOrderOreGen.add(karmesineValue.getName());
        propOrderOreGen.add(palladiumValue.getName());
        propOrderOreGen.add(uruValue.getName());
        propOrderOreGen.add(osramValue.getName());
        propOrderOreGen.add(abyssumValue.getName());
        propOrderOreGen.add(eezoValue.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_ORE_GEN, propOrderOreGen);


        if (config.hasChanged()) {
            config.save();
        }
    }

    public static class ConfigEventHandler {
        @SubscribeEvent(priority = EventPriority.NORMAL)
        public void onEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (TAIGA.MODID.equals(event.getModID()) && !event.isWorldRunning()) {
                if (event.getConfigID().equals(CATEGORY_NAME_GENERAL) || event.getConfigID().equals(CATEGORY_NAME_ORE_GEN)) {
                    syncFromGUI();
                }
            }
        }
    }
}