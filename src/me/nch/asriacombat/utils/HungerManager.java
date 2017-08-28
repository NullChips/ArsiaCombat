package me.nch.asriacombat.utils;

public class HungerManager {
    private static HungerManager ourInstance = new HungerManager();

    public static HungerManager getInstance() {
        return ourInstance;
    }

    private HungerManager() {
    }
}
