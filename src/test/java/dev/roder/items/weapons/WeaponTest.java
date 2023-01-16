package dev.roder.items.weapons;

import dev.roder.items.types.SlotType;
import dev.roder.items.types.WeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    Weapon sword;

    @BeforeEach
    void setUp() {
        sword = new Weapon("Great Sword", 50, WeaponType.Sword,10);
    }

    @Test
    void testCorrectName() {
        System.out.println("Test correct weapon name...");
        assertEquals("Great Sword",sword.getName());
    }

    @Test
    void testCorrectSlotType() {
        System.out.println("Test correct slot...");
        assertEquals(SlotType.Weapon,sword.getSlot());
    }

    @Test
    void testCorrectLevelRequirement() {
        System.out.println("Test correct levelRequirement...");
        assertEquals(50,sword.getRequiredLevel());
    }

    @Test
    void testCorrectWeaponDamage() {
        System.out.println("Test correct weapon damage...");
        assertEquals(10,sword.getWeaponDamage());
    }

    @Test
    void testCorrectWeaponType() {
        System.out.println("Test correct weapon type");
        assertEquals(WeaponType.Sword,sword.getWeaponType());
    }
}