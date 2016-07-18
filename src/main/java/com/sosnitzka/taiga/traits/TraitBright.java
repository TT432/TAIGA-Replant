package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitBright extends AbstractTrait {

    public TraitBright() {
        super("bright", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        int time = (int) target.getEntityWorld().getWorldTime();
        if (isDay(time)) {
            newDamage += damage / 2f;
        }
        return super.damage(tool, player, target, damage, newDamage, isCritical);

    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity entity, int i, boolean b) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer e = (EntityPlayer) entity;
            if (TinkerUtil.hasTrait(TagUtil.getTagSafe(e.getHeldItemMainhand()), identifier)) {
                e.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100));
            }
        }

    }

    public boolean isDay(int time) {
        if (time < 12500) {
            return true;
        } else {
            return false;
        }
    }
}
