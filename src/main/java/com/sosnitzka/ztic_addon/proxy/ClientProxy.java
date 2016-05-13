package com.sosnitzka.ztic_addon.proxy;

import com.sosnitzka.ztic_addon.main.ZTiC;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import static com.sosnitzka.ztic_addon.main.ZTiC.*;

public class ClientProxy extends ServerProxy {

    private static void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

    private static void registerItemModel(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
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
        registerBlockModel(ZTiC.aardiumOre);
        registerBlockModel(ZTiC.adamantiteOre);
        registerBlockModel(ZTiC.arcaniteOre);
        registerBlockModel(ZTiC.axiidianOre);
        registerBlockModel(ZTiC.basalt);
        registerBlockModel(ZTiC.bismuthOre);
        registerBlockModel(ZTiC.eterniteOre);
        registerBlockModel(ZTiC.ignititeOre);
        registerBlockModel(ZTiC.karmesineOre);
        registerBlockModel(ZTiC.ligniteOre);
        registerBlockModel(ZTiC.meteoriteOre);
        registerBlockModel(ZTiC.mindoriteOre);
        registerBlockModel(ZTiC.mythrilOre);
        registerBlockModel(ZTiC.palladiumOre);
        registerBlockModel(ZTiC.prometheumOre);
        registerBlockModel(ZTiC.rottenGround);
        registerBlockModel(ZTiC.slagironOre);
        registerBlockModel(ZTiC.slaggoldOre);
        registerBlockModel(ZTiC.tiberiumOre);
        registerBlockModel(ZTiC.vibraniumOre);
        registerBlockModel(ZTiC.yrdeanOre);
    }
}
