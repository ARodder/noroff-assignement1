package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

public class LegArmor extends Armor{
    public LegArmor(String name, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, SlotType.Legs, requiredLevel, armorType, armorAttribute);
    }
}
