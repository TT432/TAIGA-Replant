package com.sosnitzka.taiga;


import com.google.common.base.Joiner;
import com.sosnitzka.taiga.generic.BasicItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.util.Utils.*;

public class Items {

    public static Item ironNugget = new BasicItem("iron_nugget", PREFIX_NUGGET);

    public static Item tiberiumIngot = new BasicItem("tiberium_ingot", PREFIX_INGOT);
    public static Item tiberiumDust = new BasicItem("tiberium_dust", PREFIX_DUST);
    public static Item tiberiumNugget = new BasicItem("tiberium_nugget", PREFIX_NUGGET);

    public static Item auroriumIngot = new BasicItem("aurorium_ingot", PREFIX_INGOT);
    public static Item auroriumDust = new BasicItem("aurorium_dust", PREFIX_DUST);
    public static Item auroriumNugget = new BasicItem("aurorium_nugget", PREFIX_NUGGET);

    public static Item prometheumIngot = new BasicItem("prometheum_ingot", PREFIX_INGOT);
    public static Item prometheumDust = new BasicItem("prometheum_dust", PREFIX_DUST);
    public static Item prometheumNugget = new BasicItem("prometheum_nugget", PREFIX_NUGGET);

    public static Item duraniteIngot = new BasicItem("duranite_ingot", PREFIX_INGOT);
    public static Item duraniteDust = new BasicItem("duranite_dust", PREFIX_DUST);
    public static Item duraniteNugget = new BasicItem("duranite_nugget", PREFIX_NUGGET);

    public static Item valyriumIngot = new BasicItem("valyrium_ingot", PREFIX_INGOT);
    public static Item valyriumDust = new BasicItem("valyrium_dust", PREFIX_DUST);
    public static Item valyriumNugget = new BasicItem("valyrium_nugget", PREFIX_NUGGET);

    public static Item vibraniumIngot = new BasicItem("vibranium_ingot", PREFIX_INGOT);
    public static Item vibraniumDust = new BasicItem("vibranium_dust", PREFIX_DUST);
    public static Item vibraniumNugget = new BasicItem("vibranium_nugget", PREFIX_NUGGET);

    public static Item karmesineIngot = new BasicItem("karmesine_ingot", PREFIX_INGOT);
    public static Item karmesineDust = new BasicItem("karmesine_dust", PREFIX_DUST);
    public static Item karmesineNugget = new BasicItem("karmesine_nugget", PREFIX_NUGGET);

    public static Item oviumIngot = new BasicItem("ovium_ingot", PREFIX_INGOT);
    public static Item oviumDust = new BasicItem("ovium_dust", PREFIX_DUST);
    public static Item oviumNugget = new BasicItem("ovium_nugget", PREFIX_NUGGET);

    public static Item jauxumIngot = new BasicItem("jauxum_ingot", PREFIX_INGOT);
    public static Item jauxumDust = new BasicItem("jauxum_dust", PREFIX_DUST);
    public static Item jauxumNugget = new BasicItem("jauxum_nugget", PREFIX_NUGGET);

    public static Item terraxIngot = new BasicItem("terrax_ingot", PREFIX_INGOT);
    public static Item terraxDust = new BasicItem("terrax_dust", PREFIX_DUST);
    public static Item terraxNugget = new BasicItem("terrax_nugget", PREFIX_NUGGET);

    public static Item palladiumIngot = new BasicItem("palladium_ingot", PREFIX_INGOT);
    public static Item palladiumDust = new BasicItem("palladium_dust", PREFIX_DUST);
    public static Item palladiumNugget = new BasicItem("palladium_nugget", PREFIX_NUGGET);

    public static Item uruIngot = new BasicItem("uru_ingot", PREFIX_INGOT);
    public static Item uruDust = new BasicItem("uru_dust", PREFIX_DUST);
    public static Item uruNugget = new BasicItem("uru_nugget", PREFIX_NUGGET);

    public static Item osramIngot = new BasicItem("osram_ingot", PREFIX_INGOT);
    public static Item osramDust = new BasicItem("osram_dust", PREFIX_DUST);
    public static Item osramNugget = new BasicItem("osram_nugget", PREFIX_NUGGET);

