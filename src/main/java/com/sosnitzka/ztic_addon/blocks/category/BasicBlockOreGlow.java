package com.sosnitzka.ztic_addon.blocks.category;

import net.minecraft.block.material.Material;

public class BasicBlockOreGlow extends BasicBlockOre {

    public BasicBlockOreGlow(String name, Material material, float hardness, float resistance, int harvest, float glow) {
        super(name, material, hardness, resistance, harvest);
        setLightLevel(glow);
    }
}
