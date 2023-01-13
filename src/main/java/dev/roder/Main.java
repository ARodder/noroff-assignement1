package dev.roder;

import dev.roder.characters.Hero;
import dev.roder.characters.HeroAttribute;
import dev.roder.characters.Mage;
import dev.roder.items.armor.Armor;
import dev.roder.items.armor.HeadArmor;
import dev.roder.items.types.ArmorType;

public class Main {
    public static void main(String[] args) {
        Hero mage = new Mage("mage1");
        Armor helm = new HeadArmor("Helm1",1, ArmorType.Cloth, new HeroAttribute(3,3,10));
        try{
            mage.equip(helm);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(mage.display());
    }
}