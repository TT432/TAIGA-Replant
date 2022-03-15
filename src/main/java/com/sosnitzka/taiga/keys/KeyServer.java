package com.sosnitzka.taiga.keys;

/**
 * @author DustW
 */
public class KeyServer {
    public static final KeyServer alt = new KeyServer();

    private boolean isDown = false;

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean isDown) {
        this.isDown = isDown;
    }
}
