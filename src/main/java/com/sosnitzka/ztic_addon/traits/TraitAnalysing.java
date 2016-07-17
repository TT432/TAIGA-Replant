package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitAnalysing extends AbstractTrait {

    public TraitAnalysing() {
        super("analysing", TextFormatting.GREEN);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onXpDrop(LivingExperienceDropEvent event) {
        EntityPlayer player = event.getAttackingPlayer();
        if (player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)) {
            event.setDroppedExperience(this.getUpdateXP(event.getDroppedExperience()));
        }

    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        if (player != null && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)) {
            event.setExpToDrop(this.getUpdateXP(event.getExpToDrop()));
        }

    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (!w.isRemote && event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                event.getDrops().clear();
            }
        }
    }

    private int getUpdateXP(int xp) {
        float exp = (float) random.nextFloat() * random.nextFloat() * random.nextFloat() * (xp + 18) * 50;
        return Math.round(exp);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        if (random.nextFloat() < 0.85) {
            event.getDrops().clear();
        }
    }

}
