package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
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

import java.util.Optional;


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
        if (!w.isRemote && e.getSource().getTrueSource() != null) {
            if (e.getSource().getTrueSource() instanceof EntityPlayer && e.getEntity() instanceof EntityCreature) {
                if (random.nextFloat() <= chance && TinkerUtil.hasTrait(TagUtil.getTagSafe(((EntityPlayer) e
                        .getSource().getTrueSource()).getHeldItemMainhand()), identifier)) {
                    int id = e.getEntity().getEntityId();
                    Entity ent = EntityList.createEntityByID(id, w);
                    if (ent != null) {
                        ent.setPosition(pos.getX(), pos.getY(), pos.getZ());
                        w.spawnEntity(ent);
                        e.getSource().getTrueSource().playSound(SoundEvents.AMBIENT_CAVE, 1.0F, 1.0F);
                    }
                }
            }
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
