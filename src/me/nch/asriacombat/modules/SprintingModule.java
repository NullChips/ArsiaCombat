package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;

public class SprintingModule extends RepeatingModule {

    protected SprintingModule() {
        super("sprinting", "Sprinting", 1, 1);
    }

    @Override
    public void updateModule() {
        for(AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if (p != null) {
                if(p.isSprinting()) {
                    ap.setHealth(ap.getHealth() - 1);
                }
            }
        }
    }
}
