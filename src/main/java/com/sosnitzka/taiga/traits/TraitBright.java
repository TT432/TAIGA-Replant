package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import static com.sosnitzka.taiga.util.Utils.isNight;
import static net.minecraft.init.MobEffects.GLOWING;


public class TraitBright extends AbstractTrait {

    private static final float chance = 0.90f;

    public TraitBright() {
        super("bright", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float
            newDamage, boolean isCritical) {
        int time = (int) target.getEntityWorld().getWorldTime();
        if (!isNight(time)) {
            newDamage = damage * (1 + random.nextFloat() / 2f);
        } else {
            newDamage = damage / (1 + random.nextFloat() / 3f);
        }
        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase
            player, boolean wasEffective) {
        if (random.nextFloat() >= chance) {
            player.addPotionEffect(new PotionEffect(GLOWING, 200));
        }
    }
}
