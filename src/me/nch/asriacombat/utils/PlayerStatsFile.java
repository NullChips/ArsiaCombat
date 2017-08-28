package me.nch.asriacombat.utils;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
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
        for(AsriaPlayer ap : AsriaCombat.getPlayers()) {
            String s = ap.getUUID() + ":" + ap.getHealth();
            playersToSave.add(s);
        }
        getConfig().set("players", playersToSave);
        save();
    }
}
