package me.nch.asriacombat.commands;

import me.nch.asriacombat.modules.Module;
import me.nch.asriacombat.modules.ModuleManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ListModulesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        for(Module m : ModuleManager.getInstance().getModules()) {
            sender.sendMessage(ChatColor.GREEN + m.getDisplayName() + ": " + m.getHungerChange());
        }
        return true;
    }

    //TODO Add selectable pages for modules.

}
