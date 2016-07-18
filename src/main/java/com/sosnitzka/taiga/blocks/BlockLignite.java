package com.sosnitzka.taiga.blocks;

import com.sosnitzka.taiga.generic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static com.sosnitzka.taiga.Items.lignite;
import static com.sosnitzka.taiga.Items.lignite2;
import static com.sosnitzka.taiga.Items.lignite3;

public class BlockLignite extends BasicBlock {

    public BlockLignite() {
        super("lignite_ore", Material.ROCK, 4.0f, 5.0f, 1);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World) world).rand : new Random();
        int r = RANDOM.nextInt(11);
        if (r > 7) {
            return MathHelper.getRandomIntegerInRange(rand, 0, 10) + fortune;
        } else return 0;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return MathHelper.getRandomIntegerInRange(random, 1, 3 + fortune);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        int r = RANDOM.nextInt(3);
        if (r == 0) {
            return lignite;
        } else if (r == 1) {
            return lignite2;
        } else
            return lignite3;
    }
}
