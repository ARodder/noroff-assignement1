package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.Equipable;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;

public class Armor extends Equipable {

    private ArmorType armorType;
    private HeroAttribute armorAttribute;

    /**
     * Creates a piece of armor
     * @param name name of the armor-
     * @param slot which slot the armor is for.
     * @param requiredLevel required level to use the piece of armor.
     * @param armorType the type of armor.
     * @param armorAttribute the attributes from the armor.
     */
    public Armor(String name, SlotType slot, int requiredLevel,ArmorType armorType,HeroAttribute armorAttribute) {
        super(name, slot, requiredLevel);
        this.armorType = armorType;
        this.armorAttribute = armorAttribute;
    }
    /**
     * Sets the armorType of the armor piece.
     */
    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    /**
     * Retrieves the attributes of the armor.
     * @return attributes of the armor
     */
    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    /**
     * Sets the armorAttributes of the armor piece.
     */
    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    /**
     * Retrieves the type of the armor.
     * @return type of the armor
     */
    public ArmorType getArmorType(){
        return armorType;
    }
}
