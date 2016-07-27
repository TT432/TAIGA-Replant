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

import static com.sosnitzka.taiga.Items.*;

public class TraitGarishly extends AbstractTrait {

    public TraitGarishly() {
        super("garishly", TextFormatting.YELLOW);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {

                int r = random.nextInt(5);
                ItemStack i = null;
                switch (r) {
                    case 0:
                        i = new ItemStack(Items.BLAZE_POWDER, random.nextInt(3));
                        break;
                    case 1:
                        i = new ItemStack(Items.BLAZE_ROD, random.nextInt(3));
                        break;
                    case 2:
                        i = new ItemStack(glimmerstone_dust, random.nextInt(3));
                        break;
                    case 3:
                        i = new ItemStack(luminar_dust, random.nextInt(3));
                        break;
                    case 4:
                        i = new ItemStack(Items.COAL, random.nextInt(3));
                        break;
                    case 5:
                        i = new ItemStack(lignite, random.nextInt(3));
                        break;
                }

                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, i));
            }
        }
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        float r = random.nextFloat();
        if (r > 0.5f) event.getDrops().clear();
        else if (r < 0.1 && event.getWorld().getBlockState(event.getPos()).getMaterial() == Material.ROCK) {
            @SuppressWarnings("ConstantConditions") ItemStack stack = new ItemStack(Item.getItemFromBlock(event.getWorld().getBlockState(event.getPos()).getBlock()), random.nextInt(3));
            event.getDrops().add(0, stack);
            ToolHelper.damageTool(tool, random.nextInt(6) + 1, event.getHarvester());
        }
    }


}



