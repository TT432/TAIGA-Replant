package com.sosnitzka.taiga.traits;

import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;


public class TraitLeveled extends AbstractTraitLeveled {


    public TraitLeveled(int levels) {
        super(TraitLeveled.class.getSimpleName().toLowerCase().substring(5), 0xFFFF5500, 3, levels);
        MinecraftForge.EVENT_BUS.register(this);
    }


}
