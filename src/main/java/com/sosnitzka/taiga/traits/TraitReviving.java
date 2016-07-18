package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;


/**
 * Created by Robert on 03.06.2016.
 */
public class TraitReviving extends AbstractTrait {

    public TraitReviving() {
        super("reviving", TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityKill(LivingDeathEvent e) {
        BlockPos pos = e.getEntity().getPosition();
        World w = e.getEntity().getEntityWorld();
        if (!w.isRemote && e.getSource().getEntity() != null) {
            if (e.getSource().getEntity() instanceof EntityPlayer && e.getEntity() instanceof EntityCreature) {
                if (isNight((int) w.getWorldTime()) && random.nextFloat() > 0.85 && TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) e.getSource().getEntity()).getHeldItemMainhand()), identifier)) {
                    String name = EntityList.getEntityString(e.getEntity());
                    Entity ent = EntityList.createEntityByName(name, w);
                    ent.setPosition(pos.getX(), pos.getY(), pos.getZ());
                    w.spawnEntityInWorld(ent);
                }
            }
        }
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        int time = (int) world.getWorldTime();
        if (random.nextFloat() <= 0.1 && isNight(time)) {
            ToolHelper.healTool(tool, random.nextInt(15) + 1, null);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        int time = (int) player.getEntityWorld().getWorldTime();
        if (random.nextFloat() <= 0.1 && isNight(time)) {
            ToolHelper.healTool(tool, random.nextInt(15) + 1, null);
        }
    }


    public boolean isNight(int time) {
        if (time > 12500) {
            return true;
        } else {
            return false;
        }
    }
}
