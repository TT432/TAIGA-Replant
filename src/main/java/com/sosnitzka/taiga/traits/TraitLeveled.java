package com.sosnitzka.taiga.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;

import java.util.Optional;


public class TraitLeveled extends AbstractTraitLeveled {


    public TraitLeveled(int levels) {
        super(TraitLeveled.class.getSimpleName().toLowerCase().substring(5), 0xFFFF5500, 3, levels);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
