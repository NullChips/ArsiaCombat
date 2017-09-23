package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;

public class WalkingModule extends RepeatingModule{

    protected WalkingModule() {
        super("walking", "walking", 1, 1);
    }

    @Override
    public void updateModule() {
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());
            if (p != null) {
                if (!ap.locationCheck(p.getLocation()) && !p.isSneaking() && !p.isSprinting()) {
                    ap.setHealth(ap.getHealth() + getHungerChange());
                }
            }
        }
    }

}
