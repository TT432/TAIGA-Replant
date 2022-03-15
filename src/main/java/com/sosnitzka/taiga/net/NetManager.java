package com.sosnitzka.taiga.net;

import com.sosnitzka.taiga.TAIGA;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author DustW
 */
public class NetManager {
    public static final NetManager INSTANCE = new NetManager();

    private final SimpleNetworkWrapper channel = NetworkRegistry.INSTANCE.newSimpleChannel(TAIGA.MODID);

    int id = 0;

    public NetManager() {
        this.channel.registerMessage(AltKeySyncClient.Handler.class, AltKeySyncClient.class, id++, Side.SERVER);
    }

    // 向某个维度发包（服务器到客户端）
    public void sendMessageToDim(IMessage msg, int dim) {
        channel.sendToDimension(msg, dim);
    }

    // 向某个维度的某个点发包（服务器到客户端）
    public void sendMessageAroundPos(IMessage msg, int dim, BlockPos pos) {
        // TargetPoint的构造器为：
        // 维度id x坐标 y坐标 z坐标 覆盖范围
        // 其中，覆盖范围指接受此更新数据包的坐标的范围
        channel.sendToAllAround(msg, new NetworkRegistry.TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(), 2.0D));
    }

    // 向某个玩家发包（服务器到客户端）
    public void sendMessageToPlayer(IMessage msg, EntityPlayerMP player) {
        channel.sendTo(msg, player);
    }

    // 向所有人发包（服务器到客户端）
    public void sendMessageToAll(IMessage msg) {
        channel.sendToAll(msg);
    }

    // 向服务器发包（客户端到服务器）
    public void sendMessageToServer(IMessage msg) {
        channel.sendToServer(msg);
    }
}
