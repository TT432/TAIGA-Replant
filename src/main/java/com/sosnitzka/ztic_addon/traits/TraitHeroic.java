package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * Created by Robert on 30.06.2016.
 */
public class TraitHeroic extends AbstractTrait {

    public TraitHeroic() {
        super("heroic", TextFormatting.DARK_GRAY);
    }

    @Override
    public float damage(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, float newDamage, boolean isCritical) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int durabilitymax = ToolHelper.getMaxDurability(tool);
        float calc = (float) (newDamage + (newDamage / 2) / (durability * durabilitymax / (durabilitymax - durability)));
        if ((float) durability < (float) (0.12 * durabilitymax)) {
            return super.damage(tool, player, target, damage, calc, isCritical);
        } else return super.damage(tool, player, target, damage, newDamage, isCritical);
    }


    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        System.out.println("Damage: " + damage);
    }

}
