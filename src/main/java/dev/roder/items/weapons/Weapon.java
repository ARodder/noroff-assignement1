package dev.roder.items.weapons;

import dev.roder.items.Equipable;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;

public class Weapon extends Equipable {
    private WeaponType weaponType;
    private double weaponDamage;

    /**
     * This is the constructor for the Weapon class.
     * It takes in 4 parameters and assigns them to the instance variables.
     * It calls the super class' constructor to set the name, slot and required
     * level.
     * 
     * @param name          The name of the weapon
     * @param requiredLevel the level the player must be to use the weapon
     * @param weaponType    The type of the weapon
     * @param weaponDamage  The damage the weapon deals
     */
    public Weapon(String name, int requiredLevel, WeaponType weaponType, double weaponDamage) {
        super(name, SlotType.Weapon, requiredLevel);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    /**
     * Sets the type of the weapon.
     */
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    /**
     * Retrieves the damage of the weapon.
     * 
     * @return damage of the weapon
     */
    public double getWeaponDamage() {
        return weaponDamage;
    }

    /**
     * Sets the damage of the weapon.
     */
    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    /**
     * Retrieves the type of the weapon.
     * 
     * @return type of the weapon
     */
    public WeaponType getWeaponType() {
        return this.weaponType;
    }
}
