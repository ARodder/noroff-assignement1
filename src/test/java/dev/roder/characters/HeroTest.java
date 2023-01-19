package dev.roder.characters;

import dev.roder.Exceptions.InvalidArmorException;
import dev.roder.Exceptions.InvalidWeaponException;
import dev.roder.items.armor.Armor;
import dev.roder.items.armor.BodyArmor;
import dev.roder.items.armor.HeadArmor;
import dev.roder.items.armor.LegArmor;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    Hero hero;

    /**
     * Set up a hero to repeatedly run test.
     */
    @BeforeEach
    void setUp() {
        //Create any character for testing, for example warrior:
        hero = new Warrior("Isildur");
    }

    /**
     * Test equipping to high levelRequirement weapon.
     */
    @Test
    void highLevelWeaponTest(){
        System.out.println("Attempt equip of too high level weapon...");
        Weapon sword = new Weapon("Great sword", 50, WeaponType.Sword,10);
        //checks that the correct exception is thrown when attempting to equip a weapon with too high levelRequirement.
        assertThrows(InvalidWeaponException.class,()->hero.equip(sword));
        //Checks that the weapon didn't get equipped even when the exception was thrown.
        assertNull(hero.getEquipment().get(SlotType.Weapon));
    }

    /**
     * Test equipping wrong weaponType weapon.
     */
    @Test
    void wrongWeaponTypeTest(){
        System.out.println("Attempt equip wrong weapon type...");
        Weapon staff = new Weapon("Gandalf's staff", 1,WeaponType.Staff,5);
        //checks that the correct exception is thrown when attempting to equip wrong weaponType.
        assertThrows(InvalidWeaponException.class,()-> hero.equip(staff));
        //Checks that the weapon didn't get equipped even when the exception was thrown.
        assertNull(hero.getEquipment().get(SlotType.Weapon));
    }




    /**
     * Test equipping valid weapon.
     */
    @Test
    void equipWeaponTest() {
        Weapon sword = new Weapon("Great sword", 50, WeaponType.Sword,10);
        for(int i =1;i<50;i++)hero.levelUp();
        System.out.println("Attempt equip valid weapon...");
        try{
        hero.equip(sword);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Checks if the damage with the weapon equipped is correct by using the same formula as inside the class.
        assertEquals(sword.getWeaponDamage()*(1+hero.totalAttributes().getStrength()/100.0d),hero.damage());
    }

    /**
     * Test damage when weapon is equipped, and then switched.
     */

    @Test
    void switchWeaponTest(){
        System.out.println("Test switching from one weapon to another");
        Weapon sword = new Weapon("Great sword", 1, WeaponType.Sword,10);
        try{
            hero.equip(sword);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Weapon axe = new Weapon("Berserker's Axe", 1,WeaponType.Axe,7);
        try{
            hero.equip(axe);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(axe.getWeaponDamage()*(1+hero.totalAttributes().getStrength()/100.0d),hero.damage());

    }

    /**
     * Test equip too high levelRequirement armor
     */
    @Test
    void equipHighLevelArmorTest(){
        System.out.println("Attempt to equip too high level armor...");

        Armor chest = new BodyArmor("Galadriel's chest piece",50,ArmorType.Mail,new HeroAttribute(10,3,2));
        //checks that the correct exception is thrown when attempting to equip an armor piece with too high levelRequirement.
        assertThrows(InvalidArmorException.class,()->hero.equip(chest));
        //Checks that the chest didn't get equipped even when the exception was thrown.
        assertNull(hero.getEquipment().get(SlotType.Body));
    }

    /**
     * Test equipping wrong armorType.
     */
    @Test
    void equipWrongArmorTypeTest(){
        System.out.println("Attempt equip wrong armor type...");

        Armor helm = new HeadArmor("Grey Magic Hat",1, ArmorType.Cloth, new HeroAttribute(3,3,10));
        //checks that the correct exception is thrown when attempting to equip wrong armorType.
        assertThrows(InvalidArmorException.class,()-> hero.equip(helm));
        //Checks that the helm didn't get equipped even when the exception was thrown.
        assertNull(hero.getEquipment().get(SlotType.Head));
    }

    /**
     * Test equipping valid armor
     */
    @Test
    void equipArmorTest() {
        Armor chest = new BodyArmor("Galadriel's chest piece",50,ArmorType.Mail,new HeroAttribute(10,3,2));

        for(int i =1;i<50;i++)hero.levelUp();

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

    /**
     * Test damage when both a weapon and a piece of armor is equipped.
     */
    @Test
    void armorWeaponDamageTest(){
        System.out.println("Test damage with armor weapon combination...");
        Armor chest = new BodyArmor("Galadriel's chest piece",1,ArmorType.Mail,new HeroAttribute(10,3,2));
        Weapon sword = new Weapon("Great sword", 1, WeaponType.Sword,10);

        try{
            hero.equip(chest);
            hero.equip(sword);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        assertEquals(hero.getEquipment().get(SlotType.Body), chest);
        assertEquals(hero.getEquipment().get(SlotType.Weapon), sword);

        assertEquals(sword.getWeaponDamage()*(1.0d+hero.totalAttributes().getStrength()/100.0d),hero.damage());
    }

    /**
     * Test the damage calculation is correct without a weapon.
     */
    @Test
    void baseDamageTest(){
        System.out.println("Test damage with no weapon...");
        //Uses the formula to calculate the expected damage, using strength since this is warrior class hero.
        assertEquals((1.0d+hero.totalAttributes().getStrength()/100.0d),hero.damage());
    }

    /**
     * Test the damage calculation is correct with a weapon.
     */
    @Test
    void weaponDamageTest() {
        System.out.println("Test damage with weapon...");
        Weapon sword = new Weapon("Great sword", 1, WeaponType.Sword,5);

        try{
            hero.equip(sword);
        }catch (InvalidWeaponException e){
            System.out.println(e.getMessage());
        }
        assertEquals(sword.getWeaponDamage()*(1.0d+hero.totalAttributes().getStrength()/100.0d),hero.damage());
    }

    /**
     * Test that the total attribute calculations are correct with and without a single armor piece.
     */
    @Test
    void totalAttributesTest() {
        System.out.println("Test hero attributes with armor piece...");
        Armor chest = new BodyArmor("Galadriel's chest piece",1,ArmorType.Mail,new HeroAttribute(3,3,3));
        try{
            hero.equip(chest);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Checking that all the heroAttributes are correct.
        HeroAttribute totalAttributes = hero.totalAttributes();
        assertEquals(8,totalAttributes.getStrength());
        assertEquals(5,totalAttributes.getDexterity());
        assertEquals(4,totalAttributes.getIntelligence());

    }

    /**
     * Test equipping multiple armor pieces
     */
    @Test
    void equipMultipleArmorPieceTest() {
        System.out.println("Test multiple armor piece equipped...");
        Armor legPiece = new LegArmor(
                "Galadriel's leg-armor",
                1,
                ArmorType.Mail,
                new HeroAttribute(5, 5, 1));
        Armor chestPiece = new BodyArmor(
                "Galadriel's chest piece",
                1,
                ArmorType.Mail,
                new HeroAttribute(3, 3, 3));

        try {
            hero.equip(legPiece);
            hero.equip(chestPiece);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        //Checks that the recently created chest and leg armor has been placed in the hero's slots.
        assertEquals(hero.getEquipment().get(SlotType.Body), chestPiece);
        assertEquals(hero.getEquipment().get(SlotType.Legs), legPiece);

        //Checks that the attributes have been properly applied and calculated. Where the
        //expected numbers are the sum of the armor piece attributes and the base hero attributes.
        HeroAttribute totalAttributes = hero.totalAttributes();
        assertEquals(13, totalAttributes.getStrength());
        assertEquals(10, totalAttributes.getDexterity());
        assertEquals(5, totalAttributes.getIntelligence());

    }

    /**
     * Test switching different armor pieces still gives correct attributes and correct piece replacement.
     */
    @Test
    void switchArmorPieceTest(){
        System.out.println("Test switching armor");
        Armor legPiece = new LegArmor(
                "Galadriel's leg-armor",
                1,
                ArmorType.Mail,
                new HeroAttribute(5, 5, 1));
        Armor chestPiece = new BodyArmor(
                "Galadriel's chest piece",
                1,
                ArmorType.Mail,
                new HeroAttribute(3, 3, 3));

        try {
            hero.equip(legPiece);
            hero.equip(chestPiece);
        } catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }


        Armor newChest = new BodyArmor(
                "Orcish plate armor chest",
                1,
                ArmorType.Plate,
                new HeroAttribute(7,3,1));

        try{
            hero.equip(newChest);
        }catch(InvalidArmorException e){
            System.out.println(e.getMessage());
        }
        //Checks that the recently created chest and leg armor has been placed in the hero's slot.
        assertEquals(hero.getEquipment().get(SlotType.Body), newChest);

        //Checks that the attributes have been properly applied and calculated.
        HeroAttribute totalAttributes = hero.totalAttributes();
        assertEquals(17,totalAttributes.getStrength());
        assertEquals(10,totalAttributes.getDexterity());
        assertEquals(3,totalAttributes.getIntelligence());
    }

}