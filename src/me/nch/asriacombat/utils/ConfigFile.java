package me.nch.asriacombat.utils;

import org.bukkit.plugin.Plugin;

public class ConfigFile extends AsriaFile {

    public ConfigFile(Plugin pl) {
        super(pl, "config.yml");
    }

    public void loadConfig() {
        //TODO Load config.
    }
}
