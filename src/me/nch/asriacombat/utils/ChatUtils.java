package me.nch.asriacombat.utils;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtils {
    private static ChatUtils ourInstance = new ChatUtils();

    public static ChatUtils getInstance() {
        return ourInstance;
    }

    private ChatUtils() {
    }

    public static void debugMessage(String message) {
        Bukkit.getServer().broadcastMessage(ChatColor.YELLOW  + "[DEBUG] " + ChatColor.GREEN + message);
    }

    public void broadcastMessage(String message) {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage(message);
        }
    }

    public void message(Player p, String message) {
        p.sendMessage(message);
    }

    public void message(AsriaPlayer ap, String message) {
        Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

        if (p != null) {
            p.sendMessage(message);
        }
    }
}
