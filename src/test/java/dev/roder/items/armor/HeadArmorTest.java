package dev.roder.items.armor;

import dev.roder.characters.HeroAttribute;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.SlotType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeadArmorTest {

    private Armor headArmor;
    @BeforeEach
    void setUp() {
        headArmor = new HeadArmor(
                "Galadriel's Head-piece",
                30,
                ArmorType.Mail,
                new HeroAttribute(5,3,1));
    }

    /**
     * Test all three attributes have the correct value upon creation.
     */
    @Test
    void testCorrectAttributes() {
        System.out.println("Test correct head armor attributes...");
        HeroAttribute headAttributes = headArmor.getArmorAttribute();
        assertEquals(5,headAttributes.getStrength());
        assertEquals(3,headAttributes.getDexterity());
        assertEquals(1,headAttributes.getIntelligence());
    }

    /**
     * Test that the armor piece is created with the correct armorType
     */
    @Test
    void testCorrectArmorType() {
        System.out.println("Test correct head armor type...");
        assertEquals(ArmorType.Mail, headArmor.getArmorType());
    }

    /**
     * Test the armor piece is created with correct name.
     */
    @Test
    void testCorrectName() {
        System.out.println("Test correct name for head armor...");
        assertEquals("Galadriel's Head-piece", headArmor.getName());
    }

    /**
     * Test The armor piece is created with correct slot.
     */
    @Test
    void testCorrectSlot() {
        System.out.println("Test correct slot for head armor...");
        assertEquals(SlotType.Head, headArmor.getSlot());
    }

    /**
     * Test the armor piece is created with correct level requirement.
     */
    @Test
    void testCorrectRequiredLevel() {
        System.out.println("Test correct required level for head armor...");
        assertEquals(30, headArmor.getRequiredLevel());
    }
}