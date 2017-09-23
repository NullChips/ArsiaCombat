package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import me.nch.asriacombat.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class SprintingModule extends RepeatingModule {

    protected SprintingModule() {
        super("sprinting", "Sprinting", -1, 1);
    }

    @Override
    public void updateModule() {
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if (p != null) {
                if (p.isSprinting() && !p.hasPotionEffect(PotionEffectType.SPEED)) {
                    ap.setHealth(ap.getHealth() + getHungerChange());
                }
            }
        }
    }
}
