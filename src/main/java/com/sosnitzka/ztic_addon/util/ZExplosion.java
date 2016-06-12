package com.sosnitzka.ztic_addon.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ZExplosion extends Explosion {

    /**
     * whether or not the explosion sets fire to blocks around it
     */
    private final boolean isFlaming;
    /**
     * whether or not this explosion spawns smoke particles
     */
    private final boolean isSmoking;
    private final Random explosionRNG;
    private final World worldObj;
    private final double explosionX;
    private final double explosionY;
    private final double explosionZ;
    private final Entity exploder;
    private final float explosionSize;
    private final List<BlockPos> affectedBlockPositions;
    private final Map<EntityPlayer, Vec3d> playerKnockbackMap;
    private final Vec3d position;

    @SideOnly(Side.CLIENT)
    public ZExplosion(World worldIn, Entity entityIn, double x, double y, double z, float size, List<BlockPos> affectedPositions) {
        this(worldIn, entityIn, x, y, z, size, false, true, affectedPositions);
    }

    @SideOnly(Side.CLIENT)
    public ZExplosion(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming, boolean smoking, List<BlockPos> affectedPositions) {
        this(worldIn, entityIn, x, y, z, size, flaming, smoking);
        this.affectedBlockPositions.addAll(affectedPositions);
    }

    @SideOnly(Side.CLIENT)
    public ZExplosion(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming, boolean smoking) {
        super(worldIn, entityIn, x, y, z, size, flaming, smoking);

        this.explosionRNG = new Random();
        this.affectedBlockPositions = Lists.<BlockPos>newArrayList();
        this.playerKnockbackMap = Maps.<EntityPlayer, Vec3d>newHashMap();
        this.worldObj = entityIn.getEntityWorld();
        this.exploder = entityIn;
        this.explosionSize = size;
        this.explosionX = x;
        this.explosionY = y;
        this.explosionZ = z;
        this.isFlaming = flaming;
        this.isSmoking = smoking;
        this.position = new Vec3d(explosionX, explosionY, explosionZ);
    }

}