package com.sosnitzka.taiga.keys;

import com.sosnitzka.taiga.net.AltKeySyncClient;
import com.sosnitzka.taiga.net.NetManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * @author DustW
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class TickListener {
    @SubscribeEvent
    public static void tick(TickEvent.ClientTickEvent event) {
        if (Keybindings.altKey.isKeyDown()) {
            if (!KeyServer.alt.isDown()) {
                KeyServer.alt.setDown(true);
                sync();
            }
        } else {
            if (KeyServer.alt.isDown()) {
                KeyServer.alt.setDown(false);
                sync();
            }
        }
    }

    static void sync() {
        NetManager.INSTANCE.sendMessageToServer(new AltKeySyncClient(KeyServer.alt.isDown()));
    }
}
