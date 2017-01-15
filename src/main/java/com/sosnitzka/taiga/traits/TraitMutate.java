package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


public class TraitMutate extends AbstractTrait {


    public TraitMutate() {
        super(TraitMutate.class.getSimpleName().toLowerCase().substring(5), TextFormatting.YELLOW);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void beforeBlockBreak(ItemStack tool, BlockEvent.BreakEvent event) {
        if (!event.getWorld().isRemote && random.nextFloat() > 0.95) {
            IBlockState state = event.getState();
            List<Block> blist = newArrayList(Blocks.STONE, Blocks.COBBLESTONE, Blocks.DIRT, Blocks.SAND, Blocks.GRASS, Blocks.CLAY, Blocks.NETHERRACK, Blocks.ICE, Blocks.SNOW, Blocks.BONE_BLOCK, Blocks.LAVA, Blocks.WATER, Blocks.WHEAT);
            if (blist.contains(state.getBlock())) {
                Block newBlock = blist.get(random.nextInt(blist.size()));
                IBlockState newState = newBlock.getDefaultState();
                event.setCanceled(true);
                event.getWorld().setBlockState(event.getPos(), newState);
            }

        }

    }
}



