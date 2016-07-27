package com.sosnitzka.taiga.blocks;

import com.sosnitzka.taiga.Items;
import com.sosnitzka.taiga.generic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

import static com.sosnitzka.taiga.util.Utils.PREFIX_ORE;
import static slimeknights.tconstruct.TConstruct.random;
import static slimeknights.tconstruct.library.utils.HarvestLevels.OBSIDIAN;

public class BlockTiberium extends BasicBlock {

    public BlockTiberium() {
        super("tiberium_ore", Material.ROCK, 15.0f, 2.0f, OBSIDIAN, 1.0F, PREFIX_ORE);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if (random.nextBoolean()) {
            return random.nextInt(10) + fortune;
        } else return 0;
    }

    @Override
    @ParametersAreNonnullByDefault
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return (random.nextInt(3 + fortune) + 1);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.tiberiumShardInstable;
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            if (MathHelper.getRandomIntegerInRange(random, 1, 15) > 10) {
                worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 1.6f, true, true);
            }
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        if (MathHelper.getRandomIntegerInRange(random, 1, 30) < 3) {
            if (!worldIn.isRemote) {
                worldIn.newExplosion(null, pos.getX(), pos.getY() + 1 / 16f, pos.getZ(), 1.1f, true, true);
            }
        }
    }
}
