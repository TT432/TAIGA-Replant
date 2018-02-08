package com.sosnitzka.taiga.traits;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;


public class TraitDissolving extends AbstractTrait {

    public TraitDissolving() {
        super("dissolving", TextFormatting.DARK_AQUA);
        MinecraftForge.EVENT_BUS.register(this);
    }

    // high chance to remove XP, low chance to double,triple or quatruple dropped Experience

    @SubscribeEvent
    public void onXpDrop(LivingExperienceDropEvent event) {
        if (!event.getEntity().getEntityWorld().isRemote) {
            EntityPlayer player = event.getAttackingPlayer();
            float r = random.nextFloat();
            if (player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this
                    .identifier)) {
                if (r <= 0.80) {
                    event.setDroppedExperience(0);
                } else {
                    event.setDroppedExperience(event.getDroppedExperience() * (random.nextInt(3) + 2));
                }
            }
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
