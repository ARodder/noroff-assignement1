package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    private Hero ranger;
    /**
     * Set up new hero before each test starts.
     */
    @BeforeEach
    void setUp() {
        ranger = new Ranger("Legolas");
    }

    /**
     * Test that the hero is created with the correct name
     */
    @Test
    void heroNameTest(){
        System.out.println("Test hero is created with correct name...");
        assertEquals("Legolas", ranger.getName());
    }

    /**
     * Test that the hero is created with the correct level(1).
     */
    @Test
    void initialLevelTest(){
        System.out.println("Test initial hero level...");
        assertEquals(1,ranger.getLevel());
    }

    /**
     * Test that the hero is created with the correct attributes(1,7,1).
     */
    @Test
    void initialAttributeTest(){
        System.out.println("Test initial hero attributes...");
        HeroAttribute rangerAttributes = ranger.totalAttributes();
        assertEquals(1,rangerAttributes.getStrength());
        assertEquals(7,rangerAttributes.getDexterity());
        assertEquals(1,rangerAttributes.getIntelligence());
    }

    /**
     * Test that the hero levels up correctly as ranger.
     */
    @Test
    void levelup() {
        System.out.println("Test ranger level up...");
        ranger.levelUp();
        assertEquals(2,ranger.getAttributes().getStrength());
        assertEquals(12,ranger.getAttributes().getDexterity());
        assertEquals(2,ranger.getAttributes().getIntelligence());
    }
}