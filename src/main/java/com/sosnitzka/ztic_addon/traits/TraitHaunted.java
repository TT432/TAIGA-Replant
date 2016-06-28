package com.sosnitzka.ztic_addon.traits;

import com.sosnitzka.ztic_addon.util.EntityPanic;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.traits.AbstractTrait;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitHaunted extends AbstractTrait {

    public TraitHaunted() {
        super("haunted", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        if (target instanceof EntityLiving) {
            //((EntityLiving) target).tasks.addTask(0, new EntityAIAvoidEntity((EntityCreature) target, EntityPlayer.class,16f, 2.0d, 2.4D));
            ((EntityLiving) target).tasks.addTask(0, new EntityPanic((EntityCreature) target, 2.0D));
        }
    }




    /*@SubscribeEvent
    public void onDamage(LivingAttackEvent e){
        System.out.println(e.getEntity() + " " + e.getSource());
    }*/

}
