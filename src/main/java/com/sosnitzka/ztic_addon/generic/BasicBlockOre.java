package com.sosnitzka.ztic_addon.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlockOre extends Block {
    public String oreDictName;

    public BasicBlockOre(String name, Material material, float hardness, float resistance, int harvest, String oreDictName) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvest);
        this.oreDictName = oreDictName;
    }

    public boolean isOreDict() {
        return this.oreDictName != null;
    }

    public String getOreDictName() {
        return oreDictName;
    }
}
