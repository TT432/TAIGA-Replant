package com.sosnitzka.ztic_addon.util.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * Created by Robert on 14.05.2016.
 */
public class TraitInstable extends AbstractTrait {


    public TraitInstable() {
        super("instable", TextFormatting.DARK_RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (MathHelper.getRandomIntegerInRange(random, 0, 100) > 2) {
            if (!world.isRemote) {
                if (random.nextBoolean()) {
                    Explode(player, pos.getX(), pos.getY(), pos.getZ());
                } else Explode(null, pos.getX(), pos.getY(), pos.getZ());
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
                    Explode(player, pos.getX(), pos.getY(), pos.getZ());
                } else Explode(target, pos.getX(), pos.getY(), pos.getZ());
            }
            ToolHelper.damageTool(tool, 3 + random.nextInt(18), null);
        }
    }

    private void Explode(EntityLivingBase e, double x, double y, double z) {
        e.getEntityWorld().newExplosion(e, x, y, z, 1.2f + random.nextFloat() * 5, random.nextBoolean(), true);
    }

}
