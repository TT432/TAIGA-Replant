package com.sosnitzka.ztic_addon.traits;

import com.sosnitzka.ztic_addon.util.EntityAIPermanentPanic;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitHaunted extends AbstractTrait {

    public TraitHaunted() {
        super("haunted", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }


    // Just several tested Vanilla-Mobs, e.g. no ghasts, bats or skeletons
    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        int time = (int) player.getEntityWorld().getWorldTime();
        if (random.nextFloat() <= 0.1 || (random.nextFloat() <= 0.3 && isNight(time)))
            if (target instanceof EntityCow || target instanceof EntityZombie || target instanceof EntityWolf || target instanceof EntityPig || target instanceof EntitySpider ||
                    target instanceof EntityVillager || target instanceof EntitySheep || target instanceof EntityEnderman || target instanceof EntityEndermite ||
                    target instanceof EntityBlaze || target instanceof EntityWitch || target instanceof EntityHorse) {
                ((EntityLiving) target).tasks.taskEntries.clear();
                ((EntityLiving) target).targetTasks.taskEntries.clear();
                ((EntityLiving) target).tasks.addTask(0, new EntityAIPermanentPanic((EntityCreature) target, target.getAIMoveSpeed() + 2.0D));

            }
    }

    public boolean isNight(int time) {
        if (time > 12500) {
            return true;
        } else {
            return false;
        }
    }
}
