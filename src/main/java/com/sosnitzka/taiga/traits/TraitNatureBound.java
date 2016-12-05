package com.sosnitzka.taiga.traits;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;


public class TraitNatureBound extends AbstractTrait {

    public TraitNatureBound() {
        super("naturebound", TextFormatting.GREEN);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public int onToolHeal(ItemStack tool, int amount, int newAmount, EntityLivingBase entity) {
        // 10% less durability repaired!
        return newAmount - amount * 10 / 100;
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // * 20 because 20 ticks in a second
        int chance = 20 * 20;
        Material m = world.getBlockState(entity.getPosition().down()).getMaterial();
        if (!world.isRemote && entity instanceof EntityLivingBase && random.nextInt(chance) == 0) {
            if (m.equals(Material.GRASS) || m.equals(Material.LEAVES)) {
                ToolHelper.healTool(tool, random.nextInt(2) + 1, (EntityLivingBase) entity);
            } else ToolHelper.damageTool(tool, 1, (EntityLivingBase) entity);
        }
    }
}
