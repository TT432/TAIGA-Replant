package com.sosnitzka.taiga.world;

import com.sosnitzka.taiga.ConfigHandler;
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
        if (ConfigHandler.generateAdamantite){ Generator.generateNetherOre(adamantiteOre.getDefaultState(), random, x, z, world, 25, 1, 32, 2, 5); }
        if (ConfigHandler.generateTiberium){ Generator.generateNetherOre(tiberiumOre.getDefaultState(), random, x, z, world, 60, 1, 128, 2, 7); }
        if (ConfigHandler.generatePalladium){ Generator.generateNetherOre(palladiumOre.getDefaultState(), random, x, z, world, 21, 32, 64, 2, 5); }
        if (ConfigHandler.generatePrometheum){ Generator.generateOre(prometheumOre.getDefaultState(), random, x, z, world, 21, 48, 64, 2, 4); }
    }

    private void world(Random random, int x, int z, World world) {
    	if (ConfigHandler.generateSlagIron){ Generator.generateOre(slagironOre.getDefaultState(), random, x, z, world, 40, 8, 96, 5, 16); }
    	if (ConfigHandler.generateSlagGold){ Generator.generateOre(slaggoldOre.getDefaultState(), random, x, z, world, 20, 8, 48, 5, 9); }
    	if (ConfigHandler.generateLignite){ Generator.generateOre(ligniteOre.getDefaultState(), random, x, z, world, 40, 8, 96, 5, 15); }
    	if (ConfigHandler.generateExtraIron){ Generator.generateOre(Blocks.IRON_ORE.getDefaultState(), random, x, z, world, 40, 8, 96, 2, 14); }
    	if (ConfigHandler.generateBasalt){ Generator.generateOre(basalt.getDefaultState(), Blocks.LAVA.getDefaultState(), random, x, z, world, 100, 8, 24, 2, 5); }
    	if (ConfigHandler.generateRottenGround){ Generator.generateOre(rottenGround.getDefaultState(), Blocks.DIRT.getDefaultState(), random, x, z, world, 25, 50, 70, 2, 15); }

    	if (ConfigHandler.generateVibranium){ Generator.generateOre(vibraniumOre.getDefaultState(), random, x, z, world, 18, 48, 64, 2, 4); }
    	if (ConfigHandler.generateKarmesine){ Generator.generateOre(karmesineOre.getDefaultState(), random, x, z, world, 30, 16, 48, 2, 5); }
    	if (ConfigHandler.generateBismuth){ Generator.generateOre(bismuthOre.getDefaultState(), random, x, z, world, 50, 50, 130, 2, 4); }
    	if (ConfigHandler.generateMythril){ Generator.generateOre(mythrilOre.getDefaultState(), random, x, z, world, 18, 16, 32, 2, 4); }
    	if (ConfigHandler.generateMeteorite){ Generator.generateOre(meteoriteOre.getDefaultState(), random, x, z, world, 12, 0, 32, 2, 10); }
    	if (ConfigHandler.generateMindorite){ Generator.generateOre(mindoriteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.DIORITE, random, x, z, world, 200, 16, 96, 2, 4); }
    	if (ConfigHandler.generateArcanite){ Generator.generateOre(arcaniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.GRANITE, random, x, z, world, 200, 16, 96, 2, 4); }
    	if (ConfigHandler.generateEternite){ Generator.generateOre(eterniteOre.getDefaultState(), Blocks.STONE.getDefaultState(), BlockStone.VARIANT, BlockStone.EnumType.ANDESITE, random, x, z, world, 200, 16, 96, 2, 4); }
    }

    private void end(Random random, int x, int z, World world) {

    	if (ConfigHandler.generateRubium){ Generator.generateEndOre(rubiumOre.getDefaultState(), random, x, z, world, 16, 10, 35, 2, 6); }
    	if (ConfigHandler.generateIgnitite){ Generator.generateEndOre(ignititeOre.getDefaultState(), random, x, z, world, 16, 20, 45, 2, 6); }
    	if (ConfigHandler.generateViolium){ Generator.generateEndOre(violiumOre.getDefaultState(), random, x, z, world, 16, 30, 55, 2, 6); }
    	if (ConfigHandler.generateTitanite){ Generator.generateEndOre(titaniteOre.getDefaultState(), random, x, z, world, 16, 40, 65, 2, 6); }
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
