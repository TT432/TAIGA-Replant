package com.sosnitzka.ztic_addon.proxy;

import com.sosnitzka.ztic_addon.Blocks;
import com.sosnitzka.ztic_addon.Items;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.client.MaterialRenderInfo;
import slimeknights.tconstruct.library.client.texture.MetalTextureTexture;
import slimeknights.tconstruct.library.materials.Material;

import java.lang.reflect.Field;

import static com.sosnitzka.ztic_addon.Materials.*;

public class ClientProxy extends ServerProxy {

    private static void registerBlockModel(Block block) {
        registerItemModel(Item.getItemFromBlock(block));
    }

    private static void registerItemModel(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    @Override
    public void registerStuff() {
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

    public void setRenderInfo(final Material material, Fluid fluid) {
        /* if (material != bismuth) {
            material.setRenderInfo(new MaterialRenderInfo.Metal(fluid.getColor(), 0.4f, 0.2f, 0f));
        }  else bismuth.setRenderInfo(new MaterialRenderInfo.BlockTexture("ztic_addon:blocks/bismuth_block")); */

        if (material == adamantite) renderTo(material, 0xd55cdf, 0.5f, 0.8f, 0.2f);
        else if (material == solarium) renderTo(material, 0xffff00, 0.6f, 1.8f, 0.0f);
        else if (material == proxideum) renderTo(material, 0x2d8f8b, 0.4f, 0.3f, 0.1f);
        else if (material == tiberium) renderTo(material, 0x33ff33, 0.5f, 0.2f, 0.1f);
        else if (material == bismuth) renderTo(material, 0xffffff, 0.4f, 0.2f, 0.0f);
        else if (material == dyonite) renderTo(material, 0xffe240, 0.6f, 0.8f, 0.2f);
        else {
            material.setRenderInfo(new MaterialRenderInfo.BlockTexture("ztic_addon:blocks/" + material.getFluid().getName() + "_block"));
        }
    }

    private void renderTo(Material material, final int f, final float shine, final float brightness, final float hueshift) {
        material.setRenderInfo(new MaterialRenderInfo.AbstractMaterialRenderInfo() {
            @Override
            public TextureAtlasSprite getTexture(TextureAtlasSprite baseTexture, String location) {
                return new MetalTextureTexture("ztic_addon:blocks/materials/adamantite", baseTexture, location, f, shine, brightness, hueshift);
            }
        });
    }
}
