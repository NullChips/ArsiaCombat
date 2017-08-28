package me.nch.asriacombat;

import me.nch.asriacombat.utils.ConfigFile;
import me.nch.asriacombat.modules.ModuleManager;
import me.nch.asriacombat.utils.PlayerStatsFile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class AsriaCombat extends JavaPlugin {

    public static AsriaCombat instance;

    private static ConfigFile configFile;
    private static PlayerStatsFile playerStatsFile;

    private ModuleManager mm;

    private static ArrayList<AsriaPlayer> players;
    private static int hungerChangeScale;
    private static int loopNumber;

    @Override
    public void onEnable() {
        instance = this;
        players = new ArrayList<>();
        mm = ModuleManager.getInstance();
        mm.registerModules();

        configFile = new ConfigFile(this);
        playerStatsFile = new PlayerStatsFile(this);
        configFile.loadConfig();
        playerStatsFile.loadStats();

        hungerChangeScale = 1;
        loopNumber = 0;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Player getPlayerFromUUID(String uuid) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            if(uuid.equals(p.getUniqueId().toString())) {
                return p;
            }
        }
        return null;
    }

    public static AsriaCombat getInstance() {
        return instance;
    }

    public static ConfigFile getConfigFile() {
        return configFile;
    }

    public static PlayerStatsFile getPlayerStatsFile() {
        return playerStatsFile;
    }

    public static ArrayList<AsriaPlayer> getPlayers() {
        return players;
    }

    public static int getHungerChangeScale() {
        return hungerChangeScale;
    }

    public static int getLoopNumber() {
        return loopNumber;
    }

}
