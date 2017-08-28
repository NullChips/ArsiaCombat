package me.nch.asriacombat.threads;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerCheckThread extends BukkitRunnable {
    @Override
    public void run() {
        for(AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if(p != null) {
                if(ap.locationCheck(p.getLocation())) {
                    //TODO Do thing if player is in the same location.
                }
            }
        }
    }
}
