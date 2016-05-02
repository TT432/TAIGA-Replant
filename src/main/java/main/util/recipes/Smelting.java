package main.util.recipes;


import main.ZCompression;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Smelting {
    public Smelting(){
        register();
    }

    private void register(){
        GameRegistry.addSmelting(ZCompression.slagironOre, new ItemStack(ZCompression.slagironIngot,2),1.0F);
        GameRegistry.addSmelting(ZCompression.slagironIngot, new ItemStack(Items.GOLD_NUGGET),1.0F);
    }
}
