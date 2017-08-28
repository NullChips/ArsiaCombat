package me.nch.asriacombat.threads;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.modules.Module;
import me.nch.asriacombat.modules.ModuleManager;
import me.nch.asriacombat.modules.RepeatingModule;
import org.bukkit.scheduler.BukkitRunnable;

public class ModuleCheckThread extends BukkitRunnable {

    ModuleManager mm = ModuleManager.getInstance();

    @Override
    public void run() {
        for(Module m : mm.getModules()) {
            if(m instanceof RepeatingModule) {
                RepeatingModule rm = (RepeatingModule) m;
                if(AsriaCombat.getLoopNumber() % rm.getSecondsBetweenUpdate() == 0) {
                    rm.updateModule();
                }
            }
        }
    }
}
