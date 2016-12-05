package com.sosnitzka.taiga.world;


import com.sosnitzka.taiga.util.Generator;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static com.google.common.collect.Lists.newArrayList;
import static com.sosnitzka.taiga.Blocks.*;
import static com.sosnitzka.taiga.TAIGAConfiguration.ironGen;

@SuppressWarnings("unchecked")
public class WorldGen implements IWorldGenerator {
    private void nether(Random random, int x, int z, World world) {

        Generator.generateOre(false, Blocks.NETHERRACK.getDefaultState(), tiberiumOre.getDefaultState(), random, x, z, world, 15, 0, 128, 10, 35);
        Generator.generateOre(true, Blocks.NETHERRACK.getDefaultState(), prometheumOre.getDefaultState(), random, x, z, world, 25, 0, 128, 2, 4);
        Generator.generateOre(true, Blocks.NETHERRACK.getDefaultState(), valyriumOre.getDefaultState(), random, x, z, world, 10, 0, 32, 2, 4);
        Generator.generateOreDescending(newArrayList(Blocks.LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState()), osramOre.getDefaultState(), random, x, z, world, 1, 0, 64, 5);

    }

    private void world(Random random, int x, int z, World world) {
        // Optional
        if (!ironGen) {
            Generator.generateOre(false, Blocks.STONE.getDefaultState(), Blocks.IRON_ORE.getDefaultState(), random, x, z, world, 20, 0, 128, 1, 8);
        }
        Generator.generateMeteor(duraniteOre.getDefaultState(), blockMeteorite.getDefaultState(), random, x, z, world, 1, 4, 16, 112);
        Generator.generateOreDescending(newArrayList(Blocks.LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState()), basaltBlock.getDefaultState(), random, x, z, world, 10, 0, 64);
        Generator.generateOreDescending(newArrayList(Blocks.BEDROCK.getDefaultState()), eezoOre.getDefaultState(), random, x, z, world, 3, 0, 10);
        Generator.generateOre(karmesineOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.DIORITE, random, x, z, world, 15, 0, 96, 3, 4, null);
        Generator.generateOre(karmesineOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.ANDESITE, random, x, z, world, 15, 0, 96, 3, 4, null);
        Generator.generateOre(karmesineOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.GRANITE, random, x, z, world, 15, 0, 96, 3, 4, null);
        Generator.generateOreDense(vibraniumOre.getDefaultState(), Blocks.STONE.getDefaultState(), random, x, z, world, 10, 0, 64, 2, 12, newArrayList(Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.DESERT));
    }

    private void end(Random random, int x, int z, World world) {
        Generator.generateCube(true, uruOre.getDefaultState(), blockObsidiorite.getDefaultState(), random, x, z, world, 1, 2, 0, 96, 3);
        Generator.generateOre(Blocks.END_STONE.getDefaultState(), Blocks.AIR.getDefaultState(), null, null, random, x, z, world, 1, 3, 64, 3, 8, null);
        Generator.generateOre(false, Blocks.END_STONE.getDefaultState(), auroriumOre.getDefaultState(), random, x, z, world, 10, 32, 48, 2, 4);
        Generator.generateOre(true, Blocks.END_STONE.getDefaultState(), palladiumOre.getDefaultState(), random, x, z, world, 10, 48, 64, 2, 4);
        Generator.generateOreBottom(Blocks.END_STONE.getDefaultState(), abyssumOre.getDefaultState(), random, x, z, world, 12, 4, 64);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        switch (world.provider.getDimension()) {
            case -1:
                nether(random, x, z, world);
                break;
            case 0:
                world(random, x, z, world);
                break;
            case 1:
                end(random, x, z, world);
                break;
            default:
                world(random, x, z, world);
                break;
        }
    }
}
