package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitSuperHeavy extends TraitProgressiveStats {

    protected static int TICK_PER_STAT = 50;
    protected static float blockcount = 250f;

    public TraitSuperHeavy() {
        super(TraitSuperHeavy.class.getSimpleName().toLowerCase().substring(5), TextFormatting.DARK_GRAY);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerInteractEvent.BreakSpeed event) {
        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        if (data.brokenblocks == 0) return;
        event.setNewSpeed(Math.max(event.getNewSpeed() - data.brokenblocks * event.getOriginalSpeed() / blockcount, 0.25f));
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        data.brokenblocks += 1;
        data.write(tag);
        TagUtil.setExtraTag(tool, tag);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // every 3.6 seconds we distribute one stat. This means 1h = 1000 applications
        if (entity.ticksExisted % TICK_PER_STAT > 0) {
            return;
        }

        // we don't update if the player is currently breaking a block because that'd reset it
        if (playerIsBreakingBlock(entity)) {
            return;
        }

        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        if (data.brokenblocks > 0)
            data.brokenblocks -= 1;
        data.write(tag);
        TagUtil.setExtraTag(tool, tag);
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            e.getToolTip().add(TextFormatting.RED + "Broken Blocks: " + TextFormatting.WHITE + data.brokenblocks);

        }
    }


}
