package com.sosnitzka.taiga.recipes;


import net.minecraftforge.oredict.OreDictionary;

public class SmeltingRegistry {
    public static void register() {
        OreDictionary.getOres("nuggetIron").get(OreDictionary.getOres("nuggetIron").size() - 1);
    }
}
