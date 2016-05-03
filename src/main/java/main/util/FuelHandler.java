package main.util;

import main.ZCompression;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import org.apache.commons.lang3.RandomUtils;

public class FuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {
        if (fuel.getItem().equals(ZCompression.lignite)) {
            return 200 * 2;
        }
        if (fuel.getItem().equals(ZCompression.fuel_brick)) {
            return RandomUtils.nextInt(1, 64) * 200;
        }
        return 0;
    }

}
