package com.sosnitzka.ztic_addon;


import com.sosnitzka.ztic_addon.generic.BasicItem;
import com.sosnitzka.ztic_addon.items.ItemIronNugget;
import com.sosnitzka.ztic_addon.items.ItemLignite;
import com.sosnitzka.ztic_addon.items.ItemSlaggoldIngot;
import com.sosnitzka.ztic_addon.items.ItemSlagironIngot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Field;

public class Items {
    public static ItemSlagironIngot slagironIngot = new ItemSlagironIngot();
    public static ItemLignite lignite = new ItemLignite();
    public static ItemIronNugget iron_nugget = new ItemIronNugget();
    public static ItemSlaggoldIngot slaggoldIngot = new ItemSlaggoldIngot();
    public static Item fuel_brick = new BasicItem("fuel_brick");

    public static Item aardiumIngot = new BasicItem("aardium_ingot", "ingotAardium");
    public static Item adamantiteIngot = new BasicItem("adamantite_ingot", "ingotAdamantite");
    public static Item arcaniteIngot = new BasicItem("arcanite_ingot", "ingotArcanite");
    public static Item axiidianIngot = new BasicItem("axiidian_ingot", "ingotAxiidian");
    public static Item bismuthIngot = new BasicItem("bismuth_ingot", "ingotBismuth");
    public static Item eterniteIngot = new BasicItem("eternite_ingot", "ingotEternite");
    public static Item ignititeIngot = new BasicItem("ignitite_ingot", "ingotIgnitite");
    public static Item karmesineIngot = new BasicItem("karmesine_ingot", "ingotKarmesine");
    public static Item meteoriteIngot = new BasicItem("meteorite_ingot", "ingotMeteorite");
    public static Item mindoriteIngot = new BasicItem("mindorite_ingot", "ingotMindorite");
    public static Item mythrilIngot = new BasicItem("mythril_ingot", "ingotMythril");
    public static Item palladiumIngot = new BasicItem("palladium_ingot", "ingotPalladium");
    public static Item prometheumIngot = new BasicItem("prometheum_ingot", "ingotPrometheum");
    public static Item tiberiumIngot = new BasicItem("tiberium_ingot", "ingotTiberium");
    public static Item vibraniumIngot = new BasicItem("vibranium_ingot", "ingotVibranium");
    public static Item yrdeanIngot = new BasicItem("yrdean_ingot", "ingotYrdean");

    public static Item astriumIngot = new BasicItem("astrium_ingot", "ingotAstrium");
    public static Item instableNitroniteIngot = new BasicItem("instable_nitronite_ingot");
    public static Item proxideumIngot = new BasicItem("proxideum_ingot");
    public static Item instablePolyniumIngot = new BasicItem("instable_polyniumingot");
    public static Item imperomiteIngot = new BasicItem("imperomite_ingot");
    public static Item cryptogenIngot = new BasicItem("cryptogen_ingot");
    public static Item fractoryteIngot = new BasicItem("fractoryte_ingot");
    public static Item seismodiumIngot = new BasicItem("seismodium_ingot");
    public static Item terramiteIngot = new BasicItem("terramite_ingot");
    public static Item instablePrysociteIngot = new BasicItem("instable_prysocite_ingot");
    public static Item blazingXylititeIngot = new BasicItem("blazing_xylitite_ingot");
    public static Item instableDyoniteIngot = new BasicItem("instable_dyonite_ingot");
    public static Item ultraniteIngot = new BasicItem("ultranite_ingot");
    public static Item radiantPliniumIngot = new BasicItem("radiant_plinium_ingot");
    public static Item dysprosaniumIngot = new BasicItem("dysprosanium_ingot");
    public static Item refractiveBysumIngot = new BasicItem("refractive_bysum_ingot");

    public static Item tiberiumShardInstable = new BasicItem("tiberium_shard_instable");
    public static Item tiberiumShardStable = new BasicItem("tiberium_shard_stable");

    static void register() {
        Field[] declaredFields = Items.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    Object newInstance = targetType.newInstance();
                    GameRegistry.register(((Item) field.get(newInstance)));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
