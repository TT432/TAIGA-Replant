package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitMelting extends AbstractTrait {

    public TraitMelting() {
        super("melting", TextFormatting.YELLOW);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        float r = random.nextFloat();
        Block b = event.getWorld().getBlockState(event.getPos()).getBlock();
        if (r <= 0.01 && (b == Blocks.STONE || b == Blocks.COBBLESTONE || b == Blocks.NETHERRACK)) {
            event.getWorld().setBlockState(event.getPos(), Blocks.LAVA.getDefaultState());
        }
    }


}



