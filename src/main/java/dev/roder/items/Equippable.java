package dev.roder.items;


import dev.roder.items.types.SlotType;

public class Equippable {
    private String name;
    private SlotType slot;
    private int requiredLevel;

    public Equippable(String name, SlotType slot, int requiredLevel) {
        this.name = name;
        this.slot = slot;
        this.requiredLevel = requiredLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SlotType getSlot() {
        return slot;
    }

    public void setSlot(SlotType slot) {
        this.slot = slot;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
