package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public abstract class ListenerModule extends Module implements Listener {

    protected ListenerModule(String configId, String displayName, int defaultHungerChange, ListenerModule lm) {
        super(configId, displayName, defaultHungerChange);
        Bukkit.getServer().getPluginManager().registerEvents(lm, AsriaCombat.getInstance());
    }
}
