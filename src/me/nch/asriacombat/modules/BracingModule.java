package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BracingModule extends RepeatingModule {

    protected BracingModule() {
        super("bracing", "Bracing", -2, 1);
    }

    @Override
    public void updateModule() {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            if(p.isBlocking() && p.isSneaking()) {
                AsriaPlayer ap = AsriaCombat.getAsriaPlayerFromUUID(p.getUniqueId().toString());
                ap.setHealth(ap.getHealth() + getHungerChange());
            }
        }
    }
}
