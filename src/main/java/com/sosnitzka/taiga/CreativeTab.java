package com.sosnitzka.taiga;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static com.sosnitzka.taiga.Blocks.adamantBlock;
import static com.sosnitzka.taiga.Items.solariumIngot;


public class CreativeTab {

    public static final CreativeTabs tabTaigaBlock = new CreativeTabs("taiga_block") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(adamantBlock));
        }
    };

    public static final CreativeTabs tabTaigaItem = new CreativeTabs("taiga_item") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(solariumIngot);
        }
    };
}