    public static Item abyssumIngot = new BasicItem("abyssum_ingot", PREFIX_INGOT);
    public static Item abyssumDust = new BasicItem("abyssum_dust", PREFIX_DUST);
    public static Item abyssumNugget = new BasicItem("abyssum_nugget", PREFIX_NUGGET);

    public static Item eezoIngot = new BasicItem("eezo_ingot", PREFIX_INGOT);
    public static Item eezoDust = new BasicItem("eezo_dust", PREFIX_DUST);
    public static Item eezoNugget = new BasicItem("eezo_nugget", PREFIX_NUGGET);

    public static Item triberiumIngot = new BasicItem("triberium_ingot", PREFIX_INGOT);
    public static Item triberiumDust = new BasicItem("triberium_dust", PREFIX_DUST);
    public static Item triberiumNugget = new BasicItem("triberium_nugget", PREFIX_NUGGET);

    public static Item fractumIngot = new BasicItem("fractum_ingot", PREFIX_INGOT);
    public static Item fractumDust = new BasicItem("fractum_dust", PREFIX_DUST);
    public static Item fractumNugget = new BasicItem("fractum_nugget", PREFIX_NUGGET);

    public static Item violiumIngot = new BasicItem("violium_ingot", PREFIX_INGOT);
    public static Item violiumDust = new BasicItem("violium_dust", PREFIX_DUST);
    public static Item violiumNugget = new BasicItem("violium_nugget", PREFIX_NUGGET);

    public static Item proxiiIngot = new BasicItem("proxii_ingot", PREFIX_INGOT);
    public static Item proxiiDust = new BasicItem("proxii_dust", PREFIX_DUST);
    public static Item proxiiNugget = new BasicItem("proxii_nugget", PREFIX_NUGGET);

    public static Item tritoniteIngot = new BasicItem("tritonite_ingot", PREFIX_INGOT);
    public static Item tritoniteDust = new BasicItem("tritonite_dust", PREFIX_DUST);
    public static Item tritoniteNugget = new BasicItem("tritonite_nugget", PREFIX_NUGGET);

    public static Item ignitzIngot = new BasicItem("ignitz_ingot", PREFIX_INGOT);
    public static Item ignitzDust = new BasicItem("ignitz_dust", PREFIX_DUST);
    public static Item ignitzNugget = new BasicItem("ignitz_nugget", PREFIX_NUGGET);

    public static Item imperomiteIngot = new BasicItem("imperomite_ingot", PREFIX_INGOT);
    public static Item imperomiteDust = new BasicItem("imperomite_dust", PREFIX_DUST);
    public static Item imperomiteNugget = new BasicItem("imperomite_nugget", PREFIX_NUGGET);

    public static Item solariumIngot = new BasicItem("solarium_ingot", PREFIX_INGOT);
    public static Item solariumDust = new BasicItem("solarium_dust", PREFIX_DUST);
    public static Item solariumNugget = new BasicItem("solarium_nugget", PREFIX_NUGGET);

    public static Item nihiliteIngot = new BasicItem("nihilite_ingot", PREFIX_INGOT);
    public static Item nihiliteDust = new BasicItem("nihilite_dust", PREFIX_DUST);
    public static Item nihiliteNugget = new BasicItem("nihilite_nugget", PREFIX_NUGGET);

    public static Item adamantIngot = new BasicItem("adamant_ingot", PREFIX_INGOT);
    public static Item adamantDust = new BasicItem("adamant_dust", PREFIX_DUST);
    public static Item adamantNugget = new BasicItem("adamant_nugget", PREFIX_NUGGET);

    public static Item dyoniteIngot = new BasicItem("dyonite_ingot", PREFIX_INGOT);
    public static Item dyoniteDust = new BasicItem("dyonite_dust", PREFIX_DUST);
    public static Item dyoniteNugget = new BasicItem("dyonite_nugget", PREFIX_NUGGET);

    public static Item nucleumIngot = new BasicItem("nucleum_ingot", PREFIX_INGOT);
    public static Item nucleumDust = new BasicItem("nucleum_dust", PREFIX_DUST);
    public static Item nucleumNugget = new BasicItem("nucleum_nugget", PREFIX_NUGGET);

