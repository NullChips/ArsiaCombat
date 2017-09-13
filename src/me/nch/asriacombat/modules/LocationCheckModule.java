package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class LocationCheckModule extends RepeatingModule {

    protected LocationCheckModule() {
        super("standing-still", "Standing Still", 1, 1);
    }

    @Override
    public void updateModule() {
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if (p != null) {
                Vector v = p.getVelocity();
                if ((v.getX() == 0) && (v.getY() == 0) && (v.getZ() == 0)) {
                    ap.setHealth(ap.getHealth() + getHungerChange());
                }
            }
        }
    }

    //TODO Does this actually check if the player is standing still?
}
