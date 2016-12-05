package com.sosnitzka.taiga.traits;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitVortex extends AbstractTrait {


    public TraitVortex() {
        super(TraitVortex.class.getSimpleName().toLowerCase().substring(5), TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }


}
