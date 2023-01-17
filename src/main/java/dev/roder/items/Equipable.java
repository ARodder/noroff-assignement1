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

    /**
     * Retrieves the name of the item.
     * @return name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the slot of the item.
     * @return slot of the item
     */
    public SlotType getSlot() {
        return slot;
    }

    /**
     * Sets the slot of the item.
     */
    public void setSlot(SlotType slot) {
        this.slot = slot;
    }

    /**
     * Retrieves the requiredLevel for the item.
     * @return requiredLevel of the item
     */
    public int getRequiredLevel() {
        return requiredLevel;
    }

    /**
     * Sets the requiredLevel for the item.
     */
    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
