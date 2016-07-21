package com.sosnitzka.taiga.recipes;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.sosnitzka.taiga.Items.*;
import static slimeknights.tconstruct.shared.TinkerCommons.matNecroticBone;

public class Crafting {
    public static void register() {
        GameRegistry.addShapelessRecipe(new ItemStack(fuel_brick), Items.COAL, Items.COAL, Items.COAL, lignite, lignite, lignite);

        GameRegistry.addShapelessRecipe(new ItemStack(luminar_dust), Items.REDSTONE, Items.GLOWSTONE_DUST);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerstone_dust), luminar_dust, Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerstone_dust), Items.REDSTONE, Items.GLOWSTONE_DUST, Items.BLAZE_POWDER);

        GameRegistry.addShapelessRecipe(new ItemStack(glimmercoal), Items.COAL, glimmerstone_dust);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmercoal), lignite, glimmerstone_dust);

        GameRegistry.addShapelessRecipe(new ItemStack(radiant_pearl), Items.ENDER_PEARL, luminar_dust, new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(glimmer_pearl), Items.ENDER_PEARL, glimmerstone_dust);
        GameRegistry.addShapelessRecipe(new ItemStack(energy_pearl), Items.ENDER_PEARL, luminar_dust, Items.GUNPOWDER);

        GameRegistry.addShapelessRecipe(new ItemStack(nitro_brick), fuel_brick, Items.GUNPOWDER, Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(anthracite_dust), matNecroticBone, Items.COAL, Items.GUNPOWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(spectrum_dust), matNecroticBone, glimmerstone_dust);


    }
}
