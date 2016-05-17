package com.sosnitzka.ztic_addon.proxy;

import com.sosnitzka.ztic_addon.Blocks;
import com.sosnitzka.ztic_addon.Items;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import slimeknights.tconstruct.library.materials.Material;

import java.lang.reflect.Field;

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

    public void setRenderInfo(Material material, Fluid fluid) {
        material.setRenderInfo(fluid.getColor());
    }
}
