package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.util.Utils;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;

import static com.sosnitzka.taiga.Blocks.tiberiumOre;

public class TraitTantrum extends AbstractTrait {

    /*
     *  Collects tiberium, to release it for an explosion
     */

    public static float max_charges = 12f;
    public static float max_power = 5;

    public TraitTantrum() {
        super("tantrum", TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        World w = event.getWorld();
        if (!w.isRemote) {
            if (event.getState().getBlock().equals(tiberiumOre)) {
                event.getDrops().clear();
                NBTTagCompound tag = TagUtil.getExtraTag(tool);
                Data data = Data.read(tag);
                if (data.amount >= max_charges) {
                    return;
                }
                data.amount += (0.25f + Utils.round2(random.nextDouble() / 4));
                if (data.amount >= max_charges) {
                    TagUtil.setEnchantEffect(tool, true);
                    if (event.getHarvester() instanceof EntityPlayerMP) {
                        Sounds.PlaySoundForPlayer(event.getHarvester(), Sounds.shocking_discharge, 1f, 0.8f + .2f * random.nextFloat());
                    }
                }
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
            }
        }
    }

    @SubscribeEvent
    public void RightClickItem(PlayerInteractEvent.RightClickItem event) {
        World w = event.getWorld();
        BlockPos pos = event.getPos();
        ItemStack tool = event.getEntityPlayer().getHeldItemMainhand();
        if (!w.isRemote && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            if (data.amount > 1f) {
                double d = Math.min(Utils.round2(random.nextDouble() * data.amount), max_power);
                w.newExplosion(event.getEntityPlayer(), pos.getX(), pos.getY(), pos.getZ(), (float) Math.pow((double) 1.2f, d), false, true);
                data.amount -= d;
                data.write(tag);
                TagUtil.setExtraTag(tool, tag);
                TagUtil.setEnchantEffect(tool, false);
            }
        }
    }

    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            e.getToolTip().add(TextFormatting.RED + "Charge: " + data.amount);
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }

    public static class Data {

        float amount;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.amount = tag.getFloat("amount");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setFloat("amount", amount);
        }
    }

}
