package blocks;

import blocks.category.BasicBlockOre;
import net.minecraft.block.material.Material;

public class BlockMeteoriteOre extends BasicBlockOre {

    public BlockMeteoriteOre() {
        super("meteorite_ore", Material.ROCK, 60.0f,500.0f,4);
    }
}
