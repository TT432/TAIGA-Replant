package com.sosnitzka.ztic_addon.generic;

import net.minecraft.item.Item;

public class BasicItem extends Item {
    private String oreDictName;

    public BasicItem(String name, String oreDictName) {
        setUnlocalizedName(name);
        setRegistryName(name);
        this.oreDictName = oreDictName;
    }

    public BasicItem(String name) {
        this(name, null);
    }

    public boolean isOreDict() {
        return this.oreDictName != null;
    }

    public String getOreDictName() {
        return oreDictName;
    }
}
