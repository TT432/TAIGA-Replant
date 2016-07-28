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

    public static double oreFactorGeneral;
    public static double speedFactorGeneral;
    public static double attackFactorGeneral;
    public static double durabilityFactorGeneral;

    public static double ironFactor;
    public static double slagironFactor;
    public static double slaggoldFactor;
    public static double titaniteFactor;
    public static double adamantiteFactor;
    public static double arcaniteFactor;
    public static double violiumFactor;
    public static double bismuthFactor;
    public static double eterniteFactor;
    public static double ignititeFactor;
    public static double karmesineFactor;
    public static double meteoriteFactor;
    public static double mindoriteFactor;
    public static double mythrilFactor;
    public static double palladiumFactor;
    public static double prometheumFactor;
    public static double tiberiumFactor;
    public static double vibraniumFactor;
    public static double rubiumFactor;
    public static double basaltFactor;
    public static double rottengroundFactor;
    public static double ligniteFactor;


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

        /**
         *  Declaration of general ore generation values: <br>
         *  Activation of additional ores (iron/gold) <br>
         *  Ore generation chance multiplier
         */

        final boolean GENERATION_DEFAULT_VALUE = true;
        final double RESFAC_MIN_VALUE = 0;
        final double RESFAC_MAX_VALUE = 9999;
        final double RESFAC_DEFAULT_VALUE = 1.0;

        Property slagIronSwitch = config.get(CATEGORY_NAME_GENERAL, "SlagIron Switch", GENERATION_DEFAULT_VALUE);
        slagIronSwitch.setComment("Switch ore on/off");
        slagIronSwitch.setLanguageKey("gui.taiga_configuration.gen_slagiron");
        Property slagGoldSwitch = config.get(CATEGORY_NAME_GENERAL, "SlagGold Switch", GENERATION_DEFAULT_VALUE);
        slagGoldSwitch.setComment("Switch ore on/off");
        slagGoldSwitch.setLanguageKey("gui.taiga_configuration.gen_slaggold");
        Property ironSwitch = config.get(CATEGORY_NAME_GENERAL, "Extra Iron Switch", GENERATION_DEFAULT_VALUE);
        ironSwitch.setComment("Switch ore on/off");
        ironSwitch.setLanguageKey("gui.taiga_configuration.gen_iron");

        Property oreFactorGeneralProp = config.get(CATEGORY_NAME_GENERAL, "Ore factor", RESFAC_DEFAULT_VALUE,
                "General multiplier for all TAIGA ores at once", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        oreFactorGeneralProp.setLanguageKey("gui.taiga_configuration.ore_multiplier");
        Property durabilityFactorGeneralProp = config.get(CATEGORY_NAME_GENERAL, "Durability factor", RESFAC_DEFAULT_VALUE,
                "General multiplier for all TAIGA materials", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        durabilityFactorGeneralProp.setLanguageKey("gui.taiga_configuration.durability_multiplier");
        durabilityFactorGeneralProp.setRequiresMcRestart(true);
        Property speedFactorGeneralProp = config.get(CATEGORY_NAME_GENERAL, "Speed factor", RESFAC_DEFAULT_VALUE,
                "General multiplier for all TAIGA materials", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        speedFactorGeneralProp.setLanguageKey("gui.taiga_configuration.speed_multiplier");
        speedFactorGeneralProp.setRequiresMcRestart(true);
        Property attackFactorGeneralProp = config.get(CATEGORY_NAME_GENERAL, "Attack factor", RESFAC_DEFAULT_VALUE,
                "General multiplier for all TAIGA materials", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        attackFactorGeneralProp.setLanguageKey("gui.taiga_configuration.attack_multiplier");
        attackFactorGeneralProp.setRequiresMcRestart(true);

        List<String> propOrderGeneral = new ArrayList<String>();
        propOrderGeneral.add(ironSwitch.getName());
        propOrderGeneral.add(slagIronSwitch.getName());
        propOrderGeneral.add(slagGoldSwitch.getName());
        propOrderGeneral.add(oreFactorGeneralProp.getName());
        propOrderGeneral.add(durabilityFactorGeneralProp.getName());
        propOrderGeneral.add(speedFactorGeneralProp.getName());
        propOrderGeneral.add(attackFactorGeneralProp.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_GENERAL, propOrderGeneral);

        /**
         *  Declaration of specific ore generation values: <br>
         *  Generation chance multiplier
         */
        Property ironFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Iron factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        ironFactorProp.setLanguageKey("gui.taiga_configuration.titanite_multiplier");
        Property slagironFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Slagiorn factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        slagironFactorProp.setLanguageKey("gui.taiga_configuration.titanite_multiplier");
        Property slaggoldFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Slaggold factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        slaggoldFactorProp.setLanguageKey("gui.taiga_configuration.titanite_multiplier");
        Property titaniteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Titanite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        titaniteFactorProp.setLanguageKey("gui.taiga_configuration.titanite_multiplier");
        Property adamantiteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Adamantite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        adamantiteFactorProp.setLanguageKey("gui.taiga_configuration.adamantite_multiplier");
        Property arcaniteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Arcanite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        arcaniteFactorProp.setLanguageKey("gui.taiga_configuration.arcanite_multiplier");
        Property violiumFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Violium factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        violiumFactorProp.setLanguageKey("gui.taiga_configuration.violium_multiplier");
        Property bismuthFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Bismuth factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        bismuthFactorProp.setLanguageKey("gui.taiga_configuration.bismuth_multiplier");
        Property eterniteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Eternite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        eterniteFactorProp.setLanguageKey("gui.taiga_configuration.eternite_multiplier");
        Property ignititeFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Ignitite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        ignititeFactorProp.setLanguageKey("gui.taiga_configuration.ignitite_multiplier");
        Property karmesineFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Karmesine factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        karmesineFactorProp.setLanguageKey("gui.taiga_configuration.karmesine_multiplier");
        Property meteoriteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Meteorite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        meteoriteFactorProp.setLanguageKey("gui.taiga_configuration.meteorite_multiplier");
        Property mindoriteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Mindorite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        mindoriteFactorProp.setLanguageKey("gui.taiga_configuration.mindorite_multiplier");
        Property mythrilFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Mythril factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        mythrilFactorProp.setLanguageKey("gui.taiga_configuration.mythril_multiplier");
        Property palladiumFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Palladium factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        palladiumFactorProp.setLanguageKey("gui.taiga_configuration.palladium_multiplier");
        Property prometheumFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Prometheum factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        prometheumFactorProp.setLanguageKey("gui.taiga_configuration.prometheum_multiplier");
        Property tiberiumFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Tiberium factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        tiberiumFactorProp.setLanguageKey("gui.taiga_configuration.tiberium_multiplier");
        Property vibraniumFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Vibranium factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        vibraniumFactorProp.setLanguageKey("gui.taiga_configuration.vibranium_multiplier");
        Property rubiumFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Rubium factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        rubiumFactorProp.setLanguageKey("gui.taiga_configuration.rubium_multiplier");
        // RottenGround + Basalt
        Property basaltFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Basalt factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        basaltFactorProp.setLanguageKey("gui.taiga_configuration.basalt_multiplier");
        Property rottengroundFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "RottenGround factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        rottengroundFactorProp.setLanguageKey("gui.taiga_configuration.rottenground_multiplier");
        Property ligniteFactorProp = config.get(CATEGORY_NAME_ORE_GEN, "Lignite factor", RESFAC_DEFAULT_VALUE,
                "specific generation multiplier", RESFAC_MIN_VALUE, RESFAC_MAX_VALUE);
        ligniteFactorProp.setLanguageKey("gui.taiga_configuration.lignite_multiplier");

        List<String> propOrderOreGen = new ArrayList<String>();
        propOrderOreGen.add(ironFactorProp.getName());
        propOrderOreGen.add(slagironFactorProp.getName());
        propOrderOreGen.add(slaggoldFactorProp.getName());
        propOrderOreGen.add(ligniteFactorProp.getName());
        propOrderOreGen.add(basaltFactorProp.getName());
        propOrderOreGen.add(rottengroundFactorProp.getName());
        propOrderOreGen.add(titaniteFactorProp.getName());
        propOrderOreGen.add(adamantiteFactorProp.getName());
        propOrderOreGen.add(arcaniteFactorProp.getName());
        propOrderOreGen.add(violiumFactorProp.getName());
        propOrderOreGen.add(bismuthFactorProp.getName());
        propOrderOreGen.add(eterniteFactorProp.getName());
        propOrderOreGen.add(ignititeFactorProp.getName());
        propOrderOreGen.add(karmesineFactorProp.getName());
        propOrderOreGen.add(meteoriteFactorProp.getName());
        propOrderOreGen.add(mindoriteFactorProp.getName());
        propOrderOreGen.add(mythrilFactorProp.getName());
        propOrderOreGen.add(palladiumFactorProp.getName());
        propOrderOreGen.add(prometheumFactorProp.getName());
        propOrderOreGen.add(tiberiumFactorProp.getName());
        propOrderOreGen.add(vibraniumFactorProp.getName());
        propOrderOreGen.add(rubiumFactorProp.getName());
        config.setCategoryPropertyOrder(CATEGORY_NAME_ORE_GEN, propOrderOreGen);


        List<String> propOrderOreVal = new ArrayList<String>();
        config.setCategoryPropertyOrder(CATEGORY_NAME_ORE_VAL, propOrderOreVal);


        if (readFieldsFromConfig) {
            oreFactorGeneral = oreFactorGeneralProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (oreFactorGeneral > RESFAC_MAX_VALUE || oreFactorGeneral < RESFAC_MIN_VALUE) {
                oreFactorGeneral = RESFAC_DEFAULT_VALUE;
            }
            durabilityFactorGeneral = durabilityFactorGeneralProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (durabilityFactorGeneral > RESFAC_MAX_VALUE || durabilityFactorGeneral < RESFAC_MIN_VALUE) {
                durabilityFactorGeneral = RESFAC_DEFAULT_VALUE;
            }
            speedFactorGeneral = speedFactorGeneralProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (speedFactorGeneral > RESFAC_MAX_VALUE || speedFactorGeneral < RESFAC_MIN_VALUE) {
                speedFactorGeneral = RESFAC_DEFAULT_VALUE;
            }
            attackFactorGeneral = attackFactorGeneralProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (attackFactorGeneral > RESFAC_MAX_VALUE || attackFactorGeneral < RESFAC_MIN_VALUE) {
                attackFactorGeneral = RESFAC_DEFAULT_VALUE;
            }
            ironGen = ironSwitch.getBoolean(GENERATION_DEFAULT_VALUE);
            slagIronGen = slagIronSwitch.getBoolean(GENERATION_DEFAULT_VALUE);
            slagGoldGen = slagGoldSwitch.getBoolean(GENERATION_DEFAULT_VALUE);
            ironFactor = ironFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (ironFactor > RESFAC_MAX_VALUE || ironFactor < RESFAC_MIN_VALUE) {
                ironFactor = RESFAC_DEFAULT_VALUE;
            }
            slagironFactor = slagironFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (slagironFactor > RESFAC_MAX_VALUE || slagironFactor < RESFAC_MIN_VALUE) {
                slagironFactor = RESFAC_DEFAULT_VALUE;
            }
            slaggoldFactor = slaggoldFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (slaggoldFactor > RESFAC_MAX_VALUE || slaggoldFactor < RESFAC_MIN_VALUE) {
                slaggoldFactor = RESFAC_DEFAULT_VALUE;
            }
            titaniteFactor = titaniteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (titaniteFactor > RESFAC_MAX_VALUE || titaniteFactor < RESFAC_MIN_VALUE) {
                titaniteFactor = RESFAC_DEFAULT_VALUE;
            }
            adamantiteFactor = adamantiteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (adamantiteFactor > RESFAC_MAX_VALUE || adamantiteFactor < RESFAC_MIN_VALUE) {
                adamantiteFactor = RESFAC_DEFAULT_VALUE;
            }
            arcaniteFactor = arcaniteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (arcaniteFactor > RESFAC_MAX_VALUE || arcaniteFactor < RESFAC_MIN_VALUE) {
                arcaniteFactor = RESFAC_DEFAULT_VALUE;
            }
            violiumFactor = violiumFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (violiumFactor > RESFAC_MAX_VALUE || violiumFactor < RESFAC_MIN_VALUE) {
                violiumFactor = RESFAC_DEFAULT_VALUE;
            }
            bismuthFactor = bismuthFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (bismuthFactor > RESFAC_MAX_VALUE || bismuthFactor < RESFAC_MIN_VALUE) {
                bismuthFactor = RESFAC_DEFAULT_VALUE;
            }
            eterniteFactor = eterniteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (eterniteFactor > RESFAC_MAX_VALUE || eterniteFactor < RESFAC_MIN_VALUE) {
                eterniteFactor = RESFAC_DEFAULT_VALUE;
            }
            ignititeFactor = ignititeFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (ignititeFactor > RESFAC_MAX_VALUE || ignititeFactor < RESFAC_MIN_VALUE) {
                ignititeFactor = RESFAC_DEFAULT_VALUE;
            }
            karmesineFactor = karmesineFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (karmesineFactor > RESFAC_MAX_VALUE || karmesineFactor < RESFAC_MIN_VALUE) {
                karmesineFactor = RESFAC_DEFAULT_VALUE;
            }
            meteoriteFactor = meteoriteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (meteoriteFactor > RESFAC_MAX_VALUE || meteoriteFactor < RESFAC_MIN_VALUE) {
                meteoriteFactor = RESFAC_DEFAULT_VALUE;
            }
            mindoriteFactor = mindoriteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (mindoriteFactor > RESFAC_MAX_VALUE || mindoriteFactor < RESFAC_MIN_VALUE) {
                mindoriteFactor = RESFAC_DEFAULT_VALUE;
            }
            mythrilFactor = mythrilFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (mythrilFactor > RESFAC_MAX_VALUE || mythrilFactor < RESFAC_MIN_VALUE) {
                mythrilFactor = RESFAC_DEFAULT_VALUE;
            }
            palladiumFactor = palladiumFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (palladiumFactor > RESFAC_MAX_VALUE || palladiumFactor < RESFAC_MIN_VALUE) {
                palladiumFactor = RESFAC_DEFAULT_VALUE;
            }
            prometheumFactor = prometheumFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (prometheumFactor > RESFAC_MAX_VALUE || prometheumFactor < RESFAC_MIN_VALUE) {
                prometheumFactor = RESFAC_DEFAULT_VALUE;
            }
            tiberiumFactor = tiberiumFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (tiberiumFactor > RESFAC_MAX_VALUE || tiberiumFactor < RESFAC_MIN_VALUE) {
                tiberiumFactor = RESFAC_DEFAULT_VALUE;
            }
            vibraniumFactor = vibraniumFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (vibraniumFactor > RESFAC_MAX_VALUE || vibraniumFactor < RESFAC_MIN_VALUE) {
                vibraniumFactor = RESFAC_DEFAULT_VALUE;
            }
            rubiumFactor = rubiumFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (rubiumFactor > RESFAC_MAX_VALUE || rubiumFactor < RESFAC_MIN_VALUE) {
                rubiumFactor = RESFAC_DEFAULT_VALUE;
            }
            basaltFactor = basaltFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (basaltFactor > RESFAC_MAX_VALUE || basaltFactor < RESFAC_MIN_VALUE) {
                basaltFactor = RESFAC_DEFAULT_VALUE;
            }
            rottengroundFactor = rottengroundFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (rottengroundFactor > RESFAC_MAX_VALUE || rottengroundFactor < RESFAC_MIN_VALUE) {
                rottengroundFactor = RESFAC_DEFAULT_VALUE;
            }
            ligniteFactor = ligniteFactorProp.getDouble(RESFAC_DEFAULT_VALUE);
            if (ligniteFactor > RESFAC_MAX_VALUE || ligniteFactor < RESFAC_MIN_VALUE) {
                ligniteFactor = RESFAC_DEFAULT_VALUE;
            }
        }

        ironSwitch.set(ironGen);
        slagIronSwitch.set(slagIronGen);
        slagGoldSwitch.set(slagGoldGen);
        oreFactorGeneralProp.set(oreFactorGeneral);
        durabilityFactorGeneralProp.set(durabilityFactorGeneral);
        speedFactorGeneralProp.set(speedFactorGeneral);
        attackFactorGeneralProp.set(attackFactorGeneral);
        titaniteFactorProp.set(titaniteFactor);
        adamantiteFactorProp.set(adamantiteFactor);
        arcaniteFactorProp.set(arcaniteFactor);
        violiumFactorProp.set(violiumFactor);
        bismuthFactorProp.set(bismuthFactor);
        eterniteFactorProp.set(eterniteFactor);
        ignititeFactorProp.set(ignititeFactor);
        karmesineFactorProp.set(karmesineFactor);
        meteoriteFactorProp.set(meteoriteFactor);
        mindoriteFactorProp.set(mindoriteFactor);
        mythrilFactorProp.set(mythrilFactor);
        palladiumFactorProp.set(palladiumFactor);
        prometheumFactorProp.set(prometheumFactor);
        tiberiumFactorProp.set(tiberiumFactor);
        vibraniumFactorProp.set(vibraniumFactor);
        rubiumFactorProp.set(rubiumFactor);
        basaltFactorProp.set(basaltFactor);
        rottengroundFactorProp.set(rottengroundFactor);
        ligniteFactorProp.set(ligniteFactor);

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