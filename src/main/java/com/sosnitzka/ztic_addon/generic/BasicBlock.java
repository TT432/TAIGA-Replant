package com.sosnitzka.ztic_addon.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {
    private String oreDictPrefix;

    public BasicBlock(String name, Material material, float hardness, float resistance, int harvest, float lightLevel, String oreDictPrefix) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvest);
        setLightLevel(lightLevel);
        this.oreDictPrefix = oreDictPrefix;
    }

    public BasicBlock(String name, Material material, float hardness, float resistance, int harvest) {
        this(name, material, hardness, resistance, harvest, 0.0F, null);
    }

    public BasicBlock(String name, Material material, float hardness, float resistance, int harvest, float lightLevel) {
        this(name, material, hardness, resistance, harvest, lightLevel, null);
    }

    public BasicBlock(String name, Material material, float hardness, float resistance, int harvest, String oreDictPrefix) {
        this(name, material, hardness, resistance, harvest, 0.0F, oreDictPrefix);
    }

    public boolean isOreDict() {
        return this.oreDictPrefix != null;
    }

    public String getOreDictPrefix() {
        return this.oreDictPrefix;
    }

}
