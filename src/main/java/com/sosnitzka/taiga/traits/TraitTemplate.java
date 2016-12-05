package com.sosnitzka.taiga.traits;

import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;


public class TraitTemplate extends AbstractTrait {


    public TraitTemplate() {
        super(TraitTemplate.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }


}
