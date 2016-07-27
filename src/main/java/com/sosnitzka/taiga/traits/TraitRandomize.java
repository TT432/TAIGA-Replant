package com.sosnitzka.taiga.traits;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.world.entity.EntityBlueSlime;

import static com.sosnitzka.taiga.Blocks.*;
import static slimeknights.tconstruct.shared.TinkerCommons.oreArdite;
import static slimeknights.tconstruct.shared.TinkerCommons.oreCobalt;

public class TraitRandomize extends AbstractTrait {

    public TraitRandomize() {
        super("randomize", TextFormatting.DARK_RED);
    }

    @Override
    public void miningSpeed(ItemStack tool, PlayerEvent.BreakSpeed event) {
        if (ToolHelper.isToolEffective2(tool, event.getState())) {
            event.setNewSpeed(event.getNewSpeed() + random.nextFloat() * 2);
        }
    }

    @Override
    public void onHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damage, boolean isCritical) {
        if (random.nextFloat() <= .15 && target instanceof EntityLiving) {
            World w = player.getEntityWorld();
            Entity e = new EntityCow(w);
            target.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
            if (!w.isRemote) {
                int i = random.nextInt(22);
                switch (i) {
                    case 0:
                        e = new EntityCow(w);
                        break;
                    case 1:
                        e = new EntityPig(w);
                        break;
                    case 2:
                        e = new EntityHorse(w);
                        break;
                    case 3:
                        e = new EntityChicken(w);
                        break;
                    case 4:
                        e = new EntityVillager(w);
                        break;
                    case 5:
                        e = new EntityEnderman(w);
                        break;
                    case 6:
                        e = new EntityPolarBear(w);
                        break;
                    case 7:
                        e = new EntityIronGolem(w);
                        break;
                    case 8:
                        e = new EntitySilverfish(w);
                        break;
                    case 9:
                        e = new EntityCaveSpider(w);
                        break;
                    case 10:
                        e = new EntityWolf(w);
                        break;
                    case 11:
                        e = new EntityWitch(w);
                        break;
                    case 12:
                        e = new EntityTNTPrimed(w);
                        break;
                    case 13:
                        e = new EntityGhast(w);
                        break;
                    case 14:
                        e = new EntitySpider(w);
                        break;
                    case 15:
                        e = new EntitySkeleton(w);
                        break;
                    case 16:
                        e = new EntityMagmaCube(w);
                        break;
                    case 17:
                        e = new EntitySlime(w);
                        break;
                    case 18:
                        e = new EntityBlueSlime(w);
                        break;
                    case 19:
                        e = new EntityBat(w);
                        break;
                    case 20:
                        e = new EntityPigZombie(w);
                        break;
                    case 21:
                        e = new EntityBlaze(w);
                        break;
                }
                e.setPosition(target.getPosition().getX(), target.getPosition().getY() + 0.1f, target.getPosition().getZ());
                e.setCustomNameTag("Missingno");
                if (e instanceof EntityLiving)
                    ((EntityLiving) e).setHealth(((EntityLiving) e).getHealth() * (random.nextInt(5) + 1));
                w.spawnEntityInWorld(e);
                target.setDead();
            }
        }
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void blockHarvestDrops(ItemStack tool, BlockEvent.HarvestDropsEvent event) {
        float r = random.nextFloat();
        if (r > 0.95f) event.getDrops().clear();
        if (event.getDrops() != null) {
            if (r < 0.4f && (event.getDrops().get(0).getItem() == Item.getItemFromBlock(Blocks.IRON_ORE) || event.getDrops().get(0).getItem() == Item.getItemFromBlock(Blocks.GOLD_ORE))) {
                ItemStack change = new ItemStack(Item.getItemFromBlock(Blocks.IRON_ORE));
                int i = random.nextInt(12);
                switch (i) {
                    case 0:
                        change = new ItemStack(Item.getItemFromBlock(Blocks.GOLD_ORE));
                        break;
                    case 1:
                        change = new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_ORE));
                        break;
                    case 2:
                        change = new ItemStack(Item.getItemFromBlock(Blocks.LAPIS_ORE));
                        break;
                    case 3:
                        change = new ItemStack(Item.getItemFromBlock(Blocks.DIAMOND_ORE));
                        break;
                    case 4:
                        change = new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_ORE));
                        break;
                    case 5:
                        change = new ItemStack(oreCobalt.getItem());
                        break;
                    case 6:
                        change = new ItemStack(oreArdite.getItem());
                        break;
                    case 7:
                        change = new ItemStack(titaniteOre);
                        break;
                    case 8:
                        change = new ItemStack(bismuthOre);
                        break;
                    case 9:
                        change = new ItemStack(tiberiumOre);
                        break;
                    case 10:
                        change = new ItemStack(eterniteOre);
                        break;
                    case 11:
                        change = new ItemStack(Item.getItemFromBlock(Blocks.IRON_ORE));
                        break;
                }
                event.getDrops().set(0, change);


            }
        }
    }
}
