package me.nch.asriacombat.commands;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListPlayersCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        for(AsriaPlayer ap : AsriaCombat.getPlayers()) {
            p.sendMessage(ap.getUUID() + " " + ap.getHealth());
        }

        p.sendMessage(AsriaCombat.getPlayers().size() + "");

        return true;
    }


}
