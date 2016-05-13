package com.sosnitzka.ztic_addon.recipes;


import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.RandomUtils;

import static com.sosnitzka.ztic_addon.Blocks.*;
import static com.sosnitzka.ztic_addon.Items.*;

public class Smelting {

    public static void register() {
        GameRegistry.addSmelting(slagironOre, new ItemStack(slagironIngot), 1.0F);
        GameRegistry.addSmelting(new ItemStack(slagironIngot, 3), new ItemStack(iron_nugget), 0);
        GameRegistry.addSmelting(new ItemStack(slaggoldIngot, 3), new ItemStack(Items.GOLD_NUGGET), 0);
        GameRegistry.addSmelting(new ItemStack(tiberiumShardInstable), new ItemStack(tiberiumShardStable), 0.2F);


        GameRegistry.addSmelting(aardiumOre, new ItemStack(aardiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(arcaniteOre, new ItemStack(arcaniteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(adamantiteOre, new ItemStack(adamantiteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(axiidianOre, new ItemStack(axiidianIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(bismuthOre, new ItemStack(bismuthIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(eterniteOre, new ItemStack(eterniteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(ignititeOre, new ItemStack(ignititeIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(karmesineOre, new ItemStack(karmesineIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(meteoriteOre, new ItemStack(meteoriteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(mindoriteOre, new ItemStack(mindoriteIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(mythrilOre, new ItemStack(mythrilIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(palladiumOre, new ItemStack(palladiumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(prometheumOre, new ItemStack(prometheumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(tiberiumOre, new ItemStack(tiberiumShardStable, 2), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(vibraniumOre, new ItemStack(vibraniumIngot), RandomUtils.nextFloat(0F, 2F));
        GameRegistry.addSmelting(yrdeanOre, new ItemStack(yrdeanIngot), RandomUtils.nextFloat(0F, 2F));

    }
}
