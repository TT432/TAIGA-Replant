package com.sosnitzka.taiga.blocks;

import com.sosnitzka.taiga.generic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class BlockLignite extends BasicBlock {

    public BlockLignite() {
        super("lignite_ore", Material.ROCK, 4.0f, 5.0f, 1);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World) world).rand : new Random();
        int r = RANDOM.nextInt(11);
        if (r > 7) {
            return MathHelper.getInt(rand, 0, 10) + fortune;
        } else return 0;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return random.nextInt(3) + 1 + fortune;
    }
}
