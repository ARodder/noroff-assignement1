package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LegArmorTest {

    private Armor legArmor;


    /**
     * Builds an Instance of leg armor to test repeatedly.
     */
    @BeforeEach
    void setUp() {
        legArmor = new LegArmor(
                "Gandalf's Pants",
                25,
                ArmorType.Cloth,
                new HeroAttribute(1,1,7));
    }

    /**
     * Test all three attributes have the correct value upon creation.
     */
    @Test
    void testCorrectAttributes() {
        System.out.println("Test correct leg armor attributes...");
        HeroAttribute legsAttributes = legArmor.getArmorAttribute();
        assertEquals(1,legsAttributes.getStrength());
        assertEquals(1,legsAttributes.getDexterity());
        assertEquals(7,legsAttributes.getIntelligence());
    }

    /**
     * Test that the armor piece is created with the correct armorType
     */
    @Test
    void testCorrectArmorType() {
        System.out.println("Test correct leg armor type...");
        assertEquals(ArmorType.Cloth,legArmor.getArmorType());
    }

    /**
     * Test the armor piece is created with correct name.
     */
    @Test
    void testCorrectName() {
        System.out.println("Test correct name for leg armor...");
        assertEquals("Gandalf's Pants",legArmor.getName());
    }

    /**
     * Test The armor piece is created with correct slot.
     */
    @Test
    void testCorrectSlot() {
        System.out.println("Test correct slot for leg armor...");
        assertEquals(SlotType.Legs,legArmor.getSlot());
    }

    /**
     * Test the armor piece is created with correct level requirement.
     */
    @Test
    void testCorrectRequiredLevel() {
        System.out.println("Test correct required level for leg armor...");
        assertEquals(25,legArmor.getRequiredLevel());
    }
}