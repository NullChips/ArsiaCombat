package me.nch.asriacombat;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class AsriaPlayer {

    private final String UUID;

    private int health;
    private Location lastLocation;

    public AsriaPlayer(String UUID, int health) {
        this.UUID = UUID;
        this.health = health;
    }

    public boolean locationCheck(Location l) {
        if(lastLocation != null) {
            boolean sameLocation = l.getBlockX() == lastLocation.getBlockX() && l.getBlockY() == lastLocation.getBlockY() &&
                    l.getBlockZ() == lastLocation.getBlockZ() && l.getWorld().getName() == lastLocation.getWorld().getName();
            lastLocation = l;
            return sameLocation;
        }
        lastLocation = l;
        return false;
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

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }

}
