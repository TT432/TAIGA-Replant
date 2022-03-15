package com.sosnitzka.taiga.traits;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitGarishly extends AbstractTrait {

    public TraitGarishly() {
        super("garishly", TextFormatting.YELLOW);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player
                    .getHeldItemMainhand()), identifier)) {

                int r = random.nextInt(2);
                ItemStack i;
                switch (r) {
                    case 0:
                        i = new ItemStack(Items.BLAZE_POWDER, random.nextInt(3));
                        break;
                    case 1:
                        i = new ItemStack(Items.BLAZE_ROD, random.nextInt(3));
                        break;
                    case 2:
                        i = new ItemStack(Items.COAL, random.nextInt(3));
                        break;
                    default: i = new ItemStack(Items.AIR);
                }
                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event
                        .getEntity().posZ, i));
            }
        }
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        float r = random.nextFloat();
        if (random.nextBoolean()) event.getDrops().clear();
        else if (r < 0.25 && event.getWorld().getBlockState(event.getPos()).getMaterial() == Material.ROCK) {
            @SuppressWarnings("ConstantConditions") ItemStack stack = new ItemStack(Item.getItemFromBlock(event
                    .getWorld().getBlockState(event.getPos()).getBlock()), random.nextInt(3));
            event.getDrops().add(0, stack);
            ToolHelper.damageTool(tool, random.nextInt(6) + 1, event.getHarvester());
        }
    }
}



