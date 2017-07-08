package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Optional;

import static com.sosnitzka.taiga.util.Utils.isNight;

public class TraitArcane extends AbstractTrait {

    public TraitArcane() {
        super("arcane", TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        int time = (int) world.getWorldTime();
        if (random.nextFloat() <= 0.05 && isNight(time)) {
            ToolHelper.healTool(tool, random.nextInt(8) + 1, null);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        int time = (int) player.getEntityWorld().getWorldTime();
        if (random.nextFloat() <= 0.05 && isNight(time)) {
            ToolHelper.healTool(tool, random.nextInt(8) + 1, null);
        }
    }


    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent e) {
        World w = e.getEntity().getEntityWorld();
        if (!w.isRemote && e.getSource().getTrueSource() != null) {
            if (e.getSource().getTrueSource() instanceof EntityPlayer && e.getEntity() instanceof EntityCreature) {
                ItemStack tool = ((EntityPlayer) e.getSource().getTrueSource()).getHeldItemMainhand();
                if (isNight((int) w.getWorldTime()) && random.nextFloat() < 0.1 && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
                    ToolHelper.healTool(tool, random.nextInt(16), null);
                }
            }
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
