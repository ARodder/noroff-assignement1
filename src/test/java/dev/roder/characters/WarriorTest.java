package dev.roder.characters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private Hero warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Galadriel");
    }

    @Test
    void heroCreationTest(){
        System.out.println("Testing hero creation");
        assertEquals("Galadriel",warrior.getName());
        assertEquals(1,warrior.getLevel());
        HeroAttribute rangerAttributes = warrior.totalAttributes();
        assertEquals(5,rangerAttributes.getStrength());
        assertEquals(2,rangerAttributes.getDexterity());
        assertEquals(1,rangerAttributes.getIntelligence());
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