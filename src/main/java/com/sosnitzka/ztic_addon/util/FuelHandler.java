package com.sosnitzka.ztic_addon.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import org.apache.commons.lang3.RandomUtils;

import static com.sosnitzka.ztic_addon.Items.fuel_brick;
import static com.sosnitzka.ztic_addon.Items.lignite;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem().equals(lignite)) {
            return 200 * 2;
        }
        if (fuel.getItem().equals(fuel_brick)) {
            return RandomUtils.nextInt(1, RandomUtils.nextInt(1, RandomUtils.nextInt(1, 64))) * 200;
        }
        return 0;
    }

}
