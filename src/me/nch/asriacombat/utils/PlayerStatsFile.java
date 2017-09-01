package me.nch.asriacombat.utils;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class PlayerStatsFile extends AsriaFile {

    public PlayerStatsFile(Plugin pl) {
        super(pl, "playerstats.yml");
    }

    public void loadStats() {
        //TODO Load stats.
    }

    public void saveStats() {
        ArrayList<String> playersToSave = new ArrayList<>();
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            String s = ap.getUUID() + ":" + ap.getHealth();
            playersToSave.add(s);
        }
        getConfig().set("players", playersToSave);
        save();
    }


    //The method below handles the player joining and finding if there is a player stats that exists
    //for the player that has just joined.

    public static boolean containsPlayer(Player p) {
        String uuid = p.getUniqueId().toString();

        boolean contains = false;
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            if (ap.getUUID().equals(uuid)) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
