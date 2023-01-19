package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * The Rogue class is a subclass of Hero that represents a rogue character in
 * the game.
 * 
 * It has a specific set of weapons and armor types that it can use, determined
 * in the constructor.
 * 
 * Additionally, it overrides the levelUp() and damage() methods to reflect the
 * characteristics of a rogue character.
 */
public class Rogue extends Hero {

    /**
     * 
     * Constructor for creating a new rogue character. It calls the constructor of
     * the superclass Hero with specific parameters for a rogue character.
     * 
     * @param name The name of the rogue character.
     */
    public Rogue(String name) {
        super(name,
                2,
                6,
                1,
                new ArrayList<WeaponType>(Arrays.asList(WeaponType.Dagger, WeaponType.Sword)),
                new ArrayList<ArmorType>(Arrays.asList(ArmorType.Mail, ArmorType.Leather)));
    }

    /**
     * 
     * Overrides the levelUp() method of the superclass Hero to adjust the
     * attributes of a rogue character when they level up.
     * Specifically, it adds 1 point to the character's strength, 4 points to their
     * dexterity, 1 point to their intelligence, and 5 points to their max health.
     */
    @Override
    public void levelUp() {
        setLevel(getLevel()+1);
        getAttributes().add(1,4,1);
        setMaxHealth(getMaxHealth()+5);
        resetHealth();
    }

    /**
     * Overrides the damage() method of the superclass Hero to calculate the damage
     * dealt by a rogue character based on their dexterity and equipped weapon.
     * Specifically, it returns the weapon damage multiplied by 1 plus the
     * character's dexterity divided by 100.
     * If the character has no weapon equipped, it returns 1 plus the character's
     * dexterity divided by 100.
     * 
     * @return The damage dealt by the rogue character.
     */
    @Override
    public double damage() {
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = totalAttributes().getDexterity();
        if (weapon == null)
            return 1.0d + mainStat / 100.0d;
        return weapon.getWeaponDamage() * (1.0d + mainStat / 100.0d);
    }
}
