package me.nch.asriacombat.threads;

import me.nch.asriacombat.AsriaCombat;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerStatsSaveThread extends BukkitRunnable {

    /*
    This thread is use as an 'autosave' for player stats, so that recent player stats are saved in the case of
    an unexpected shutdown. I'm not really sure whether they would save or not in this case, so it's better
    to be safe rather than sorry.
    */

    @Override
    public void run() {
        AsriaCombat.getPlayerStatsFile().saveStats();
    }
}
