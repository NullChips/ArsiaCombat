package me.nch.asriacombat;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class AsriaPlayer {

    private final String UUID;

    private int health;
    private Location lastLocation;

    public AsriaPlayer(String UUID, int health) {
        this.UUID = UUID;
        this.health = health;
    }

    public boolean locationCheck(Location l) {
        if (lastLocation != null) {
            return l.getX() == lastLocation.getX() && l.getY() == lastLocation.getY() &&
                    l.getZ() == lastLocation.getZ() && l.getWorld().getName() == lastLocation.getWorld().getName();

        }
        return false;
    }

    public void giveEffect() {
        Player p = AsriaCombat.getPlayerFromUUID(UUID);

        if (p != null) {
            if (health > 6) {
                removePotionEffects(p);
                return;
            }

            if (health == 6 || health == 5) {
                removePotionEffects(p);
                addPotionEffect(p, PotionEffectType.WEAKNESS, 1);
                return;
            }

            if (health == 4 || health == 3) {
                removePotionEffects(p);
                addPotionEffect(p, PotionEffectType.WEAKNESS, 1);
                addPotionEffect(p, PotionEffectType.SLOW, 1);
                return;
            }


            if(health == 2 || health == 1) {
                removePotionEffects(p);
                addPotionEffect(p, PotionEffectType.WEAKNESS, 1);
                addPotionEffect(p, PotionEffectType.SLOW, 2);
                return;
            }

            if(health <= 0) {
                removePotionEffects(p);
                addPotionEffect(p, PotionEffectType.WEAKNESS, 1);
                addPotionEffect(p, PotionEffectType.SLOW, 3);
                addPotionEffect(p, PotionEffectType.BLINDNESS, 1);
                return;
            }
        }
    }

    private void removePotionEffects(Player p) {
        for (PotionEffect pe : p.getActivePotionEffects()) {
            p.removePotionEffect(pe.getType());
        }
        return;
    }

    private void addPotionEffect(Player p, PotionEffectType type, int amplifer) {
        p.addPotionEffect(new PotionEffect(type, 999999999, amplifer));
    }

    public String getUUID() {
        return UUID;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        Player p = AsriaCombat.getPlayerFromUUID(UUID);

        if (p != null) {
            if (health >= 20) {
                p.setFoodLevel(20);
                this.health = 20;
                return;

            } else if (health <= 0) {
                this.health = 0;
                p.setFoodLevel(0);
                return;
            }

            p.setFoodLevel(health);
            this.health = health;
        }
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
}