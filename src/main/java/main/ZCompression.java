package main;

import blocks.BasicBlock;
import blocks.BlockAdamantiteOre;
import blocks.BlockArcaniteOre;
import blocks.BlockBasalt;
import blocks.BlockBismuthOre;
import blocks.BlockEterniteOre;
import blocks.BlockKarmesineOre;
import blocks.BlockLigniteOre;
import blocks.BlockMeteoriteOre;
import blocks.BlockMindoriteOre;
import blocks.BlockMythrilOre;
import blocks.BlockPalladiumOre;
import blocks.BlockPrometheumOre;
import blocks.BlockRottenGround;
import blocks.BlockSlagironOre;
import blocks.BlockTiberiumOre;
import blocks.BlockVibraniumre;
import items.ItemSlagiron;
import main.world.ZWorldGen;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import proxy.ServerProxy;

@Mod(modid = ZCompression.MODID, version = ZCompression.VERSION)
public class ZCompression {

	public static final String MODID = "zcompression";
	public static final String VERSION = "1.0";
	
	@SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.ServerProxy")
	public static ServerProxy proxy;
	
	// Items
	public static ItemSlagiron slagiron = new ItemSlagiron();
	
	
	//Blocks, esp. for tconstruct
	public static BlockAdamantiteOre adamantiteOre = new BlockAdamantiteOre();
	public static BlockArcaniteOre arcaniteOre = new BlockArcaniteOre();
	public static BlockBasalt basalt = new BlockBasalt();
	public static BlockBismuthOre bismuthOre = new BlockBismuthOre();
	public static BlockEterniteOre eterniteOre = new BlockEterniteOre();
	public static BlockKarmesineOre karmesineOre = new BlockKarmesineOre();
	public static BlockLigniteOre ligniteOre = new BlockLigniteOre();
	public static BlockMeteoriteOre meteoriteOre = new BlockMeteoriteOre();
	public static BlockMindoriteOre mindoriteOre = new BlockMindoriteOre();
	public static BlockMythrilOre mythrilOre = new BlockMythrilOre();
	public static BlockPalladiumOre palladiumOre = new BlockPalladiumOre();
	public static BlockPrometheumOre prometheumOre = new BlockPrometheumOre();
	public static BlockRottenGround rottenGround = new BlockRottenGround();
	public static BlockSlagironOre slagironOre = new BlockSlagironOre();
	public static BlockTiberiumOre tiberiumOre = new BlockTiberiumOre(); 
	public static BlockVibraniumre vibraniumOre = new BlockVibraniumre();
	
	
	
	
	
	
	
	
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		GameRegistry.register(slagiron);
		registerBlock(adamantiteOre);
		registerBlock(arcaniteOre);
		registerBlock(basalt);
		registerBlock(bismuthOre);
		registerBlock(eterniteOre);
		registerBlock(karmesineOre);
		registerBlock(ligniteOre);
		registerBlock(meteoriteOre);
		registerBlock(mindoriteOre);
		registerBlock(mythrilOre);
		registerBlock(palladiumOre);
		registerBlock(prometheumOre);
		registerBlock(rottenGround);
		registerBlock(slagironOre);
		registerBlock(tiberiumOre);
		registerBlock(vibraniumOre);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		proxy.registerClientStuff();
		GameRegistry.registerWorldGenerator(new ZWorldGen(), 100);
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){

	}
	
	public static void registerBlock(BasicBlock block){
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}
	
	
	
}
