package com.sosnitzka.ztic_addon.generic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlockOre extends Block {

    public BasicBlockOre(String name, Material material, float hardness, float resistance, int harvest, float lightLevel) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("pickaxe", harvest);
        setLightLevel(lightLevel);
    }

    public BasicBlockOre(String name, Material material, float hardness, float resistance, int harvest) {
        this(name, material, hardness, resistance, harvest, 0.0F);
    }
}
