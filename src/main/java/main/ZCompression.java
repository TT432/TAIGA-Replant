package main;

import blocks.*;
import fluids.MoltenAardium;
import items.*;
import main.util.FuelHandler;
import main.util.recipes.Crafting;
import main.util.recipes.Smelting;
import main.world.ZWorldGen;
import net.minecraft.block.Block;
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

    // Fluids
    public static MoltenAardium moltenAardium = new MoltenAardium();


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
        registerFluid(moltenAardium);
        registerTinkerFluid("Aardium", moltenAardium, true);
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