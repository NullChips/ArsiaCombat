package me.nch.asriacombat.threads;

import me.nch.asriacombat.AsriaPlayer;
import me.nch.asriacombat.modules.JumpingModule;
import org.bukkit.scheduler.BukkitRunnable;

public class JumpingCooldownThread extends BukkitRunnable {

    private final AsriaPlayer PLAYER;
    private final JumpingModule MODULE;

    public JumpingCooldownThread(AsriaPlayer ap, JumpingModule m) {
        this.PLAYER = ap;
        this.MODULE = m;
    }

    @Override
    public void run() {
        MODULE.getJumpingCooldown().remove(PLAYER);
    }
}
