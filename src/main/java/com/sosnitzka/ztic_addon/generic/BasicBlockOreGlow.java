package com.sosnitzka.ztic_addon.generic;

import net.minecraft.block.material.Material;

public class BasicBlockOreGlow extends BasicBlockOre {

    public BasicBlockOreGlow(String name, Material material, float hardness, float resistance, int harvest, float glow, String oreDictName) {
        super(name, material, hardness, resistance, harvest, oreDictName);
        setLightLevel(glow);
    }
}
