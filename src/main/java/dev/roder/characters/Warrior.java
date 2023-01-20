package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * The Warrior class extends the abstract class Hero and represents a character
 * that focuses on strength.
 * It has a higher strength stat than other classes, and can use weapons such as
 * Axe, Hammer and Sword.
 * It can also wear Mail and Plate armor types.
 */
public class Warrior extends Hero {

    /**
     * 
     * Constructor for the Warrior class, it calls the super constructor of the Hero
     * class and passes in the name, strength, dexterity and intelligence.
     * It also passes in two ArrayLists, one with the valid weapon types (Axe,
     * Hammer, Sword) and one with the valid armor types (Mail, Plate) that this
     * hero class is able to use.
     * 
     * @param name The name of the Warrior hero.
     */
    public Warrior(String name) {

        super(name,
                5,
                2,
                1,
                new ArrayList<>(Arrays.asList(WeaponType.Axe, WeaponType.Hammer, WeaponType.Sword)),
                new ArrayList<>(Arrays.asList(ArmorType.Mail, ArmorType.Plate)));
    }

    /**
     * Levels up the hero by increasing the level by 1, increasing the attributes by
     * 3 in strength, 2 in dexterity and 1 in intelligence and max health by 5.
     * Also reset the health to max health.
     */
    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);
        getAttributes().add(3, 2, 1);
        setMaxHealth(getMaxHealth() + 5);
        resetHealth();
    }

    /**
     * Calculates the damage done by the Hero. It takes into account the weapon
     * equipped and the hero's main stat.
     * If no weapon is equipped, it returns a default value based on the hero's main
     * stat.
     * 
     * @return Total damage done by the hero.
     */
    @Override
    public double damage() {
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = totalAttributes().getStrength();
        if (weapon == null)
            return 1.0d + mainStat / 100.0d;
        return weapon.getWeaponDamage() * (1.0d + mainStat / 100.0d);
    }

}
