package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.Equipable;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

/**
 * This is the class representing the Armor.
 * It is a subclass of the Equipable class and has a constructor that calls the
 * super class' constructor to set the name, slot, and required level.
 * It also has instance variables for the armor type and the armor attribute.
 * It has getters and setters for the instance variables.
 */
public class Armor extends Equipable {

    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    /**
     * This is the constructor for the Armor class which is a sub class of
     * Equipable.
     * It takes in 5 parameters and assigns them to the instance variables.
     * It calls the super class' constructor to set the name, slot, and required
     * level.
     * 
     * @param name           The name of the Armor
     * @param slot           The slot of the Armor
     * @param requiredLevel  the level the player must be to use the Armor
     * @param armorType      The type of the Armor
     * @param armorAttribute The attribute of the Armor
     */
    public Armor(String name, SlotType slot, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, slot, requiredLevel);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    /**
     * This setter method sets the armor type.
     * 
     * @param armorType the new type of the Armor
     */
    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    /**
     * This getter method gets the armor attribute.
     * 
     * @return the attribute of the Armor
     */
    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    /**
     * This setter method sets the armor attribute.
     * 
     * @param armorAttribute the new attribute of the Armor
     */
    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    /**
     * This getter method gets the armor type.
     * 
     * @return the type of the Armor
     */
    public ArmorType getArmorType() {
        return armorType;
    }
}
