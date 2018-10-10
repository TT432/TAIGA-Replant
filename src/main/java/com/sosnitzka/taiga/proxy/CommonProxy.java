package com.sosnitzka.taiga.proxy;

import com.sosnitzka.taiga.TAIGAConfiguration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import slimeknights.tconstruct.library.materials.Material;

import static com.sosnitzka.taiga.MaterialTraits.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.harvestLevelNames;

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

    public void registerBookPages() {
    }

    public void regsiterKeyBindings() {

    }

    public void registerHarvestLevels() {
        harvestLevelNames.put(DURANITE, "harvestlevel.duranite");
        harvestLevelNames.put(VALYRIUM, "harvestlevel.valyrium");
        harvestLevelNames.put(VIBRANIUM, "harvestlevel.vibranium");
    }
}
