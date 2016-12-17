package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitFracture extends AbstractTrait {

    public TraitFracture() {
        super("fracture", TextFormatting.DARK_GRAY);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        float f = random.nextFloat();
        float b = 0.99F * calcBonus(tool);
        if (!world.isRemote && tool.canHarvestBlock(state) && f <= b) {
            RayTraceResult mop = ((ToolCore) tool.getItem()).rayTrace(world, (EntityPlayer) player, false);
            if (mop != null) {
                for (int i = random.nextInt(9) + 1; i >= 0; i--) {
                    switch (mop.sideHit) {
                        case UP:
                            BlockPos next1 = new BlockPos(pos.getX(), pos.getY() - i, pos.getZ());
                            if (tool.canHarvestBlock(world.getBlockState(next1)) && !world.getBlockState(next1).equals(Blocks.BEDROCK.getDefaultState()))
                                world.destroyBlock(next1, true);
                            break;
                        case DOWN:
                            BlockPos next2 = new BlockPos(pos.getX(), pos.getY() + i, pos.getZ());
                            if (tool.canHarvestBlock(world.getBlockState(next2)) && !world.getBlockState(next2).equals(Blocks.BEDROCK.getDefaultState()))
                                world.destroyBlock(next2, true);
                            break;
                        case WEST:
                            BlockPos next3 = new BlockPos(pos.getX() + i, pos.getY(), pos.getZ());
                            if (tool.canHarvestBlock(world.getBlockState(next3)) && !world.getBlockState(next3).equals(Blocks.BEDROCK.getDefaultState()))
                                world.destroyBlock(next3, true);
                            break;
                        case EAST:
                            BlockPos next4 = new BlockPos(pos.getX() - i, pos.getY(), pos.getZ());
                            if (tool.canHarvestBlock(world.getBlockState(next4)) && !world.getBlockState(next4).equals(Blocks.BEDROCK.getDefaultState()))
                                world.destroyBlock(next4, true);
                            break;
                        case SOUTH:
                            BlockPos next5 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - i);
                            if (tool.canHarvestBlock(world.getBlockState(next5)) && !world.getBlockState(next5).equals(Blocks.BEDROCK.getDefaultState()))
                                world.destroyBlock(next5, true);
                            break;
                        case NORTH:
                            BlockPos next6 = new BlockPos(pos.getX(), pos.getY() - i, pos.getZ() + i);
                            if (tool.canHarvestBlock(world.getBlockState(next6)) && !world.getBlockState(next6).equals(Blocks.BEDROCK.getDefaultState()))
                                world.destroyBlock(next6, true);
                            break;
                    }
                }
                if (random.nextBoolean()) ToolHelper.damageTool(tool, random.nextInt(5), player);
            }
        }
    }

    private float calcBonus(ItemStack tool) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int maxDurability = ToolHelper.getMaxDurability(tool);
        return (0.4f) / (maxDurability - 50) * (durability) + 0.55f;
    }
}
