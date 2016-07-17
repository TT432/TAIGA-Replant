package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitResonance extends AbstractTrait {


    public TraitResonance() {
        super("resonance", TextFormatting.AQUA);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        if (random.nextFloat() <= .33) {
            target.knockBack(target, random.nextFloat() * random.nextFloat() * 12, player.posX - target.posX, player.posZ - target.posZ);
        }
    }


}



