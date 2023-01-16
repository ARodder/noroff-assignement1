package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Hero mage;

    /**
     * Set up new hero before each test starts.
     */
    @BeforeEach
    void setUp() {
        mage = new Mage("Gandalf");
    }

    /**
     * Test that the hero is created with the correct name
     */
    @Test
    void heroNameTest(){
        System.out.println("Test hero is created with correct name...");
        assertEquals("Gandalf", mage.getName());
    }

    /**
     * Test that the hero is created with the correct level(1).
     */
    @Test
    void initialLevelTest(){
        System.out.println("Test initial hero level...");
        assertEquals(1,mage.getLevel());
    }

    /**
     * Test that the hero is created with the correct attributes(1,1,8).
     */
    @Test
    void initialAttributeTest(){
        System.out.println("Test initial hero attributes...");
        HeroAttribute mageAttributes = mage.totalAttributes();
        assertEquals(1,mageAttributes.getStrength());
        assertEquals(1,mageAttributes.getDexterity());
        assertEquals(8,mageAttributes.getIntelligence());
    }

    /**
     * Test that the hero levels up correctly as mage.
     */
    @Test
    void levelup() {
        System.out.println("Test mage level up...");
        mage.levelup();
        //Post-level test.
        assertEquals(2,mage.getAttributes().getStrength());
        assertEquals(2,mage.getAttributes().getDexterity());
        assertEquals(13,mage.getAttributes().getIntelligence());
    }
}