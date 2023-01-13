package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    private Hero ranger;

    @BeforeEach
    void setUp() {
        ranger = new Ranger("Ranger1");
    }

    @Test
    void levelup() {
        assertEquals(1,ranger.getAttributes().getStrength());
        assertEquals(7,ranger.getAttributes().getDexterity());
        assertEquals(1,ranger.getAttributes().getIntelligence());
        ranger.levelup();
        assertEquals(2,ranger.getAttributes().getStrength());
        assertEquals(12,ranger.getAttributes().getDexterity());
        assertEquals(2,ranger.getAttributes().getIntelligence());
    }
}