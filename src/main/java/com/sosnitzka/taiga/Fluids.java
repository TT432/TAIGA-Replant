package com.sosnitzka.taiga;


import com.sosnitzka.taiga.generic.BasicTinkerFluid;
import com.sosnitzka.taiga.util.Utils;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.smeltery.block.BlockMolten;

import java.lang.reflect.Field;

import static com.sosnitzka.taiga.util.Utils.registerFluid;

public class Fluids {

    public static BasicTinkerFluid basaltFluid = new BasicTinkerFluid("basalt_fluid", 0xFFe4ddc3, 550, 10, 6000);
    public static BasicTinkerFluid tiberiumFluid = new BasicTinkerFluid("tiberium_fluid", 0xFFd4ff00, 400, 10, 8000);
    public static BasicTinkerFluid auroriumFluid = new BasicTinkerFluid("aurorium_fluid", 0xFFefae94, 750, 10, 10000);
    public static BasicTinkerFluid prometheumFluid = new BasicTinkerFluid("prometheum_fluid", 0xFF372c49, 850, 10, 10000);
    public static BasicTinkerFluid duraniteFluid = new BasicTinkerFluid("duranite_fluid", 0xFFacddeb, 1400, 10, 10000);
    public static BasicTinkerFluid valyriumFluid = new BasicTinkerFluid("valyrium_fluid", 0xFFe85c31, 1915, 10, 10000);
    public static BasicTinkerFluid vibraniumFluid = new BasicTinkerFluid("vibranium_fluid", 0xFFbad2d9, 3050, 10, 10000);
    public static BasicTinkerFluid karmesineFluid = new BasicTinkerFluid("karmesine_fluid", 0xFFeb484a, 750, 10, 9000);
    public static BasicTinkerFluid jauxumFluid = new BasicTinkerFluid("jauxum_fluid", 0xFF68c663, 750, 10, 9000);
    public static BasicTinkerFluid oviumFluid = new BasicTinkerFluid("ovium_fluid", 0xFF7d77c3, 750, 10, 9000);
    public static BasicTinkerFluid terraxFluid = new BasicTinkerFluid("terrax_fluid", 0xFFa5978e, 850, 10, 9000);
    public static BasicTinkerFluid palladiumFluid = new BasicTinkerFluid("palladium_fluid", 0xFFee8736, 690, 10, 10000);
    public static BasicTinkerFluid uruFluid = new BasicTinkerFluid("uru_fluid", 0xFFbfb9f0, 1200, 10, 10000);
    public static BasicTinkerFluid osramFluid = new BasicTinkerFluid("osram_fluid", 0xFFffbc90, 800, 10, 4000);
    public static BasicTinkerFluid abyssumFluid = new BasicTinkerFluid("abyssum_fluid", 0xFF21bcc2, 700, 10, 10000);
    public static BasicTinkerFluid eezoFluid = new BasicTinkerFluid("eezo_fluid", 0xFF58798a, 450, 0, 1000);
    public static BasicTinkerFluid triberiumFluid = new BasicTinkerFluid("triberium_fluid", 0xFF66f136, 550, 10, 9000);
    public static BasicTinkerFluid fractumFluid = new BasicTinkerFluid("fractum_fluid", 0xFFd2c583, 750, 10, 10000);
    public static BasicTinkerFluid violiumFluid = new BasicTinkerFluid("violium_fluid", 0xFFbfb0e2, 850, 10, 10000);
    public static BasicTinkerFluid proxiiFluid = new BasicTinkerFluid("proxii_fluid", 0xFFcefde1, 750, 10, 10000);
    public static BasicTinkerFluid tritoniteFluid = new BasicTinkerFluid("tritonite_fluid", 0xFF8edeff, 550, 10, 10000);
    public static BasicTinkerFluid ignitzFluid = new BasicTinkerFluid("ignitz_fluid", 0xFFff284b, 950, 10, 6000);
    public static BasicTinkerFluid imperomiteFluid = new BasicTinkerFluid("imperomite_fluid", 0xFF7fefa0, 900, 10, 10000);
    public static BasicTinkerFluid solariumFluid = new BasicTinkerFluid("solarium_fluid", 0xFFfef864, 1500, 10, 2000);
    public static BasicTinkerFluid nihiliteFluid = new BasicTinkerFluid("nihilite_fluid", 0xFF6645ba, 580, 10, 10000);
    public static BasicTinkerFluid adamantFluid = new BasicTinkerFluid("adamant_fluid", 0xFFff8efe, 1650, 10, 10000);
    public static BasicTinkerFluid dyoniteFluid = new BasicTinkerFluid("dyonite_fluid", 0xFFffbd3f, 660, 10, 7000);
    public static BasicTinkerFluid nucleumFluid = new BasicTinkerFluid("nucleum_fluid", 0xFFe6ff40, 490, 10, 10000);
    public static BasicTinkerFluid lumixFluid = new BasicTinkerFluid("lumix_fluid", 0xFFf9f3cc, 450, 10, 8000);
    public static BasicTinkerFluid seismumFluid = new BasicTinkerFluid("seismum_fluid", 0xFFecbca8, 720, 10, 10000);
    public static BasicTinkerFluid astriumFluid = new BasicTinkerFluid("astrium_fluid", 0xFF8f385f, 680, 10, 10000);
    public static BasicTinkerFluid niobFluid = new BasicTinkerFluid("niob_fluid", 0xFF7398b9, 550, 10, 10000);
    public static BasicTinkerFluid yrdeenFluid = new BasicTinkerFluid("yrdeen_fluid", 0xFF8f385f, 710, 10, 10000);
    public static BasicTinkerFluid ioxFluid = new BasicTinkerFluid("iox_fluid", 0xFF99323c, 900, 10, 10000);
    public static BasicTinkerFluid meteoriteFluid = new BasicTinkerFluid("meteorite_fluid", 0xFF374f3d, 950, 10, 7000);
    public static BasicTinkerFluid obsidioriteFluid = new BasicTinkerFluid("obsidiorite_fluid", 0xFF224853, 1050, 10, 7000);
    public static BasicTinkerFluid magmaFluid = new BasicTinkerFluid("magma_fluid", 0xFFffc000, 2000, 10, 5000);
    public static BasicTinkerFluid nitroniteFluid = new BasicTinkerFluid("nitronite_fluid", 0xFFCCFF00, 3100, 10, 5000);

