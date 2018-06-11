package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static com.sosnitzka.taiga.util.Utils.isNight;

public class TraitBlind extends AbstractTrait {

    public TraitBlind() {
        super("blind", TextFormatting.DARK_GRAY);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase
            player, boolean wasEffective) {
        int time = (int) world.getWorldTime();
        if (random.nextFloat() <= 0.01 || (random.nextFloat() <= 0.03 && isNight(time))) {
            if (random.nextBoolean())
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, random.nextInt(200) + 100));
            else
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, random.nextInt(200) + 100));
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean
            wasCritical, boolean wasHit) {
        int time = (int) player.getEntityWorld().getWorldTime();
        if (random.nextFloat() <= 0.01 || (random.nextFloat() <= 0.03 && isNight(time))) {
            if (random.nextBoolean())
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, random.nextInt(400) + 200));
            else
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, random.nextInt(400) + 200));
        }
    }
}