    public static Item lumixIngot = new BasicItem("lumix_ingot", PREFIX_INGOT);
    public static Item lumixDust = new BasicItem("lumix_dust", PREFIX_DUST);
    public static Item lumixNugget = new BasicItem("lumix_nugget", PREFIX_NUGGET);

    public static Item seismumIngot = new BasicItem("seismum_ingot", PREFIX_INGOT);
    public static Item seismumDust = new BasicItem("seismum_dust", PREFIX_DUST);
    public static Item seismumNugget = new BasicItem("seismum_nugget", PREFIX_NUGGET);

    public static Item astriumIngot = new BasicItem("astrium_ingot", PREFIX_INGOT);
    public static Item astriumDust = new BasicItem("astrium_dust", PREFIX_DUST);
    public static Item astriumNugget = new BasicItem("astrium_nugget", PREFIX_NUGGET);

    public static Item niobIngot = new BasicItem("niob_ingot", PREFIX_INGOT);
    public static Item niobDust = new BasicItem("niob_dust", PREFIX_DUST);
    public static Item niobNugget = new BasicItem("niob_nugget", PREFIX_NUGGET);

    public static Item yrdeenIngot = new BasicItem("yrdeen_ingot", PREFIX_INGOT);
    public static Item yrdeenDust = new BasicItem("yrdeen_dust", PREFIX_DUST);
    public static Item yrdeenNugget = new BasicItem("yrdeen_nugget", PREFIX_NUGGET);

    public static Item ioxIngot = new BasicItem("iox_ingot", PREFIX_INGOT);
    public static Item ioxDust = new BasicItem("iox_dust", PREFIX_DUST);
    public static Item ioxNugget = new BasicItem("iox_nugget", PREFIX_NUGGET);

    public static Item meteoriteIngot = new BasicItem("meteorite_ingot", PREFIX_INGOT);
    public static Item meteoriteDust = new BasicItem("meteorite_dust", PREFIX_DUST);
    public static Item meteoriteNugget = new BasicItem("meteorite_nugget", PREFIX_NUGGET);

    public static Item basaltIngot = new BasicItem("basalt_ingot", PREFIX_INGOT);
    public static Item basaltDust = new BasicItem("basalt_dust", PREFIX_DUST);
    public static Item basaltNugget = new BasicItem("basalt_nugget", PREFIX_NUGGET);

    public static Item obsidioriteIngot = new BasicItem("obsidiorite_ingot", PREFIX_INGOT);
    public static Item obsidioriteDust = new BasicItem("obsidiorite_dust", PREFIX_DUST);
    public static Item obsidioriteNugget = new BasicItem("obsidiorite_nugget", PREFIX_NUGGET);

    public static Item dilithiumIngot = new BasicItem("dilithium_ingot", PREFIX_INGOT);
    public static Item dilithiumDust = new BasicItem("dilithium_dust", PREFIX_DUST);
    public static Item dilithiumCrystal = new BasicItem("dilithium_crystal", PREFIX_CRYSTAL);
    public static Item tiberiumCrystal = new BasicItem("tiberium_crystal", PREFIX_CRYSTAL);
    public static Item dilithiumNugget = new BasicItem("dilithium_nugget", PREFIX_NUGGET);

    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    @SubscribeEvent
    public static void register() {
        Field[] declaredFields = Items.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Item item = (Item) field.get(targetType); // Gets the field as a BasicItem which is then casted
                    // to an Item
                    if (item.equals(ironNugget) && OreDictionary.doesOreNameExist("nuggetIron")) {
                        System.out.println("TAIGA: Skipped registration of nuggetIron which already exists.");
                        continue;
                    }
                    item.setCreativeTab(CreativeTab.tabTaigaItem);
                    ForgeRegistries.ITEMS.register(item); // Registers the item into the game
                    if (item instanceof BasicItem) {  // Checks that the item is a BasicItem
                        if (((BasicItem) item).isOreDict()) { // Checks if this item should be registered into the
                            // oreDict and registers it
                            String oreDictName;
                            String[] nameParts = item.getUnlocalizedName().replace("item.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length -
                                        1));
                            } else {
                                oreDictName = nameParts[0];
                            }

                            OreDictionary.registerOre(((BasicItem) item).getOreDictPrefix() + StringUtils.capitalize
                                    (oreDictName), item); // Registers into oreDict
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
