package com.sosnitzka.taiga.traits;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitFragile extends AbstractTrait {

    public TraitFragile() {
        super("fragile", TextFormatting.DARK_GRAY);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (random.nextBoolean()) {
            float f = random.nextFloat();
            float b = 0.99F * calcBonus(tool);
            if (!world.isRemote && tool.canHarvestBlock(state) && f <= b) {
                if (random.nextBoolean()) ToolHelper.damageTool(tool, random.nextInt(3), player);
            }
        } else {
            float f = random.nextFloat();
            float b = 0.99F * calcBonus(tool);
            if (!world.isRemote && state.getBlock() == Blocks.STONE && f <= b) {
                double x, y, z, sx, sy, sz;
                sx = x = pos.getX();
                sy = y = pos.getY();
                sz = z = pos.getZ();
                for (int i = random.nextInt(50) + 50; i > 0; i--) {
                    int r = random.nextInt(3);
                    int d = random.nextBoolean() ? 1 : -1;
                    if (r == 0) x += d;
                    if (r == 1) y += d;
                    if (r == 2) z += d;
                    BlockPos nextBlock = new BlockPos(x, y, z);
                    int tn = (int) world.getWorldTime() + 5;
                    if (world.getBlockState(nextBlock) == world.getBlockState(pos)) {
                        Block block = Blocks.STONE;
                        int ib = random.nextInt(3);
                        switch (ib) {
                            case 0:
                                block = Blocks.COBBLESTONE;
                                break;
                            case 1:
                                block = Blocks.MOSSY_COBBLESTONE;
                                break;
                            case 2:
                                block = Blocks.GRAVEL;
                                break;
                        }
                        f = random.nextFloat();
                        if (f < 0.85) {
                            world.setBlockState(nextBlock, block.getDefaultState());
                        } else if (f > 95) {
                            world.destroyBlock(nextBlock, true);
                        }
                        sx = x = nextBlock.getX();
                        sy = y = nextBlock.getY();
                        sz = z = nextBlock.getZ();
                        if (random.nextBoolean()) ToolHelper.damageTool(tool, 1, player);
                    } else {
                        x = sx;
                        y = sy;
                        z = sz;
                    }

                }

            }

        }
    }


    private float calcBonus(ItemStack tool) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int maxDurability = ToolHelper.getMaxDurability(tool);
        return (0.4f) / (maxDurability - 50) * (durability) + 0.55f;
    }
}
