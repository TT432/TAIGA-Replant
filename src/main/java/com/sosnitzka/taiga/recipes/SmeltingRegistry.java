package com.sosnitzka.taiga.recipes;


import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class SmeltingRegistry {
    public static void register() {
        ItemStack nugget_iron = OreDictionary.getOres("nuggetIron").get(OreDictionary.getOres("nuggetIron").size() - 1);
        //GameRegistry.addSmelting(tiberiumOre, new ItemStack(tiberiumShardInstable, 6), (1F));
        //GameRegistry.addSmelting(tiberiumShardInstable, new ItemStack(tiberiumIngot), (.1F));
    }
}
