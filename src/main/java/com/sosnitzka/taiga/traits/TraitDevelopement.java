package com.sosnitzka.taiga.traits;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitDevelopement extends AbstractTrait {


    public TraitDevelopement() {
        super(TraitDevelopement.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent e) {
        IBlockState state = e.getState();
        if (state.getBlock().equals(net.minecraft.init.Blocks.STONE))
            System.out.println("State.Variant: " + state.getValue(BlockStone.VARIANT));
    }


}
