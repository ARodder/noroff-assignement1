package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyArmorTest {
    private Armor bodyArmor;
    @BeforeEach
    void setUp() {
        bodyArmor = new BodyArmor(
                "Ferrin's Jacket",
                20,
                ArmorType.Leather,
                new HeroAttribute(3,5,1));
    }

    /**
     * Test all three attributes have the correct value upon creation.
     */
    @Test
    void testCorrectAttributes() {
        System.out.println("Test correct body armor attributes...");
        HeroAttribute bodyAttribute = bodyArmor.getArmorAttribute();
        assertEquals(3,bodyAttribute.getStrength());
        assertEquals(5,bodyAttribute.getDexterity());
        assertEquals(1,bodyAttribute.getIntelligence());
    }

    /**
     * Test that the armor piece is created with the correct armorType
     */
    @Test
    void testCorrectArmorType() {
        System.out.println("Test correct body armor type...");
        assertEquals(ArmorType.Leather, bodyArmor.getArmorType());
    }

    /**
     * Test the armor piece is created with correct name.
     */
    @Test
    void testCorrectName() {
        System.out.println("Test correct name for body armor...");
        assertEquals("Ferrin's Jacket", bodyArmor.getName());
    }

    /**
     * Test The armor piece is created with correct slot.
     */
    @Test
    void testCorrectSlot() {
        System.out.println("Test correct slot for body armor...");
        assertEquals(SlotType.Body, bodyArmor.getSlot());
    }

    /**
     * Test the armor piece is created with correct level requirement.
     */
    @Test
    void testCorrectRequiredLevel() {
        System.out.println("Test correct required level for body armor...");
        assertEquals(20, bodyArmor.getRequiredLevel());
    }
}