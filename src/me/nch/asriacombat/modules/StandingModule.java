package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import me.nch.asriacombat.utils.ChatUtils;
import org.bukkit.entity.Player;

public class StandingModule extends RepeatingModule {

    protected StandingModule() {
        super("standing-still", "Standing Still", 1, 1);
    }

    @Override
    public void updateModule() {
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if (p != null) {
                if (ap.locationCheck(p.getLocation())) {
                    ChatUtils.debugMessage("Player is standing still.");
                    ap.setHealth(ap.getHealth() + getHungerChange());
                }
                ap.setLastLocation(p.getLocation());
            }
        }
    }
    //TODO Still doesn't register as being stood still?...
}
