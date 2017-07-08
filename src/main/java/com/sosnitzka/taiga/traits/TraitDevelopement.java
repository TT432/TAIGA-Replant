package com.sosnitzka.taiga.traits;

import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.Optional;


public class TraitDevelopement extends AbstractTrait {


    public TraitDevelopement() {
        super(TraitDevelopement.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent e) {
        IBlockState state = e.getState();
        ItemStack tool = e.getPlayer().getHeldItemMainhand();
        if (state.getBlock().equals(net.minecraft.init.Blocks.STONE) && TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier))
            System.out.println("State.Variant: " + state.getValue(BlockStone.VARIANT));
    }


    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
