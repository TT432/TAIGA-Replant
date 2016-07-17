package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitDissolving extends AbstractTrait {

    public TraitDissolving() {
        super("dissolving", TextFormatting.DARK_AQUA);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // high chance to remove XP, low chance to double,triple or quatruple dropped Experience
    @SubscribeEvent
    public void onXpDrop(LivingExperienceDropEvent event) {
        EntityPlayer player = event.getAttackingPlayer();
        float r = random.nextFloat();
        if (r <= 0.75 && player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)) {
            event.setDroppedExperience(0);
        }
        if (r > 0.95 && player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)) {
            event.setDroppedExperience(event.getDroppedExperience() * (random.nextInt(3) + 2));
        }
    }
}
