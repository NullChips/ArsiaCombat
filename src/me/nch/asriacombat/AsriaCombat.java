package me.nch.asriacombat;

import me.nch.asriacombat.commands.ListModulesCommand;
import me.nch.asriacombat.listeners.PlayerListeners;
import me.nch.asriacombat.threads.ModuleCheckThread;
import me.nch.asriacombat.threads.PlayerStatsSaveThread;
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

        configFile = new ConfigFile(this);
        playerStatsFile = new PlayerStatsFile(this);
        configFile.loadConfig();
        playerStatsFile.loadStats();

        mm = ModuleManager.getInstance();
        mm.registerModules();

        hungerChangeScale = 1;
        loopNumber = 0;

        registerListeners();
        registerCommands();

        startThreads();
    }

    @Override
    public void onDisable() {
        playerStatsFile.saveStats();

        instance = null;
    }

    private void registerListeners() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
    }

    private void registerCommands() {
        getCommand("listmodules").setExecutor(new ListModulesCommand());
    }

    private void startThreads() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new ModuleCheckThread(), 20, 20);
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new PlayerStatsSaveThread(), 12000, 12000);
    }

    public static Player getPlayerFromUUID(String uuid) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            if (uuid.equals(p.getUniqueId().toString())) {
                return p;
            }
        }
        return null;
    }

    public static AsriaPlayer getAsriaPlayerFromUUID(String uuid) {
        for(AsriaPlayer ap : players) {
            if(ap.getUUID().equals(uuid)) {
                return ap;
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
