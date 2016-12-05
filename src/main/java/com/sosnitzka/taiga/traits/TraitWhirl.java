package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;


public class TraitWhirl extends AbstractTrait {

    protected static int TICK_PER_STAT = 36;

    public TraitWhirl() {
        super(TraitWhirl.class.getSimpleName().toLowerCase().substring(5), TextFormatting.DARK_BLUE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {

        if (entity instanceof FakePlayer || entity.worldObj.isRemote) {
            return;
        }

        if (entity.ticksExisted % TICK_PER_STAT > 0) {
            return;
        }

        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        data.radius += random.nextFloat() * 0.5f;
        if (data.radius >= 1) {
            TagUtil.setEnchantEffect(tool, true);
        }
        data.write(tag);
        TagUtil.setExtraTag(tool, tag);
    }

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        World w = event.getWorld();
        ItemStack tool = event.getEntityPlayer().getHeldItemMainhand();
        if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            if ((int) data.radius >= 1) {
                int r = Math.min((int) data.radius, 8);
                for (int x = -r; x <= r; x++) {
                    for (int y = -r; y <= r; y++) {
                        for (int z = -r; z <= r; z++) {
                            if (MathHelper.sqrt_double(x * x + y * y + z * z) > r) {
                                continue;
                            }
                            BlockPos nPos = new BlockPos(event.getPos().getX() + x, event.getPos().getY() + y, event.getPos().getZ() + z);
                            if (!(event.getWorld().getBlockState(nPos).equals(Blocks.WATER.getDefaultState()) || event.getWorld().getBlockState(nPos).equals(Blocks.FLOWING_WATER.getDefaultState())))
                                continue;
                            event.getWorld().destroyBlock(nPos, false);
                        }
                    }
                }
                data.radius -= r;
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
                TagUtil.setEnchantEffect(tool, false);
                ToolHelper.damageTool(tool, 2 * r, event.getEntityPlayer());
            }

        }
    }


    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            if (data.radius > 0) {
                e.getToolTip().add(TextFormatting.BLUE + "Actual Radius: " + TextFormatting.WHITE + Math.round(data.radius * 100) / 100);
            }
        }
    }

}
