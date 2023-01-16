package dev.roder.items;


import dev.roder.items.types.SlotType;

/**
 * Equipable serves as an abstract class containing fields and methods
 * common for all equipable items.
 */
public abstract class Equipable {
    private String name;
    private SlotType slot;
    private int requiredLevel;

    public Equipable(String name, SlotType slot, int requiredLevel) {
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
