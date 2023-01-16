package dev.roder;

import dev.roder.characters.Hero;
import dev.roder.characters.HeroAttribute;
import dev.roder.characters.Mage;
import dev.roder.characters.Warrior;
import dev.roder.items.armor.Armor;
import dev.roder.items.armor.HeadArmor;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

public class Main {
    public static void main(String[] args) {
        Hero mage = new Mage("Gandalf The Grey");
        Hero warrior = new Warrior("Galadriel");
        Armor helm = new HeadArmor("Grey Magic Hat",50, ArmorType.Cloth, new HeroAttribute(3,3,10));
        Weapon staff = new Weapon("Gandalf's staff",99, WeaponType.Staff,50);
        //for(int i=1;i<50;i++)warrior.levelup();
        try{
            //mage.equip(helm);
            //mage.equip(staff);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(warrior.display());
    }
}