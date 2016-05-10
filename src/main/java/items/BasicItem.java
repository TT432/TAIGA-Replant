package items;

import net.minecraft.item.Item;

public class BasicItem extends Item {

    public BasicItem(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
