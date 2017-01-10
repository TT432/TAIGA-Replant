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

    public static boolean ironGen;
    public static boolean endGen;

    public static boolean tiberiumGen;
    public static boolean prometheumGen;
    public static boolean valyriumGen;
    public static boolean osramGen;
    public static boolean duraniteGen;
    public static boolean basaltGen;
    public static boolean eezoGen;
    public static boolean karmesineGen;
    public static boolean oviumGen;
    public static boolean jauxumGen;
    public static boolean vibraniumGen;
    public static boolean uruGen;
    public static boolean auroriumGen;
    public static boolean palladiumGen;
    public static boolean abyssumGen;


    public static int IRON_VAL;
    public static int TIBERIUM_VAL;
    public static int PROMETHEUM_VAL;
    public static int VALYRIUM_VAL;
    public static int OSRAM_VAL;
    public static int DURANITE_VAL;
    public static int BASALT_VAL;
    public static int EEZO_VAL;
    public static int KARMESINE_VAL;
    public static int OVIUM_VAL;
    public static int JAUXUM_VAL;
    public static int VIBRANIUM_VAL;
    public static int DILITHIUM_VAL;
    public static int URU_VAL;
    public static int AURORIUM_VAL;
    public static int PALLADIUM_VAL;
    public static int ABYSSUM_VAL;

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

        final int RESFAC_MIN_VALUE = 0;
        final int RESFAC_MAX_VALUE = 100;

        final int IRON_DEFAULT = 20;
        final int TIBERIUM_DEFAULT = 15;
        final int PROMETHEUM_DEFAULT = 18;
        final int VALYRIUM_DEFAULT = 10;
        final int DILITHIUM_DEFAULT = 12;
        final int OSRAM_DEFAULT = 1;
        final int DURANITE_DEFAULT = 1;
        final int BASALT_DEFAULT = 10;
        final int EEZO_DEFAULT = 3;
        final int KARMESINE_DEFAULT = 8;
        final int JAUXUM_DEFAULT = 8;
        final int OVIUM_DEFAULT = 8;
        final int VIBRANIUM_DEFAULT = 8;
        final int URU_DEFAULT = 1;
        final int AURORIUM_DEFAULT = 10;
        final int PALLADIUM_DEFAULT = 10;
        final int ABYSSUM_DEFAULT = 4;


        Property ironSwitch = config.get(CATEGORY_NAME_GENERAL, "Additional Iron", false);
        ironSwitch.setComment("Switch additional ore on/off");
        ironSwitch.setLanguageKey("gui.taiga_configuration.gen_iron");

        Property endSwitch = config.get(CATEGORY_NAME_GENERAL, "Additional Endstone", true);
        endSwitch.setComment("Switch additional endstone on/off");
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


        Property ironValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Iron", IRON_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        ironValueProp.setLanguageKey("gui.taiga_configuration.iron_multiplier");
        Property basaltValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Basalt", BASALT_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        basaltValueProp.setLanguageKey("gui.taiga_configuration.basalt_multiplier");
        Property tiberiumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Tiberium", TIBERIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        tiberiumValueProp.setLanguageKey("gui.taiga_configuration.tiberium_multiplier");
        Property auroriumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Aurorium", AURORIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        auroriumValueProp.setLanguageKey("gui.taiga_configuration.aurorium_multiplier");
        Property prometheumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Prometheum", PROMETHEUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        prometheumValueProp.setLanguageKey("gui.taiga_configuration.prometheum_multiplier");
        Property duraniteValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Duranite", DURANITE_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        duraniteValueProp.setLanguageKey("gui.taiga_configuration.duranite_multiplier");
        Property valyriumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Valyrium", VALYRIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        valyriumValueProp.setLanguageKey("gui.taiga_configuration.valyrium_multiplier");
        Property vibraniumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Vibranium", VIBRANIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        vibraniumValueProp.setLanguageKey("gui.taiga_configuration.vibranium_multiplier");
        Property dilithiumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Dilithium", DILITHIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        dilithiumValueProp.setLanguageKey("gui.taiga_configuration.dilithium_multiplier");
        Property karmesineValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Karmesine", KARMESINE_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        karmesineValueProp.setLanguageKey("gui.taiga_configuration.karmesine_multiplier");
        Property oviumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Ovium", OVIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        oviumValueProp.setLanguageKey("gui.taiga_configuration.ovium_multiplier");
        Property jauxumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Jauxum", JAUXUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        jauxumValueProp.setLanguageKey("gui.taiga_configuration.jauxum_multiplier");
        Property palladiumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Palladium", PALLADIUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        palladiumValueProp.setLanguageKey("gui.taiga_configuration.palladium_multiplier");
        Property uruValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Uru", URU_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        uruValueProp.setLanguageKey("gui.taiga_configuration.uru_multiplier");
        Property osramValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Osram", OSRAM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        osramValueProp.setLanguageKey("gui.taiga_configuration.osram_multiplier");
        Property abyssumValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Abyssum", ABYSSUM_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        abyssumValueProp.setLanguageKey("gui.taiga_configuration.abyssum_multiplier");
        Property eezoValueProp = config.get(CATEGORY_NAME_ORE_GEN, "Eezo", EEZO_DEFAULT, "value for generation", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        eezoValueProp.setLanguageKey("gui.taiga_configuration.eezo_multiplier");


        List<String> propOrderOreGen = new ArrayList<String>();
        propOrderOreGen.add(ironValueProp.getName());
        propOrderOreGen.add(basaltValueProp.getName());
        propOrderOreGen.add(tiberiumValueProp.getName());
        propOrderOreGen.add(auroriumValueProp.getName());
        propOrderOreGen.add(prometheumValueProp.getName());
        propOrderOreGen.add(duraniteValueProp.getName());
        propOrderOreGen.add(valyriumValueProp.getName());
        propOrderOreGen.add(vibraniumValueProp.getName());
        propOrderOreGen.add(dilithiumValueProp.getName());
        propOrderOreGen.add(karmesineValueProp.getName());
        propOrderOreGen.add(oviumValueProp.getName());
        propOrderOreGen.add(jauxumValueProp.getName());
        propOrderOreGen.add(palladiumValueProp.getName());
        propOrderOreGen.add(uruValueProp.getName());
        propOrderOreGen.add(osramValueProp.getName());
        propOrderOreGen.add(abyssumValueProp.getName());
        propOrderOreGen.add(eezoValueProp.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_ORE_GEN, propOrderOreGen);


        if (readFieldsFromConfig) {
            ironGen = ironSwitch.getBoolean(false);
            endGen = endSwitch.getBoolean(true);
            IRON_VAL = ironValueProp.getInt(IRON_DEFAULT);
            if (IRON_VAL > RESFAC_MAX_VALUE || IRON_VAL < RESFAC_MIN_VALUE) {
                IRON_VAL = IRON_DEFAULT;
            }
            TIBERIUM_VAL = tiberiumValueProp.getInt(TIBERIUM_DEFAULT);
            if (TIBERIUM_VAL > RESFAC_MAX_VALUE || TIBERIUM_VAL < RESFAC_MIN_VALUE) {
                TIBERIUM_VAL = TIBERIUM_DEFAULT;
            }
            PROMETHEUM_VAL = prometheumValueProp.getInt(PROMETHEUM_DEFAULT);
            if (PROMETHEUM_VAL > RESFAC_MAX_VALUE || PROMETHEUM_VAL < RESFAC_MIN_VALUE) {
                PROMETHEUM_VAL = PROMETHEUM_DEFAULT;
            }
            VALYRIUM_VAL = valyriumValueProp.getInt(VALYRIUM_DEFAULT);
            if (VALYRIUM_VAL > RESFAC_MAX_VALUE || VALYRIUM_VAL < RESFAC_MIN_VALUE) {
                VALYRIUM_VAL = VALYRIUM_DEFAULT;
            }
            OSRAM_VAL = osramValueProp.getInt(OSRAM_DEFAULT);
            if (OSRAM_VAL > RESFAC_MAX_VALUE || OSRAM_VAL < RESFAC_MIN_VALUE) {
                OSRAM_VAL = OSRAM_DEFAULT;
            }
            DURANITE_VAL = duraniteValueProp.getInt(DURANITE_DEFAULT);
            if (DURANITE_VAL > RESFAC_MAX_VALUE || DURANITE_VAL < RESFAC_MIN_VALUE) {
                DURANITE_VAL = DURANITE_DEFAULT;
            }
            BASALT_VAL = basaltValueProp.getInt(BASALT_DEFAULT);
            if (BASALT_VAL > RESFAC_MAX_VALUE || BASALT_VAL < RESFAC_MIN_VALUE) {
                BASALT_VAL = BASALT_DEFAULT;
            }
            EEZO_VAL = eezoValueProp.getInt(EEZO_DEFAULT);
            if (EEZO_VAL > RESFAC_MAX_VALUE || EEZO_VAL < RESFAC_MIN_VALUE) {
                EEZO_VAL = EEZO_DEFAULT;
            }
            KARMESINE_VAL = karmesineValueProp.getInt(KARMESINE_DEFAULT);
            if (KARMESINE_VAL > RESFAC_MAX_VALUE || KARMESINE_VAL < RESFAC_MIN_VALUE) {
                KARMESINE_VAL = KARMESINE_DEFAULT;
            }
            OVIUM_VAL = oviumValueProp.getInt(OVIUM_DEFAULT);
            if (OVIUM_VAL > RESFAC_MAX_VALUE || OVIUM_VAL < RESFAC_MIN_VALUE) {
                OVIUM_VAL = KARMESINE_DEFAULT;
            }
            JAUXUM_VAL = jauxumValueProp.getInt(OVIUM_DEFAULT);
            if (JAUXUM_VAL > RESFAC_MAX_VALUE || JAUXUM_VAL < RESFAC_MIN_VALUE) {
                JAUXUM_VAL = JAUXUM_DEFAULT;
            }
            VIBRANIUM_VAL = vibraniumValueProp.getInt(VIBRANIUM_DEFAULT);
            if (VIBRANIUM_VAL > RESFAC_MAX_VALUE || VIBRANIUM_VAL < RESFAC_MIN_VALUE) {
                VIBRANIUM_VAL = VIBRANIUM_DEFAULT;
            }
            DILITHIUM_VAL = dilithiumValueProp.getInt(DILITHIUM_DEFAULT);
            if (DILITHIUM_VAL > RESFAC_MAX_VALUE || DILITHIUM_VAL < RESFAC_MIN_VALUE) {
                DILITHIUM_VAL = DILITHIUM_DEFAULT;
            }
            URU_VAL = uruValueProp.getInt(URU_DEFAULT);
            if (URU_VAL > RESFAC_MAX_VALUE || URU_VAL < RESFAC_MIN_VALUE) {
                URU_VAL = URU_DEFAULT;
            }
            AURORIUM_VAL = auroriumValueProp.getInt(AURORIUM_DEFAULT);
            if (AURORIUM_VAL > RESFAC_MAX_VALUE || AURORIUM_VAL < RESFAC_MIN_VALUE) {
                AURORIUM_VAL = AURORIUM_DEFAULT;
            }
            PALLADIUM_VAL = palladiumValueProp.getInt(PALLADIUM_DEFAULT);
            if (PALLADIUM_VAL > RESFAC_MAX_VALUE || PALLADIUM_VAL < RESFAC_MIN_VALUE) {
                PALLADIUM_VAL = PALLADIUM_DEFAULT;
            }
            ABYSSUM_VAL = abyssumValueProp.getInt(ABYSSUM_DEFAULT);
            if (ABYSSUM_VAL > RESFAC_MAX_VALUE || ABYSSUM_VAL < RESFAC_MIN_VALUE) {
                ABYSSUM_VAL = ABYSSUM_DEFAULT;
            }
        }

        ironSwitch.set(ironGen);
        endSwitch.set(endGen);
        ironValueProp.set(IRON_VAL);
        tiberiumValueProp.set(TIBERIUM_VAL);
        prometheumValueProp.set(PROMETHEUM_VAL);
        valyriumValueProp.set(VALYRIUM_VAL);
        osramValueProp.set(OSRAM_VAL);
        duraniteValueProp.set(DURANITE_VAL);
        basaltValueProp.set(BASALT_VAL);
        eezoValueProp.set(EEZO_VAL);
        karmesineValueProp.set(KARMESINE_VAL);
        oviumValueProp.set(OVIUM_VAL);
        jauxumValueProp.set(JAUXUM_VAL);
        vibraniumValueProp.set(VIBRANIUM_VAL);
        dilithiumValueProp.set(DILITHIUM_VAL);
        uruValueProp.set(URU_VAL);
        auroriumValueProp.set(AURORIUM_VAL);
        palladiumValueProp.set(PALLADIUM_VAL);
        abyssumValueProp.set(ABYSSUM_VAL);


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