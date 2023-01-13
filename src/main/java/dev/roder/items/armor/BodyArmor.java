package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

public class BodyArmor extends Armor{
    public BodyArmor(String name, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, SlotType.Body, requiredLevel, armorType, armorAttribute);
    }
}
