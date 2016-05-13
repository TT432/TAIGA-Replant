package com.sosnitzka.ztic_addon.generic;

import net.minecraft.item.Item;

public class BasicItem extends Item {
    private boolean oreDict;

    public BasicItem(String name, boolean oreDict) {
        setUnlocalizedName(name);
        setRegistryName(name);
        this.oreDict = oreDict;
    }

    public BasicItem(String name) {
        this(name, false);
    }

    public boolean isOreDict() {
        return this.oreDict;
    }
}
