package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

/**
 * This is the class representing the Body Armor.
 * It is a subclass of the Armor class and has a constructor that
 * creates an Armor piece with body as the SlotType
 */
public class BodyArmor extends Armor{
    public BodyArmor(String name, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, SlotType.Body, requiredLevel, armorType, armorAttribute);
    }
}
