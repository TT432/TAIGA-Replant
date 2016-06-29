package com.sosnitzka.ztic_addon.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitFragile extends AbstractTrait {

    public TraitFragile() {
        super("fragile", TextFormatting.DARK_GRAY);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        float f = random.nextFloat();
        float b = 0.99F * calcBonus(tool);
        if (!world.isRemote && tool.canHarvestBlock(state) && f <= b) {
            if (random.nextBoolean()) ToolHelper.damageTool(tool, random.nextInt(5), player);
        }

    }

    private float calcBonus(ItemStack tool) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int maxDurability = ToolHelper.getMaxDurability(tool);
        return (0.4f) / (maxDurability - 50) * (durability) + 0.55f;
    }
}
