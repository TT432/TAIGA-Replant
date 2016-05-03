package fluids;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;


public class MoltenAardium extends Fluid {
    public MoltenAardium() {
        super("molten_aardium", new ResourceLocation("tconstruct:blocks/fluids/molten_metal"), new ResourceLocation("tconstruct:blocks/fluids/molten_metal_flow"));
    }

    @Override
    public int getColor() {
        return 0x00FF15;
    }

}
