package com.sosnitzka.taiga.util;


public class TickTask {
    private Runnable task;
    private int targetTicks = 0;
    private int ticks;

    public TickTask(int targetTicks, Runnable runnable) {
        this.task = runnable;
        this.targetTicks = targetTicks;
    }

    public TickTask(Runnable runnable) {
        this.task = runnable;
        this.targetTicks = 1;
    }

    public boolean tickRun() {
        ticks++;

        if (ticks >= targetTicks) {
            this.task.run();
            return true;
        }
        return false;
    }
}
