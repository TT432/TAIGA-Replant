package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitMelting extends AbstractTrait {

    public TraitMelting() {
        super("melting", TextFormatting.YELLOW);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void blockbreak(BlockEvent.BreakEvent e) {
        Block b = e.getWorld().getBlockState(e.getPos()).getBlock();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(e.getPlayer().getHeldItemMainhand()), identifier)) {
            if (!e.getWorld().isRemote && random.nextFloat() <= 0.025 && (b == Blocks.STONE || b == Blocks
                    .COBBLESTONE || b == Blocks.NETHERRACK || b == Blocks.OBSIDIAN)) {
                e.setCanceled(true);
                e.getWorld().setBlockState(e.getPos(), Blocks.LAVA.getDefaultState());
            }
        }
    }
}



