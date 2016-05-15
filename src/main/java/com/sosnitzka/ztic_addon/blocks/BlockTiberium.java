package com.sosnitzka.ztic_addon.blocks;

import com.sosnitzka.ztic_addon.Items;
import com.sosnitzka.ztic_addon.generic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import static com.sosnitzka.ztic_addon.util.Utils.PREFIX_ORE;

public class BlockTiberium extends BasicBlock {

    public BlockTiberium() {
        super("tiberium_ore", Material.ROCK, 15.0f, 2.0f, 6, 1.0F, PREFIX_ORE);
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
        return MathHelper.getRandomIntegerInRange(random, 1, MathHelper.getRandomIntegerInRange(random, 1, 31 + fortune));
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.tiberiumShardInstable;
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (new Random().nextBoolean() || new Random().nextBoolean()) {
            worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1f, true, true);
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if (new Random().nextBoolean() && new Random().nextBoolean() && new Random().nextBoolean()) {
            worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1f, true, true);
        }
    }

}
