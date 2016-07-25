package com.sosnitzka.taiga.proxy;

import com.sosnitzka.taiga.Blocks;
import com.sosnitzka.taiga.Items;
import com.sosnitzka.taiga.TAIGA;
import com.sosnitzka.taiga.TAIGAConfiguration;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.client.texture.MetalTextureTexture;
import slimeknights.tconstruct.library.materials.Material;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;

import static com.sosnitzka.taiga.MaterialTraits.*;

public class ClientProxy extends CommonProxy {

    private static void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

    private static void registerItemModel(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
    public void registerModels() {
        Field[] itemFields = Items.class.getDeclaredFields();
        for (Field field : itemFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    Item item = (Item) field.get(targetType);
                    registerItemModel(item);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        Field[] blockFields = Blocks.class.getDeclaredFields();
        for (Field field : blockFields) {
            if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
                Class<?> targetType = field.getType();
                try {
                    Block block = (Block) field.get(targetType);
                    registerBlockModel(block);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setRenderInfo(final Material material) {

        if (material.equals(adamantite)) specialRender(material, 0xd55cdf, 0.5f, 0.6f, 0.2f);
        else if (material.equals(solarium)) specialRender(material, 0xFFDD11, 0.7f, 0.3f, 0.1f);
        else if (material.equals(proxideum)) specialRender(material, 0x2d8f8b, 0.4f, 0.3f, 0.1f);
        else if (material.equals(meteorite)) specialRender(material, 0xaaaaaa, 0.6f, 0.8f, 0.0f);
        else if (material.equals(tiberium)) specialRender(material, 0x33ff33, 0.5f, 0.2f, 0.1f);
        else if (material.equals(bismuth)) specialRender(material, 0xffffff, 0.3f, 0.0f, 0.0f);
        else if (material.equals(bysmuid)) specialRender(material, 0xccccee, 0.6f, 0.2f, 0.0f);
        else if (material.equals(imperomite)) specialRender(material, 0x8decaf, 0.8f, 0.5f, -0.0f);
        else if (material.equals(noctunyx)) specialRender(material, 0xce70e8, 0.5f, 0.2f, 0.3f);
        else if (material.equals(nucleum)) specialRender(material, 0xd9f446, 1.0f, 0.4f, 0.3f);
        else if (material.equals(dyonite)) specialRender(material, 0xffe240, 0.6f, 1.0f, 0.2f);
        else if (material.equals(arcanite)) specialRender(material, 0x5e5499, 0.6f, 0.8f, 0.2f);
        else {
            material.setRenderInfo(new MaterialRenderInfo.BlockTexture("taiga:blocks/" + material.getIdentifier() + "_block"));
        }
    }

    private void specialRender(final Material material, final int f, final float shine, final float brightness, final float hueshift) {
        material.setRenderInfo(new MaterialRenderInfo.AbstractMaterialRenderInfo() {
            @Override
            public TextureAtlasSprite getTexture(TextureAtlasSprite baseTexture, String location) {
                return new MetalTextureTexture("taiga:blocks/materials/" + material.getIdentifier(), baseTexture, location, f, shine, brightness, hueshift);
            }
        });
    }

    @Override
    public void registerFluidModels(Fluid fluid) {
        if (fluid == null) {
            return;
        }

        Block block = fluid.getBlock();
        if (block != null) {
            Item item = Item.getItemFromBlock(block);
            FluidStateMapper mapper = new FluidStateMapper(fluid);

            // item-model
            if (item != null) {
                ModelLoader.registerItemVariants(item);
                ModelLoader.setCustomMeshDefinition(item, mapper);
            }
            // block-model
            ModelLoader.setCustomStateMapper(block, mapper);
        }
    }

    @Override
    public void initConfig() {
        TAIGAConfiguration.clientPreInit();
    }

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition {

        public final Fluid fluid;
        public final ModelResourceLocation location;

        public FluidStateMapper(Fluid fluid) {
            this.fluid = fluid;

            // have each block hold its fluid per nbt? hm
            this.location = new ModelResourceLocation(new ResourceLocation(TAIGA.MODID, "fluid_block"), fluid.getName());
        }

        @Nonnull
        @Override
        protected ModelResourceLocation getModelResourceLocation(@Nonnull IBlockState state) {
            return location;
        }

        @Nonnull
        @Override
        public ModelResourceLocation getModelLocation(@Nonnull ItemStack stack) {
            return location;
        }
    }
}
