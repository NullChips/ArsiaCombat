package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;

public class LocationCheckModule extends RepeatingModule {

    protected LocationCheckModule() {
        super("standing-still", "Standing Still", 1, 1);
    }

    @Override
    public void updateModule() {
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if (p != null) {
                if(ap.locationCheck(p.getLocation())) {
                    ap.setHealth(ap.getHealth() + getHungerChange());
                }
            }
        }
    }
}
