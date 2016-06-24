package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitHaunted extends AbstractTrait {

    public TraitHaunted() {
        super("haunted", TextFormatting.DARK_GRAY);
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        if (target instanceof EntityCow) {
            EntityCow cow = (EntityCow) target;
            cow.tasks.addTask(2, new EntityAIAttackMelee(cow, 1.50D, false));
            cow.targetTasks.addTask(2, new EntityAINearestAttackableTarget(cow, player.getClass(), false, true));
            cow.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
            cow.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(16.0D);
            cow.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        }
        if (target instanceof EntityMob) {
            EntityMob mob = (EntityMob) target;
            mob.tasks.addTask(1, new EntityAIPanic(mob, 3.0D));
        }
    }


}
