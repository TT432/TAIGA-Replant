package com.sosnitzka.taiga;


import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.shared.TinkerFluids;

import static com.sosnitzka.taiga.Fluids.*;
import static com.sosnitzka.taiga.util.Utils.registerTinkerAlloy;

public class Alloys {

    /**
     * Registers alloying in the smeltery
     */
    public static void register() {
        registerTinkerAlloy(new FluidStack(triberiumFluid, 1), new FluidStack(tiberiumFluid, 5), new FluidStack(basaltFluid, 1));
        registerTinkerAlloy(new FluidStack(fractumFluid, 2), new FluidStack(triberiumFluid, 3), new FluidStack(TinkerFluids.obsidian, 3), new FluidStack(abyssumFluid, 1));
        registerTinkerAlloy(new FluidStack(violiumFluid, 2), new FluidStack(auroriumFluid, 3), new FluidStack(TinkerFluids.ardite, 2));
        registerTinkerAlloy(new FluidStack(proxiiFluid, 3), new FluidStack(prometheumFluid, 3), new FluidStack(palladiumFluid, 3), new FluidStack(eezoFluid, 1));
        registerTinkerAlloy(new FluidStack(tritoniteFluid, 2), new FluidStack(TinkerFluids.cobalt, 3), new FluidStack(karmesineFluid, 2));
        registerTinkerAlloy(new FluidStack(ignitzFluid, 2), new FluidStack(TinkerFluids.ardite, 2), new FluidStack(karmesineFluid, 2), new FluidStack(osramFluid, 1));
        registerTinkerAlloy(new FluidStack(imperomiteFluid, 2), new FluidStack(duraniteFluid, 3), new FluidStack(prometheumFluid, 1), new FluidStack(abyssumFluid, 1));
        registerTinkerAlloy(new FluidStack(solariumFluid, 2), new FluidStack(valyriumFluid, 2), new FluidStack(uruFluid, 2), new FluidStack(nucleumFluid, 1));
        registerTinkerAlloy(new FluidStack(adamantFluid, 3), new FluidStack(vibraniumFluid, 1), new FluidStack(solariumFluid, 1), new FluidStack(ioxFluid, 3));
        registerTinkerAlloy(new FluidStack(nihiliteFluid, 1), new FluidStack(vibraniumFluid, 1), new FluidStack(solariumFluid, 1));
        registerTinkerAlloy(new FluidStack(seismumFluid, 4), new FluidStack(TinkerFluids.obsidian, 4), new FluidStack(triberiumFluid, 2), new FluidStack(eezoFluid, 1));
        registerTinkerAlloy(new FluidStack(astriumFluid, 2), new FluidStack(karmesineFluid, 3), new FluidStack(auroriumFluid, 2));
        registerTinkerAlloy(new FluidStack(niobFluid, 3), new FluidStack(palladiumFluid, 3), new FluidStack(duraniteFluid, 1), new FluidStack(osramFluid, 1));
        registerTinkerAlloy(new FluidStack(yrdeenFluid, 3), new FluidStack(uruFluid, 3), new FluidStack(valyriumFluid, 3), new FluidStack(osramFluid, 1));
        registerTinkerAlloy(new FluidStack(yrdeenFluid, 3), new FluidStack(uruFluid, 3), new FluidStack(valyriumFluid, 3), new FluidStack(eezoFluid, 1));
        registerTinkerAlloy(new FluidStack(yrdeenFluid, 3), new FluidStack(uruFluid, 3), new FluidStack(valyriumFluid, 3), new FluidStack(abyssumFluid, 1));
        registerTinkerAlloy(new FluidStack(ioxFluid, 1), new FluidStack(eezoFluid, 2), new FluidStack(abyssumFluid, 2), new FluidStack(osramFluid, 2), new FluidStack(obsidioriteFluid, 9));
        registerTinkerAlloy(new FluidStack(ioxFluid, 1), new FluidStack(eezoFluid, 2), new FluidStack(abyssumFluid, 2), new FluidStack(osramFluid, 2), new FluidStack(meteoriteFluid, 9), new FluidStack(TinkerFluids.obsidian, 9));
        registerTinkerAlloy(new FluidStack(lumixFluid, 1), new FluidStack(palladiumFluid, 1), new FluidStack(karmesineFluid, 1));
        registerTinkerAlloy(new FluidStack(obsidioriteFluid, 1), new FluidStack(meteoriteFluid, 1), new FluidStack(TinkerFluids.obsidian, 1));
        registerTinkerAlloy(new FluidStack(nucleumFluid, 3), new FluidStack(proxiiFluid, 3), new FluidStack(abyssumFluid, 1), new FluidStack(osramFluid, 1));
        registerTinkerAlloy(new FluidStack(nucleumFluid, 3), new FluidStack(imperomiteFluid, 3), new FluidStack(osramFluid, 1), new FluidStack(eezoFluid, 1));
        registerTinkerAlloy(new FluidStack(nucleumFluid, 3), new FluidStack(niobFluid, 3), new FluidStack(eezoFluid, 1), new FluidStack(abyssumFluid, 1));
        registerTinkerAlloy(new FluidStack(dyoniteFluid, 3), new FluidStack(triberiumFluid, 3), new FluidStack(fractumFluid, 1), new FluidStack(seismumFluid, 1), new FluidStack(osramFluid, 1));
        registerTinkerAlloy(new FluidStack(dyoniteFluid, 3), new FluidStack(tiberiumFluid, 12), new FluidStack(fractumFluid, 1), new FluidStack(seismumFluid, 1), new FluidStack(osramFluid, 1));
        registerTinkerAlloy(new FluidStack(nitroniteFluid, 6), new FluidStack(magmaFluid, 6), new FluidStack(osramFluid, 1));

    }
}
