package com.sosnitzka.taiga.blocks;

import com.sosnitzka.taiga.generic.BasicBlock;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static slimeknights.tconstruct.TConstruct.random;

public class BlockCobble extends BasicBlock {

    public BlockCobble(String name, Material material, float hardness, float resistance, int harvestlevel, float
            light, String oreDictPrefix) {
        super(name, material, hardness, resistance, harvestlevel, light, oreDictPrefix);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void breakMoonRock(BlockEvent.BreakEvent e) {
        if (e.getWorld().getBlockState(e.getPos()).getBlock().equals(this)) {
            if (!e.getWorld().isRemote && random.nextFloat() > .9) {
                e.setCanceled(true);
                if (random.nextBoolean()) {
                    e.getWorld().setBlockState(e.getPos(), Blocks.LAVA.getDefaultState());
                } else {
                    e.getWorld().newExplosion(null, e.getPos().getX(), e.getPos().getY() + 1 / 16f, e.getPos().getZ()
                            , 0.5f + random.nextFloat() * 1.5f, false, true);
                }
            }
        }
    }

}
