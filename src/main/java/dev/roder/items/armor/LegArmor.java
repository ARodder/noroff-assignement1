package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

/**
 * This is the class representing the Leg Armor.
 * It is a subclass of the Armor class and has a constructor that
 * creates an Armor piece with legs as the SlotType
 */
public class LegArmor extends Armor {

    /**
     * This is the constructor for the LegArmor class which is a sub class of Armor.
     * It takes in 4 parameters and assigns them to the instance variables.
     * It calls the super class' constructor to set the name, slot, required level,
     * armor type and armor attribute.
     * 
     * @param name           The name of the Leg Armor
     * @param requiredLevel  the level the player must be to use the Leg Armor
     * @param armorType      The type of the Leg Armor
     * @param armorAttribute The attribute of the Leg Armor
     */
    public LegArmor(String name, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, SlotType.Legs, requiredLevel, armorType, armorAttribute);
    }
}
