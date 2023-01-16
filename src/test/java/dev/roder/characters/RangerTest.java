package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangerTest {

    private Hero ranger;

    @BeforeEach
    void setUp() {
        ranger = new Ranger("Legolas");
    }

    @Test
    void rangerCreationTest(){
        System.out.println("Testing hero creation");
        assertEquals("Legolas",ranger.getName());
        assertEquals(1,ranger.getLevel());
        HeroAttribute rangerAttributes = ranger.totalAttributes();
        assertEquals(1,rangerAttributes.getStrength());
        assertEquals(7,rangerAttributes.getDexterity());
        assertEquals(1,rangerAttributes.getIntelligence());

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