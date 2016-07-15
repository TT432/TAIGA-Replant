package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
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
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        // *20 because 20 ticks in a second
        if (!world.isRemote && entity instanceof EntityLivingBase && random.nextInt(20 * chance) == 0) {
            ToolHelper.healTool(tool, 1, (EntityLivingBase) entity);
        }

    }
}
