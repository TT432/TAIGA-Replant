package com.sosnitzka.taiga.util;


import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TickTaskHandler {
    private List<TickTask> tickTasks = new ArrayList<TickTask>();


    private TickTaskHandler() {
    }

    public static TickTaskHandler getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent e) {
        for (Iterator<TickTask> iterator = tickTasks.iterator(); iterator.hasNext(); ) {
            TickTask task = iterator.next();
            if (task.tickRun()) {
                iterator.remove();
            }
        }
    }

    public void addTask(TickTask tickTask) {
        tickTasks.add(tickTask);
    }

    private static final class InstanceHolder {
        static final TickTaskHandler INSTANCE = new TickTaskHandler();
    }
}
