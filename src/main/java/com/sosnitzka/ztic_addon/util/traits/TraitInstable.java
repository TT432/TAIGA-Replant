package com.sosnitzka.ztic_addon.util.traits;

import com.sosnitzka.ztic_addon.util.ZWorld;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;

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
        ZWorld world2 = (ZWorld) world;
        if (MathHelper.getRandomIntegerInRange(random, 0, 100) > 2) {
            if (!world.isRemote)

                world2.newExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2f, true, true);

        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        BlockPos pos = target.getPosition();
        if (MathHelper.getRandomIntegerInRange(random, 0, 100) < 2) {
            target.getEntityWorld().newExplosion(target, pos.getX(), pos.getY(), pos.getZ(), 1.5f, true, true);
        }
    }

    /* @SubscribeEvent
    public void onInstableExplosionDamage(LivingHurtEvent e){
        if(e.getEntityLiving() instanceof EntityPlayer){
            EntityPlayer p = (EntityPlayer) e.getEntityLiving();
            p.addChatComponentMessage(new TextComponentString("E: " + e.getSource().getEntity() + " D: " + e.getSource().getDamageType() + " C: " + e.getSource().getSourceOfDamage()));

        }
    } */



}
