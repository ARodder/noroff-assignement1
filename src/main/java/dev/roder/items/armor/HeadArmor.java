package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

public class HeadArmor extends Armor{
    public HeadArmor(String name, int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, SlotType.Head, requiredLevel,armorType,armorAttribute);
    }
}
