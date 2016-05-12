package main;

import blocks.BlockLigniteOre;
import blocks.BlockTiberiumOre;
import blocks.category.BasicBlockGround;
import blocks.category.BasicBlockOre;
import blocks.category.BasicBlockOreGlow;
import fluids.BasicFluid;
import items.*;
import main.util.FuelHandler;
import main.util.recipes.Crafting;
import main.util.recipes.Smelting;
import main.world.ZWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import proxy.ServerProxy;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;

@Mod(modid = ZCompression.MODID, version = ZCompression.VERSION)
public class ZCompression {

    static final String MODID = "zcompression";
    static final String VERSION = "@VERSION@";

    // ITEMS
    public static ItemSlagironIngot slagironIngot = new ItemSlagironIngot();
    public static ItemLignite lignite = new ItemLignite();
    public static ItemIronNugget iron_nugget = new ItemIronNugget();
    public static ItemSlaggoldIngot slaggoldIngot = new ItemSlaggoldIngot();
    public static Item fuel_brick = new BasicItem("fuel_brick");

    public static Item aardiumIngot = new BasicItem("aardium_ingot");
    public static Item adamantiteIngot = new BasicItem("adamantite_ingot");
    public static Item arcaniteIngot = new BasicItem("arcanite_ingot");
    public static Item axiidianIngot = new BasicItem("axiidian_ingot");
    public static Item bismuthIngot = new BasicItem("bismuth_ingot");
    public static Item eterniteIngot = new BasicItem("eternite_ingot");
    public static Item ignititeIngot = new BasicItem("ignitite_ingot");
    public static Item karmesineIngot = new BasicItem("karmesine_ingot");
    public static Item meteoriteIngot = new BasicItem("meteorite_ingot");
    public static Item mindoriteIngot = new BasicItem("mindorite_ingot");
    public static Item mythrilIngot = new BasicItem("mythril_ingot");
    public static Item palladiumIngot = new BasicItem("palladium_ingot");
    public static Item prometheumIngot = new BasicItem("prometheum_ingot");
    public static Item tiberiumIngot = new BasicItem("tiberium_ingot");
    public static Item vibraniumIngot = new BasicItem("vibranium_ingot");
    public static Item yrdeanIngot = new BasicItem("yrdean_ingot");

    public static Item astriteIngot = new BasicItem("astrite_ingot");
    public static Item instableNitroniteIngot = new BasicItem("instable_nitronite_ingot");
    public static Item proxideumIngot = new BasicItem("proxideum_ingot");
    public static Item instablePolyniumIngot = new BasicItem("instable_polyniumingot");
    public static Item imperomiteIngot = new BasicItem("imperomite_ingot");
    public static Item cryptogenIngot = new BasicItem("cryptogen_ingot");
    public static Item fractoryteIngot = new BasicItem("fractoryte_ingot");
    public static Item seismodiumIngot = new BasicItem("seismodium_ingot");
    public static Item terramiteIngot = new BasicItem("terramite_ingot");
    public static Item instablePrysociteIngot = new BasicItem("instable_prysocite_ingot");
    public static Item blazingXylititeIngot = new BasicItem("blazing_xylitite_ingot");
    public static Item instableDyoniteIngot = new BasicItem("instable_dyonite_ingot");
    public static Item ultraniteIngot = new BasicItem("ultranite_ingot");
    public static Item radiantPliniumIngot = new BasicItem("radiant_plinium_ingot");
    public static Item dysprosaniumIngot = new BasicItem("dysprosanium_ingot");
    public static Item refractiveBysumIngot = new BasicItem("refractive_bysum_ingot");


    public static Item tiberiumShardInstable = new BasicItem("tiberium_shard_instable");
    public static Item tiberiumShardStable = new BasicItem("tiberium_shard_stable");

    // BLOCKS
    public static Block basalt = new BasicBlockOre("basalt", Material.ROCK, 45.0f, 35.0f, 3);
    public static Block rottenGround = new BasicBlockGround("rotten_ground", Material.GROUND, 2.0f, 2.0f, 0);
    public static Block ligniteOre = new BlockLigniteOre();


