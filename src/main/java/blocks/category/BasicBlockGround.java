package blocks.category;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlockGround extends Block {

    public BasicBlockGround(String name, Material material, float hardness, float resistance, int harvest) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel("shovel", harvest);
    }
}
