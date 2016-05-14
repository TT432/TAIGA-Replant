package com.sosnitzka.ztic_addon.util.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 14.05.2016.
 */
public class TraitResonance extends AbstractTrait {


    public TraitResonance() {
        super("resonance", TextFormatting.AQUA);
    }

    @Override
    public void onBlock(ItemStack tool, EntityPlayer player, LivingHurtEvent event) {
        player.addChatComponentMessage(new TextComponentString(event.getEntity() + " " + event.getEntityLiving()));

        // event.getEntityLiving().knockBack(event.getEntityLiving(), 20f, 20f, 20f);
        //  event.getSource().getEntity()
    }
}



