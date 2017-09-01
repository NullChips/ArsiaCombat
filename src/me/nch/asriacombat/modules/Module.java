package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.utils.ConfigFile;
import org.bukkit.Bukkit;

public abstract class Module {

    private String configId;
    private String displayName;
    private int hungerChange;

    protected Module(String configId, String displayName, int defaultHungerChange) {
        this.configId = configId;
        this.displayName = displayName;

        ConfigFile cf = AsriaCombat.getConfigFile();
        if (cf.containsInt(configId)) {
            this.hungerChange = cf.getConfig().getInt(configId);
        } else {
            this.hungerChange = defaultHungerChange;
        }
    }


    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getHungerChange() {
        return hungerChange;
    }

    public void setHungerChange(int hungerChange) {
        this.hungerChange = hungerChange;
    }

}
