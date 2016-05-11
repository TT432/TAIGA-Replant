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

        BasicFluid arcaniteFluid = new BasicFluid("arcaniteFluid", 0xFF272354);
        BasicFluid aardiumFluid = new BasicFluid("aardiumFluid", 0xFFC3F93D);
        BasicFluid adamantiteFluid = new BasicFluid("adamantiteFluid", 0xFFc45c82);
        BasicFluid axiidianFluid = new BasicFluid("axiidianFluid", 0xFF77a19a);
        BasicFluid bismuthFluid = new BasicFluid("bismuthFluid", 0xFF555555);
        BasicFluid eterniteFluid = new BasicFluid("eterniteFluid", 0xFFfafa98);
        BasicFluid ignititeFluid = new BasicFluid("ignititeFluid", 0xFFd29453);
        BasicFluid karmesineFluid = new BasicFluid("karmesineFluid", 0xFFc16d6d);
        BasicFluid meteoriteFluid = new BasicFluid("meteoriteFluid", 0xFF6e6a62);
        BasicFluid mindoriteFluid = new BasicFluid("mindoriteFluid", 0xFF6bbbbf);
        BasicFluid mythrilFluid = new BasicFluid("mythrilFluid", 0xFFa8c0ba);
        BasicFluid palladiumFluid = new BasicFluid("palladiumFluid", 0xFFfe5c05);
        BasicFluid prometheumFluid = new BasicFluid("prometheumFluid", 0xFF2b282f);
        BasicFluid tiberiumFluid = new BasicFluid("tiberiumFluid", 0xFF174124);
        BasicFluid vibraniumFluid = new BasicFluid("vibraniumFluid", 0xFFb6bba8);
        BasicFluid yrdeanFluid = new BasicFluid("yrdeanFluid", 0xFF3e3c6f);

        registerFluid(arcaniteFluid);
        registerFluid(aardiumFluid);
        registerFluid(adamantiteFluid);
        registerFluid(axiidianFluid);
        registerFluid(bismuthFluid);
        registerFluid(eterniteFluid);
        registerFluid(ignititeFluid);
        registerFluid(karmesineFluid);
        registerFluid(meteoriteFluid);
        registerFluid(mindoriteFluid);
        registerFluid(mythrilFluid);
        registerFluid(palladiumFluid);
        registerFluid(prometheumFluid);
        registerFluid(tiberiumFluid);
        registerFluid(vibraniumFluid);
        registerFluid(yrdeanFluid);

        registerTinkerFluid("Arcanite", arcaniteFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Aardium", aardiumFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Adamantite", adamantiteFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Axiidian", axiidianFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Bismuth", bismuthFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Eternite", eterniteFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Ignitite", ignititeFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Karmesine", karmesineFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Meteorite", meteoriteFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Mindorite", mindoriteFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Mythril", mythrilFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Palladium", palladiumFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Prometheum", prometheumFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Tiberium", tiberiumFluid, true);
        aardiumFluid.setTemperature(2000).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Vibranium", vibraniumFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Yrdean", yrdeanFluid, true);
        aardiumFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);

        // TConstruct Alloys

        BasicFluid fractoryteFluid = new BasicFluid("fractoryteFluid", 0xFF75BFEB);

        registerFluid(fractoryteFluid);

        registerTinkerFluid("Fractoryte", fractoryteFluid, true);
        fractoryteFluid.setTemperature(200).setLuminosity(10).setViscosity(4000);

        registerTinkerAlloys(fractoryteFluid, adamantiteFluid, arcaniteFluid);


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

    private void registerTinkerFluid(String oreDictSuffix, Fluid fluid, boolean toolForge) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("fluid", fluid.getName());
        tag.setString("ore", oreDictSuffix);
        tag.setBoolean("toolforge", toolForge);
        FMLInterModComms.sendMessage("tconstruct", "integrateSmeltery", tag);
    }

    private void registerTinkerAlloys(Fluid alloy, Fluid first, Fluid second) {
        NBTTagList tagList = new NBTTagList();
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", alloy.getName());
        fluid.setInteger("Amount", 144);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", first.getName());
        fluid.setInteger("Amount", 144);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", second.getName());
        fluid.setInteger("Amount", 288);
        tagList.appendTag(fluid);

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }

}