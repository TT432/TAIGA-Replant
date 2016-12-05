package com.sosnitzka.taiga.proxy;

import com.sosnitzka.taiga.TAIGAConfiguration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import slimeknights.tconstruct.library.materials.Material;

public class CommonProxy {

    public void registerModels() {

    }

    public void setRenderInfo(Material material) {

    }

    public void registerFluidModels(Fluid fluid) {
    }

    public void initConfig() {
        TAIGAConfiguration.preInit();
    }

    public void registerServerCommands(FMLServerStartingEvent e) {
    }
}