    public static Block aardiumOre = new BasicBlockOre("aardium_ore", Material.ROCK, 55.0f, 400.0f, 3);
    public static Block adamantiteOre = new BasicBlockOre("adamantite_ore", Material.ROCK, 80.0f, 1000.0f, 4);
    public static Block arcaniteOre = new BasicBlockOre("arcanite_ore", Material.ROCK, 23.0f, 25.0f, 2);
    public static Block axiidianOre = new BasicBlockOre("axiidian_ore", Material.ROCK, 13.0f, 13.0f, 3);
    public static Block bismuthOre = new BasicBlockOre("bismuth_ore", Material.ROCK, 8.0f, 8.0f, 1);
    public static Block eterniteOre = new BasicBlockOre("eternite_ore", Material.ROCK, 24.0f, 25.0f, 3);
    public static Block ignititeOre = new BasicBlockOre("ignitite_ore", Material.ROCK, 23.0f, 25.0f, 3);
    public static Block karmesineOre = new BasicBlockOre("karmesine_ore", Material.ROCK, 13.0f, 15.0f, 1);
    public static Block meteoriteOre = new BasicBlockOre("meteorite_ore", Material.ROCK, 60.0f, 500.0f, 4);
    public static Block mindoriteOre = new BasicBlockOre("mindorite_ore", Material.ROCK, 12.0f, 12.0f, 2);
    public static Block mythrilOre = new BasicBlockOre("mythril_ore", Material.ROCK, 25.0f, 25.0f, 4);
    public static Block palladiumOre = new BasicBlockOre("palladium_ore", Material.ROCK, 25.0f, 25.0f, 3);
    public static Block prometheumOre = new BasicBlockOreGlow("prometheum_ore", Material.ROCK, 35.0f, 35.0f, 4, 0.25f);
    public static Block slagironOre = new BasicBlockOre("slagiron_ore", Material.ROCK, 3.0f, 5.0f, 1);
    public static Block slaggoldOre = new BasicBlockOre("slaggold_ore", Material.ROCK, 3.0f, 5.0f, 1);
    public static Block tiberiumOre = new BlockTiberiumOre();
    public static Block vibraniumOre = new BasicBlockOre("vibranium_ore", Material.ROCK, 70.0f, 800.0f, 4);
    public static Block yrdeanOre = new BasicBlockOre("yrdean_ore", Material.ROCK, 13.0f, 15.0f, 3);

