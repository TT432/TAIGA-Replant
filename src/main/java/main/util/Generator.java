package main.util;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class Generator {
	
	public static void generateOre(IBlockState state, Random random, int x, int z, World world, int chance, int minY, int maxY, int minSize, int maxSize){
		generateOre(state, Blocks.STONE, random, x, z, world, chance, minY, maxY, minSize, maxSize);
	}
	
	public static void generateNetherOre(IBlockState state, Random random, int x, int z, World world, int chance, int minY, int maxY, int minSize, int maxSize){
		generateOre(state, Blocks.NETHERRACK, random, x, z, world, chance, minY, maxY, minSize, maxSize);
	}
		
	
	public static void generateOre(IBlockState state, Block replace, Random random, int chunkX, int chunkZ, World world, int chance, int minY, int maxY, int minSize, int maxSize){
		int size = minSize + random.nextInt(maxSize - minSize);
		int height = maxY - minY;
		
		for(int i = 0; i < chance; i++) {
			int posX = chunkX + random.nextInt(16);
			int posY = random.nextInt(height) + minY;
			int posZ = chunkZ + random.nextInt(16);
			new WorldGenMinable(state, size, BlockMatcher.forBlock(replace)).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	
	
}
