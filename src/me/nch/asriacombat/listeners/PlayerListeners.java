package me.nch.asriacombat.listeners;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import me.nch.asriacombat.utils.PlayerStatsFile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void stopNaturalHungerLoss(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if(!PlayerStatsFile.containsPlayer(e.getPlayer())) {
            AsriaPlayer ap = new AsriaPlayer(e.getPlayer().getUniqueId().toString(), 20);
            ap.setHealth(20);
            ap.setLastLocation(e.getPlayer().getLocation());

            AsriaCombat.getPlayers().add(ap);
        }
    }
}
