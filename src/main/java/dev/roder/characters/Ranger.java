package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Ranger extends Hero{

    /**
     * Creates a new hero of type Ranger.
     * @param name name of the new hero.
     */
    public Ranger(String name) {

        super(name,
                1,
                7,
                1,
                new ArrayList<WeaponType>(Arrays.asList(WeaponType.Bow)),
                new ArrayList<ArmorType>(Arrays.asList(ArmorType.Mail,ArmorType.Leather))
        );
    }

    /**
     * Levels hero up with the correct attribute increases.
     */
    @Override
    public void levelup() {
        setLevel(getLevel()+1);
        getAttributes().add(1,5,1);
    }

    /**
     * Calculates the damage of the hero, both with and without a weapon.
     * @return total damage of the hero.
     */
    @Override
    public double damage() {
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = totalAttributes().getDexterity();
        if(weapon == null) return 1.0d+mainStat/100.0d;
        return weapon.getWeaponDamage()*(1.0d+mainStat/100.0d);
    }

}
