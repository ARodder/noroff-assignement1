package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Hero mage;
    @BeforeEach
    void setUp() {
        mage = new Mage("Gandalf");
    }

    @Test
    void heroCreationTest(){
        System.out.println("Testing hero creation");
        assertEquals("Gandalf",mage.getName());
        assertEquals(1,mage.getLevel());
        HeroAttribute rangerAttributes = mage.totalAttributes();
        assertEquals(1,rangerAttributes.getStrength());
        assertEquals(1,rangerAttributes.getDexterity());
        assertEquals(8,rangerAttributes.getIntelligence());

    }

    @Test
    void levelup() {
        //Pre-level test.
        assertEquals(1,mage.getAttributes().getStrength());
        assertEquals(1,mage.getAttributes().getDexterity());
        assertEquals(8,mage.getAttributes().getIntelligence());
        mage.levelup();
        //Post-level test.
        assertEquals(2,mage.getAttributes().getStrength());
        assertEquals(2,mage.getAttributes().getDexterity());
        assertEquals(13,mage.getAttributes().getIntelligence());
    }
}