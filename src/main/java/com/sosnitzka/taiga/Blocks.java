package com.sosnitzka.taiga;

import com.google.common.base.Joiner;
import com.sosnitzka.taiga.blocks.BlockCobble;
import com.sosnitzka.taiga.blocks.BlockMeteoriteRock;
import com.sosnitzka.taiga.blocks.BlockTiberium;
import com.sosnitzka.taiga.generic.BasicBlock;
import com.sosnitzka.taiga.generic.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.sosnitzka.taiga.MaterialTraits.*;
import static com.sosnitzka.taiga.util.Utils.PREFIX_BLOCK;
import static com.sosnitzka.taiga.util.Utils.PREFIX_ORE;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;

public class Blocks {


    // blocks and ores spawned via worldgen
    public static Block basaltBlock = new BasicBlock("basalt_block", Material.ROCK, 20.0f, 35.0f, IRON, PREFIX_BLOCK);
    public static Block tiberiumOre = new BlockTiberium();
    public static Block auroriumOre = new BasicBlock("aurorium_ore", Material.ROCK, 15.0f, 12f, COBALT, 0.2f,
            PREFIX_ORE);
    public static Block prometheumOre = new BasicBlock("prometheum_ore", Material.ROCK, 20.0f, 12f, DURANITE, 0.4f,
            PREFIX_ORE);
    public static Block duraniteOre = new BasicBlock("duranite_ore", Material.ROCK, 25.0f, 1000f, DURANITE, PREFIX_ORE);
    public static Block valyriumOre = new BasicBlock("valyrium_ore", Material.ROCK, 35.0f, 2000f, VALYRIUM, PREFIX_ORE);
    public static Block vibraniumOre = new BasicBlock("vibranium_ore", Material.ROCK, 40.0f, 3000f, VIBRANIUM,
            PREFIX_ORE);
    public static Block karmesineOre = new BasicBlock("karmesine_ore", Material.ROCK, 10.0f, 10f, COBALT, PREFIX_ORE);
    public static Block oviumOre = new BasicBlock("ovium_ore", Material.ROCK, 10.0f, 10f, COBALT, PREFIX_ORE);
    public static Block jauxumOre = new BasicBlock("jauxum_ore", Material.ROCK, 10.0f, 10f, COBALT, PREFIX_ORE);
    public static Block palladiumOre = new BasicBlock("palladium_ore", Material.ROCK, 25.0f, 150f, DURANITE, 0.4f,
            PREFIX_ORE);
    public static Block uruOre = new BasicBlock("uru_ore", Material.ROCK, 35.0f, 500f, VALYRIUM, PREFIX_ORE);
    public static Block osramOre = new BasicBlock("osram_ore", Material.ROCK, 15.0f, 35.0f, COBALT, PREFIX_ORE);
    public static Block eezoOre = new BasicBlock("eezo_ore", Material.ROCK, 50.0f, 50000.0f, COBALT, PREFIX_ORE);
    public static Block abyssumOre = new BasicBlock("abyssum_ore", Material.ROCK, 15.0f, 35.0f, COBALT, PREFIX_ORE);

