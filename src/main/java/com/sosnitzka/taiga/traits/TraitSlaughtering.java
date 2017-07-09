package com.sosnitzka.taiga.traits;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;

public class TraitSlaughtering extends AbstractTrait {

    public TraitSlaughtering() {
        super("slaughtering", TextFormatting.DARK_RED);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (!w.isRemote && event.getEntity() instanceof EntityLiving && !(event.getEntity() instanceof EntityPlayer) && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                ItemStack i = event.getDrops().get(random.nextInt(event.getDrops().size())).getItem();
                event.getDrops().add(new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(i.getItem(), random.nextInt(4) + 1, i.getMetadata(), i.getTagCompound())));
            }
        }
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
