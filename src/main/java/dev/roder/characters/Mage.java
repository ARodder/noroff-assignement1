package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Mage extends Hero{

    /**
     * Creates a new hero of type Mage.
     * @param name name of the new hero.
     */
    public Mage(String name) {

        super(name,
                1,
                1,
                8,
                new ArrayList<WeaponType>(Arrays.asList(WeaponType.Staff,WeaponType.Wand)),
                new ArrayList<ArmorType>(Arrays.asList(ArmorType.Cloth))
        );
    }

    /**
     * Levels hero up with the correct attribute increases.
     */
    @Override
    public void levelup() {
        setLevel(getLevel()+1);
        getAttributes().add(1,1,5);
    }

    /**
     * Calculates the damage of the hero, both with and without a weapon.
     * @return total damage of the hero.
     */
    @Override
    public double damage() {
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = totalAttributes().getIntelligence();
        if(weapon == null) return 1.0d+mainStat/100.0d;
        return weapon.getWeaponDamage()*(1.0d+mainStat/100.0d);
    }


}
