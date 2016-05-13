package com.sosnitzka.ztic_addon;


import com.google.common.base.Joiner;
import com.sosnitzka.ztic_addon.generic.BasicItem;
import com.sosnitzka.ztic_addon.items.ItemIronNugget;
import com.sosnitzka.ztic_addon.items.ItemLignite;
import com.sosnitzka.ztic_addon.items.ItemSlaggoldIngot;
import com.sosnitzka.ztic_addon.items.ItemSlagironIngot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.ztic_addon.util.Utils.PREFIX_INGOT;
import static com.sosnitzka.ztic_addon.util.Utils.PREFIX_NUGGET;

public class Items {
    public static ItemSlagironIngot slagironIngot = new ItemSlagironIngot();
    public static ItemLignite lignite = new ItemLignite();
    public static ItemIronNugget iron_nugget = new ItemIronNugget();
    public static ItemSlaggoldIngot slaggoldIngot = new ItemSlaggoldIngot();
    public static Item fuel_brick = new BasicItem("fuel_brick");

    public static Item aardiumIngot = new BasicItem("aardium_ingot", PREFIX_INGOT);
    public static Item adamantiteIngot = new BasicItem("adamantite_ingot", PREFIX_INGOT);
    public static Item arcaniteIngot = new BasicItem("arcanite_ingot", PREFIX_INGOT);
    public static Item axiidianIngot = new BasicItem("axiidian_ingot", PREFIX_INGOT);
    public static Item bismuthIngot = new BasicItem("bismuth_ingot", PREFIX_INGOT);
    public static Item eterniteIngot = new BasicItem("eternite_ingot", PREFIX_INGOT);
    public static Item ignititeIngot = new BasicItem("ignitite_ingot", PREFIX_INGOT);
    public static Item karmesineIngot = new BasicItem("karmesine_ingot", PREFIX_INGOT);
    public static Item meteoriteIngot = new BasicItem("meteorite_ingot", PREFIX_INGOT);
    public static Item mindoriteIngot = new BasicItem("mindorite_ingot", PREFIX_INGOT);
    public static Item mythrilIngot = new BasicItem("mythril_ingot", PREFIX_INGOT);
    public static Item palladiumIngot = new BasicItem("palladium_ingot", PREFIX_INGOT);
    public static Item prometheumIngot = new BasicItem("prometheum_ingot", PREFIX_INGOT);
    public static Item tiberiumIngot = new BasicItem("tiberium_ingot", PREFIX_INGOT);
    public static Item vibraniumIngot = new BasicItem("vibranium_ingot", PREFIX_INGOT);
    public static Item yrdeanIngot = new BasicItem("yrdean_ingot", PREFIX_INGOT);

    public static Item astriumIngot = new BasicItem("astrium_ingot", PREFIX_INGOT);
    public static Item instableNitroniteIngot = new BasicItem("instable_nitronite_ingot", PREFIX_INGOT);
    public static Item proxideumIngot = new BasicItem("proxideum_ingot", PREFIX_INGOT);
    public static Item instablePolyniumIngot = new BasicItem("instable_polyniumingot", PREFIX_INGOT);
    public static Item imperomiteIngot = new BasicItem("imperomite_ingot", PREFIX_INGOT);
    public static Item cryptogenIngot = new BasicItem("cryptogen_ingot", PREFIX_INGOT);
    public static Item fractoryteIngot = new BasicItem("fractoryte_ingot", PREFIX_INGOT);
    public static Item seismodiumIngot = new BasicItem("seismodium_ingot", PREFIX_INGOT);
    public static Item terramiteIngot = new BasicItem("terramite_ingot", PREFIX_INGOT);
    public static Item instablePrysociteIngot = new BasicItem("instable_prysocite_ingot", PREFIX_INGOT);
    public static Item blazingXylititeIngot = new BasicItem("blazing_xylitite_ingot", PREFIX_INGOT);
    public static Item instableDyoniteIngot = new BasicItem("instable_dyonite_ingot", PREFIX_INGOT);
    public static Item ultraniteIngot = new BasicItem("ultranite_ingot", PREFIX_INGOT);
    public static Item radiantPliniumIngot = new BasicItem("radiant_plinium_ingot", PREFIX_INGOT);
    public static Item dysprosaniumIngot = new BasicItem("dysprosanium_ingot", PREFIX_INGOT);
    public static Item refractiveBysumIngot = new BasicItem("refractive_bysum_ingot", PREFIX_INGOT);

    public static Item tiberiumShardInstable = new BasicItem("tiberium_shard_instable", PREFIX_NUGGET);
    public static Item tiberiumShardStable = new BasicItem("tiberium_shard_stable", PREFIX_NUGGET);

    public static void register() {
        Field[] declaredFields = Items.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    Item item = (Item) field.get(targetType);
                    GameRegistry.register(item);

                    if (item instanceof BasicItem) {
                        if (((BasicItem) item).isOreDict()) {
                            String oreDictName;
                            String[] nameParts = item.getUnlocalizedName().replace("item.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                            } else {
                                oreDictName = nameParts[0];
                            }

                            OreDictionary.registerOre(((BasicItem) item).getOreDictPrefix() + StringUtils.capitalize(oreDictName), item);
                            System.out.println(String.format("Registered OreDict: %s", "ingot" + StringUtils.capitalize(oreDictName)));
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
