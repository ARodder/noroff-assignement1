package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * The mage class is a subclass of Hero that represents a mage character in
 * the game.
 * 
 * It has a specific set of weapons and armor types that it can use, determined
 * in the constructor.
 * 
 * Additionally, it overrides the levelUp() and damage() methods to reflect the
 * characteristics of a mage character.
 */
public class Mage extends Hero {

    /**
     * 
     * Constructor for creating a new mage character. It calls the constructor of
     * the superclass Hero with specific parameters for a mage character.
     * 
     * @param name The name of the mage character.
     */
    public Mage(String name) {

        super(name,
                1,
                1,
                8,
                new ArrayList<WeaponType>(Arrays.asList(WeaponType.Staff, WeaponType.Wand)),
                new ArrayList<ArmorType>(Arrays.asList(ArmorType.Cloth)));
    }

    /**
     * Overrides the levelUp() method of the superclass Hero to adjust the
     * attributes of a mage character when they level up.
     * Specifically, it adds 1 point to the character's strength, 1 points to their
     * dexterity, 5 point to their intelligence, and 5 points to their max health.
     */
    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);
        getAttributes().add(1, 1, 5);
        setMaxHealth(getMaxHealth() + 5);
        resetHealth();
    }

    /**
     * Overrides the damage() method of the superclass Hero to calculate the damage
     * dealt by a mage character based on their intelligence and equipped weapon.
     * Specifically, it returns the weapon damage multiplied by 1 plus the
     * character's intelligence divided by 100.
     * If the character has no weapon equipped, it returns 1 plus the character's
     * intelligence divided by 100.
     * 
     * @return The damage dealt by the mage character.
     */
    @Override
    public double damage() {
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = totalAttributes().getIntelligence();
        if (weapon == null)
            return 1.0d + mainStat / 100.0d;
        return weapon.getWeaponDamage() * (1.0d + mainStat / 100.0d);
    }

}
