package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 03.06.2016.
 */
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

    public boolean isDay(int time) {
        if (time < 12500) {
            return true;
        } else {
            return false;
        }
    }
}
