package dev.roder.characters;

import dev.roder.Exceptions.InvalidArmorException;
import dev.roder.Exceptions.InvalidWeaponException;
import dev.roder.items.armor.Armor;
import dev.roder.items.armor.BodyArmor;
import dev.roder.items.armor.HeadArmor;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Hero hero;
    @BeforeEach
    void setUp() {
        //Create any character for testing, for example warrior:
        hero = new Warrior("Isildur");
    }

    @Test
    void equipWeaponTest() {
        System.out.println("Attempt equip of too high level weapon...");
        Weapon sword = new Weapon("Great sword", 50, WeaponType.Sword,10);
        //checks that the correct exception is thrown when attempting to equip a weapon with too high levelRequirement.
        assertThrows(InvalidWeaponException.class,()->hero.equip(sword));
        assertEquals(1.05,hero.damage());

        System.out.println("Attempt equip wrong weapon type...");
        Weapon staff = new Weapon("Gandalf's staff", 1,WeaponType.Staff,5);
        //checks that the correct exception is thrown when attempting to equip wrong weaponType.
        assertThrows(InvalidWeaponException.class,()-> hero.equip(staff));
        assertEquals(1.05,hero.damage());


        for(int i =1;i<50;i++)hero.levelup();

        System.out.println("Attempt equip valid weapon...");
        try{
        hero.equip(sword);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Checks if the damage with the weapon equipped is correct by using the same formula as inside the class.
        assertEquals(sword.getWeaponDamage()*(1+hero.totalAttributes().getStrength()/100.0d),hero.damage());


    }

    @Test
    void equipArmorTest() {
        System.out.println("Attempt to equip too high level armor...");

        Armor chest = new BodyArmor("Galadriel's chest piece",50,ArmorType.Mail,new HeroAttribute(10,3,2));
        //checks that the correct exception is thrown when attempting to equip an armor piece with too high levelRequirement.
        assertThrows(InvalidArmorException.class,()->hero.equip(chest));
        assertEquals(1.05,hero.damage());

        System.out.println("Attempt equip wrong armor type...");

        Armor helm = new HeadArmor("Grey Magic Hat",1, ArmorType.Cloth, new HeroAttribute(3,3,10));
        //checks that the correct exception is thrown when attempting to equip wrong armorType.
        assertThrows(InvalidArmorException.class,()-> hero.equip(helm));
        assertEquals(1.05,hero.damage());

        for(int i =1;i<50;i++)hero.levelup();

        System.out.println("Attempt equip valid weapon...");
        try{
            hero.equip(chest);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Checks if attributes are as expected after leveling and adding an armor piece.
        HeroAttribute totalAttributes = hero.totalAttributes();
        assertEquals(162,totalAttributes.getStrength());
        assertEquals(103,totalAttributes.getDexterity());
        assertEquals(52,totalAttributes.getIntelligence());

    }

    @Test
    void damageTest() {
        System.out.println("Test damage with no weapon...");
        assertEquals(1.05,hero.damage());

        System.out.println("Test damage with weapon...");
        Weapon sword = new Weapon("Great sword", 1, WeaponType.Sword,5);

        try{
            hero.equip(sword);
        }catch (InvalidWeaponException e){
            System.out.println(e.getMessage());
        }
        assertEquals(sword.getWeaponDamage()*(1.0d+hero.totalAttributes().getStrength()/100.0d),hero.damage());
    }

    @Test
    void totalAttributesTest() {
        System.out.println("Test base hero attributes...");

        HeroAttribute totalAttributes = hero.getAttributes();
        assertEquals(5,totalAttributes.getStrength());
        assertEquals(2,totalAttributes.getDexterity());
        assertEquals(1,totalAttributes.getIntelligence());

        System.out.println("Test hero attributes with armor piece...");
        Armor chest = new BodyArmor("Galadriel's chest piece",1,ArmorType.Mail,new HeroAttribute(3,3,3));
        try{
            hero.equip(chest);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        totalAttributes = hero.totalAttributes();
        assertEquals(8,totalAttributes.getStrength());
        assertEquals(5,totalAttributes.getDexterity());
        assertEquals(4,totalAttributes.getIntelligence());

    }
}