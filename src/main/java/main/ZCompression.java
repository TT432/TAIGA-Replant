package main;

import blocks.*;
import fluids.BasicFluid;
import items.*;
import main.util.FuelHandler;
import main.util.recipes.Crafting;
import main.util.recipes.Smelting;
import main.world.ZWorldGen;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
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
    // Items
    public static ItemSlagironIngot slagironIngot = new ItemSlagironIngot();
    public static ItemLignite lignite = new ItemLignite();
    public static ItemIronNugget iron_nugget = new ItemIronNugget();
    public static ItemSlaggoldIngot slaggoldIngot = new ItemSlaggoldIngot();
    public static ItemFuelBrick fuel_brick = new ItemFuelBrick();

    public static ItemAardiumIngot aardiumIngot = new ItemAardiumIngot();
    public static ItemAdamantiteIngot adamantiteIngot = new ItemAdamantiteIngot();
    public static ItemArcaniteIngot arcaniteIngot = new ItemArcaniteIngot();
    public static ItemAxiidianIngot axiidianIngot = new ItemAxiidianIngot();
    public static ItemBismuthIngot bismuthIngot = new ItemBismuthIngot();
    public static ItemEterniteIngot eterniteIngot = new ItemEterniteIngot();
    public static ItemIgnititeIngot ignititeIngot = new ItemIgnititeIngot();
    public static ItemKarmesineIngot karmesineIngot = new ItemKarmesineIngot();
    public static ItemMeteoriteIngot meteoriteIngot = new ItemMeteoriteIngot();
    public static ItemMindoriteIngot mindoriteIngot = new ItemMindoriteIngot();
    public static ItemMythrilIngot mythrilIngot = new ItemMythrilIngot();
    public static ItemPalladiumIngot palladiumIngot = new ItemPalladiumIngot();
    public static ItemPrometheumIngot prometheumIngot = new ItemPrometheumIngot();
    public static ItemTiberiumIngot tiberiumIngot = new ItemTiberiumIngot();
    public static ItemVibraniumIngot vibraniumIngot = new ItemVibraniumIngot();
    public static ItemYrdeanIngot yrdeanIngot = new ItemYrdeanIngot();

    //Blocks, esp. for tconstruct
    public static BlockAardiumOre aardiumOre = new BlockAardiumOre();
    public static BlockAdamantiteOre adamantiteOre = new BlockAdamantiteOre();
    public static BlockArcaniteOre arcaniteOre = new BlockArcaniteOre();
    public static BlockAxiidianOre axiidianOre = new BlockAxiidianOre();
    public static BlockBasalt basalt = new BlockBasalt();
    public static BlockBismuthOre bismuthOre = new BlockBismuthOre();
    public static BlockEterniteOre eterniteOre = new BlockEterniteOre();
    public static BlockIgnititeOre ignititeOre = new BlockIgnititeOre();
    public static BlockKarmesineOre karmesineOre = new BlockKarmesineOre();
    public static BlockLigniteOre ligniteOre = new BlockLigniteOre();
    public static BlockMeteoriteOre meteoriteOre = new BlockMeteoriteOre();
    public static BlockMindoriteOre mindoriteOre = new BlockMindoriteOre();
    public static BlockMythrilOre mythrilOre = new BlockMythrilOre();
    public static BlockPalladiumOre palladiumOre = new BlockPalladiumOre();
    public static BlockPrometheumOre prometheumOre = new BlockPrometheumOre();
    public static BlockRottenGround rottenGround = new BlockRottenGround();
    public static BlockSlagironOre slagironOre = new BlockSlagironOre();
    public static BlockSlaggoldOre slaggoldOre = new BlockSlaggoldOre();
    public static BlockTiberiumOre tiberiumOre = new BlockTiberiumOre();
    public static BlockVibraniumOre vibraniumOre = new BlockVibraniumOre();
    public static BlockYrdeanOre yrdeanOre = new BlockYrdeanOre();


    @SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
    private static ServerProxy proxy;

    private static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        //Items
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

        // TConstruct registrations
        registerOreDict();
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
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Aardium", aardiumFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Adamantite", adamantiteFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Axiidian", axiidianFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Bismuth", bismuthFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Eternite", eterniteFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Ignitite", ignititeFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Karmesine", karmesineFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Meteorite", meteoriteFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Mindorite", mindoriteFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Mythril", mythrilFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Palladium", palladiumFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Prometheum", prometheumFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Tiberium", tiberiumFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Vibranium", vibraniumFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);
        registerTinkerFluid("Yrdean", yrdeanFluid, true);
        aardiumFluid.setTemperature(200).setRarity(EnumRarity.RARE).setLuminosity(10).setViscosity(4000);

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
}