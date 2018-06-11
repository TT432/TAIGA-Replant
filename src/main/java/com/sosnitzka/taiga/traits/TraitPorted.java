package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;


public class TraitPorted extends AbstractTrait {
    public static int distance = 10;

    public TraitPorted() {
        super("ported", TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onItemRightClick(PlayerInteractEvent.RightClickItem e) {
        ItemStack tool = e.getEntityPlayer().getHeldItemMainhand();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier))
            teleport(e.getEntityPlayer(), e.getWorld());
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase
            player, boolean wasEffective) {
        if (random.nextFloat() <= 0.005) {
            player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            teleport(player, world);
        }
    }


    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean
            wasCritical, boolean wasHit) {
        if (random.nextFloat() <= 0.005) {
            target.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            teleport(player, player.getEntityWorld());
        }
    }

    private void teleport(EntityLivingBase e, World w) {
        BlockPos tPos = new BlockPos(e.getPosition().up(distance));
        if (e.getPosition().getY() >= 128) {
            return;
        }

        while (!w.getBlockState(tPos).equals(Blocks.AIR.getDefaultState()) && tPos.getY() <= 128) {
            tPos = tPos.up();
        }
        if (!w.getBlockState(tPos).equals(Blocks.AIR.getDefaultState())) {
            return;
        }
        e.setPosition(tPos.getX(), tPos.getY(), tPos.getZ());
        ToolHelper.damageTool(e.getHeldItemMainhand(), ToolHelper.getCurrentDurability(e.getHeldItemMainhand()) / 2 +
                1, e);
    }
}
