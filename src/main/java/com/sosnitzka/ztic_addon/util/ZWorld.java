package com.sosnitzka.ztic_addon.util;

import com.sosnitzka.ztic_addon.util.traits.ZExplosion;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

/**
 * Created by Robert on 11.06.2016.
 */
public class ZWorld extends World {
    protected ZWorld(ISaveHandler saveHandlerIn, WorldInfo info, WorldProvider providerIn, Profiler profilerIn, boolean client) {
        super(saveHandlerIn, info, providerIn, profilerIn, client);
    }

    @Override
    protected IChunkProvider createChunkProvider() {
        return null;
    }

    @Override
    protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
        return false;
    }

    @Override
    public Explosion newExplosion(Entity entityIn, double x, double y, double z, float strength, boolean isFlaming, boolean isSmoking) {
        ZExplosion explosion = new ZExplosion(this, entityIn, x, y, z, strength, isFlaming, isSmoking);
        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this, explosion)) return explosion;
        explosion.doExplosionA();
        explosion.doExplosionB(true);
        return explosion;
    }
}
