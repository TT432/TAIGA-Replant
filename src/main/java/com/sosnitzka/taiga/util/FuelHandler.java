package com.sosnitzka.taiga.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import static com.sosnitzka.taiga.Items.*;
import static slimeknights.tconstruct.TConstruct.random;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem().equals(lignite)) {
            return 200 * 8;
        }
        if (fuel.getItem().equals(lignite2)) {
            return 200 * 6;
        }
        if (fuel.getItem().equals(lignite3)) {
            return 200 * 10;
        }
        if (fuel.getItem().equals(fuel_brick)) {
            return 200 * 16;
        }
        if (fuel.getItem().equals(glimmercoal)) {
            return (random.nextInt(32) + 32) * 200;
        }
        return 0;
    }

}
