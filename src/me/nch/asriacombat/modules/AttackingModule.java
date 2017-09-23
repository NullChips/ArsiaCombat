package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AttackingModule extends ListenerModule {

    protected AttackingModule() {
        super("attacking", "Attacking", -4);
        registerListenerModule(this);
    }

    @EventHandler
    public void onAttack(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            AsriaPlayer ap = AsriaCombat.getAsriaPlayerFromUUID(e.getPlayer().getUniqueId().toString());

            if (ap != null) {
                ap.setHealth(ap.getHealth() + getHungerChange());
            }
        }
    }

}
