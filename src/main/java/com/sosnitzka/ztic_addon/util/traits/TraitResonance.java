package com.sosnitzka.ztic_addon.util.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 14.05.2016.
 */
public class TraitResonance extends AbstractTrait {


    public TraitResonance() {
        super("resonance", TextFormatting.AQUA);
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        if (random.nextBoolean()) {
            target.knockBack(target, random.nextFloat() * random.nextFloat() * 10, player.posX - target.posX, player.posZ - target.posZ);
            if (random.nextBoolean()) player.addChatMessage(new TextComponentString("Boinggg!"));
        }
    }
}



