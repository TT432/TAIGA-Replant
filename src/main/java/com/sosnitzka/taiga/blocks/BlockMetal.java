package com.sosnitzka.taiga.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.mantle.block.EnumBlock;

import java.util.Locale;

public class BlockMetal extends EnumBlock<BlockMetal.MetalTypes> {

    public static final PropertyEnum<MetalTypes> TYPE = PropertyEnum.create("type", MetalTypes.class);

    public BlockMetal() {
        super(Material.IRON, TYPE, MetalTypes.class);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        for (MetalTypes type : MetalTypes.values()) {
            list.add(new ItemStack(this, 1, type.getMeta()));
        }
    }

    public enum MetalTypes implements IStringSerializable, EnumBlock.IEnumMeta {
        TIBERIUM,
        AURODIUM,
        PROMETHEUM,
        ARCANITE,
        TITANITE,
        MYTHRIL,
        URU,
        VIBRANIUM,
        ETERNITE,
        FRACTORYTE,
        PALLADIUM,
        IGNITITE,
        BISMUTH,
        JAUXITE,
        VIOLIUM,
        KARMESINE;

        public final int meta;

        MetalTypes() {
            meta = ordinal();
        }

        @Override
        public String getName() {
            return this.toString().toLowerCase(Locale.US);
        }

        @Override
        public int getMeta() {
            return meta;
        }

    }


}
