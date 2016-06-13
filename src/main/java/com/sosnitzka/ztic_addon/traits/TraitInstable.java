package com.sosnitzka.ztic_addon.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;


public class TraitInstable extends AbstractTrait {


    public TraitInstable() {
        super("instable", TextFormatting.DARK_RED);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (MathHelper.getRandomIntegerInRange(random, 0, 100) > 2) {
            if (!world.isRemote) {
                if (random.nextBoolean()) {
                    explode(world, player, pos.getX(), pos.getY(), pos.getZ());
                } else explode(world, null, pos.getX(), pos.getY(), pos.getZ());
            }
            ToolHelper.damageTool(tool, 11 + random.nextInt(10), null);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        BlockPos pos = target.getPosition();
        if (MathHelper.getRandomIntegerInRange(random, 0, 100) > 2) {
            if (!player.getEntityWorld().isRemote) {
                if (random.nextBoolean()) {
                    explode(player.getEntityWorld(), player, pos.getX(), pos.getY(), pos.getZ());
                } else explode(player.getEntityWorld(), target, pos.getX(), pos.getY(), pos.getZ());
            }
            ToolHelper.damageTool(tool, 3 + random.nextInt(18), null);
        }
    }

    private void explode(World w, Entity e, double x, double y, double z) {
        w.newExplosion(e, x, y, z, 1.2f + random.nextFloat() * 5, random.nextBoolean(), true);
    }
}
