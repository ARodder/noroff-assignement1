package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.Equipable;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

public class Armor extends Equipable {

    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    public Armor(String name, SlotType slot, int requiredLevel,ArmorType armorType,HeroAttribute armorAttribute) {
        super(name, slot, requiredLevel);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    public ArmorType getArmorType(){
        return armorType;
    }
}
