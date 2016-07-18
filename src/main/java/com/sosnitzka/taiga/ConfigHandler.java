package com.sosnitzka.taiga;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	public static Configuration config;
	
	///  Sections
	public static String generationSection = "Generation configuration";
	public static String recipeSection = "Recipe Configuration";
	
	///  Options
	// regular Ores / Blocks without extra abilities
	public static boolean generateBasalt;
	public static boolean generateRottenGround;
	public static boolean generateLignite;
	public static boolean generateSlagIron;
	public static boolean generateSlagGold;
	public static boolean generateExtraIron;
	
	// Ores
	// Group: Solid
	public static boolean generateTitanite;
	public static boolean generateMeteorite;
	public static boolean generateVibranium;
	public static boolean generateAdamantite;
	// Group: Arcane
	public static boolean generatePrometheum;
	public static boolean generateRubium;
	public static boolean generateTiberium;
	public static boolean generateArcanite;
	// Group: Etheric
	public static boolean generateEternite;
	public static boolean generateMythril;
	public static boolean generatePalladium;
	public static boolean generateIgnitite;
	// Group: Ratio
	public static boolean generateViolium;
	public static boolean generateBismuth;
	public static boolean generateMindorite;
	public static boolean generateKarmesine;
	
	public static void init(File file){
		config = new Configuration(file);
		syncConfig();
	}
	
	public static void syncConfig() {
		config.addCustomCategoryComment(generationSection, "This section contains all settings regarding ore/block generation. ");
		
		// regular Ores / Blocks without extra abilities
		generateBasalt = config.get(generationSection, "generateBasalt", true, "Enable this if you want basalt to generate in the world. default=true").getBoolean(generateBasalt);
		generateRottenGround = config.get(generationSection, "generateRottenGround", true, "Enable this if you want rotten ground to generate in the world. default=true").getBoolean(generateRottenGround);
		generateLignite = config.get(generationSection, "generateLignite", true, "Enable this if you want lignite to generate in the world. default=true").getBoolean(generateLignite);
		generateSlagIron = config.get(generationSection, "generateSlagIron", true, "Enable this if you want slag iron to generate in the world. default=true").getBoolean(generateSlagIron);
		generateSlagGold = config.get(generationSection, "generateSlagGold", true, "Enable this if you want slag gold to generate in the world. default=true").getBoolean(generateSlagGold);
		generateExtraIron = config.get(generationSection, "generateExtraIron", true, "Enable this if you want extra iron to generate in the world. default=true").getBoolean(generateExtraIron);
		
		// Ores
		// Group: Solid
		generateTitanite = config.get(generationSection, "generateTitanite", true, "Enable this if you want titanite to generate in the world. default=true").getBoolean(generateTitanite);
		generateMeteorite = config.get(generationSection, "generateMeteorite", true, "Enable this if you want meteorite to generate in the world. default=true").getBoolean(generateMeteorite);
		generateVibranium = config.get(generationSection, "generateVibranium", true, "Enable this if you want vibranium to generate in the world. default=true").getBoolean(generateVibranium);
		generateAdamantite = config.get(generationSection, "generateAdamantite", true, "Enable this if you want adamantite to generate in the world. default=true").getBoolean(generateAdamantite);
		// Group: Arcane
		generatePrometheum = config.get(generationSection, "generatePrometheum", true, "Enable this if you want prometheum to generate in the world. default=true").getBoolean(generatePrometheum);
		generateRubium = config.get(generationSection, "generateRubium", true, "Enable this if you want rubium to generate in the world. default=true").getBoolean(generateRubium);
		generateTiberium = config.get(generationSection, "generateTiberium", true, "Enable this if you want tiberium to generate in the world. default=true").getBoolean(generateTiberium);
		generateArcanite = config.get(generationSection, "generateArcanite", true, "Enable this if you want arcanite to generate in the world. default=true").getBoolean(generateArcanite);
		// Group: Etheric
		generateEternite = config.get(generationSection, "generateEternite", true, "Enable this if you want eternite to generate in the world. default=true").getBoolean(generateEternite);
		generateMythril = config.get(generationSection, "generateMythril", true, "Enable this if you want mythril to generate in the world. default=true").getBoolean(generateMythril);
		generatePalladium = config.get(generationSection, "generatePalladium", true, "Enable this if you want palladium to generate in the world. default=true").getBoolean(generatePalladium);
		generateIgnitite = config.get(generationSection, "generateIgnitite", true, "Enable this if you want ignitite to generate in the world. default=true").getBoolean(generateIgnitite);
		// Group: Ratio
		generateViolium = config.get(generationSection, "generateViolium", true, "Enable this if you want violium to generate in the world. default=true").getBoolean(generateViolium);
		generateBismuth = config.get(generationSection, "generateBismuth", true, "Enable this if you want bismuth to generate in the world. default=true").getBoolean(generateBismuth);
		generateMindorite = config.get(generationSection, "generateMindorite", true, "Enable this if you want mindorite to generate in the world. default=true").getBoolean(generateMindorite);
		generateKarmesine = config.get(generationSection, "generateKarmesine", true, "Enable this if you want karmesine to generate in the world. default=true").getBoolean(generateKarmesine);
	
		config.save();
	}

}
