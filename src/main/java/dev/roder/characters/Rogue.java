package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Rogue extends Hero{

    public Rogue(String name) {
        super(name,
                2,
                6,
                1,
                new ArrayList<WeaponType>(Arrays.asList(WeaponType.Dagger,WeaponType.Sword)),
                new ArrayList<ArmorType>(Arrays.asList(ArmorType.Mail,ArmorType.Leather))
        );
    }

    @Override
    public void levelup() {
        setLevel(getLevel()+1);
        getAttributes().add(1,4,1);
    }

    @Override
    public double damage() {
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = totalAttributes().getDexterity();
        if(weapon == null) return 1.0d+mainStat/100.0d;
        return weapon.getWeaponDamage()*(1.0d+mainStat/100.0d);
    }
}
