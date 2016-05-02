package blocks;

import blocks.category.BasicBlockOreGlow;
import net.minecraft.block.material.Material;

public class BlockPrometheumOre extends BasicBlockOreGlow {

    public BlockPrometheumOre() {
        super("prometheum_ore", Material.ROCK, 35.0f, 35.0f, 4, 0.25f);
    }
}
