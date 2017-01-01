package com.sosnitzka.taiga.traits;

import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTraitLeveled;


public class TraitDeflection extends AbstractTraitLeveled {


    public TraitDeflection(int levels) {
        super(TraitDeflection.class.getSimpleName().toLowerCase().substring(5), 0xFFFF5500, 3, levels);
        MinecraftForge.EVENT_BUS.register(this);
    }


}
