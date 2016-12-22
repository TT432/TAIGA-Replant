package com.sosnitzka.taiga.world;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.storage.MapStorage;

import java.util.ArrayList;
import java.util.List;

import static com.sosnitzka.taiga.TAIGA.MODID;

public class MeteorWorldSaveData extends WorldSavedData {
    private static final String DATA_NAME = MODID + "_meteors";
    private List<BlockPos> posList;

    public MeteorWorldSaveData() {
        super(DATA_NAME);
    }

    @SuppressWarnings("unused")
    public MeteorWorldSaveData(String name) {
        super(name);
    }

    public static MeteorWorldSaveData getForWorld(World world) {
        MapStorage storage = world.getPerWorldStorage();
        MeteorWorldSaveData instance = (MeteorWorldSaveData) storage.getOrLoadData(MeteorWorldSaveData.class, DATA_NAME);

        if (instance == null) {
            instance = new MeteorWorldSaveData();
            storage.setData(DATA_NAME, instance);
        }
        return instance;
    }

    public List<BlockPos> getPosList() {
        return posList;
    }

    public void addPos(BlockPos pos) {
        if (posList == null)
            posList = new ArrayList<BlockPos>();

        posList.add(pos);
    }

    public boolean removePos(BlockPos pos) {
        return posList != null && posList.remove(pos);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        if (nbt.hasKey("posData") && !nbt.getString("posData").isEmpty()) {
            posList = new Gson().fromJson(nbt.getString("posData"), new TypeToken<List<BlockPos>>(){}.getType());
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        if (posList == null)
            return null;

        compound.setString("posData", new Gson().toJson(posList));
        return compound;
    }
}
