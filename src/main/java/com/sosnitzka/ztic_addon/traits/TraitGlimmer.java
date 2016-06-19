package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitGlimmer extends AbstractTrait {


    public TraitGlimmer() {
        super("glimmer", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onUpdate(ItemStack item, World world, Entity entity, int i, boolean b) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer e = (EntityPlayer) entity;
            if (TinkerUtil.hasTrait(TagUtil.getTagSafe(e.getHeldItemMainhand()), identifier)) {
                e.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 100));

            }
        }

    }
}
