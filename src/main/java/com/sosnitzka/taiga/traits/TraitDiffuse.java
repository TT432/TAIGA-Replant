package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;


public class TraitDiffuse extends AbstractTrait {

    public TraitDiffuse() {
        super("diffuse", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        if (!player.getEntityWorld().isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), this.identifier)) {
            event.setExpToDrop((int) this.getUpdateXP(event.getExpToDrop()));
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (event.getEntity() instanceof EntityCreature && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                event.getDrops().clear();
            }
        }
    }

    private float getUpdateXP(int xp) {
        float exp = random.nextFloat() * random.nextFloat() * random.nextFloat() * (1 + random.nextFloat() * xp);
        if (random.nextFloat() <= 0.25)
            return exp;
        else return 0;
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        if (random.nextFloat() < 0.35) {
            event.getDrops().clear();
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
