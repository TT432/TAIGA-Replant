package com.sosnitzka.ztic_addon.generic;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class BasicTinkerFluid extends Fluid {

    private int color;
    private boolean toolForge;

    public BasicTinkerFluid(String fluidName, int color, boolean toolForge, int temp, int lumen, int visk) {
        super(fluidName, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"), new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"));
        this.color = color;
        this.setTemperature(temp);
        this.setLuminosity(lumen);
        this.setViscosity(visk);
        this.toolForge = toolForge;
    }

    @Override
    public int getColor() {
        return color;
    }

    public boolean isToolForge() {
        return toolForge;
    }
}
