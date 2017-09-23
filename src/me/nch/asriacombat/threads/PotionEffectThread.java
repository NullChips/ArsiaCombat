package me.nch.asriacombat.threads;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PotionEffectThread extends BukkitRunnable {

    /*
    This thread checks every second to see if a players health is below a certain number and then applies
    the correct effect depending on their health. This is the most efficient way of doing this without running through
    this everytime a players health is changed (which is multiple times per second).
    */

    @Override
    public void run() {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            AsriaPlayer ap = AsriaCombat.getAsriaPlayerFromUUID(p.getUniqueId().toString());

            if (ap != null) {
                ap.giveEffect();
            }
        }
    }
}
