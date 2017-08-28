package me.nch.asriacombat.modules;

public abstract class RepeatingModule extends Module {

    private int secondsBetweenUpdate;

    protected RepeatingModule(String configId, String displayName, int defaultHungerChange, int secondsBetweenUpdate) {
        super(configId, displayName, defaultHungerChange);
        this.secondsBetweenUpdate = secondsBetweenUpdate;
    }

    public abstract void updateModule();

    public int getSecondsBetweenUpdate() {
        return secondsBetweenUpdate;
    }

}
