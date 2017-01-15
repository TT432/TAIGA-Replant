package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitReviving extends AbstractTrait {


    public final float chance = 0.15f;

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
                if (random.nextFloat() <= chance && TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) e.getSource().getEntity()).getHeldItemMainhand()), identifier)) {
                    String name = EntityList.getEntityString(e.getEntity());
                    Entity ent = EntityList.createEntityByName(name, w);
                    if (ent != null) {
                        if (ent instanceof EntitySkeleton && e.getEntity() instanceof EntitySkeleton) {
                            ((EntitySkeleton) ent).setSkeletonType(((EntitySkeleton) e.getEntity()).getSkeletonType());
                        }
                        ent.setPosition(pos.getX(), pos.getY(), pos.getZ());
                        w.spawnEntity(ent);
                        e.getSource().getEntity().playSound(SoundEvents.AMBIENT_CAVE, 1.0F, 1.0F);
                    }
                }
            }
        }
    }
}
