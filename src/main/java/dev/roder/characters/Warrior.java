package dev.roder.characters;

import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Warrior extends Hero{


    public Warrior(String name) {

        super(name,
                5,
                2,
                1,
                new ArrayList<WeaponType>(Arrays.asList(WeaponType.Axe,WeaponType.Hammer,WeaponType.Sword)),
                new ArrayList<ArmorType>(Arrays.asList(ArmorType.Mail,ArmorType.Plate))
                );
    }

    @Override
    public void levelup() {
        setLevel(getLevel()+1);
        getAttributes().add(3,2,1);
    }

    public double damage(){
        Weapon weapon = (Weapon) getEquipment().get(SlotType.Weapon);
        double mainStat = getAttributes().getStrength();
        if(weapon == null) return 1.0+mainStat/100.0d;
        return weapon.getWeaponDamage()*(1.0+mainStat/100.0d);
    }

}
