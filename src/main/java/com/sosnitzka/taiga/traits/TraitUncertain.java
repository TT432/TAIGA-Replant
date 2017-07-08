package com.sosnitzka.taiga.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.Optional;


public class TraitUncertain extends AbstractTrait {


    public TraitUncertain() {
        super(TraitUncertain.class.getName().toLowerCase().substring(4), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
