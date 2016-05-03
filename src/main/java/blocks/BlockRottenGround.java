package blocks;

import blocks.category.BasicBlockGround;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockRottenGround extends BasicBlockGround {

    public BlockRottenGround() {
        super("rotten_ground", Material.GROUND, 2.0f, 2.0f, 0);
        this.setSoundType(SoundType.GROUND);
    }
}
