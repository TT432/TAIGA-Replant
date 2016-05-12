package com.sosnitzka.ztic_addon.fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class BasicFluid extends Fluid {

    private int color;

    public BasicFluid(String fluidName, int color) {
        super(fluidName, new ResourceLocation("tconstruct:com.sosnitzka.ztic_addon.blocks/com.sosnitzka.ztic_addon.fluids/molten_metal"), new ResourceLocation("tconstruct:com.sosnitzka.ztic_addon.blocks/com.sosnitzka.ztic_addon.fluids/molten_metal_flow"));
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

}
