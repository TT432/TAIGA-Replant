package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import static com.sosnitzka.taiga.util.Utils.isNight;

public class TraitHollow extends AbstractTrait {

    public TraitHollow() {
        super("hollow", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        int time = (int) player.getEntityWorld().getWorldTime();
        if (random.nextFloat() <= 0.2 || (random.nextFloat() <= 0.2 && isNight(time))) {
            ((EntityLiving) target).setNoAI(true);
            target.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            if (target.getMaxHealth() < 200) {
                target.setHealth(target.getMaxHealth() * (1.8f - random.nextFloat() * 0.4f));
            }
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (random.nextFloat() <= 0.9 && event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                event.getDrops().clear();
            }
        }
    }
}
