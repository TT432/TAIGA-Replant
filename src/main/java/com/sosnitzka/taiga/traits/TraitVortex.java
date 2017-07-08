package com.sosnitzka.taiga.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.Optional;


public class TraitVortex extends AbstractTrait {


    public TraitVortex() {
        super(TraitVortex.class.getSimpleName().toLowerCase().substring(5), TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
