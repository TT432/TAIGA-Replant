package com.sosnitzka.taiga.traits;

import com.sosnitzka.taiga.traits.abs.AbstractKeyBindTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;


public class TraitCatcher extends AbstractKeyBindTrait {

    public static int chance = 3;
    public static float costMulti = 0.25f;

    public TraitCatcher() {
        super(TraitCatcher.class.getSimpleName().toLowerCase().substring(5), TextFormatting.RED);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void killEntity(LivingDeathEvent event) {
        if (!(event.getSource().getTrueSource() instanceof EntityPlayer))
            return;
        if (event.getEntityLiving() instanceof EntityPlayer || event.getEntityLiving() instanceof EntityPlayerMP)
            return;

        World w = event.getSource().getTrueSource().getEntityWorld();
        EntityPlayer p = (EntityPlayer) event.getSource().getTrueSource();

        if (!TinkerUtil.hasTrait(TagUtil.getTagSafe(p.getHeldItemMainhand()), identifier))
            return;

        EntityLivingBase target = event.getEntityLiving();
        NBTTagCompound tag = TagUtil.getExtraTag(p.getHeldItemMainhand());
        Data data = Data.read(tag);

        if (!data.mobClass.isEmpty()) {
            return;
        }

        if (!w.isRemote && random.nextInt((int) target.getMaxHealth()) <= chance && target instanceof EntityLiving) {
            event.setCanceled(true);
            target.setDropItemsWhenDead(false);

            if (data.mobClass.isEmpty()) {
                data.mobClass = target.getClass().getName();
                data.mobName = target.getName();
                data.write(tag);
                TagUtil.setExtraTag(p.getHeldItemMainhand(), tag);
                p.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                target.setDropItemsWhenDead(false);
                target.setDead();
            }
        }
    }

    @Override
    public void onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (!world.isRemote) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            TagUtil.setEnchantEffect(tool, !data.mobClass.isEmpty());
        }
    }

    @SubscribeEvent
    public void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        World w = event.getWorld();
        BlockPos pos = event.getEntityPlayer().getPosition();
        ItemStack tool = event.getEntityPlayer().getHeldItemMainhand();
        if (!w.isRemote && canActive(tool)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            if (!data.mobClass.isEmpty()) {
                Entity ent = null;
                try {
                    ent = (Entity) Class.forName(data.mobClass).getConstructor(World.class).newInstance(w);
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (ent != null) {
                    ent.setPosition(pos.getX(), pos.getY(), pos.getZ()); // TODO: set to player view target
                    w.spawnEntity(ent);
                    event.getEntityPlayer().playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                    data.mobClass = "";
                    data.mobName = "";
                    data.write(tag);
                    TagUtil.setExtraTag(tool, tag);
                    ToolHelper.damageTool(tool, random.nextInt((int) (ToolHelper.getCurrentDurability(tool) *
                            costMulti)), event.getEntityPlayer());
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent e) {
        ItemStack tool = e.getItemStack();
        if (TinkerUtil.hasTrait(TagUtil.getTagSafe(tool), identifier)) {
            NBTTagCompound tag = TagUtil.getExtraTag(tool);
            Data data = Data.read(tag);
            if (!data.mobClass.isEmpty())
                e.getToolTip().add(TextFormatting.DARK_PURPLE + "Captured: " + TextFormatting.LIGHT_PURPLE + data
                        .mobName);
        }
    }

    public static class Data {
        String mobClass;
        String mobName;

        public static Data read(NBTTagCompound tag) {
            Data data = new Data();
            data.mobName = tag.getString("mobName");
            data.mobClass = tag.getString("mobClass");
            return data;
        }

        public void write(NBTTagCompound tag) {
            tag.setString("mobClass", mobClass);
            tag.setString("mobName", mobName);
        }
    }
}



