package com.sosnitzka.taiga.world;

import com.sosnitzka.taiga.util.Generator;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static com.sosnitzka.taiga.Blocks.*;

public class ZWorldGen implements IWorldGenerator {
    private void nether(Random random, int x, int z, World world) {

        Generator.generateNetherOre(titaniteOre.getDefaultState(), random, x, z, world, 30, 1, 64, 2, 12);
        Generator.generateNetherOre(tiberiumOre.getDefaultState(), random, x, z, world, 30, 1, 128, 7, 15);
        Generator.generateNetherOre(palladiumOre.getDefaultState(), random, x, z, world, 30, 32, 64, 2, 7);
        Generator.generateNetherOre(prometheumOre.getDefaultState(), random, x, z, world, 30, 64, 128, 2, 6);
    }

    private void world(Random random, int x, int z, World world) {
        Generator.generateOre(slagironOre.getDefaultState(), random, x, z, world, 45, 8, 96, 5, 12);
        Generator.generateOre(slaggoldOre.getDefaultState(), random, x, z, world, 30, 8, 48, 4, 8);
        Generator.generateOre(ligniteOre.getDefaultState(), random, x, z, world, 30, 8, 96, 5, 12);
        Generator.generateOre(Blocks.IRON_ORE.getDefaultState(), random, x, z, world, 40, 8, 96, 2, 8);
        Generator.generateOre(basalt.getDefaultState(), Blocks.LAVA.getDefaultState(), random, x, z, world, 100, 8, 24, 2, 5);
        Generator.generateOre(rottenGround.getDefaultState(), Blocks.DIRT.getDefaultState(), random, x, z, world, 25, 50, 70, 2, 15);

        Generator.generateOre(vibraniumOre.getDefaultState(), random, x, z, world, 30, 48, 64, 2, 8);
        Generator.generateOre(karmesineOre.getDefaultState(), random, x, z, world, 35, 16, 48, 2, 7);
        Generator.generateOre(bismuthOre.getDefaultState(), random, x, z, world, 60, 50, 130, 2, 4);
        Generator.generateOre(mythrilOre.getDefaultState(), random, x, z, world, 33, 16, 32, 2, 8);
        Generator.generateOre(meteoriteOre.getDefaultState(), random, x, z, world, 10, 0, 32, 2, 25);
        Generator.generateOre(mindoriteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.DIORITE, random, x, z, world, 150, 16, 96, 2, 8);
        Generator.generateOre(arcaniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.GRANITE, random, x, z, world, 150, 16, 96, 2, 8);
        Generator.generateOre(eterniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.ANDESITE, random, x, z, world, 150, 16, 96, 2, 8);
    }

    private void end(Random random, int x, int z, World world) {
        Generator.generateEndOre(adamantiteOre.getDefaultState(), random, x, z, world, 15, 10, 35, 2, 8);
        Generator.generateEndOre(rubiumOre.getDefaultState(), random, x, z, world, 15, 10, 65, 2, 8);
        Generator.generateEndOre(ignititeOre.getDefaultState(), random, x, z, world, 15, 10, 45, 2, 8);
        Generator.generateEndOre(violiumOre.getDefaultState(), random, x, z, world, 15, 10, 55, 2, 8);

    }


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {
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
        }
    }
}
