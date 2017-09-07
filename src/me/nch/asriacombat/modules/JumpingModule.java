package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import me.nch.asriacombat.threads.JumpingCooldownThread;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class JumpingModule extends ListenerModule {

    //This is the Y value of the vetor if the player is not jumping.
    final double STILL = -0.0784000015258789;

    private ArrayList<AsriaPlayer> jumpingCooldown;

    protected JumpingModule() {
        super("jumping", "Jumping", -1);
        registerListenerModule(this);

        this.jumpingCooldown = new ArrayList<>();
    }

    @EventHandler
    public void onJump(PlayerMoveEvent e) {
        AsriaPlayer ap = AsriaCombat.getAsriaPlayerFromUUID(e.getPlayer().getUniqueId().toString());

        if (ap != null) {
            if (e.getPlayer().getVelocity().getY() > STILL && !jumpingCooldown.contains(ap)) {
                ap.setHealth(ap.getHealth() + getHungerChange());

                jumpingCooldown.add(ap);

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(AsriaCombat.getInstance(),
                        new JumpingCooldownThread(ap, this), 9);
            }
        }
    }

    public ArrayList<AsriaPlayer> getJumpingCooldown() {
        return jumpingCooldown;
    }

}
