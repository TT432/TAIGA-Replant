package com.sosnitzka.taiga.traits;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitTraditional extends AbstractTrait {

    public TraitTraditional() {
        super("traditional", TextFormatting.GREEN);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
