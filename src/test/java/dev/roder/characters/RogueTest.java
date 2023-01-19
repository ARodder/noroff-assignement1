package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {
    private Hero rogue;

    /**
     * Set up new hero before each test starts.
     */
    @BeforeEach
    void setUp() {
        rogue = new Rogue("Ferrin");
    }

    /**
     * Test that the hero is created with the correct name
     */
    @Test
    void heroNameTest(){
        System.out.println("Test hero is created with correct name...");
        assertEquals("Ferrin", rogue.getName());
    }

    /**
     * Test that the hero is created with the correct level(1).
     */
    @Test
    void initialLevelTest(){
        System.out.println("Test initial hero level...");
        assertEquals(1,rogue.getLevel());
    }

    /**
     * Test that the hero is created with the correct attributes(2,6,1).
     */
    @Test
    void initialAttributeTest(){
        System.out.println("Test initial hero attributes...");
        HeroAttribute rogueAttributes = rogue.totalAttributes();
        assertEquals(2,rogueAttributes.getStrength());
        assertEquals(6,rogueAttributes.getDexterity());
        assertEquals(1,rogueAttributes.getIntelligence());
    }

    /**
     * Test that the hero levels up correctly as rogue.
     */
    @Test
    void levelup() {
        System.out.println("Test rogue leveling up...");
        rogue.levelUp();
        assertEquals(3, rogue.getAttributes().getStrength());
        assertEquals(10, rogue.getAttributes().getDexterity());
        assertEquals(2, rogue.getAttributes().getIntelligence());
    }
}