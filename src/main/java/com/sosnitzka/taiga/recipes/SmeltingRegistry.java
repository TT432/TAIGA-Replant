package com.sosnitzka.taiga.recipes;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static com.sosnitzka.taiga.Blocks.*;
import static com.sosnitzka.taiga.Items.*;

public class SmeltingRegistry {
    public static void register() {
        GameRegistry.addSmelting(slagironOre, new ItemStack(slagironIngot), 1.0F);
        GameRegistry.addSmelting(slagironIngot, new ItemStack(iron_nugget), 0);
        GameRegistry.addSmelting(slaggoldIngot, new ItemStack(Items.GOLD_NUGGET), 0);
        GameRegistry.addSmelting(slaggoldOre, new ItemStack(slaggoldIngot), 1.0F);
        GameRegistry.addSmelting(tiberiumOre, new ItemStack(tiberiumShardInstable, 6), (2F));
        GameRegistry.addSmelting(tiberiumShardInstable, new ItemStack(tiberiumIngot), (.1F));
    }
}
