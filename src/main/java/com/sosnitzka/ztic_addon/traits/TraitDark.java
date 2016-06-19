package com.sosnitzka.ztic_addon.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitDark extends AbstractTrait {

    public TraitDark() {
        super("dark", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (random.nextFloat() <= 0.1) {
            player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 300));
            player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 300));
            ToolHelper.healTool(tool, random.nextInt(51) + 10, null);
        }
    }


    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        if (random.nextFloat() <= 0.1) {
            player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 300));
            player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 300));
            ToolHelper.healTool(tool, random.nextInt(51) + 10, null);
        }
    }
}
