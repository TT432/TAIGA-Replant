package com.sosnitzka.taiga.recipes;

import com.sosnitzka.taiga.Blocks;
import com.sosnitzka.taiga.Items;
import com.sosnitzka.taiga.TAIGA;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingRegistry {

    public static void register() {
        convertion(Item.getItemFromBlock(Blocks.tiberiumBlock), Items.tiberiumIngot, Items.tiberiumNugget);
        convertion(Item.getItemFromBlock(Blocks.auroriumBlock), Items.auroriumIngot, Items.auroriumNugget);
        convertion(Item.getItemFromBlock(Blocks.prometheumBlock), Items.prometheumIngot, Items.prometheumNugget);
        convertion(Item.getItemFromBlock(Blocks.duraniteBlock), Items.duraniteIngot, Items.duraniteNugget);
        convertion(Item.getItemFromBlock(Blocks.valyriumBlock), Items.valyriumIngot, Items.valyriumNugget);
        convertion(Item.getItemFromBlock(Blocks.vibraniumBlock), Items.vibraniumIngot, Items.vibraniumNugget);
        convertion(Item.getItemFromBlock(Blocks.karmesineBlock), Items.karmesineIngot, Items.karmesineNugget);
        convertion(Item.getItemFromBlock(Blocks.oviumBlock), Items.oviumIngot, Items.oviumNugget);
        convertion(Item.getItemFromBlock(Blocks.jauxumBlock), Items.jauxumIngot, Items.jauxumNugget);
        convertion(Item.getItemFromBlock(Blocks.palladiumBlock), Items.palladiumIngot, Items.palladiumNugget);
        convertion(Item.getItemFromBlock(Blocks.uruBlock), Items.uruIngot, Items.uruNugget);
        convertion(Item.getItemFromBlock(Blocks.osramBlock), Items.osramIngot, Items.osramNugget);
        convertion(Item.getItemFromBlock(Blocks.eezoBlock), Items.eezoIngot, Items.eezoNugget);
        convertion(Item.getItemFromBlock(Blocks.abyssumBlock), Items.abyssumIngot, Items.abyssumNugget);
        convertion(Item.getItemFromBlock(Blocks.terraxBlock), Items.terraxIngot, Items.terraxNugget);
        convertion(Item.getItemFromBlock(Blocks.triberiumBlock), Items.triberiumIngot, Items.triberiumNugget);
        convertion(Item.getItemFromBlock(Blocks.fractumBlock), Items.fractumIngot, Items.fractumNugget);
        convertion(Item.getItemFromBlock(Blocks.violiumBlock), Items.violiumIngot, Items.violiumNugget);
        convertion(Item.getItemFromBlock(Blocks.proxiiBlock), Items.proxiiIngot, Items.proxiiNugget);
        convertion(Item.getItemFromBlock(Blocks.tritoniteBlock), Items.tritoniteIngot, Items.tritoniteNugget);
        convertion(Item.getItemFromBlock(Blocks.ignitzBlock), Items.ignitzIngot, Items.ignitzNugget);
        convertion(Item.getItemFromBlock(Blocks.imperomiteBlock), Items.imperomiteIngot, Items.imperomiteNugget);
        convertion(Item.getItemFromBlock(Blocks.solariumBlock), Items.solariumIngot, Items.solariumNugget);
        convertion(Item.getItemFromBlock(Blocks.nihiliteBlock), Items.nihiliteIngot, Items.nihiliteNugget);
        convertion(Item.getItemFromBlock(Blocks.adamantBlock), Items.adamantIngot, Items.adamantNugget);
        convertion(Item.getItemFromBlock(Blocks.dyoniteBlock), Items.dyoniteIngot, Items.dyoniteNugget);
        convertion(Item.getItemFromBlock(Blocks.nucleumBlock), Items.nucleumIngot, Items.nucleumNugget);
        convertion(Item.getItemFromBlock(Blocks.lumixBlock), Items.lumixIngot, Items.lumixNugget);
        convertion(Item.getItemFromBlock(Blocks.seismumBlock), Items.seismumIngot, Items.seismumNugget);
        convertion(Item.getItemFromBlock(Blocks.astriumBlock), Items.astriumIngot, Items.astriumNugget);
        convertion(Item.getItemFromBlock(Blocks.niobBlock), Items.niobIngot, Items.niobNugget);
        convertion(Item.getItemFromBlock(Blocks.yrdeenBlock), Items.yrdeenIngot, Items.yrdeenNugget);
        convertion(Item.getItemFromBlock(Blocks.ioxBlock), Items.ioxIngot, Items.ioxNugget);
        convertion(Item.getItemFromBlock(Blocks.blockMeteorite), Items.meteoriteIngot, Items.meteoriteNugget);
        convertion(Item.getItemFromBlock(Blocks.blockObsidiorite), Items.obsidioriteIngot, Items.obsidioriteNugget);
        convertion(Item.getItemFromBlock(Blocks.dilithiumBlock), Items.dilithiumIngot, Items.dilithiumNugget);
    }

    public static void convertion(Item block, Item ingot, Item nugget) {
        GameRegistry.addShapelessRecipe(new ResourceLocation(TAIGA.MODID + ":recipe_ingot_from_block_" + block
                .getUnlocalizedName()), new ResourceLocation(""), new ItemStack(ingot, 9), Ingredient.fromStacks(new
                ItemStack(block)));
        GameRegistry.addShapelessRecipe(new ResourceLocation(TAIGA.MODID + ":recipe_ingot_from_nugget_" + block
                .getUnlocalizedName()), new ResourceLocation(""), new ItemStack(nugget, 9), Ingredient.fromStacks(new
                ItemStack(ingot)));
    }
}
