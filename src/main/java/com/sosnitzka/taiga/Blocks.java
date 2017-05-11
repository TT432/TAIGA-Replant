package com.sosnitzka.taiga;

import com.google.common.base.Joiner;
import com.sosnitzka.taiga.blocks.BlockCobble;
import com.sosnitzka.taiga.blocks.BlockMeteoriteRock;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BlockOre;
import com.sosnitzka.taiga.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.MaterialTraits.VIBRANIUM;
import static com.sosnitzka.taiga.util.Utils.PREFIX_BLOCK;
import static com.sosnitzka.taiga.util.Utils.PREFIX_ORE;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

public class Blocks {


    // Natural Blocks
    public static Block eezoOre = new BasicBlock("eezo_ore", Material.ROCK, 10.0f, 15f, OBSIDIAN, .55f, PREFIX_ORE);
    public static Block osramOre = new BasicBlock("osram_ore", Material.ROCK, 10.0f, 15f, DIAMOND, .55f, PREFIX_ORE);
    public static Block abyssumOre = new BasicBlock("abyssum_ore", Material.ROCK, 10.0f, 15f, DIAMOND, .55f, PREFIX_ORE);
    public static Block tiberiumOre = new BasicBlock("tiberium_ore", Material.GLASS, 10.0f, 15f, IRON, .75f, PREFIX_ORE);
    public static Block dilithiumOre = new BlockOre("dilithium_ore", Material.GLASS, 18f, 18f, IRON, 0.15f, Items.dilithiumCrystal, 3, 10);
    public static Block dimeriteOre = new BasicBlock("dimerite_ore", Material.GLASS, 10.0f, 15f, DIAMOND, .55f, PREFIX_ORE);
    public static Block meteoritecobbleBlock = new BlockCobble("meteoritecobble_block", Material.ROCK, 20f, 10f, COBALT, 0.075f, PREFIX_BLOCK);
    public static Block meteoriteBlock = new BlockMeteoriteRock("meteorite_block", Material.ROCK, 20f, 35f, OBSIDIAN, 0.15f, PREFIX_BLOCK, meteoritecobbleBlock.getDefaultState());
    public static Block basaltBlock = new BasicBlock("basalt_block", Material.ROCK, 20.0f, 35.0f, STONE, PREFIX_BLOCK);
    public static Block uruOre = new BasicBlock("uru_ore", Material.GLASS, 10.0f, 15f, COBALT, PREFIX_ORE);
    public static Block prometheumOre = new BasicBlock("prometheum_ore", Material.GLASS, 10.0f, 15f, OBSIDIAN, .55f, PREFIX_ORE);
    public static Block vibraniumOre = new BasicBlock("vibranium_ore", Material.GLASS, 10.0f, 15f, VIBRANIUM, PREFIX_ORE);
    public static Block karmesineOre = new BasicBlock("karmesine_ore", Material.ROCK, 10.0f, 15f, DIAMOND, PREFIX_ORE);
    public static Block violiumOre = new BasicBlock("violium_ore", Material.ROCK, 10.0f, 15f, IRON, PREFIX_ORE);
    public static Block jauxiteOre = new BasicBlock("jauxite_ore", Material.ROCK, 10.0f, 15f, STONE, PREFIX_ORE);
    public static Block moonrockBlock = new BasicBlock("moonrock_block", Material.GLASS, 10.0f, 15f, OBSIDIAN, .55f, PREFIX_BLOCK);


