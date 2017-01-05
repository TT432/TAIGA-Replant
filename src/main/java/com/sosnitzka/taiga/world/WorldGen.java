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
import static com.sosnitzka.taiga.TAIGAConfiguration.*;

@SuppressWarnings("unchecked")
public class WorldGen implements IWorldGenerator {
    private void nether(Random random, int x, int z, World world) {
        Generator.generateOre(tiberiumOre.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), random, x, z, world, TIBERIUM_VAL, 0, 128, 10, 35);
        Generator.generateOre(prometheumOre.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), random, x, z, world, PROMETHEUM_VAL, 0, 128, 2, 4);
        Generator.generateOre(valyriumOre.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), random, x, z, world, VALYRIUM_VAL, 0, 32, 2, 4);
        Generator.generateOre(newArrayList(Blocks.LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState()), osramOre.getDefaultState(), random, x, z, world, OSRAM_VAL, 0, 64, 15);
    }

    private void world(Random random, int x, int z, World world) {
        Generator.generateMeteor(duraniteOre.getDefaultState(), blockMeteorite.getDefaultState(), random, x, z, world, DURANITE_VAL, 6, 16, 112);
        Generator.generateOreDescending(newArrayList(Blocks.LAVA.getDefaultState(), Blocks.FLOWING_LAVA.getDefaultState()), basaltBlock.getDefaultState(), random, x, z, world, BASALT_VAL, 0, 64);
        Generator.generateOreDescending(newArrayList(Blocks.BEDROCK.getDefaultState()), eezoOre.getDefaultState(), random, x, z, world, EEZO_VAL, 0, 10);
        Generator.generateOreStoneVariant(karmesineOre.getDefaultState(), BlockStone.EnumType.ANDESITE, random, x, z, world, KARMESINE_VAL);
        Generator.generateOreStoneVariant(oviumOre.getDefaultState(), BlockStone.EnumType.DIORITE, random, x, z, world, OVIUM_VAL);
        Generator.generateOreStoneVariant(jauxumOre.getDefaultState(), BlockStone.EnumType.GRANITE, random, x, z, world, JAUXUM_VAL);
        Generator.generateOre(vibraniumOre.getDefaultState(), Blocks.STONE.getDefaultState(), random, x, z, world, VIBRANIUM_VAL, 100, 0, 64, 2, 6, newArrayList(Biomes.DESERT_HILLS, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES, Biomes.DESERT));
        Generator.generateOre(dilithiumOre.getDefaultState(), Blocks.STONE.getDefaultState(), random, x, z, world, DILITHIUM_VAL, 100, 0, 64, 2, 8, newArrayList(Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.MUTATED_DESERT, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.FROZEN_OCEAN, Biomes.BEACH));
        Generator.generateOre(vibraniumOre.getDefaultState(), Blocks.STONE.getDefaultState(), random, x, z, world, 1, 25, 0, 128, 1, 5, null);
        if (ironGen) {
            Generator.generateOre(Blocks.IRON_ORE.getDefaultState(), Blocks.STONE.getDefaultState(), random, x, z, world, IRON_VAL, 0, 32, 2, 8);
        }
    }

    private void end(Random random, int x, int z, World world) {
        Generator.generateCube(true, uruOre.getDefaultState(), blockObsidiorite.getDefaultState(), random, x, z, world, URU_VAL, 2, 0, 96, 3);
        if (endGen)
            Generator.generateOre(Blocks.AIR.getDefaultState(), Blocks.END_STONE.getDefaultState(), null, null, random, x, z, world, 1, 100, 3, 64, 3, 8, null);
        Generator.generateOre(auroriumOre.getDefaultState(), Blocks.END_STONE.getDefaultState(), random, x, z, world, AURORIUM_VAL, 32, 48, 2, 4);
        Generator.generateOre(palladiumOre.getDefaultState(), Blocks.END_STONE.getDefaultState(), random, x, z, world, PALLADIUM_VAL, 48, 64, 2, 4);
        Generator.generateOreBottom(Blocks.END_STONE.getDefaultState(), abyssumOre.getDefaultState(), random, x, z, world, ABYSSUM_VAL, 4, 64);
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
