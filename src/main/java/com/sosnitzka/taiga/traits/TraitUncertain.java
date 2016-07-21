package com.sosnitzka.taiga.traits;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
import slimeknights.tconstruct.library.utils.ToolHelper;

import static com.sosnitzka.taiga.Items.glimmerstone_dust;
import static com.sosnitzka.taiga.Items.tiberiumShardStable;


public class TraitUncertain extends AbstractTrait {


    public TraitUncertain() {
        super("uncertain", TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void afterBlockBreak(ItemStack tool, World world, IBlockState state, BlockPos pos, EntityLivingBase player, boolean wasEffective) {
        if (random.nextFloat() <= 0.05) {
            if (!world.isRemote) {
                if (random.nextFloat() > 0.1f) {
                    explode(world, player, pos.getX(), pos.getY(), pos.getZ());
                } else explode(world, null, pos.getX(), pos.getY(), pos.getZ());
            }
            ToolHelper.damageTool(tool, random.nextInt(5) + 1, null);
        }
    }

    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
        World w = event.getEntity().getEntityWorld();
        if (!w.isRemote && event.getSource().getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if (event.getEntity() instanceof EntityMob && TinkerUtil.hasTrait(TagUtil.getTagSafe(player.getHeldItemMainhand()), identifier)) {
                ItemStack i = new ItemStack(Items.COAL, random.nextInt(4));
                if (random.nextBoolean()) {
                    int r = random.nextInt(4);
                    switch (r) {
                        case 0:
                            i = new ItemStack(Items.GUNPOWDER, random.nextInt(4));
                            break;
                        case 1:
                            i = new ItemStack(tiberiumShardStable, random.nextInt(4));
                            break;
                        case 2:
                            i = new ItemStack(tiberiumShardStable, random.nextInt(4));
                            break;
                        case 3:
                            i = new ItemStack(glimmerstone_dust, random.nextInt(4));
                            break;
                    }
                }
                event.getDrops().add(0, new EntityItem(w, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, i));
            }
        }
    }

    private void explode(World w, Entity e, double x, double y, double z) {
        w.newExplosion(e, x, y, z, 1.2f + random.nextFloat() * 5, random.nextBoolean(), true);
    }
}
