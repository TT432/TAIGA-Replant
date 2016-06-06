package com.sosnitzka.ztic_addon.util.traits;

import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;

/**
 * Created by Robert on 03.06.2016.
 */
public class TraitPulverizing extends AbstractTrait {

    public TraitPulverizing() {
        super("pulverizing", TextFormatting.DARK_GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if (ToolHelper.isToolEffective2(tool, event.getState())) {
            event.setNewSpeed((float) (event.getNewSpeed() + calcBonus(tool)));
        }
    }

    private double calcBonus(ItemStack tool) {
        int durability = ToolHelper.getCurrentDurability(tool);
        int maxDurability = ToolHelper.getMaxDurability(tool);
        float speed = ToolHelper.getMiningSpeedStat(tool);
        return (speed / 3) / (maxDurability - 100) * (durability) + 0.5f;
    }


    @SubscribeEvent
    public void onBlockBreak(HarvestDropsEvent event) {
        event.getDrops().clear();
    }


}
