package com.sosnitzka.taiga;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.sosnitzka.taiga.Blocks.adamantBlock;
import static com.sosnitzka.taiga.Items.solariumIngot;


public class CreativeTab {

    public static final CreativeTabs tabTaigaBlock = new CreativeTabs("taiga_block") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(adamantBlock);
        }
    };

    public static final CreativeTabs tabTaigaItem = new CreativeTabs("taiga_item") {
        @Override
        public Item getTabIconItem() {
            return solariumIngot;
        }
    };
}
