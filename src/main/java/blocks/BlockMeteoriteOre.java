package blocks;

import blocks.category.BasicBlockOre;
import net.minecraft.block.material.Material;

public class BlockMeteoriteOre extends BasicBlockOre {

    public BlockMeteoriteOre() {
        super("meteorite_ore", Material.ROCK, 3.0f, 5.0f);
    }
}
