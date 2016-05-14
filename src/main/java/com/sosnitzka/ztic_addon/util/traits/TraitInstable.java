package com.sosnitzka.ztic_addon.util.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 14.05.2016.
 */
public class TraitInstable extends AbstractTrait {


    public TraitInstable() {
        super("instable", TextFormatting.DARK_RED);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (player.getHealth() > 2) {
            world.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3, true, true);
        }
    }


}
