package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitCursed extends AbstractTrait {

    private static int chance = 60 * 1000;

    public TraitCursed() {
        super(TraitCursed.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        if (random.nextInt((chance + data.curse) / (data.curse + 1)) == 1) {
            if (isSelected) data.curse += 10;
            else data.curse++;
            entity.attackEntityFrom(new DamageSource("Curse"), random.nextFloat() * ((EntityPlayer) entity).getHealth
                    () / 2);
        }

        data.write(tag);
        TagUtil.setExtraTag(tool, tag);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            if (data.curse != 0) {
                e.getToolTip().add(TextFormatting.DARK_PURPLE + "Curse: " + TextFormatting.WHITE + data.curse);
            }
        }
    }
}
