package dev.roder.items.weapons;

import dev.roder.items.Equippable;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;

public class Weapon extends Equippable {
    private WeaponType weaponType;
    private double weaponDamage;

    public Weapon(String name, int requiredLevel,WeaponType weaponType,double weaponDamage) {
        super(name, SlotType.Weapon, requiredLevel);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType(){
        return this.weaponType;
    }
}
