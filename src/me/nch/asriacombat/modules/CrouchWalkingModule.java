package me.nch.asriacombat.modules;

import me.nch.asriacombat.AsriaCombat;
import me.nch.asriacombat.AsriaPlayer;
import me.nch.asriacombat.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Copyright (c) NullChips 2017. All rights reserved.
 * All code contained within this document is the
 * sole property of NullChips. Distribution, reproduction,
 * taking snippets or claiming any contents as your own will
 * break the terms of the license, and void any agreements with
 * you, the third party.
 * Thanks.
 **/
public class CrouchWalkingModule extends RepeatingModule {

    protected CrouchWalkingModule() {
        super("crouching-and-walking", "Crouching and Walking", 2, 1);
    }

    @Override
    public void updateModule() {
        for (AsriaPlayer ap : AsriaCombat.getPlayers()) {
            Player p = AsriaCombat.getPlayerFromUUID(ap.getUUID());

            if (p != null) {
                Vector v = p.getVelocity();
                if ((v.getX() != 0) && (v.getY() != 0) && (v.getZ() != 0) && p.isSneaking() && !p.isSprinting()) {
                    ChatUtils.debugMessage("Player is crouching and walking.");
                    ap.setHealth(ap.getHealth() + getHungerChange());
                }
            }
        }
    }
}
