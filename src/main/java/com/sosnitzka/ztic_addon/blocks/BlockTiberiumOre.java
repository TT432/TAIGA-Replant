package com.sosnitzka.ztic_addon.blocks;

import com.sosnitzka.ztic_addon.Items;
import com.sosnitzka.ztic_addon.generic.BasicBlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTiberiumOre extends BasicBlockOre {

    public BlockTiberiumOre() {
        super("tiberium_ore", Material.ROCK, 30.0f, 30.0f, 3, 1.0F);
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
        return MathHelper.getRandomIntegerInRange(random, 1, MathHelper.getRandomIntegerInRange(random, 1, 3 + fortune));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.tiberiumShardInstable;
    }
}
