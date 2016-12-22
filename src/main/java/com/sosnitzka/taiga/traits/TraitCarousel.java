package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitCarousel extends AbstractTrait {

    public static final int TICK = 24;

    public TraitCarousel() {
        super(TraitCarousel.class.getSimpleName().toLowerCase().substring(5), 0xffcc5511);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {

    }


}
