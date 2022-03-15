package com.sosnitzka.taiga.net;

import com.sosnitzka.taiga.keys.KeyServer;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class AltKeySyncClient implements IMessage {
    boolean isDown;

    public AltKeySyncClient() {
    }

    public AltKeySyncClient(boolean isDown) {
        this.isDown = isDown;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(isDown);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        isDown = buf.readBoolean();
    }

    public static class Handler implements IMessageHandler<AltKeySyncClient, IMessage> {
        @Override
        public IMessage onMessage(AltKeySyncClient msg, MessageContext ctx) {
            KeyServer.alt.setDown(msg.isDown);
            return null;
        }
    }
}
