package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitResonance extends AbstractTrait {

    public static float chance = 0.33f;

    public TraitResonance() {
        super("resonance", TextFormatting.AQUA);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean
            wasCritical, boolean wasHit) {
        if (random.nextFloat() <= chance) {
            target.knockBack(target, random.nextFloat() * random.nextFloat() * 10, player.posX - target.posX, player
                    .posZ - target.posZ);
        }
    }
}



