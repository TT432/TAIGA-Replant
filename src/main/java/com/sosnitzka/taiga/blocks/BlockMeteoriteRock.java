package com.sosnitzka.taiga.blocks;

import com.sosnitzka.taiga.generic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static slimeknights.tconstruct.TConstruct.random;

public class BlockMeteoriteRock extends BasicBlock {

    private IBlockState cobbblestate;

    public BlockMeteoriteRock(String name, Material material, float hardness, float resistance, int harvestlevel, float light, String oreDictPrefix, IBlockState cobble) {
        super(name, material, hardness, resistance, harvestlevel, light, oreDictPrefix);
        MinecraftForge.EVENT_BUS.register(this);
        this.cobbblestate = cobble;
    }

    @SubscribeEvent
    public void breakMoonRock(BlockEvent.BreakEvent e) {
        if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(this)) {
            if (!e.getWorld().isRemote && random.nextFloat() > .25) {
                e.setCanceled(true);
                e.getWorld().setBlockState(e.getPos(), cobbblestate);
            }
        }

    }

}
