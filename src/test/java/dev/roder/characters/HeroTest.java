package dev.roder.characters;

import dev.roder.Exceptions.InvalidWeaponException;
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
        System.out.println("Attempt equip of to high level weapon...");
        Weapon sword = new Weapon("Great sword", 50, WeaponType.Sword,10);
        assertThrows(InvalidWeaponException.class,()->hero.equip(sword));
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
    }

    @Test
    void damageTest() {
    }

    @Test
    void totalAttributesTest() {
    }
}