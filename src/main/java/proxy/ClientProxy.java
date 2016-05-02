package proxy;

import main.ZCompression;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends ServerProxy {

    @Override
    public void registerClientStuff() {
        // Items
        registerItemModel(ZCompression.slagironIngot);
        registerItemModel(ZCompression.lignite);

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

    private static void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

    private static void registerItemModel(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
