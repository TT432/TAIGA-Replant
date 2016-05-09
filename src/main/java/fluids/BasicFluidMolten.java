package fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Robert on 09.05.2016.
 */
public class BasicFluidMolten extends Fluid {
    public BasicFluidMolten(String fluidName, ResourceLocation still, ResourceLocation flowing) {
        super(fluidName, still, flowing);
    }

    @Override
    public int getColor() {
        return 0x000000;
    }

}
