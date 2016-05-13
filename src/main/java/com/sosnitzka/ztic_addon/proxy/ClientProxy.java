package com.sosnitzka.ztic_addon.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import static com.sosnitzka.ztic_addon.Blocks.*;
import static com.sosnitzka.ztic_addon.Items.*;

public class ClientProxy {

    private static void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

    private static void registerItemModel(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public void registerClientStuff() {
        // Items
        registerItemModel(slagironIngot);
        registerItemModel(slaggoldIngot);
        registerItemModel(lignite);
        registerItemModel(iron_nugget);
        registerItemModel(fuel_brick);
        registerItemModel(tiberiumShardInstable);
        registerItemModel(tiberiumShardStable);


        registerItemModel(aardiumIngot);
        registerItemModel(adamantiteIngot);
        registerItemModel(arcaniteIngot);
        registerItemModel(axiidianIngot);
        registerItemModel(bismuthIngot);
        registerItemModel(eterniteIngot);
        registerItemModel(ignititeIngot);
        registerItemModel(karmesineIngot);
        registerItemModel(meteoriteIngot);
        registerItemModel(mindoriteIngot);
        registerItemModel(mythrilIngot);
        registerItemModel(palladiumIngot);
        registerItemModel(tiberiumIngot);
        registerItemModel(vibraniumIngot);
        registerItemModel(yrdeanIngot);

        registerItemModel(astriumIngot);
        registerItemModel(instableDyoniteIngot);
        registerItemModel(instableNitroniteIngot);
        registerItemModel(instablePolyniumIngot);
        registerItemModel(instablePrysociteIngot);
        registerItemModel(imperomiteIngot);
        registerItemModel(cryptogenIngot);
        registerItemModel(proxideumIngot);
        registerItemModel(fractoryteIngot);
        registerItemModel(seismodiumIngot);
        registerItemModel(terramiteIngot);
        registerItemModel(blazingXylititeIngot);
        registerItemModel(radiantPliniumIngot);
        registerItemModel(ultraniteIngot);
        registerItemModel(dysprosaniumIngot);
        registerItemModel(refractiveBysumIngot);

        // Blocks
        registerBlockModel(aardiumOre);
        registerBlockModel(adamantiteOre);
        registerBlockModel(arcaniteOre);
        registerBlockModel(axiidianOre);
        registerBlockModel(basalt);
        registerBlockModel(bismuthOre);
        registerBlockModel(eterniteOre);
        registerBlockModel(ignititeOre);
        registerBlockModel(karmesineOre);
        registerBlockModel(ligniteOre);
        registerBlockModel(meteoriteOre);
        registerBlockModel(mindoriteOre);
        registerBlockModel(mythrilOre);
        registerBlockModel(palladiumOre);
        registerBlockModel(prometheumOre);
        registerBlockModel(rottenGround);
        registerBlockModel(slagironOre);
        registerBlockModel(slaggoldOre);
        registerBlockModel(tiberiumOre);
        registerBlockModel(vibraniumOre);
        registerBlockModel(yrdeanOre);
    }
}
