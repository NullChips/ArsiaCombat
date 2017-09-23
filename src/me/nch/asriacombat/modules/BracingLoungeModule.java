package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class BracingLoungeModule extends ListenerModule {

    protected BracingLoungeModule() {
        super("bracing-a-lounge", "Bracing a Lounge", -3);
        registerListenerModule(this);
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            Player damager = (Player) e.getEntity();

            if(check(p, damager)) {
                AsriaPlayer ap = AsriaCombat.getAsriaPlayerFromUUID(p.getUniqueId().toString());

                ap.setHealth(ap.getHealth() + getHungerChange());
            }
        }
    }

    private boolean check(Player p, Player damager) {
        return p.isSneaking() && p.isBlocking() && damager.isSprinting() && !AsriaCombat.playerIsFalling(damager);
    }

}
