package com.sosnitzka.taiga.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

import static com.sosnitzka.taiga.Items.*;
import static slimeknights.tconstruct.TConstruct.random;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem().equals(lignite)) {
            return 200 * 6;
        }
        if (fuel.getItem().equals(fuel_brick)) {
            return 200 * 50;
        }
        if (fuel.getItem().equals(glimmercoal)) {
            return (random.nextInt(20) + 40) * 200;
        }
        return 0;
    }

}
