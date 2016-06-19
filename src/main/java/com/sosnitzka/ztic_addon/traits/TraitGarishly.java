package com.sosnitzka.ztic_addon.traits;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

import static com.sosnitzka.ztic_addon.Items.*;

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
        if (event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (!w.isRemote && event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {

                int r = random.nextInt(5);
                ItemStack i = null;
                switch (r) {
                    case 0:
                        i = new ItemStack(Items.BLAZE_POWDER, random.nextInt(3) + 1);
                        break;
                    case 1:
                        i = new ItemStack(Items.BLAZE_ROD, random.nextInt(2) + 1);
                        break;
                    case 2:
                        i = new ItemStack(glimmerstone_dust, random.nextInt(3));
                        break;
                    case 3:
                        i = new ItemStack(luminar_dust, random.nextInt(3));
                        break;
                    case 4:
                        i = new ItemStack(Items.COAL, random.nextInt(3) + 1);
                        break;
                    case 5:
                        i = new ItemStack(lignite, random.nextInt(3) + 1);
                        break;
                }

                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, i));
            }
        }
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        int i = random.nextInt(10);
        if (i == 9) event.getDrops().clear();
        else if (i == 1 || i == 2 || i == 3) {
            ItemStack stack = new ItemStack(Item.getItemFromBlock(event.getWorld().getBlockState(event.getPos()).getBlock()), i);
            event.getDrops().add(0, stack);
            ToolHelper.damageTool(tool, i * 2, event.getHarvester());
        } else if (i == 0 && random.nextBoolean())
            event.getWorld().setBlockState(event.getPos(), Blocks.LAVA.getDefaultState());
    }


}