    // Community

    public static BasicTinkerFluid dilithiumFluid = new BasicTinkerFluid("dilithium_fluid", 0xFF79aea6, 1500, 10, 5000);

    /**
     * Registers all materials' fluids <br>
     * Detailed summary: <br>
     * Gets the fluids declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (fluids), and registers the models on the client
     */
    static void register() {
        Field[] declaredFields = Fluids.class.getDeclaredFields(); // Gets the blocks and ores declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    BasicTinkerFluid fluid = (BasicTinkerFluid) field.get(targetType); // Gets the field as a BasicTinkerFluid
                    registerFluid(fluid); // Registers the fluid into the game along wit its bucket

                    BlockMolten block = new BlockMolten(fluid);
                    // Sets names
                    block.setUnlocalizedName("molten_" + fluid.getName());
                    block.setRegistryName(TAIGA.MODID, "molten_" + fluid.getName());
                    // Registers the fluid in its block form and its corresponding item (block/fluid as item in inventory)
                    Utils.registerBlockWithItem(block);
                    // Registers the fluid's model but only on the client side
                    TAIGA.proxy.registerFluidModels(fluid);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Registers special smeltery recipes (not alloying)
     */
    static void registerfromItem() {
        TinkerRegistry.registerMelting(Blocks.blockMeteoriteCobble, meteoriteFluid, 288);
        TinkerRegistry.registerMelting(Blocks.blockObsidiorite, meteoriteFluid, 288);
        TinkerRegistry.registerMelting(net.minecraft.init.Blocks.MAGMA, magmaFluid, 288);
        TinkerRegistry.registerMelting(Items.dilithiumCrystal, dilithiumFluid, 72);
        TinkerRegistry.registerMelting(Items.tiberiumCrystal, dilithiumFluid, 72);


        TinkerRegistry.registerSmelteryFuel(new FluidStack(magmaFluid, 50), 100);
        TinkerRegistry.registerSmelteryFuel(new FluidStack(nitroniteFluid, 100), 500);
        TinkerRegistry.registerSmelteryFuel(new FluidStack(dilithiumFluid, 50), 100);
    }

}
