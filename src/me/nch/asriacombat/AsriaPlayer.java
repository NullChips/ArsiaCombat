package me.nch.asriacombat;

import org.bukkit.entity.Player;

public class AsriaPlayer {

    private final String UUID;

    private int health;

    public AsriaPlayer(String UUID, int health) {
        this.UUID = UUID;
        this.health = health;
    }

    public String getUUID() {
        return UUID;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        Player p = AsriaCombat.getPlayerFromUUID(UUID);
        if (p != null) {
            p.setFoodLevel(health);
        }
        //TODO Handle when player runs out of health.
    }
}
