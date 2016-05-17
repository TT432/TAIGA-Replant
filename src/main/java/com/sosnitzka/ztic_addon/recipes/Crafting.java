package com.sosnitzka.ztic_addon.recipes;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.sosnitzka.ztic_addon.Items.*;

public class Crafting {
    public static void register() {
        GameRegistry.addShapelessRecipe(new ItemStack(fuel_brick), Items.COAL, Items.COAL, Items.COAL, lignite, lignite, lignite);
        GameRegistry.addShapedRecipe(new ItemStack((tiberiumShardStable), 3), "STS", "TST", "STS", 'T', new ItemStack(tiberiumShardInstable), 'S', new ItemStack(Item.getItemFromBlock(Blocks.SAND)));
        GameRegistry.addShapedRecipe(new ItemStack((tiberiumShardStable), 2), "GTG", "TGT", "GTG", 'T', new ItemStack(tiberiumShardInstable), 'G', new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)));
    }
}
