package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;


public class TraitCurvature extends AbstractTrait {


    public TraitCurvature() {
        super("curvature", TextFormatting.BLACK);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (random.nextFloat() <= 0.05 && world.provider.getDimension() != -1) {
            teleport(player, world);
            player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        World w = player.getEntityWorld();
        if (random.nextFloat() <= 0.1 && w.provider.getDimension() != -1) {
            if (random.nextBoolean()) {
                teleport(player, w);
                target.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            } else {
                target.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                teleport(target, w);
            }
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (!w.isRemote && event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                ItemStack i = new ItemStack(Items.ENDER_PEARL, random.nextInt(3));
                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, i));
            }
        }
    }

    private void teleport(EntityLivingBase e, World w) {
        int x = e.getPosition().getX() + random.nextInt(250) - 125;
        int y = e.getPosition().getY();
        int z = e.getPosition().getZ() + random.nextInt(250) - 125;
        while (w.getBlockState(new BlockPos(x, y, z)).getBlock() != Blocks.AIR) {
            y++;
        }
        while (w.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.AIR) {
            y--;
        }

        e.setPosition(x, y, z);
    }

}
