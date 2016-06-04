package com.sosnitzka.ztic_addon.util.traits;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitGarishly extends AbstractTrait {

    public TraitGarishly() {
        super("garishly", TextFormatting.YELLOW);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getEntity() instanceof EntityMob) {
            event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(Items.BLAZE_POWDER, random.nextInt(3) + 1)));
        }
    }


}



