package blocks;

import blocks.category.BasicBlockOre;
import blocks.category.BasicBlockOreGlow;
import net.minecraft.block.material.Material;

public class BlockPrometheumOre extends BasicBlockOreGlow {

    public BlockPrometheumOre() {
        super("prometheum_ore", Material.ROCK, 3.0f, 5.0f, 0.25f);
    }
}
