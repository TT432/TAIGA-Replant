package com.sosnitzka.taiga.generic;

import net.minecraft.item.Item;

/**
 * A "wrapper" for Item that makes construction and manipulation easier
 */
public class BasicItem extends Item {
    private String oreDictPrefix;

    public BasicItem(String name, String oreDictPrefix) {
        setUnlocalizedName(name);
        setRegistryName(name);
        this.oreDictPrefix = oreDictPrefix;
    }

    public BasicItem(String name, String oreDictPrefix, String registryname) {
        setUnlocalizedName(name);
        setRegistryName(registryname);
        this.oreDictPrefix = oreDictPrefix;
    }

    public BasicItem(String name) {
        this(name, null);
    }

    public boolean isOreDict() {
        return this.oreDictPrefix != null;
    }

    public String getOreDictPrefix() {
        return oreDictPrefix;
    }
}
