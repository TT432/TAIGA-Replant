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
import static com.sosnitzka.taiga.TAIGAConfiguration.*;

public class ZWorldGen implements IWorldGenerator {
    private void nether(Random random, int x, int z, World world) {

        Generator.generateNetherOre(titaniteOre.getDefaultState(), random, x, z, world, (int) (35 * titaniteFactor * oreFactorGeneral), 1, 64, 2, 12);
        Generator.generateNetherOre(tiberiumOre.getDefaultState(), random, x, z, world, (int) (30 * tiberiumFactor * oreFactorGeneral), 0, 128, 2, 15);
        Generator.generateNetherOre(palladiumOre.getDefaultState(), random, x, z, world, (int) (35 * palladiumFactor * oreFactorGeneral), 32, 64, 2, 6);
        Generator.generateNetherOre(prometheumOre.getDefaultState(), random, x, z, world, (int) (35 * prometheumFactor * oreFactorGeneral), 64, 128, 2, 6);
    }

    private void world(Random random, int x, int z, World world) {

        // Optional
        if (slagIronGen) {
            Generator.generateOre(slagironOre.getDefaultState(), random, x, z, world, (int) (45 * slagironFactor * oreFactorGeneral), 0, 128, 2, 12);
        }
        if (slagGoldGen) {
            Generator.generateOre(slaggoldOre.getDefaultState(), random, x, z, world, (int) (20 * slaggoldFactor * oreFactorGeneral), 0, 32, 2, 12);
        }
        if (ironGen) {
            Generator.generateOre(Blocks.IRON_ORE.getDefaultState(), random, x, z, world, (int) (30 * ironFactor * oreFactorGeneral), 0, 128, 1, 9);
        }

        // to be integrated mod specific
        Generator.generateOre(basalt.getDefaultState(), Blocks.LAVA.getDefaultState(), random, x, z, world, (int) (125 * basaltFactor * oreFactorGeneral), 0, 28, 2, 4);
        Generator.generateOre(rottenGround.getDefaultState(), Blocks.DIRT.getDefaultState(), random, x, z, world, (int) (25 * rottengroundFactor * oreFactorGeneral), 50, 70, 2, 15);

        Generator.generateOre(ligniteOre.getDefaultState(), random, x, z, world, (int) (30 * ligniteFactor * oreFactorGeneral), 8, 96, 2, 12);
        Generator.generateOre(vibraniumOre.getDefaultState(), random, x, z, world, (int) (30 * vibraniumFactor * oreFactorGeneral), 48, 64, 2, 8);
        Generator.generateOre(karmesineOre.getDefaultState(), random, x, z, world, (int) (35 * karmesineFactor * oreFactorGeneral), 16, 48, 2, 8);
        Generator.generateOre(bismuthOre.getDefaultState(), random, x, z, world, (int) (40 * bismuthFactor * oreFactorGeneral), 50, 130, 2, 4);
        Generator.generateOre(mythrilOre.getDefaultState(), random, x, z, world, (int) (34 * mythrilFactor * oreFactorGeneral), 16, 32, 2, 8);
        Generator.generateOre(meteoriteOre.getDefaultState(), random, x, z, world, (int) (10 * meteoriteFactor * oreFactorGeneral), 0, 32, 2, 25);
        Generator.generateOre(mindoriteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.DIORITE, random, x, z, world, (int) (120 * mindoriteFactor * oreFactorGeneral), 16, 96, 2, 8);
        Generator.generateOre(arcaniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.GRANITE, random, x, z, world, (int) (120 * arcaniteFactor * oreFactorGeneral), 16, 96, 2, 8);
        Generator.generateOre(eterniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.ANDESITE, random, x, z, world, (int) (120 * eterniteFactor * oreFactorGeneral), 16, 96, 2, 8);
    }

    private void end(Random random, int x, int z, World world) {
        Generator.generateEndOre(adamantiteOre.getDefaultState(), random, x, z, world, (int) (15 * adamantiteFactor * oreFactorGeneral), 10, 35, 2, 8);
        Generator.generateEndOre(rubiumOre.getDefaultState(), random, x, z, world, (int) (15 * rubiumFactor * oreFactorGeneral), 10, 65, 2, 8);
        Generator.generateEndOre(ignititeOre.getDefaultState(), random, x, z, world, (int) (15 * ignititeFactor * oreFactorGeneral), 10, 45, 2, 8);
        Generator.generateEndOre(violiumOre.getDefaultState(), random, x, z, world, (int) (15 * violiumFactor * oreFactorGeneral), 10, 55, 2, 8);

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
