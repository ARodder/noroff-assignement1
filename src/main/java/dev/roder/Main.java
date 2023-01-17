package dev.roder;

import dev.roder.characters.Hero;
import dev.roder.characters.HeroAttribute;
import dev.roder.characters.Mage;
import dev.roder.characters.Warrior;
import dev.roder.items.armor.Armor;
import dev.roder.items.armor.HeadArmor;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.run();
    }
}