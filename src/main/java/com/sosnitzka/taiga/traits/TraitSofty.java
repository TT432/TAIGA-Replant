package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

public class TraitSofty extends AbstractTrait {

    private static final float chance = 0.1f;
    private static final float speedmulti = 1.3f;

    public TraitSofty() {
        super("softy", TextFormatting.GRAY);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void blockbreak(BlockEvent.BreakEvent e) {
        float r = random.nextFloat();
        float hardness = e.getWorld().getBlockState(e.getPos()).getBlockHardness(e.getWorld(), e.getPos());
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(e.getPlayer().getHeldItemMainhand()), identifier)) {
            if (!e.getWorld().isRemote && r <= chance && hardness >= 1.0f) {
                e.setCanceled(true);
                ToolHelper.damageTool(e.getPlayer().getHeldItemMainhand(), random.nextInt(3) + 1, e.getPlayer());
            }
        }
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        World w = event.getEntity().getEntityWorld();
        IBlockState state = w.getBlockState(event.getPos());
        float speed = event.getOriginalSpeed();
        if (!w.isRemote) {
            if (state.getBlockHardness(w, event.getPos()) <= 1.0f) {
                event.setNewSpeed(speed * speedmulti);
            }
        }
    }
}



