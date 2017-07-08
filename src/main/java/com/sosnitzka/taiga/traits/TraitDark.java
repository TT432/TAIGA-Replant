package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.Optional;

import static com.sosnitzka.taiga.util.Utils.isNight;


public class TraitDark extends AbstractTrait {

    public TraitDark() {
        super("dark", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        int time = (int) target.getEntityWorld().getWorldTime();
        if (isNight(time)) {
            newDamage = damage * (1 + random.nextFloat() / 2f);
        } else newDamage = damage / (1 + random.nextFloat() / 3f);
        return super.damage(tool, player, target, damage, newDamage, isCritical);
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