    public static slimeknights.tconstruct.library.materials.Material arcanite = new slimeknights.tconstruct.library.materials.Material("arcanite", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material tiberium = new slimeknights.tconstruct.library.materials.Material("tiberium", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material prometheum = new slimeknights.tconstruct.library.materials.Material("prometheum", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material yrdean = new slimeknights.tconstruct.library.materials.Material("yrdean", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material axiidian = new slimeknights.tconstruct.library.materials.Material("axiidian", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material bismuth = new slimeknights.tconstruct.library.materials.Material("bismuth", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material karmesine = new slimeknights.tconstruct.library.materials.Material("karmesine", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material mindorite = new slimeknights.tconstruct.library.materials.Material("mindorite", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material aardium = new slimeknights.tconstruct.library.materials.Material("aardium", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material meteorite = new slimeknights.tconstruct.library.materials.Material("meteorite", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material adamantite = new slimeknights.tconstruct.library.materials.Material("adamantite", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material vibranium = new slimeknights.tconstruct.library.materials.Material("vibranium", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material ignitite = new slimeknights.tconstruct.library.materials.Material("ignitite", TextFormatting.AQUA);
    public static slimeknights.tconstruct.library.materials.Material palladium = new slimeknights.tconstruct.library.materials.Material("palladium", TextFormatting.AQUA);
    public static slimeknights.tconstruct.library.materials.Material eternite = new slimeknights.tconstruct.library.materials.Material("eternite", TextFormatting.AQUA);
    public static slimeknights.tconstruct.library.materials.Material mythril = new slimeknights.tconstruct.library.materials.Material("mythril", TextFormatting.AQUA);

    public static slimeknights.tconstruct.library.materials.Material astrite = new slimeknights.tconstruct.library.materials.Material("astrite", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material instableNitronite = new slimeknights.tconstruct.library.materials.Material("instableNitronite", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material proxideum = new slimeknights.tconstruct.library.materials.Material("proxideum", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material instablePolynium = new slimeknights.tconstruct.library.materials.Material("instablePolynium", TextFormatting.LIGHT_PURPLE);
    public static slimeknights.tconstruct.library.materials.Material imperomite = new slimeknights.tconstruct.library.materials.Material("imperomite", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material cryptogen = new slimeknights.tconstruct.library.materials.Material("cryptogen", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material fractoryte = new slimeknights.tconstruct.library.materials.Material("fractoryte", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material seismodium = new slimeknights.tconstruct.library.materials.Material("seismodium", TextFormatting.DARK_GREEN);
    public static slimeknights.tconstruct.library.materials.Material terramite = new slimeknights.tconstruct.library.materials.Material("terramite", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material instablePrysocite = new slimeknights.tconstruct.library.materials.Material("instablePrysocite", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material blazingXylitite = new slimeknights.tconstruct.library.materials.Material("blazingXylitite", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material instableDyonite = new slimeknights.tconstruct.library.materials.Material("instableDyonite", TextFormatting.GRAY);
    public static slimeknights.tconstruct.library.materials.Material ultranite = new slimeknights.tconstruct.library.materials.Material("ultranite", TextFormatting.AQUA);
    public static slimeknights.tconstruct.library.materials.Material radiantPlinium = new slimeknights.tconstruct.library.materials.Material("radiantPlinium", TextFormatting.AQUA);
    public static slimeknights.tconstruct.library.materials.Material dysprosanium = new slimeknights.tconstruct.library.materials.Material("dysprosanium", TextFormatting.AQUA);
    public static slimeknights.tconstruct.library.materials.Material refractiveBysmuid = new slimeknights.tconstruct.library.materials.Material("refractiveBysmuidFluid", TextFormatting.AQUA);


    @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
    private static ServerProxy proxy;

    private static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {


        //Items


        GameRegistry.register(tiberiumShardInstable);
        GameRegistry.register(tiberiumShardStable);

        GameRegistry.register(slagironIngot);
        GameRegistry.register(fuel_brick);
        GameRegistry.register(slaggoldIngot);
        GameRegistry.register(iron_nugget);
        GameRegistry.register(lignite);

        GameRegistry.register(aardiumIngot);
        GameRegistry.register(adamantiteIngot);
        GameRegistry.register(arcaniteIngot);
        GameRegistry.register(axiidianIngot);
        GameRegistry.register(bismuthIngot);
        GameRegistry.register(eterniteIngot);
        GameRegistry.register(ignititeIngot);
        GameRegistry.register(karmesineIngot);
        GameRegistry.register(meteoriteIngot);
        GameRegistry.register(mindoriteIngot);
        GameRegistry.register(mythrilIngot);
        GameRegistry.register(palladiumIngot);
        GameRegistry.register(prometheumIngot);
        GameRegistry.register(tiberiumIngot);
        GameRegistry.register(vibraniumIngot);
        GameRegistry.register(yrdeanIngot);

        GameRegistry.register(astriteIngot);
        GameRegistry.register(instableDyoniteIngot);
        GameRegistry.register(instableNitroniteIngot);
        GameRegistry.register(instablePolyniumIngot);
        GameRegistry.register(instablePrysociteIngot);
        GameRegistry.register(imperomiteIngot);
        GameRegistry.register(cryptogenIngot);
        GameRegistry.register(proxideumIngot);
        GameRegistry.register(fractoryteIngot);
        GameRegistry.register(seismodiumIngot);
        GameRegistry.register(terramiteIngot);
        GameRegistry.register(blazingXylititeIngot);
        GameRegistry.register(radiantPliniumIngot);
        GameRegistry.register(ultraniteIngot);
        GameRegistry.register(dysprosaniumIngot);
        GameRegistry.register(refractiveBysumIngot);


        //Blocks

        registerBlockWithItem(aardiumOre);
        registerBlockWithItem(adamantiteOre);
        registerBlockWithItem(arcaniteOre);
        registerBlockWithItem(axiidianOre);
        registerBlockWithItem(basalt);
        registerBlockWithItem(bismuthOre);
        registerBlockWithItem(eterniteOre);
        registerBlockWithItem(ignititeOre);
        registerBlockWithItem(karmesineOre);
        registerBlockWithItem(ligniteOre);
        registerBlockWithItem(meteoriteOre);
        registerBlockWithItem(mindoriteOre);
        registerBlockWithItem(mythrilOre);
        registerBlockWithItem(palladiumOre);
        registerBlockWithItem(prometheumOre);
        registerBlockWithItem(rottenGround);
        registerBlockWithItem(slagironOre);
        registerBlockWithItem(slaggoldOre);
        registerBlockWithItem(tiberiumOre);
        registerBlockWithItem(vibraniumOre);
        registerBlockWithItem(yrdeanOre);

        registerOreDict();

        // TConstruct Fluids

        Fluid arcaniteFluid = new BasicFluid("arcaniteFluid", 0xFF272354);
        Fluid aardiumFluid = new BasicFluid("aardiumFluid", 0xFFC3F93D);
        Fluid adamantiteFluid = new BasicFluid("adamantiteFluid", 0xFFc45c82);
        Fluid axiidianFluid = new BasicFluid("axiidianFluid", 0xFF77a19a);
        Fluid bismuthFluid = new BasicFluid("bismuthFluid", 0xFF555555);
        Fluid eterniteFluid = new BasicFluid("eterniteFluid", 0xFFfafa98);
        Fluid ignititeFluid = new BasicFluid("ignititeFluid", 0xFFd29453);
        Fluid karmesineFluid = new BasicFluid("karmesineFluid", 0xFFc16d6d);
        Fluid meteoriteFluid = new BasicFluid("meteoriteFluid", 0xFF6e6a62);
        Fluid mindoriteFluid = new BasicFluid("mindoriteFluid", 0xFF6bbbbf);
        Fluid mythrilFluid = new BasicFluid("mythrilFluid", 0xFFa8c0ba);
        Fluid palladiumFluid = new BasicFluid("palladiumFluid", 0xFFfe5c05);
        Fluid prometheumFluid = new BasicFluid("prometheumFluid", 0xFF2b282f);
        Fluid tiberiumFluid = new BasicFluid("tiberiumFluid", 0xFF86bd5a);
        Fluid vibraniumFluid = new BasicFluid("vibraniumFluid", 0xFFb6bba8);
        Fluid yrdeanFluid = new BasicFluid("yrdeanFluid", 0xFF3e3c6f);

        registerTinkerFluid("Arcanite", arcaniteFluid, true, 200, 10, 4000);
        registerTinkerFluid("Aardium", aardiumFluid, true, 200, 10, 4000);
        registerTinkerFluid("Adamantite", adamantiteFluid, true, 200, 10, 4000);
        registerTinkerFluid("Axiidian", axiidianFluid, true, 200, 10, 4000);
        registerTinkerFluid("Bismuth", bismuthFluid, true, 200, 10, 4000);
        registerTinkerFluid("Eternite", eterniteFluid, true, 200, 10, 4000);
        registerTinkerFluid("Ignitite", ignititeFluid, true, 200, 10, 4000);
        registerTinkerFluid("Karmesine", karmesineFluid, true, 200, 10, 4000);
        registerTinkerFluid("Meteorite", meteoriteFluid, true, 200, 10, 4000);
        registerTinkerFluid("Mindorite", mindoriteFluid, true, 200, 10, 4000);
        registerTinkerFluid("Mythril", mythrilFluid, true, 200, 10, 4000);
        registerTinkerFluid("Palladium", palladiumFluid, true, 200, 10, 4000);
        registerTinkerFluid("Prometheum", prometheumFluid, true, 200, 10, 4000);
        registerTinkerFluid("Tiberium", tiberiumFluid, true, 200, 10, 4000);
        registerTinkerFluid("Vibranium", vibraniumFluid, true, 200, 10, 4000);
        registerTinkerFluid("Yrdean", yrdeanFluid, true, 200, 10, 4000);

        // TConstruct Alloys

        Fluid astriteFluid = new BasicFluid("astriteFluid", 0xFF7a3b74);
        registerTinkerAlloys("Astrite", astriteFluid, true, 200, 10, 4000, 1, arcaniteFluid, 3, karmesineFluid, 2);
        Fluid instableNitroniteFluid = new BasicFluid("instableNitroniteFluid", 0xFF659933);
        registerTinkerAlloys("InstableNitronite", instableNitroniteFluid, true, 200, 10, 4000, 1, tiberiumFluid, 5, vibraniumFluid, 3);
        Fluid proxideumFluid = new BasicFluid("proxideumFluid", 0xFF416565);
        registerTinkerAlloys("Proxideum", proxideumFluid, true, 200, 10, 4000, 1, prometheumFluid, 3, axiidianFluid, 2);
        Fluid instablePolyniumFluid = new BasicFluid("instablePolyniumFluid", 0xFF6c6aa3);
        registerTinkerAlloys("InstablePolynium", instablePolyniumFluid, true, 200, 10, 4000, 1, yrdeanFluid, 3, meteoriteFluid, 2);
        Fluid imperomiteFluid = new BasicFluid("imperomiteFluid", 0xFF339966);
        registerTinkerAlloys("Imperomite", imperomiteFluid, true, 200, 10, 4000, 2, aardiumFluid, 3, prometheumFluid, 3);
        Fluid cryptogenFluid = new BasicFluid("cryptogenFluid", 0xFF9f8a4a);
        registerTinkerAlloys("Cryptogen", cryptogenFluid, true, 200, 10, 4000, 1, meteoriteFluid, 3, mythrilFluid, 2);
        Fluid fractoryteFluid = new BasicFluid("fractoryteFluid", 0xFFb44a14);
        registerTinkerAlloys("Fractoryte", fractoryteFluid, true, 200, 10, 4000, 1, adamantiteFluid, 4, arcaniteFluid, 2);
        Fluid seismodiumFluid = new BasicFluid("seismodiumFluid", 0xFF46131D);
        registerTinkerAlloys("Seismodium", seismodiumFluid, true, 200, 10, 4000, 1, vibraniumFluid, 4, palladiumFluid, 4);
        Fluid terramiteFluid = new BasicFluid("terramiteFluid", 0xFFa6b27a);
        registerTinkerAlloys("Terramite", terramiteFluid, true, 200, 10, 4000, 2, axiidianFluid, 4, eterniteFluid, 2);
        Fluid instablePrysociteFluid = new BasicFluid("instablePrysociteFluid", 0xFFbde398);
        registerTinkerAlloys("InstablePrysocite", instablePrysociteFluid, true, 200, 10, 4000, 1, bismuthFluid, 3, yrdeanFluid, 2);
        Fluid blazingXylititeFluid = new BasicFluid("blazingXylititeFluid", 0xFFffc81d);
        registerTinkerAlloys("BlazingXylitite", blazingXylititeFluid, true, 200, 10, 4000, 1, karmesineFluid, 3, ignititeFluid, 2);
        Fluid instableDyoniteFluid = new BasicFluid("instableDyoniteFluid", 0xFFff6743);
        registerTinkerAlloys("InstableDyonite", instableDyoniteFluid, true, 200, 10, 4000, 1, mindoriteFluid, 4, tiberiumFluid, 2);
        Fluid ultraniteFluid = new BasicFluid("ultraniteFluid", 0xFFfff69b);
        registerTinkerAlloys("Ultranite", ultraniteFluid, true, 200, 10, 4000, 1, ignititeFluid, 5, adamantiteFluid, 3);
        Fluid radiantPliniumFluid = new BasicFluid("radiantPliniumFluid", 0xFFc1ff68);
        registerTinkerAlloys("RadiantPlinium", radiantPliniumFluid, true, 200, 10, 4000, 1, palladiumFluid, 3, mindoriteFluid, 3);
        Fluid dysprosaniumFluid = new BasicFluid("dysprosaniumFluid", 0xFFb7a2bd);
        registerTinkerAlloys("Dysprosanium", dysprosaniumFluid, true, 200, 10, 4000, 1, eterniteFluid, 3, aardiumFluid, 3);
        Fluid refractiveBysmuidFluid = new BasicFluid("refractiveBysmuidFluid", 0xFF7b97b0);
        registerTinkerAlloys("RefractiveBysmuid", refractiveBysmuidFluid, true, 200, 10, 4000, 1, mythrilFluid, 4, bismuthFluid, 2);


        // Material from ores
        registerTinkerMaterial("Arcanite", arcanite, arcaniteFluid, 1, 5, 6, 7, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Tiberium", tiberium, tiberiumFluid, 1, 5, 6, 6, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Prometheum", prometheum, prometheumFluid, 1, 5, 6, 5, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Yrdean", yrdean, yrdeanFluid, 1, 5, 6, 4, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Axiidian", axiidian, axiidianFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Bismuth", bismuth, bismuthFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Karmesine", karmesine, karmesineFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Mindorite", mindorite, mindoriteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Aardium", aardium, aardiumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Meteorite", meteorite, meteoriteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Adamantite", adamantite, adamantiteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Vibranium", vibranium, vibraniumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Ignitite", ignitite, ignititeFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Palladium", palladium, palladiumFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Eternite", eternite, eterniteFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);
        registerTinkerMaterial("Mythril", mythril, mythrilFluid, 1, 5, 6, 3, 0.8f, 0, 100, false, true);

        // Material from alloys
        registerTinkerMaterial("Astrite", astrite, astriteFluid, 1, 5, 6, 7, 0.8f, 0, 100, false, true);
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
        proxy.registerClientStuff();
        GameRegistry.registerWorldGenerator(new ZWorldGen(), 100);
        GameRegistry.registerFuelHandler(new FuelHandler());
        new Smelting();
        new Crafting();
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {


    }

    private void registerOreDict() {

        OreDictionary.registerOre("oreAardium", aardiumOre);
        OreDictionary.registerOre("ingotAardium", aardiumIngot);
        OreDictionary.registerOre("oreArcanite", arcaniteOre);
        OreDictionary.registerOre("ingotArcanite", arcaniteIngot);
        OreDictionary.registerOre("oreAdamantite", adamantiteOre);
        OreDictionary.registerOre("ingotAdamantite", adamantiteIngot);
        OreDictionary.registerOre("oreAxiidian", axiidianOre);
        OreDictionary.registerOre("ingotAxiidian", axiidianIngot);
        OreDictionary.registerOre("oreBismuth", bismuthOre);
        OreDictionary.registerOre("ingotBismuth", bismuthIngot);
        OreDictionary.registerOre("oreEternite", eterniteOre);
        OreDictionary.registerOre("ingotEternite", eterniteIngot);
        OreDictionary.registerOre("oreIgnitite", ignititeOre);
        OreDictionary.registerOre("ingotIgnitite", ignititeIngot);
        OreDictionary.registerOre("oreKarmesine", karmesineOre);
        OreDictionary.registerOre("ingotKarmesine", karmesineIngot);
        OreDictionary.registerOre("oreMeteorite", meteoriteOre);
        OreDictionary.registerOre("ingotMeteorite", meteoriteIngot);
        OreDictionary.registerOre("oreMindorite", mindoriteOre);
        OreDictionary.registerOre("ingotMindorite", mindoriteIngot);
        OreDictionary.registerOre("oreMythril", mythrilOre);
        OreDictionary.registerOre("ingotMythril", mythrilIngot);
        OreDictionary.registerOre("orePalladium", palladiumOre);
        OreDictionary.registerOre("ingotPalladium", palladiumIngot);
        OreDictionary.registerOre("orePrometheum", prometheumOre);
        OreDictionary.registerOre("ingotPrometheum", prometheumIngot);
        OreDictionary.registerOre("oreTiberium", tiberiumOre);
        OreDictionary.registerOre("ingotTiberium", tiberiumIngot);
        OreDictionary.registerOre("oreVibranium", vibraniumOre);
        OreDictionary.registerOre("ingotVibranium", vibraniumIngot);
        OreDictionary.registerOre("oreYrdean", yrdeanOre);
        OreDictionary.registerOre("ingotYrdean", yrdeanIngot);


    }

    private void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    private void registerTinkerFluid(String oreDictSuffix, Fluid fluid, boolean toolForge, int temperature, int lumen, int viscosity) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName());
        tag.setString("ore", oreDictSuffix);
        tag.setBoolean("toolforge", toolForge);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);

        fluid.setTemperature(temperature).setLuminosity(lumen).setViscosity(viscosity);
    }

    private void registerTinkerAlloys(String oreDictSuffix, Fluid alloy, boolean toolFoge, int temperature, int lumen, int viscosity, int out, Fluid first, int inOne, Fluid second, int inTwo) {
        registerTinkerFluid(oreDictSuffix, alloy, toolFoge, temperature, lumen, viscosity);
        NBTTagList tagList = new NBTTagList();
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", alloy.getName());
        fluid.setInteger("Amount", out);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", first.getName());
        fluid.setInteger("Amount", inOne);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", second.getName());
        fluid.setInteger("Amount", inTwo);
        tagList.appendTag(fluid);

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }

    private void registerTinkerMaterial(String name, slimeknights.tconstruct.library.materials.Material material, Fluid fluid, int headDura, int headSpeed, int headAttack, int headLevel, float handleMod, int handleDura, int extra, boolean craft, boolean cast) {
        material.addStats(new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel)).addStats(new HandleMaterialStats(handleMod, handleDura)).addStats(new ExtraMaterialStats(extra)).setFluid(fluid).setCraftable(craft).setCastable(cast).setRenderInfo(fluid.getColor());
        new MaterialIntegration(material, fluid, name).integrate();
    }


}