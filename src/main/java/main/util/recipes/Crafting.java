package main.util.recipes;


import main.ZTiC;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafting {
    public Crafting(){
        register();
    }

    private void register(){
        GameRegistry.addShapelessRecipe(new ItemStack(ZTiC.fuel_brick), new Object[]{
                Items.COAL, Items.COAL, Items.COAL, ZTiC.lignite, ZTiC.lignite, ZTiC.lignite
        });
    }

}
