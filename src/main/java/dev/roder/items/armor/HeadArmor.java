package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

/**
 * This is the class representing the Head Armor.
 * It is a subclass of the Armor class and has a constructor that
 * creates an Armor piece with head as the SlotType
 */
public class HeadArmor extends Armor {

    /**
     * This is the constructor for the HeadArmor class which is a sub class of
     * Armor.
     * It takes in 4 parameters and assigns them to the instance variables.
     * It calls the super class' constructor to set the name, slot, required level,
     * armor type and armor attribute.
     * 
     * @param name           The name of the Head Armor
     * @param requiredLevel  the level the player must be to use the Head Armor
     * @param armorType      The type of the Head Armor
     * @param armorattribute The attribute of the Head Armor
     */
    public HeadArmor(String name, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, SlotType.Head, requiredLevel, armorType, armorAttribute);
    }
}
