package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public class TraitCrushing extends AbstractTrait {

    public TraitCrushing() {
        super(TraitCrushing.class.getSimpleName().toLowerCase().substring(5), TextFormatting.GRAY);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent e) {
        if (!e.getWorld().isRemote) {
            IBlockState state = e.getState();
            float f = random.nextFloat();
            if (state.equals(Blocks.STONE.getDefaultState())) {
                e.getDrops().clear();
                if (f < .3f) {
                    e.getDrops().add(new ItemStack(Blocks.SAND));
                } else if (f < .6f) {
                    e.getDrops().add(new ItemStack(Blocks.GRAVEL));
                } else if (f <= .9f) {
                    e.getDrops().add(new ItemStack(Blocks.COBBLESTONE));
                } else e.getDrops().add(new ItemStack(Blocks.STONE));
            }
        }
    }
}