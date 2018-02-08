package com.sosnitzka.taiga.traits;

import com.google.common.collect.Lists;
import com.sosnitzka.taiga.util.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;

import java.util.List;
import java.util.Optional;


public class TraitCurvature extends AbstractTrait {
    public static int chance = 5;
    public static int distance = 10;

    public TraitCurvature() {
        super("curvature", TextFormatting.DARK_PURPLE);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        if (!event.getWorld().isRemote && random.nextFloat() < 0.05) {
            List<IBlockState> blockstates = Lists.newArrayList(Blocks.STONE.getDefaultState(), Blocks.NETHERRACK
                    .getDefaultState(), Blocks.END_STONE.getDefaultState(), Blocks.AIR.getDefaultState(), Blocks.DIRT
                    .getDefaultState());
            IBlockState mainstate = event.getState();
            if (blockstates.contains(mainstate)) return;
            for (int i = 0; i < chance; i++) {
                int x = event.getPos().getX() + Utils.nextInt(random, -distance, distance);
                int y = event.getPos().getY() + Utils.nextInt(random, -distance, distance);
                int z = event.getPos().getZ() + Utils.nextInt(random, -distance, distance);
                BlockPos cPos = new BlockPos(x, y, z);
                IBlockState state = event.getWorld().getBlockState(cPos);
                if (blockstates.contains(state)) {
                    event.getDrops().clear();
                    event.getWorld().setBlockState(cPos, mainstate);
                    event.getHarvester().playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                    event.getHarvester().sendStatusMessage(new TextComponentString("Teleported to: " + x + " " + y +
                            " " + z), false);
                    return;
                }
            }
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean
            wasCritical, boolean wasHit) {
        if (random.nextFloat() <= 0.15) {
            target.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            changePos(player, target);
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player
                    .getHeldItemMainhand()), identifier)) {
                ItemStack i = new ItemStack(Items.ENDER_PEARL, random.nextInt(2));
                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event
                        .getEntity().posZ, i));
            }
        }
    }

    private void changePos(EntityLivingBase player, EntityLivingBase target) {
        BlockPos pp = new BlockPos(player.getPosition());
        BlockPos tp = new BlockPos(target.getPosition());
        player.setPosition(tp.getX(), tp.getY(), tp.getZ());
        target.setPosition(pp.getX(), pp.getY(), pp.getZ());
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
