package main.util;

import main.ZCompression;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class LigniteFuelHandler implements IFuelHandler {

    @Override
    public  int getBurnTime(ItemStack fuel){
        if(fuel.getItem().equals(ZCompression.lignite)) {
            return 200*2;
        }
        return 0;
    }

}
