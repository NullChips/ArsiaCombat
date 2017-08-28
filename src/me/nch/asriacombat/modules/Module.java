package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.utils.ConfigFile;

public abstract class Module {

    private String configId;
    private String displayName;
    private int hungerChange;

    protected Module(String configId, String displayName, int defaultHungerChange) {
        this.configId = configId;
        this.displayName = displayName;

        ConfigFile cf = AsriaCombat.getConfigFile();
        if(cf.containsInt(configId)) {
            this.hungerChange = cf.getConfig().getInt(configId) * AsriaCombat.getHungerChangeScale();
        } else {
            this.hungerChange = defaultHungerChange * AsriaCombat.getHungerChangeScale();
        }
    }
}
