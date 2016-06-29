package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

/**
 * Created by Robert on 09.06.2016.
 */
public class TraitDissolving extends AbstractTrait {

    public TraitDissolving() {
        super("dissolving", TextFormatting.DARK_AQUA);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onXpDrop(LivingExperienceDropEvent event) {
        EntityPlayer player = event.getAttackingPlayer();
        if (random.nextFloat() < 0.3 && player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)) {
            event.setDroppedExperience(0);
        }
    }
}
