package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitHeroic extends AbstractTrait {

    public TraitHeroic() {
        super("heroic", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int durabilitymax = ToolHelper.getMaxDurability(tool);

        int safeDenominator = durabilitymax - durability - 1;
        /*
        if (safeDenominator <= 0) {
            safeDenominator = 1;
        }
        */
        float calc;
        if ((durability * durabilitymax  != 0) {
            calc = newDamage + (newDamage * (float) safeDenominator*0.5) / (durability * durabilitymax);
        } else {
            calc = newDamage + (newDamage * (float) safeDenominator*0.5) / (durability * durabilitymax+1);
        }
        if (    durability < (0.10 * durabilitymax)
                || player.getHealth() < player.getMaxHealth() / 8
                || (target.getHealth() == target.getMaxHealth()
                && random.nextFloat() > 0.8)) {
            return super.damage(tool, player, target, damage, calc, isCritical);
        } else {
            return super.damage(tool, player, target, damage, newDamage * 0.9f, isCritical);
        }
    }
}
