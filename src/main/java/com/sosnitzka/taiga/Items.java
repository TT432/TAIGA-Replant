package com.sosnitzka.taiga;


import com.google.common.base.Joiner;
import com.sosnitzka.taiga.generic.BasicItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.util.Utils.PREFIX_INGOT;
import static com.sosnitzka.taiga.util.Utils.PREFIX_NUGGET;

public class Items {

    public static Item lignite = new BasicItem("lignite", null, "lignite");
    public static Item iron_nugget = new BasicItem("iron_nugget", PREFIX_NUGGET);
    public static Item slaggoldIngot = new BasicItem("slaggold_ingot");
    public static Item slagironIngot = new BasicItem("slagiron_ingot");
    public static Item fuel_brick = new BasicItem("fuel_brick");

    //Nuggets
    public static Item titanite_nugget = new BasicItem("titanite_nugget", PREFIX_NUGGET);
    public static Item adamantite_nugget = new BasicItem("adamantite_nugget", PREFIX_NUGGET);
    public static Item arcanite_nugget = new BasicItem("arcanite_nugget", PREFIX_NUGGET);
    public static Item violium_nugget = new BasicItem("violium_nugget", PREFIX_NUGGET);
    public static Item bismuth_nugget = new BasicItem("bismuth_nugget", PREFIX_NUGGET);
    public static Item eternite_nugget = new BasicItem("eternite_nugget", PREFIX_NUGGET);
    public static Item ignitite_nugget = new BasicItem("ignitite_nugget", PREFIX_NUGGET);
    public static Item karmesine_nugget = new BasicItem("karmesine_nugget", PREFIX_NUGGET);
    public static Item meteorite_nugget = new BasicItem("meteorite_nugget", PREFIX_NUGGET);
    public static Item mindorite_nugget = new BasicItem("mindorite_nugget", PREFIX_NUGGET);
    public static Item mythril_nugget = new BasicItem("mythril_nugget", PREFIX_NUGGET);
    public static Item palladium_nugget = new BasicItem("palladium_nugget", PREFIX_NUGGET);
    public static Item prometheum_nugget = new BasicItem("prometheum_nugget", PREFIX_NUGGET);
    // NAH! public static Item tiberium_nugget = new BasicItem("tiberium_nugget", PREFIX_NUGGET);
    public static Item vibranium_nugget = new BasicItem("vibranium_nugget", PREFIX_NUGGET);
    public static Item rubium_nugget = new BasicItem("rubium_nugget", PREFIX_NUGGET);
    public static Item astrium_nugget = new BasicItem("astrium_nugget", PREFIX_NUGGET);
    public static Item nitronite_nugget = new BasicItem("nitronite_nugget", PREFIX_NUGGET);
    public static Item proxideum_nugget = new BasicItem("proxideum_nugget", PREFIX_NUGGET);
    public static Item noctunyx_nugget = new BasicItem("noctunyx_nugget", PREFIX_NUGGET);
    public static Item imperomite_nugget = new BasicItem("imperomite_nugget", PREFIX_NUGGET);
    public static Item cryptogen_nugget = new BasicItem("cryptogen_nugget", PREFIX_NUGGET);
    public static Item fractoryte_nugget = new BasicItem("fractoryte_nugget", PREFIX_NUGGET);
    public static Item seismodium_nugget = new BasicItem("seismodium_nugget", PREFIX_NUGGET);
    public static Item tiberium_nugget = new BasicItem("tiberium_nugget", PREFIX_NUGGET);
    public static Item terramite_nugget = new BasicItem("terramite_nugget", PREFIX_NUGGET);
    public static Item lumixyl_nugget = new BasicItem("lumixyl_nugget", PREFIX_NUGGET);
    public static Item solarium_nugget = new BasicItem("solarium_nugget", PREFIX_NUGGET);
    public static Item dyonite_nugget = new BasicItem("dyonite_nugget", PREFIX_NUGGET);
    public static Item ultranite_nugget = new BasicItem("ultranite_nugget", PREFIX_NUGGET);
    public static Item nucleum_nugget = new BasicItem("nucleum_nugget", PREFIX_NUGGET);
    public static Item aegisalt_nugget = new BasicItem("aegisalt_nugget", PREFIX_NUGGET);
    public static Item bysmuid_nugget = new BasicItem("bysmuid_nugget", PREFIX_NUGGET);

