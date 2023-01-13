package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RogueTest {
    private Hero rogue;

    @BeforeEach
    void setUp() {
        rogue = new Rogue("Rogue1");
    }

    @Test
    void levelup() {
        assertEquals(2, rogue.getAttributes().getStrength());
        assertEquals(6, rogue.getAttributes().getDexterity());
        assertEquals(1, rogue.getAttributes().getIntelligence());
        rogue.levelup();
        assertEquals(3, rogue.getAttributes().getStrength());
        assertEquals(10, rogue.getAttributes().getDexterity());
        assertEquals(2, rogue.getAttributes().getIntelligence());
    }
}