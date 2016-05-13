package com.sosnitzka.ztic_addon;

import com.google.common.base.Joiner;
import com.sosnitzka.ztic_addon.blocks.BlockLigniteOre;
import com.sosnitzka.ztic_addon.blocks.BlockTiberiumOre;
import com.sosnitzka.ztic_addon.generic.BasicBlockGround;
import com.sosnitzka.ztic_addon.generic.BasicBlockOre;
import com.sosnitzka.ztic_addon.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Blocks {
    public static Block basalt = new BasicBlockOre("basalt", Material.ROCK, 45.0f, 35.0f, 3);
    public static Block rottenGround = new BasicBlockGround("rotten_ground", Material.GROUND, 2.0f, 2.0f, 0);
    public static Block ligniteOre = new BlockLigniteOre();

    public static Block aardiumOre = new BasicBlockOre("aardium_ore", Material.ROCK, 55.0f, 400.0f, 3);
    public static Block adamantiteOre = new BasicBlockOre("adamantite_ore", Material.ROCK, 80.0f, 1000.0f, 4);
    public static Block arcaniteOre = new BasicBlockOre("arcanite_ore", Material.ROCK, 23.0f, 25.0f, 2);
    public static Block axiidianOre = new BasicBlockOre("axiidian_ore", Material.ROCK, 13.0f, 13.0f, 3);
    public static Block bismuthOre = new BasicBlockOre("bismuth_ore", Material.ROCK, 8.0f, 8.0f, 1);
    public static Block eterniteOre = new BasicBlockOre("eternite_ore", Material.ROCK, 24.0f, 25.0f, 3);
    public static Block ignititeOre = new BasicBlockOre("ignitite_ore", Material.ROCK, 23.0f, 25.0f, 3);
    public static Block karmesineOre = new BasicBlockOre("karmesine_ore", Material.ROCK, 13.0f, 15.0f, 1);
    public static Block meteoriteOre = new BasicBlockOre("meteorite_ore", Material.ROCK, 60.0f, 500.0f, 4);
    public static Block mindoriteOre = new BasicBlockOre("mindorite_ore", Material.ROCK, 12.0f, 12.0f, 2);
    public static Block mythrilOre = new BasicBlockOre("mythril_ore", Material.ROCK, 25.0f, 25.0f, 4);
    public static Block palladiumOre = new BasicBlockOre("palladium_ore", Material.ROCK, 25.0f, 25.0f, 3);
    public static Block prometheumOre = new BasicBlockOre("prometheum_ore", Material.ROCK, 35.0f, 35.0f, 4, 0.25f);
    public static Block slagironOre = new BasicBlockOre("slagiron_ore", Material.ROCK, 3.0f, 5.0f, 1);
    public static Block slaggoldOre = new BasicBlockOre("slaggold_ore", Material.ROCK, 3.0f, 5.0f, 1);
    public static Block tiberiumOre = new BlockTiberiumOre();
    public static Block vibraniumOre = new BasicBlockOre("vibranium_ore", Material.ROCK, 70.0f, 800.0f, 4);
    public static Block yrdeanOre = new BasicBlockOre("yrdean_ore", Material.ROCK, 13.0f, 15.0f, 3);


    public static void register() {
        Field[] declaredFields = Blocks.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType);
                    Utils.registerBlockWithItem(block);

                    if (block instanceof BasicBlockOre) {
                        String oreDictName;
                        String[] nameParts = block.getUnlocalizedName().replace("tile.", "").split("_");
                        System.out.println();

                        if (nameParts.length > 2) {
                            oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                        } else {
                            oreDictName = nameParts[0];
                        }

                        OreDictionary.registerOre("ore" + StringUtils.capitalize(oreDictName), block);
                        System.out.println(String.format("Registered OreDict: %s", "ore" + StringUtils.capitalize(oreDictName)));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