    public static Item glimmercoal = new BasicItem("glimmercoal");
    public static Item radiant_pearl = new BasicItem("radiant_pearl");
    public static Item glimmer_pearl = new BasicItem("glimmer_pearl");
    public static Item energy_pearl = new BasicItem("energy_pearl");
    public static Item glimmerstone_dust = new BasicItem("glimmerstone_dust");
    public static Item luminar_dust = new BasicItem("luminar_dust");
    public static Item spectrum_dust = new BasicItem("spectrum_dust");
    public static Item anthracite_dust = new BasicItem("anthracite_dust");
    public static Item nitro_brick = new BasicItem("nitro_brick");

    public static Item titaniteIngot = new BasicItem("titanite_ingot", PREFIX_INGOT);
    public static Item adamantiteIngot = new BasicItem("adamantite_ingot", PREFIX_INGOT);
    public static Item arcaniteIngot = new BasicItem("arcanite_ingot", PREFIX_INGOT);
    public static Item violiumIngot = new BasicItem("violium_ingot", PREFIX_INGOT);
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
    public static Item rubiumIngot = new BasicItem("rubium_ingot", PREFIX_INGOT);

    public static Item astriumIngot = new BasicItem("astrium_ingot", PREFIX_INGOT);
    public static Item nitroniteIngot = new BasicItem("nitronite_ingot", PREFIX_INGOT);
    public static Item proxideumIngot = new BasicItem("proxideum_ingot", PREFIX_INGOT);
    public static Item noctunyxIngot = new BasicItem("noctunyx_ingot", PREFIX_INGOT);
    public static Item imperomiteIngot = new BasicItem("imperomite_ingot", PREFIX_INGOT);
    public static Item cryptogenIngot = new BasicItem("cryptogen_ingot", PREFIX_INGOT);
    public static Item fractoryteIngot = new BasicItem("fractoryte_ingot", PREFIX_INGOT);
    public static Item seismodiumIngot = new BasicItem("seismodium_ingot", PREFIX_INGOT);
    public static Item terramiteIngot = new BasicItem("terramite_ingot", PREFIX_INGOT);
    public static Item lumixylIngot = new BasicItem("lumixyl_ingot", PREFIX_INGOT);
    public static Item solariumIngot = new BasicItem("solarium_ingot", PREFIX_INGOT);
    public static Item dyoniteIngot = new BasicItem("dyonite_ingot", PREFIX_INGOT);
    public static Item ultraniteIngot = new BasicItem("ultranite_ingot", PREFIX_INGOT);
    public static Item nucleumIngot = new BasicItem("nucleum_ingot", PREFIX_INGOT);
    public static Item aegisaltIngot = new BasicItem("aegisalt_ingot", PREFIX_INGOT);
    public static Item bysmuidIngot = new BasicItem("bysmuid_ingot", PREFIX_INGOT);

    public static Item tiberiumShardInstable = new BasicItem("tiberium_shard_instable");

    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    public static void register() {
        Field[] declaredFields = Items.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Item item = (Item) field.get(targetType); // Gets the field as a BasicItem which is then casted to an Item
                    GameRegistry.register(item); // Registers the item into the game
                    if (item instanceof BasicItem) {  // Checks that the item is a BasicItem
                        if (((BasicItem) item).isOreDict()) { // Checks if this item should be registered into the oreDict and registers it
                            String oreDictName;
                            String[] nameParts = item.getUnlocalizedName().replace("item.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                            } else {
                                oreDictName = nameParts[0];
                            }

                            OreDictionary.registerOre(((BasicItem) item).getOreDictPrefix() + StringUtils.capitalize(oreDictName), item); // Registers into oreDict
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
