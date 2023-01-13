package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {
    private Hero mage;
    @BeforeEach
    void setUp() {
        mage = new Mage("Mage1");
    }

    @Test
    void levelup() {
        //Pre-level test.
        assertEquals(1,mage.getAttributes().getStrength());
        assertEquals(1,mage.getAttributes().getDexterity());
        assertEquals(8,mage.getAttributes().getIntelligence());
        mage.levelup();
        assertEquals(2,mage.getAttributes().getStrength());
        assertEquals(2,mage.getAttributes().getDexterity());
        assertEquals(13,mage.getAttributes().getIntelligence());
    }
}