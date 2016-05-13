package com.sosnitzka.ztic_addon.recipes;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.sosnitzka.ztic_addon.Items.fuel_brick;
import static com.sosnitzka.ztic_addon.Items.lignite;

public class Crafting {
    public static void register() {
        GameRegistry.addShapelessRecipe(new ItemStack(fuel_brick), Items.COAL, Items.COAL, Items.COAL, lignite, lignite, lignite);
    }
}
