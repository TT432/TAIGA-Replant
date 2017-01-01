package com.sosnitzka.taiga.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

import static slimeknights.tconstruct.TConstruct.random;

public class BlockOre extends Block {

    private Item dropItem;
    private int itemAmount;
    private int xpAmount;

    public BlockOre(String name, Material material, float hardness, float resistance, int harvest, float lightLevel, Item item, int amount, int xp) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvest);
        setLightLevel(lightLevel);
        this.dropItem = item;
        this.itemAmount = amount;
        this.xpAmount = xp;

    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return random.nextInt(xpAmount) + fortune;

    }

    @Override
    @ParametersAreNonnullByDefault
    public int quantityDropped(IBlockState state, int fortune, Random random) {
        return (random.nextInt(itemAmount + fortune) + 1);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return dropItem;
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        if (!worldIn.isRemote) {
            if (random.nextFloat() < 0.5) {
                worldIn.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), random.nextFloat() * 4f + 1.5f, true, true);
            }
        }
    }
}
