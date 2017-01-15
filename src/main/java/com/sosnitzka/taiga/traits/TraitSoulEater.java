package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitSoulEater extends AbstractTrait {

    private static float divisor = 25000f;

    public TraitSoulEater() {
        super(TraitSoulEater.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTargetKilled(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntity() instanceof EntityLiving) {
            World w = event.getSource().getEntity().world;
            ItemStack tool = ((EntityPlayer) event.getSource().getEntity()).getHeldItemMainhand();
            if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
                NBTTagCompound tag = TagUtil.getExtraTag(tool);
                Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
                float health = ((EntityLiving) event.getEntity()).getMaxHealth();
                data.killcount += 1;
                data.health = health;
                float bonus = Math.round(random.nextFloat() * health * 100) / divisor;
                data.bonus += bonus;
                data.bonus = (float) Math.round(data.bonus * 100f) / 100f;
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
            }
        }
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        NBTTagCompound tag = TagUtil.getExtraTag(tool);
        Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
        float bonus = data.bonus;
        return newDamage + bonus;
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            if (data.killcount != 0) {
                e.getToolTip().add(TextFormatting.WHITE + "Killed: " + TextFormatting.WHITE + data.killcount);
                e.getToolTip().add(TextFormatting.WHITE + "Bonus: " + TextFormatting.WHITE + data.bonus);
            }
        }
    }

}
