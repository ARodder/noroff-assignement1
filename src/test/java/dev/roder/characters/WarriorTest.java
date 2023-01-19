package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private Hero warrior;
    /**
     * Set up new hero before each test starts.
     */
    @BeforeEach
    void setUp() {
        warrior = new Warrior("Galadriel");
    }
    /**
     * Test that the hero is created with the correct name
     */
    @Test
    void heroNameTest(){
        System.out.println("Test hero is created with correct name...");
        assertEquals("Galadriel", warrior.getName());
    }

    /**
     * Test that the hero is created with the correct level(1).
     */
    @Test
    void initialLevelTest(){
        System.out.println("Test initial hero level...");
        assertEquals(1,warrior.getLevel());
    }

    /**
     * Test that the hero is created with the correct attributes(5,2,1).
     */
    @Test
    void initialAttributeTest(){
        System.out.println("Test initial hero attributes...");
        HeroAttribute warriorAttributes = warrior.totalAttributes();
        assertEquals(5,warriorAttributes.getStrength());
        assertEquals(2,warriorAttributes.getDexterity());
        assertEquals(1,warriorAttributes.getIntelligence());
    }

    /**
     * Test that the hero levels up correctly as rogue.
     */
    @Test
    void levelup() {
        System.out.println("Test warrior leveling up...");
        warrior.levelUp();
        assertEquals(8, warrior.getAttributes().getStrength());
        assertEquals(4, warrior.getAttributes().getDexterity());
        assertEquals(2, warrior.getAttributes().getIntelligence());
    }
}