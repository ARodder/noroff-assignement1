package dev.roder.characters;

import dev.roder.Exceptions.InvalidArmorException;
import dev.roder.Exceptions.InvalidWeaponException;
import dev.roder.items.Equippable;
import dev.roder.items.armor.Armor;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An abstract class of heroes containing all the common fields for all heroes.
 */
public abstract class Hero {
    private String name;
    private int level;
    private HeroAttribute attributes;
    private HashMap<SlotType,Equippable> equipment;
    private ArrayList<WeaponType> validWeaponTypes;
    private ArrayList<ArmorType> validArmorTypes;

    public Hero(String name, int strength, int dexterity, int intelligence, ArrayList<WeaponType> validWeaponTypes, ArrayList<ArmorType> validArmorTypes) {
        this.name = name;
        this.level = 1;
        this.attributes = new HeroAttribute(strength,dexterity,intelligence);
        this.equipment = new HashMap<>();
        equipment.put(SlotType.Weapon,null);
        equipment.put(SlotType.Head,null);
        equipment.put(SlotType.Body,null);
        equipment.put(SlotType.Legs,null);
        this.validWeaponTypes = validWeaponTypes;
        this.validArmorTypes = validArmorTypes;
    }

    /**
     * Levels up character, abstract since different classes does not level up the same way.
     */
    public abstract void levelup();

    /**
     * Equips a new weapon if the weapon is a valid weapon for the hero type, nad the hero is at or above the required level.
     * @param newWeapon new weapon to equip on the hero.
     */
    public void equip(Weapon newWeapon) throws InvalidWeaponException {
        if(!this.validWeaponTypes.contains(newWeapon.getWeaponType())) throw new InvalidWeaponException("The type of weapon can not be used on this type of hero");
        if(this.level >= newWeapon.getRequiredLevel()) throw new InvalidWeaponException("Your hero is not high enough level for this weapon yet");
        equipment.put(SlotType.Weapon,newWeapon);

    }


    /**
     * Equips a new armor-piece if the piece is valid for the hero type, and the hero is at or above the required level.
     * Also determines the slot for the armor-piece.
     * @param newArmor new armor-piece to equip on the hero.
     */
    public void equip(Armor newArmor) throws InvalidArmorException {
        if(!this.validArmorTypes.contains(newArmor.getArmorType())) throw new InvalidArmorException("The type of armor can not be used on this type of hero");
        if(!(this.level >= newArmor.getRequiredLevel())) throw new InvalidArmorException("Your hero is not high enough level for this armor yet");

        switch (newArmor.getSlot()) {
            case Head -> equipment.put(SlotType.Head, newArmor);
            case Body -> equipment.put(SlotType.Body, newArmor);
            case Legs -> equipment.put(SlotType.Legs, newArmor);
            default -> {
            }
        }
    }

    //TODO:Calculate total damage done by hero.
    /**
     * Calculates the damage done by the Hero.
     * @return Total damage done by the hero.
     */
    public abstract double damage();

    //TODO: Add  logic to calculate total attributes of hero

    /**
     * Calculates the total attributes of a hero.
     * @return Total attributes.
     */
    public HeroAttribute totalAttributes(){
        HeroAttribute[] gear = new HeroAttribute[] {
                        equipment.get(SlotType.Head)!= null ?((Armor)equipment.get(SlotType.Head)).getArmorAttribute():null,
                        equipment.get(SlotType.Body)!= null ?((Armor)equipment.get(SlotType.Body)).getArmorAttribute():null,
                        equipment.get(SlotType.Legs)!= null ?((Armor)equipment.get(SlotType.Legs)).getArmorAttribute():null
                };

        //Adding multiple HeroAttributes together by nesting the add function.
        return this.attributes.add(gear);
    }

    /**
     * Builds a String with all details of the hero.
     * @return string of hero details.
     */

    public String display() {

            StringBuilder builder = new StringBuilder();
            builder.append("Name: " +this.name+ "\n");
            builder.append("Level: "+ this.level+"\n");
            builder.append("Total damage: " + damage());
            builder.append("Total attributes: \n" + totalAttributes().toString());
            builder.append("Equipment: \n");
            builder.append("     Weapon: "+(equipment.get(SlotType.Weapon) == null ? "none" :equipment.get(SlotType.Weapon).getName())+"\n");
            builder.append("     Head: "+ (equipment.get(SlotType.Head) == null ? "none" : equipment.get(SlotType.Head).getName())+"\n");
            builder.append("     Body: "+(equipment.get(SlotType.Body) == null ? "none" : equipment.get(SlotType.Body).getName())+"\n");
            builder.append("     Legs: "+(equipment.get(SlotType.Legs) == null ? "none" : equipment.get(SlotType.Legs).getName())+"\n");


            return  builder.toString();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HeroAttribute getAttributes() {
        return attributes;
    }

    public void setAttributes(HeroAttribute attributes) {
        this.attributes = attributes;
    }

    public HashMap<SlotType, Equippable> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashMap<SlotType, Equippable> equipment) {
        this.equipment = equipment;
    }
}
