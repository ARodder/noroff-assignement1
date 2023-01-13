package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private Hero warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("warrior1");
    }

    @Test
    void levelup() {
        assertEquals(5, warrior.getAttributes().getStrength());
        assertEquals(2, warrior.getAttributes().getDexterity());
        assertEquals(1, warrior.getAttributes().getIntelligence());
        warrior.levelup();
        assertEquals(8, warrior.getAttributes().getStrength());
        assertEquals(4, warrior.getAttributes().getDexterity());
        assertEquals(2, warrior.getAttributes().getIntelligence());
    }
}