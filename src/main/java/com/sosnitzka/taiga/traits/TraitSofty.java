package com.sosnitzka.taiga.traits;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSofty extends AbstractTrait {
    private static final float chance = 0.2f;

    public TraitSofty() {
        super("softy", TextFormatting.AQUA);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (!world.isRemote && state.getMaterial().equals(Material.GROUND) && random.nextFloat() < chance) {
            ToolHelper.healTool(tool, random.nextInt(10), player);
        }
    }
}



