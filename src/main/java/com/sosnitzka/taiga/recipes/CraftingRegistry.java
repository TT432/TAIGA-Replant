package com.sosnitzka.taiga.recipes;


import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import static com.sosnitzka.taiga.Blocks.*;
import static com.sosnitzka.taiga.Items.*;
import static slimeknights.tconstruct.shared.TinkerCommons.matNecroticBone;

public class CraftingRegistry {
    public static void register() {
        GameRegistry.addShapelessRecipe(new ItemStack(fuel_brick), Items.COAL, Items.COAL, Items.COAL, lignite, lignite, lignite);

        GameRegistry.addShapelessRecipe(new ItemStack(luminar_dust), Items.REDSTONE, Items.GLOWSTONE_DUST);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerstone_dust), luminar_dust, Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmerstone_dust), Items.REDSTONE, Items.GLOWSTONE_DUST, Items.BLAZE_POWDER);

        GameRegistry.addShapelessRecipe(new ItemStack(glimmercoal), Items.COAL, glimmerstone_dust);
        GameRegistry.addShapelessRecipe(new ItemStack(glimmercoal), lignite, glimmerstone_dust);

        GameRegistry.addShapelessRecipe(new ItemStack(radiant_pearl), Items.ENDER_PEARL, luminar_dust, new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(glimmer_pearl), Items.ENDER_PEARL, glimmerstone_dust);
        GameRegistry.addShapelessRecipe(new ItemStack(energy_pearl), Items.ENDER_PEARL, luminar_dust, Items.GUNPOWDER);

        GameRegistry.addShapelessRecipe(new ItemStack(nitro_brick), fuel_brick, Items.GUNPOWDER, Items.BLAZE_POWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(anthracite_dust), matNecroticBone, Items.COAL, Items.GUNPOWDER);
        GameRegistry.addShapelessRecipe(new ItemStack(spectrum_dust), matNecroticBone, glimmerstone_dust);

        registerMetalRecipes(arcaniteIngot, arcanite_nugget, arcaniteBlock);
        registerMetalRecipes(tiberiumIngot, tiberium_nugget, tiberiumBlock);
        registerMetalRecipes(prometheumIngot, prometheum_nugget, prometheumBlock);
        registerMetalRecipes(rubiumIngot, rubium_nugget, rubiumBlock);
        registerMetalRecipes(violiumIngot, violium_nugget, violiumBlock);
        registerMetalRecipes(bismuthIngot, bismuth_nugget, bismuthBlock);
        registerMetalRecipes(karmesineIngot, karmesine_nugget, karmesineBlock);
        registerMetalRecipes(mindoriteIngot, mindorite_nugget, mindoriteBlock);
        registerMetalRecipes(titaniteIngot, titanite_nugget, titaniteBlock);
        registerMetalRecipes(meteoriteIngot, meteorite_nugget, meteoriteBlock);
        registerMetalRecipes(adamantiteIngot, adamantite_nugget, adamantiteBlock);
        registerMetalRecipes(vibraniumIngot, vibranium_nugget, vibraniumBlock);
        registerMetalRecipes(ignititeIngot, ignitite_nugget, ignititeBlock);
        registerMetalRecipes(palladiumIngot, palladium_nugget, palladiumBlock);
        registerMetalRecipes(eterniteIngot, eternite_nugget, eterniteBlock);
        registerMetalRecipes(mythrilIngot, mythril_nugget, mythrilBlock);
        registerMetalRecipes(imperomiteIngot, imperomite_nugget, imperomiteBlock);
        registerMetalRecipes(fractoryteIngot, fractoryte_nugget, fractoryteBlock);
        registerMetalRecipes(noctunyxIngot, noctunyx_nugget, noctunyxBlock);
        registerMetalRecipes(nitroniteIngot, nitronite_nugget, nitroniteBlock);
        registerMetalRecipes(cryptogenIngot, cryptogen_nugget, cryptogenBlock);
        registerMetalRecipes(seismodiumIngot, seismodium_nugget, seismodiumBlock);
        registerMetalRecipes(aegisaltIngot, aegisalt_nugget, aegisaltBlock);
        registerMetalRecipes(ultraniteIngot, ultranite_nugget, ultraniteBlock);
        registerMetalRecipes(bysmuidIngot, bysmuid_nugget, bysmuidBlock);
        registerMetalRecipes(nucleumIngot, nucleum_nugget, nucleumBlock);
        registerMetalRecipes(lumixylIngot, lumixyl_nugget, lumixylBlock);
        registerMetalRecipes(dyoniteIngot, dyonite_nugget, dyoniteBlock);
        registerMetalRecipes(terramiteIngot, terramite_nugget, terramiteBlock);
        registerMetalRecipes(solariumIngot, solarium_nugget, solariumBlock);
        registerMetalRecipes(astriumIngot, astrium_nugget, astriumBlock);
        registerMetalRecipes(proxideumIngot, proxideum_nugget, proxideumBlock);
    }

    private static void registerMetalRecipes(Item ingot, Item nugget, Block block) {

        GameRegistry.addShapelessRecipe(new ItemStack(nugget, 9), new ItemStack(ingot));
        GameRegistry.addShapelessRecipe(new ItemStack(ingot, 9), new ItemStack(block));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(block), "###", "###", "###", '#', new ItemStack(ingot)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingot), "###", "###", "###", '#', new ItemStack(nugget)));
    }
}
