package com.sosnitzka.taiga.traits;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;


public class TraitAnalysing extends AbstractTrait {

    public TraitAnalysing() {
        super("analysing", TextFormatting.GREEN);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onXpDrop(LivingExperienceDropEvent event) {
        EntityPlayer player = event.getAttackingPlayer();
        if (player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)
                && event.getDroppedExperience() > 0) {
            event.setDroppedExperience(this.getUpdateXP(event.getDroppedExperience()));
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        if (!event.getWorld().isRemote && player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player
                .getHeldItemMainhand()), this.identifier) && event.getExpToDrop() > 0) {
            event.setExpToDrop(this.getUpdateXP(event.getExpToDrop()));
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (random.nextFloat() < .1f && event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (!w.isRemote && event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe
                    (player.getHeldItemMainhand()), identifier)) {
                event.getDrops().clear();
            }
        }
    }

    private int getUpdateXP(int xp) {
        float exp = random.nextFloat() * random.nextFloat() * random.nextFloat() * (xp + random.nextInt(xp) * (1 +
                random.nextFloat()));
        return Math.round(exp);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        if (random.nextFloat() < 0.1) {
            event.getDrops().clear();
        }
    }

    /**
     * Called with a set of itemstacks and returns a match which contains the items that match
     * and how often the modifier can be applied with them
     *
     * @param stacks
     */
    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
