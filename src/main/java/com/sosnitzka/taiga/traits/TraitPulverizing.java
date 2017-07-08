package com.sosnitzka.taiga.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Optional;

public class TraitPulverizing extends AbstractTrait {

    public TraitPulverizing() {
        super("pulverizing", TextFormatting.DARK_GRAY);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if (ToolHelper.isToolEffective2(tool, event.getState())) {
            event.setNewSpeed((float) (event.getNewSpeed() * calcBonus(tool)));
        }
    }

    private double calcBonus(ItemStack tool) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int maxDurability = ToolHelper.getMaxDurability(tool);
        return (1 + .9f * (maxDurability - durability) / maxDurability);
        // Min 1.0; Max 1.9
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        if (random.nextFloat() < 0.6) {
            event.getDrops().clear();
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
