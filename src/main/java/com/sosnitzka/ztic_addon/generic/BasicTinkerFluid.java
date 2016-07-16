package com.sosnitzka.ztic_addon.generic;

import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.fluid.FluidMolten;

public class BasicTinkerFluid extends FluidMolten {

    private boolean toolForge;

    public BasicTinkerFluid(String fluidName, int color, boolean toolForge, int temp, int lumen, int visk) {
        super(fluidName, color, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"), new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"));
        this.setUnlocalizedName(Util.prefix(fluidName));
        this.setTemperature(temp);
        this.setLuminosity(lumen);
        this.setViscosity(visk);
        this.setDensity(2000);
        this.toolForge = toolForge;
    }

    public boolean isToolForge() {
        return toolForge;
    }
}