    // Ore Castsee
    public static Block tiberiumBlock = new BasicBlock("tiberium_block", Material.GLASS, 10.0f, 15f, STONE, 1f,
            PREFIX_BLOCK);
    public static Block auroriumBlock = new BasicBlock("aurorium_block", Material.ROCK, 15.0f, 15f, COBALT,
            PREFIX_BLOCK);
    public static Block prometheumBlock = new BasicBlock("prometheum_block", Material.ROCK, 20.0f, 15f, DURANITE,
            0.5f, PREFIX_BLOCK);
    public static Block duraniteBlock = new BasicBlock("duranite_block", Material.ROCK, 20.0f, 800f, DURANITE,
            PREFIX_BLOCK);
    public static Block valyriumBlock = new BasicBlock("valyrium_block", Material.ROCK, 20.0f, 1500f, VALYRIUM,
            PREFIX_BLOCK);
    public static Block vibraniumBlock = new BasicBlock("vibranium_block", Material.ROCK, 20.0f, 3000f, VIBRANIUM,
            PREFIX_BLOCK);
    public static Block karmesineBlock = new BasicBlock("karmesine_block", Material.ROCK, 10.0f, 12f, COBALT,
            PREFIX_BLOCK);
    public static Block oviumBlock = new BasicBlock("ovium_block", Material.ROCK, 10.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block jauxumBlock = new BasicBlock("jauxum_block", Material.ROCK, 10.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block palladiumBlock = new BasicBlock("palladium_block", Material.ROCK, 25.0f, 150f, DURANITE,
            0.5f, PREFIX_BLOCK);
    public static Block uruBlock = new BasicBlock("uru_block", Material.ROCK, 30.0f, 500f, VALYRIUM, PREFIX_BLOCK);
    public static Block osramBlock = new BasicBlock("osram_block", Material.ROCK, 15.0f, 12f, COBALT, PREFIX_BLOCK);
    public static Block abyssumBlock = new BasicBlock("abyssum_block", Material.ROCK, 15.0f, 35f, COBALT, PREFIX_BLOCK);
    public static Block eezoBlock = new BasicBlock("eezo_block", Material.ROCK, 20.0f, 1000f, COBALT, PREFIX_BLOCK);

    public static Block terraxBlock = new BasicBlock("terrax_block", Material.ROCK, 10.0f, 15f, COBALT, PREFIX_BLOCK);
    public static Block triberiumBlock = new BasicBlock("triberium_block", Material.ROCK, 15.0f, 15f, OBSIDIAN, 1f,
            PREFIX_BLOCK);
    public static Block fractumBlock = new BasicBlock("fractum_block", Material.ROCK, 15.0f, 25f, COBALT, PREFIX_BLOCK);
    public static Block violiumBlock = new BasicBlock("violium_block", Material.ROCK, 15.0f, 25f, COBALT, PREFIX_BLOCK);
    public static Block proxiiBlock = new BasicBlock("proxii_block", Material.ROCK, 15.0f, 25f, DURANITE, PREFIX_BLOCK);
    public static Block tritoniteBlock = new BasicBlock("tritonite_block", Material.ROCK, 15.0f, 25f, COBALT,
            PREFIX_BLOCK);
    public static Block ignitzBlock = new BasicBlock("ignitz_block", Material.ROCK, 20.0f, 20f, COBALT, PREFIX_BLOCK);
    public static Block imperomiteBlock = new BasicBlock("imperomite_block", Material.ROCK, 20.0f, 25f, DURANITE,
            PREFIX_BLOCK);
    public static Block solariumBlock = new BasicBlock("solarium_block", Material.ROCK, 25.0f, 25f, VIBRANIUM,
            PREFIX_BLOCK);
    public static Block nihiliteBlock = new BasicBlock("nihilite_block", Material.ROCK, 10.0f, 25f, VALYRIUM,
            PREFIX_BLOCK);
    public static Block adamantBlock = new BasicBlock("adamant_block", Material.ROCK, 25.0f, 25f, VIBRANIUM,
            PREFIX_BLOCK);
    public static Block dyoniteBlock = new BasicBlock("dyonite_block", Material.ROCK, 10.0f, 25f, DURANITE,
            PREFIX_BLOCK);
    public static Block nucleumBlock = new BasicBlock("nucleum_block", Material.ROCK, 10.0f, 25f, VALYRIUM,
            PREFIX_BLOCK);
    public static Block lumixBlock = new BasicBlock("lumix_block", Material.ROCK, 15.0f, 25f, COBALT, PREFIX_BLOCK);
    public static Block seismumBlock = new BasicBlock("seismum_block", Material.ROCK, 15.0f, 25f, COBALT, PREFIX_BLOCK);
    public static Block astriumBlock = new BasicBlock("astrium_block", Material.ROCK, 15.0f, 25f, COBALT, PREFIX_BLOCK);
    public static Block niobBlock = new BasicBlock("niob_block", Material.ROCK, 15.0f, 25f, DURANITE, PREFIX_BLOCK);
    public static Block yrdeenBlock = new BasicBlock("yrdeen_block", Material.ROCK, 15.0f, 25f, VALYRIUM, PREFIX_BLOCK);
    public static Block ioxBlock = new BasicBlock("iox_block", Material.ROCK, 20.0f, 25f, DURANITE, PREFIX_BLOCK);


    public static Block blockMeteoriteCobble = new BlockCobble("meteoritecobble_block", Material.ROCK, 20f, 10f,
            COBALT, 0.075f, PREFIX_BLOCK);
    public static Block blockObsidioriteCobble = new BlockCobble("obsidioritecobble_block", Material.ROCK, 25f, 20f,
            DURANITE, 0.035f, PREFIX_BLOCK);
    public static Block blockMeteorite = new BlockMeteoriteRock("meteorite_block", Material.ROCK, 40f, 2000f, COBALT,
            0.15f, PREFIX_BLOCK, blockMeteoriteCobble.getDefaultState());
    public static Block blockObsidiorite = new BlockMeteoriteRock("obsidiorite_block", Material.ROCK, 50f, 4000f,
            DURANITE, 0.2f, PREFIX_BLOCK, blockObsidioriteCobble.getDefaultState());

    // Community
    public static Block dilithiumOre = new BlockOre("dilithium_ore", Material.GLASS, 18f, 18f, DIAMOND, 0.73f, Items.dilithiumCrystal, 3, 10);
    public static Block dilithiumBlock = new BasicBlock("dilithium_block", Material.GLASS, 18f, 18f, DIAMOND, 0.73f, PREFIX_BLOCK);

    /**
     * Registers all materials' ingots and nuggets <br>
     * Detailed summary: <br>
     * Gets the ingots declared in the class (fields and reflection) and iterates through them: <br>
     * Checks that the field is static, registers the field (item), and adds an oreDict entry if needed
     */
    @SubscribeEvent
    public static void register(boolean oreDict) {
        Field[] declaredFields = Blocks.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType);
                    if (!oreDict) {
                        block.setCreativeTab(CreativeTab.tabTaigaBlock);
                        ForgeRegistries.BLOCKS.register(block); // Registers block and its item
                    } else {
                        if (block instanceof BasicBlock) { // Checks that the block is a BasicBlock
                            if (((BasicBlock) block).isOreDict()) { // Checks that the block has an oreDict entry
                                String oreDictName;
                                String[] nameParts = block.getUnlocalizedName().replace("tile.", "").split("_");

                                if (nameParts.length > 2) {
                                    oreDictName = Joiner.on("_").join(Arrays.copyOfRange(nameParts, 0, nameParts
                                            .length - 1));
                                } else {
                                    oreDictName = nameParts[0];
                                }
                                OreDictionary.registerOre(((BasicBlock) block).getOreDictPrefix() + StringUtils
                                        .capitalize(oreDictName), block); // Registers the block's oreDict
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SubscribeEvent
    public static void registerItems() {
        Field[] declaredFields = Blocks.class.getDeclaredFields(); // Gets the fields (ingots) declared above
        for (Field field : declaredFields) { // Iterates through the fields declared above
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) { // Checks that the fields are static
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType); // Gets the field as a BasicBlock which is then
                    // casted to an Block
                    ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
