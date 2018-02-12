package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Optional;


public class TraitBerserk extends TraitProgressiveStats {

    protected static int TICK_PER_STAT = 8;

    public TraitBerserk() {
        super(TraitBerserk.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerInteractEvent.BreakSpeed event) {
        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        if (!data.active) return;
        event.setNewSpeed(event.getNewSpeed() * 4);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float
            newDamage, boolean isCritical) {
        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        if (!data.active) return newDamage;
        return newDamage * 4;
    }


    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRemote) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            EntityLivingBase player = (EntityLivingBase) entity;
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            NBTTagCompound root = TagUtil.getTagSafe(tool);
            StatNBT distributed = getBonus(root);
            if (data.active) {
                TagUtil.setEnchantEffect(root, true);
                if (entity instanceof FakePlayer) {
                    return;
                }
                if (entity.ticksExisted % TICK_PER_STAT > 0) {
                    return;
                }

                ToolNBT stat = TagUtil.getToolStats(tool);
                if (random.nextFloat() > .80f) {
                    stat.durability -= 1;
                    distributed.durability -= 1;
                } else
                    ToolHelper.damageTool(tool, 1, player);
                TagUtil.setToolTag(root, stat.get());
                setBonus(root, distributed);
            } else TagUtil.setEnchantEffect(root, false);
        }
    }

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        World w = event.getWorld();
        ItemStack tool = event.getEntityPlayer().getHeldItemMainhand();
        if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            NBTTagCompound root = TagUtil.getTagSafe(tool);
            StatNBT distributed = getBonus(root);
            ToolNBT stat = TagUtil.getToolStats(tool);
            if (data.active) {
                data.active = false;
                TagUtil.setEnchantEffect(root, false);
                TagUtil.setExtraTag(root, tag);
                data.write(tag);
            } else {
                stat.durability -= 10;
                distributed.durability -= 10;
                TagUtil.setToolTag(root, stat.get());
                setBonus(root, distributed);
                data.active = true;
                data.write(tag);

                TagUtil.setExtraTag(root, tag);
                data.write(tag);
            }

        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
