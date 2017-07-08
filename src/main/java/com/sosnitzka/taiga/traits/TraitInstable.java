package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

import java.util.Optional;


public class TraitInstable extends AbstractTrait {
    public TraitInstable() {
        super("instable", TextFormatting.DARK_RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (random.nextFloat() <= 0.03) {
            if (!world.isRemote) {
                if (random.nextBoolean()) {
                    explode(world, player, pos.getX(), pos.getY(), pos.getZ());
                } else explode(world, null, pos.getX(), pos.getY(), pos.getZ());
            }
            ToolHelper.damageTool(tool, random.nextInt(10) + 2, player);
        }
    }

    @Override
    public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean wasCritical, boolean wasHit) {
        BlockPos pos = target.getPosition();
        if (random.nextFloat() <= 0.04) {
            if (!player.getEntityWorld().isRemote) {
                if (random.nextBoolean()) {
                    explode(player.getEntityWorld(), player, pos.getX(), pos.getY(), pos.getZ());
                } else explode(player.getEntityWorld(), target, pos.getX(), pos.getY(), pos.getZ());
            }
            ToolHelper.damageTool(tool, 2 + random.nextInt(10), player);
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (random.nextFloat() < 0.05 && !w.isRemote && event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                ItemStack i = new ItemStack(Items.GUNPOWDER, random.nextInt(2));
                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, i));
            }
        }
    }

    private void explode(World w, Entity e, double x, double y, double z) {
        w.newExplosion(e, x, y, z, 1.2f + random.nextFloat() * 5, random.nextBoolean(), true);
    }

    @Override
    public Optional<RecipeMatch.Match> matches(NonNullList<ItemStack> stacks) {
        return null;
    }
}
