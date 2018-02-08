package com.sosnitzka.taiga.generic;

import net.minecraft.util.ResourceLocation;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.fluid.FluidMolten;

/**
 * A "wrapper" for FluidMolten that makes construction and manipulation easier
 */
public class BasicTinkerFluid extends FluidMolten {

    private boolean toolForge;

    public BasicTinkerFluid(String fluidName, int color, int temp, int lumen, int visk) {
        // Constructs the FluidMolten with textures and color
        super(fluidName, color, new ResourceLocation("tconstruct:blocks/fluids/molten_metal"), new ResourceLocation
                ("tconstruct:blocks/fluids/molten_metal_flow"));
        //Settings
        this.setUnlocalizedName(Util.prefix(fluidName));
        this.setTemperature(temp);
        this.setLuminosity(lumen);
        this.setViscosity(visk);
        this.setDensity(2000);
        this.toolForge = true;
    }


    public boolean isToolForge() {
        return toolForge;
    }
}
