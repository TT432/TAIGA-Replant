package com.sosnitzka.ztic_addon.main.world;

import com.sosnitzka.ztic_addon.main.ZTiC;
import com.sosnitzka.ztic_addon.main.util.Generator;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ZWorldGen implements IWorldGenerator {
    private void nether(Random random, int x, int z, World world) {
        Generator.generateNetherOre(ZTiC.adamantiteOre.getDefaultState(), random, x, z, world, 25, 1, 32, 2, 5);
        Generator.generateNetherOre(ZTiC.tiberiumOre.getDefaultState(), random, x, z, world, 60, 1, 128, 2, 7);
        Generator.generateNetherOre(ZTiC.palladiumOre.getDefaultState(), random, x, z, world, 21, 32, 64, 2, 5);
        Generator.generateOre(ZTiC.prometheumOre.getDefaultState(), random, x, z, world, 21, 48, 64, 2, 4);
    }

    private void world(Random random, int x, int z, World world) {
        Generator.generateOre(ZTiC.slagironOre.getDefaultState(), random, x, z, world, 40, 8, 96, 5, 16);
        Generator.generateOre(ZTiC.slaggoldOre.getDefaultState(), random, x, z, world, 20, 8, 48, 5, 9);
        Generator.generateOre(ZTiC.ligniteOre.getDefaultState(), random, x, z, world, 40, 8, 96, 5, 15);
        Generator.generateOre(Blocks.IRON_ORE.getDefaultState(), random, x, z, world, 40, 8, 96, 2, 14);
        Generator.generateOre(ZTiC.basalt.getDefaultState(), Blocks.LAVA.getDefaultState(), random, x, z, world, 100, 8, 24, 2, 5);
        Generator.generateOre(ZTiC.rottenGround.getDefaultState(), Blocks.DIRT.getDefaultState(), random, x, z, world, 25, 50, 70, 2, 15);

        Generator.generateOre(ZTiC.vibraniumOre.getDefaultState(), random, x, z, world, 18, 48, 64, 2, 4);
        Generator.generateOre(ZTiC.karmesineOre.getDefaultState(), random, x, z, world, 30, 16, 48, 2, 5);
        Generator.generateOre(ZTiC.bismuthOre.getDefaultState(), random, x, z, world, 50, 50, 130, 2, 4);
        Generator.generateOre(ZTiC.mythrilOre.getDefaultState(), random, x, z, world, 18, 16, 32, 2, 4);
        Generator.generateOre(ZTiC.meteoriteOre.getDefaultState(), random, x, z, world, 12, 0, 32, 2, 10);
        Generator.generateOre(ZTiC.mindoriteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.DIORITE, random, x, z, world, 200, 16, 96, 2, 4);
        Generator.generateOre(ZTiC.arcaniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.GRANITE, random, x, z, world, 200, 16, 96, 2, 4);
        Generator.generateOre(ZTiC.eterniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.ANDESITE, random, x, z, world, 200, 16, 96, 2, 4);
    }

    private void end(Random random, int x, int z, World world) {

        Generator.generateEndOre(ZTiC.yrdeanOre.getDefaultState(), random, x, z, world, 16, 10, 35, 2, 6);
        Generator.generateEndOre(ZTiC.ignititeOre.getDefaultState(), random, x, z, world, 16, 20, 45, 2, 6);
        Generator.generateEndOre(ZTiC.axiidianOre.getDefaultState(), random, x, z, world, 16, 30, 55, 2, 6);
        Generator.generateEndOre(ZTiC.aardiumOre.getDefaultState(), random, x, z, world, 16, 40, 65, 2, 6);
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
