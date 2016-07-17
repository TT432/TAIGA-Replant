package com.sosnitzka.ztic_addon.util;


import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Utils {
    public static String PREFIX_INGOT = "ingot";
    public static String PREFIX_NUGGET = "nugget";
    public static String PREFIX_ORE = "ore";
    public static String PREFIX_BLOCK = "block";


    public static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    public static void registerTinkerAlloys(Fluid alloy, int out, Fluid first, int inOne, Fluid second, int inTwo) {
        NBTTagList tagList = new NBTTagList();
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", alloy.getName());
        fluid.setInteger("Amount", out);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", first.getName());
        fluid.setInteger("Amount", inOne);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", second.getName());
        fluid.setInteger("Amount", inTwo);
        tagList.appendTag(fluid);

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }

    public static void registerTinkerAlloys(Fluid alloy, int out, Fluid first, int inOne, Fluid second, int inTwo, Fluid third, int inThree) {
        NBTTagList tagList = new NBTTagList();
        NBTTagCompound fluid = new NBTTagCompound();
        fluid.setString("FluidName", alloy.getName());
        fluid.setInteger("Amount", out);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", first.getName());
        fluid.setInteger("Amount", inOne);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", second.getName());
        fluid.setInteger("Amount", inTwo);
        tagList.appendTag(fluid);
        fluid = new NBTTagCompound();
        fluid.setString("FluidName", third.getName());
        fluid.setInteger("Amount", inThree);
        tagList.appendTag(fluid);

        NBTTagCompound message = new NBTTagCompound();
        message.setTag("alloy", tagList);
        FMLInterModComms.sendMessage("tconstruct", "alloy", message);
    }
}
