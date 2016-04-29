package main.world;

import java.util.Random;

import com.google.common.base.Predicates;

import main.ZCompression;
import main.util.Generator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ZWorldGen implements IWorldGenerator {

	
	private void nether(Random random, int x, int z, World world){
		Generator.generateNetherOre(ZCompression.adamantiteOre.getDefaultState(), random, x, z, world, 24, 1, 32, 2, 5);
		Generator.generateNetherOre(ZCompression.tiberiumOre.getDefaultState(), random, x, z, world, 60, 1, 128, 2, 10);
		Generator.generateNetherOre(ZCompression.palladiumOre.getDefaultState(), random, x, z, world, 15, 32, 64, 3, 6);
		Generator.generateOre(ZCompression.prometheumOre.getDefaultState(), random, x, z, world, 20, 48, 64, 2, 4);
	}
	
	private void world(Random random, int x, int z, World world){
		// Regular
		Generator.generateOre(ZCompression.slagironOre.getDefaultState(), random, x, z, world, 40, 8, 96, 5, 16);
		Generator.generateOre(ZCompression.ligniteOre.getDefaultState(), random, x, z, world, 40, 8, 96, 5, 15);
		Generator.generateOre(Blocks.IRON_ORE.getDefaultState(),random, x, z, world, 40, 8, 96, 2, 10);
		Generator.generateOre(ZCompression.basalt.getDefaultState(), Blocks.LAVA, random, x, z, world, 20, 8, 24, 2, 5);
		Generator.generateOre(ZCompression.rottenGround.getDefaultState(), Blocks.DIRT, random, x, z, world, 25, 50, 70, 2, 15);
		
		Generator.generateOre(ZCompression.vibraniumOre.getDefaultState(), random, x, z, world, 16, 48, 64, 2, 4);
		Generator.generateOre(ZCompression.mythrilOre.getDefaultState(), random, x, z, world, 16, 16, 32, 2, 4);
		Generator.generateOre(ZCompression.meteoriteOre.getDefaultState(), random, x, z, world, 25, 0, 32, 3, 6);
		Generator.generateOre(ZCompression.mindoriteOre.getDefaultState(), Blocks.STONE, random, x, z, world, 450, 32, 96, 3, 6);
	}

	private void end(Random random, int x, int z, World world){
	
	}
	
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		int x = chunkX * 16;
		int z = chunkZ * 16;
		switch(world.provider.getDimension()) {
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
