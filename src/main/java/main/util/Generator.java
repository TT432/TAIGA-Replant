package main.util;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class Generator {

    public static void generateOre(IBlockState state, Random random, int x, int z, World world, int chance, int minY, int maxY, int minSize, int maxSize) {
        generateOre(state, Blocks.STONE.getDefaultState(), null, null, random, x, z, world, chance, minY, maxY, minSize, maxSize);
    }

    public static void generateNetherOre(IBlockState state, Random random, int x, int z, World world, int chance, int minY, int maxY, int minSize, int maxSize) {
        generateOre(state, Blocks.NETHERRACK.getDefaultState(), null, null, random, x, z, world, chance, minY, maxY, minSize, maxSize);
    }
    
    public static void generateEndOre(IBlockState state, Random random, int x, int z, World world, int chance, int minY, int maxY, int minSize, int maxSize) {
        generateOre(state, Blocks.END_STONE.getDefaultState(), null, null, random, x, z, world, chance, minY, maxY, minSize, maxSize);
    }

    public static void generateOre(IBlockState state, IBlockState replace, Random random, int chunkX, int chunkZ, World world, int chance, int minY, int maxY, int minSize, int maxSize) {
        generateOre(state, replace, null, null, random, chunkX, chunkZ, world, chance, minY, maxY, minSize, maxSize);
    }

    public static void generateOre(IBlockState state, IBlockState replace, IProperty property, Comparable comparable, Random random, int chunkX, int chunkZ, World world, int chance, int minY, int maxY, int minSize, int maxSize) {
        int size = minSize + random.nextInt(maxSize - minSize);
        int height = maxY - minY;

        for (int i = 0; i < chance; i++) {
            int posX = chunkX + random.nextInt(16);
            int posY = random.nextInt(height) + minY;
            int posZ = chunkZ + random.nextInt(16);
            new ZWorldGenMinable(state, size, StateMatcher.forState(replace, property, comparable)).generate(world, random, new BlockPos(posX, posY, posZ));
        }
    }
}