    // Natrual Refined
    public static Block eezoBlock = new BasicBlock("_block", Material.ROCK, 20.0f, 35.0f, OBSIDIAN, PREFIX_BLOCK);
    public static Block osramBlock = new BasicBlock("_block", Material.ROCK, 20.0f, 35.0f, DIAMOND, PREFIX_BLOCK);
    public static Block abyssumBlock = new BasicBlock("_block", Material.ROCK, 20.0f, 35.0f, DIAMOND, PREFIX_BLOCK);
    public static Block tiberiumBlock = new BasicBlock("tiberium_block", Material.GLASS, 20.0f, 35.0f, IRON, PREFIX_BLOCK);
    public static Block dilithiumBlock = new BasicBlock("dilithium_block", Material.GLASS, 10.0f, 15f, DIAMOND, .55f, PREFIX_BLOCK);
    public static Block dimeriteBlock = new BasicBlock("dimerite_block", Material.GLASS, 10.0f, 15f, DIAMOND, .55f, PREFIX_BLOCK);
    public static Block uruBlock = new BasicBlock("uru_block", Material.IRON, 10.0f, 15f, COBALT, .55f, PREFIX_BLOCK);
    public static Block prometheumBlock = new BasicBlock("prometheum_block", Material.GLASS, 10.0f, 15f, OBSIDIAN, .55f, PREFIX_BLOCK);
    public static Block vibraniumBlock = new BasicBlock("vibranium_block", Material.IRON, 10.0f, 15f, VIBRANIUM, .55f, PREFIX_BLOCK);
    public static Block karmesineBlock = new BasicBlock("karmesine_block", Material.ROCK, 10.0f, 15f, DIAMOND, PREFIX_BLOCK);
    public static Block violiumBlock = new BasicBlock("violium_block", Material.ROCK, 10.0f, 15f, IRON, PREFIX_BLOCK);
    public static Block jauxiteBlock = new BasicBlock("jauxite_block", Material.ROCK, 10.0f, 15f, STONE, PREFIX_BLOCK);

    // Alloys
    public static Block lumixBlock = new BasicBlock("lumix_block", Material.GLASS, 20.0f, 35.0f, DIAMOND, PREFIX_BLOCK);
    public static Block ignitzBlock = new BasicBlock("ignitz_block", Material.ROCK, 20.0f, 35.0f, OBSIDIAN, PREFIX_BLOCK);
    public static Block astriumBlock = new BasicBlock("astrium_block", Material.ROCK, 20.0f, 35.0f, OBSIDIAN, PREFIX_BLOCK);
    public static Block quxonBlock = new BasicBlock("quxon_block", Material.ROCK, 20.0f, 35.0f, OBSIDIAN, PREFIX_BLOCK);
    public static Block adamantBlock = new BasicBlock("adamant_block", Material.IRON, 20.0f, 35.0f, VIBRANIUM, PREFIX_BLOCK);
    public static Block oviumBlock = new BasicBlock("ovium_block", Material.ROCK, 20.0f, 35.0f, DIAMOND, PREFIX_BLOCK);
    public static Block fractumBlock = new BasicBlock("fractum_block", Material.ROCK, 20.0f, 35.0f, OBSIDIAN, PREFIX_BLOCK);
    public static Block seismumBlock = new BasicBlock("seismum_block", Material.ROCK, 20.0f, 35.0f, OBSIDIAN, PREFIX_BLOCK);
    public static Block valyriumBlock = new BasicBlock("valyrium_block", Material.IRON, 20.0f, 35.0f, COBALT, PREFIX_BLOCK);
    public static Block ioxBlock = new BasicBlock("iox_block", Material.ROCK, 20.0f, 35.0f, COBALT, PREFIX_BLOCK);
    public static Block hexiteBlock = new BasicBlock("hexite_block", Material.ROCK, 20.0f, 35.0f, COBALT, PREFIX_BLOCK);
    public static Block invaliteBlock = new BasicBlock("invalite_block", Material.ROCK, 20.0f, 35.0f, VIBRANIUM, PREFIX_BLOCK);



    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    public static void register() {
        Field[] declaredFields = Blocks.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType); // Gets the field as a BasicBlock which is then casted to an Block
                    block.setCreativeTab(CreativeTab.tabTaigaBlock);
                    Utils.registerBlockWithItem(block); // Registers block and its item
                    if (block instanceof BasicBlock) { // Checks that the block is a BasicBlock
                        if (((BasicBlock) block).isOreDict()) { // Checks that the block has an oreDict entry
                            String oreDictName;
                            String[] nameParts = block.getUnlocalizedName().replace("tile.", "").split("_");

                            if (nameParts.length > 2) {
                                oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts.length - 1));
                            } else {
                                oreDictName = nameParts[0];
                            }
                            OreDictionary.registerOre(((BasicBlock) block).getOreDictPrefix() + StringUtils.capitalize(oreDictName), block); // Registers the block's oreDict
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
