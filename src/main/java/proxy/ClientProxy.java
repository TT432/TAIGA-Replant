package proxy;

import main.ZCompression;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import static main.ZCompression.*;

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

        registerItemModel(astriteIngot);
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
        registerBlockModel(ZCompression.aardiumOre);
        registerBlockModel(ZCompression.adamantiteOre);
        registerBlockModel(ZCompression.arcaniteOre);
        registerBlockModel(ZCompression.axiidianOre);
        registerBlockModel(ZCompression.basalt);
        registerBlockModel(ZCompression.bismuthOre);
        registerBlockModel(ZCompression.eterniteOre);
        registerBlockModel(ZCompression.ignititeOre);
        registerBlockModel(ZCompression.karmesineOre);
        registerBlockModel(ZCompression.ligniteOre);
        registerBlockModel(ZCompression.meteoriteOre);
        registerBlockModel(ZCompression.mindoriteOre);
        registerBlockModel(ZCompression.mythrilOre);
        registerBlockModel(ZCompression.palladiumOre);
        registerBlockModel(ZCompression.prometheumOre);
        registerBlockModel(ZCompression.rottenGround);
        registerBlockModel(ZCompression.slagironOre);
        registerBlockModel(ZCompression.slaggoldOre);
        registerBlockModel(ZCompression.tiberiumOre);
        registerBlockModel(ZCompression.vibraniumOre);
        registerBlockModel(ZCompression.yrdeanOre);
    }
}
