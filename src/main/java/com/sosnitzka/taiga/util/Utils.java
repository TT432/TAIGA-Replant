package com.sosnitzka.taiga.util;


import com.sosnitzka.taiga.Items;
import com.sosnitzka.taiga.TAIGA;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.lang3.StringUtils;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.Random;

import static com.sosnitzka.taiga.TAIGA.proxy;

public class Utils {
    public static String PREFIX_INGOT = "ingot";
    public static String PREFIX_NUGGET = "nugget";
    public static String PREFIX_ORE = "ore";
    public static String PREFIX_BLOCK = "block";
    public static String PREFIX_DUST = "dust";
    public static String PREFIX_CRYSTAL = "crystal";

    /**
     * Registers the block and its corresponding item (block as item in inventory)
     *
     * @param block the associated block
     */
    public static void registerBlockWithItem(Block block) {
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    /**
     * Registers the fluid and its bucket item
     *
     * @param fluid the fluid
     */
    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }


    public static void registerTinkerAlloy(FluidStack output, FluidStack... inputs) {
        if (inputs.length >= 2 && output != null) {
            TinkerRegistry.registerAlloy(output, inputs);
        }
    }

    public static boolean isNight(int time) {
        return time > 12500;
    }

    public static double round2(double d) {
        return (Math.round(d * 100.0) / 100.0);
    }

    public static void integrateMaterial(String oreSuffix, @Nullable Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, float draw, float range, int bdamage) {
        integrateMaterial(oreSuffix, material, fluid, headDura, headSpeed, headAttack, handleMod, handleDura, extra, headLevel, new BowMaterialStats(draw, range, bdamage), false, true);
    }

    public static void integrateMaterial(String oreSuffix, @Nullable Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, BowMaterialStats bowstats) {
        integrateMaterial(oreSuffix, material, fluid, headDura, headSpeed, headAttack, handleMod, handleDura, extra, headLevel, bowstats, false, true);
    }

    public static void integrateMaterial(String oreSuffix, @Nullable Material material, Fluid fluid, int headDura, float headSpeed, float headAttack, float handleMod, int handleDura, int extra, int headLevel, BowMaterialStats bowstats, boolean craft, boolean cast) {
        if (material != null) {
            if (TinkerRegistry.getMaterial(material.identifier) != Material.UNKNOWN)
                return;

            TinkerRegistry.addMaterialStats(material, new HeadMaterialStats(headDura, headSpeed, headAttack, headLevel));
            TinkerRegistry.addMaterialStats(material, new HandleMaterialStats(handleMod, handleDura));
            TinkerRegistry.addMaterialStats(material, new ExtraMaterialStats(extra));
            TinkerRegistry.addMaterialStats(material, bowstats);

            Item item = null;
            Field[] items = Items.class.getDeclaredFields();
            for (Field i : items) {
                if (i.getName().equals(StringUtils.uncapitalize(oreSuffix) + "Ingot")) {
                    Item r = null;
                    try {
                        r = (Item) i.get(i.getType());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    item = r;
                }
            }

            material.setFluid(fluid).setCraftable(craft).setCastable(cast).addItem(item, 1, Material.VALUE_Ingot);
            material.setRepresentativeItem(item);
            proxy.setRenderInfo(material);
        }

        MaterialIntegration integration = new MaterialIntegration(material, fluid, oreSuffix);
        integration.integrate();
        TAIGA.integrateList.add(integration);
    }

    public static void integrateOre(String oreSuffix, Fluid fluid) {
        integrateMaterial(oreSuffix, null, fluid, -1, -1, -1, -1, -1, -1, -1, new BowMaterialStats(0.1f, 0.1f, -1f), true, true);
    }

    public static int nextInt(Random random, int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static class GeneralNBTData {

        public int killcount;
        public float health;
        public int brokenblocks;
        public float bonus;
        public int curse;
        public String name;
        public float radius;
        public float dfloat;
        public int dint;
        public boolean active;

        public static GeneralNBTData read(NBTTagCompound tag) {
            GeneralNBTData data = new GeneralNBTData();
            data.killcount = tag.getInteger("killcount");
            data.brokenblocks = tag.getInteger("brokenblocks");
            data.health = tag.getFloat("health");
            data.bonus = tag.getFloat("bonus");
            data.curse = tag.getInteger("curse");
            data.name = tag.getString("name");
            data.radius = tag.getFloat("radius");
            data.dfloat = tag.getFloat("dfloat");
            data.dint = tag.getInteger("dint");
            data.active = tag.getBoolean("active");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setInteger("killcount", killcount);
            tag.setInteger("brokenblocks", brokenblocks);
            tag.setFloat("health", health);
            tag.setFloat("bonus", bonus);
            tag.setInteger("curse", curse);
            tag.setString("name", name);
            tag.setFloat("radius", radius);
            tag.setInteger("dint", dint);
            tag.setFloat("dfloat", dfloat);
            tag.setBoolean("active", active);
        }
    }
}
