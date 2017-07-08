package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;


public class TraitCongenial extends AbstractTrait {


    public TraitCongenial() {
        super(TraitCongenial.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent e) {
        if (e.getSource().getTrueSource() instanceof EntityPlayer && !e.getSource().getTrueSource().world.isRemote && e.getEntity() instanceof EntityCreature) {
            if (TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) e.getSource().getTrueSource()).getHeldItemMainhand()), identifier)) {
                ItemStack tool = ((EntityPlayer) e.getSource().getTrueSource()).getHeldItemMainhand();
                String name = e.getEntity().getName();
                NBTTagCompound tag = TagUtil.getExtraTag(tool);
                Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
                if (!data.name.isEmpty()) {
                    return;
                }
                data.name = name;
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
            }
        }
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        World w = player.getEntityWorld();
        if (!w.isRemote) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            if (data.name.isEmpty()) {
                return damage;
            }
            if (!data.name.equals(target.getName())) {
                return damage / (random.nextInt(5) + 2);
            }
            float x = (1 + random.nextFloat() * 9);
            return damage * x;
        }
        return damage;
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Utils.GeneralNBTData data = Utils.GeneralNBTData.read(tag);
            if (data.name.isEmpty()) e.getToolTip().add(TextFormatting.LIGHT_PURPLE + "Unbound");
            else {
                e.getToolTip().add(TextFormatting.DARK_PURPLE + "Bound to: " + TextFormatting.LIGHT_PURPLE + data.name);
            }
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
