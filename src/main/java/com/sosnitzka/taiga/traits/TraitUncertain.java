package com.sosnitzka.taiga.traits;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitUncertain extends AbstractTrait {


    public TraitUncertain() {
        super(TraitUncertain.class.getName().toLowerCase().substring(4), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
