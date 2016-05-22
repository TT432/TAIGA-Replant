package com.sosnitzka.ztic_addon;


import net.minecraftforge.fluids.FluidRegistry;

import static com.sosnitzka.ztic_addon.Fluids.*;
import static com.sosnitzka.ztic_addon.util.Utils.registerTinkerAlloys;

public class Alloys {

    static void register() {
        registerTinkerAlloys(astriumFluid, 1, arcaniteFluid, 3, karmesineFluid, 2, energy_enderium, 3);
        registerTinkerAlloys(nitroniteFluid, 2, tiberiumFluid, 4, vibraniumFluid, 3, nitroFluid, 3);
        registerTinkerAlloys(proxideumFluid, 1, prometheumFluid, 3, violiumFluid, 2, radiant_enderium, 3);
        registerTinkerAlloys(noctunyxFluid, 1, rubiumFluid, 3, meteoriteFluid, 2, anthraciteFluid, 3);
        registerTinkerAlloys(imperomiteFluid, 2, titaniteFluid, 3, prometheumFluid, 3, FluidRegistry.LAVA, 3);
        registerTinkerAlloys(cryptogenFluid, 1, meteoriteFluid, 3, mythrilFluid, 2, spectrumFluid, 3);
        registerTinkerAlloys(fractoryteFluid, 2, adamantiteFluid, 4, arcaniteFluid, 2, FluidRegistry.LAVA, 3);
        registerTinkerAlloys(seismodiumFluid, 2, vibraniumFluid, 4, palladiumFluid, 4, nitroFluid, 3);
        registerTinkerAlloys(terramiteFluid, 2, violiumFluid, 4, eterniteFluid, 2, energy_enderium, 3);
        registerTinkerAlloys(lumixylFluid, 1, bismuthFluid, 3, rubiumFluid, 2, glimming_enderium, 3);
        registerTinkerAlloys(solariumFluid, 1, karmesineFluid, 3, ignititeFluid, 2, glimmercoalFluid, 3);
        registerTinkerAlloys(dyoniteFluid, 1, mindoriteFluid, 4, tiberiumFluid, 2, anthraciteFluid, 3);
        registerTinkerAlloys(ultraniteFluid, 1, ignititeFluid, 5, adamantiteFluid, 3, glimming_enderium, 3);
        registerTinkerAlloys(nucleumFluid, 1, palladiumFluid, 3, mindoriteFluid, 3, radiant_enderium, 3);
        registerTinkerAlloys(aegisaltFluid, 1, eterniteFluid, 3, titaniteFluid, 3, glimmercoalFluid, 3);
        registerTinkerAlloys(bysmuidFluid, 1, mythrilFluid, 4, bismuthFluid, 2, spectrumFluid, 3);
    }

}
