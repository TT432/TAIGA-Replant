package com.sosnitzka.ztic_addon.traits;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;


public class TraitNatureBound extends AbstractTrait {
    public static DamageSource splinter = new DamageSource("splinter").setDamageBypassesArmor();
    private static int chance = 10;

    public TraitNatureBound() {
        super("naturebound", TextFormatting.GREEN);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        // 5% less durability repaired!
        return newAmount - amount * 5 / 100;
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // *20 because 20 ticks in a second
        if (!world.isRemote && entity instanceof EntityLivingBase && random.nextInt(20 * chance) == 0) {
            ToolHelper.healTool(tool, 1, (EntityLivingBase) entity);
        }

    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent e) {
        Block b = e.getWorld().getBlockState(e.getPos()).getBlock();
        if (random.nextFloat() <= .07 && (b == Blocks.DIRT || b == Blocks.GRASS || b == Blocks.LOG || b == Blocks.LOG2 || b == Blocks.STONE)) {
            e.setCanceled(true);
            e.getPlayer().playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
        }
    }





}
