package dev.roder;

import dev.roder.characters.*;
import dev.roder.items.Equipable;
import dev.roder.items.armor.Armor;
import dev.roder.items.armor.BodyArmor;
import dev.roder.items.armor.HeadArmor;
import dev.roder.items.armor.LegArmor;
import dev.roder.items.types.ArmorType;
import dev.roder.items.types.WeaponType;
import dev.roder.items.weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private Scanner sc;
    private Hero hero;
    private Hero enemy;
    private Random random;
    private ArrayList<Equipable> availableDrops;

    /**
     * Creates instance of Engine, initializing scanner and random number generator.
     */
    public Engine() {
        sc = new Scanner(System.in);
        random = new Random();
        availableDrops = new ArrayList<>();
        fillAvailableDrops();
    }


    private void fillAvailableDrops() {
        //Different pieces of head armor.
        availableDrops.add(new HeadArmor("Common cloth head armor", 1 , ArmorType.Cloth, new HeroAttribute(1, 2, 7)));
        availableDrops.add(new HeadArmor("Common leather head armor", 1 , ArmorType.Leather, new HeroAttribute(2, 7, 1)));
        availableDrops.add(new HeadArmor("Common leather head armor", 1 , ArmorType.Mail, new HeroAttribute(8, 1, 1)));

        //Different pieces of body armor
        availableDrops.add(new BodyArmor("Common cloth body armor", 1 , ArmorType.Cloth, new HeroAttribute(1, 2, 7)));
        availableDrops.add(new BodyArmor("Common leather body armor", 1 , ArmorType.Leather, new HeroAttribute(2, 7, 1)));
        availableDrops.add(new BodyArmor("Common leather body armor", 1 , ArmorType.Mail, new HeroAttribute(8, 1, 1)));

        //Different pieces of leg armor
        availableDrops.add(new LegArmor("Common cloth leg armor", 1 , ArmorType.Cloth, new HeroAttribute(1, 2, 7)));
        availableDrops.add(new LegArmor("Common leather leg armor", 1 , ArmorType.Leather, new HeroAttribute(2, 7, 1)));
        availableDrops.add(new LegArmor("Common leather leg armor", 1 , ArmorType.Mail, new HeroAttribute(8, 1, 1)));

        availableDrops.add(new Weapon("Rotten old staff", 1, WeaponType.Staff, 5));
        availableDrops.add(new Weapon("Rotten old bow", 1, WeaponType.Bow, 5));
        availableDrops.add(new Weapon("Rusty old sword", 1, WeaponType.Sword, 5));
    }




    /**
     * This method runs the game loop and controls the flow of the game.
     * It uses a while loop to keep the game running and a switch statement to
     * handle the player's input from the main menu.
     * The options in the switch statement include: starting a new game, continuing
     * a previous game and quitting the game.
     * If the player chooses to start a new game, the character creation process is
     * started and then the main game loop is executed.
     * If the player chooses to continue, the main game loop is executed only if a
     * hero already exist.
     */
    public void run() {
        boolean running = true;
        while (running) {
            switch (initialGameState()) {
                case 1 -> {
                    // Starts Character creation.
                    characterCreation();
                    // Starts the main game loop
                    gameLoop();
                }
                case 2 -> {
                    // Checks if a hero exist, if it does the game continues.
                    if (hero != null)
                        gameLoop();
                    else
                        System.out.println("You have not created a hero, please start with that");
                }
                case 3 -> System.out.println("Not yet implemented");
                case 4 -> running = false;
                default -> System.out.println("Not a valid input, please try again");
            }
        }

    }

    /**
     * This method displays the main menu options to the player and prompts them to
     * select an option.
     * It returns the player's choice as an integer.
     * The options presented in the menu are: Start New Game, Continue, and Quit.
     * 
     * @return users input choice
     */
    public int initialGameState() {
        System.out.println("----- MAIN MENU -----");
        System.out.println("1.Start New Game");
        System.out.println("2.Continue");
        // System.out.println("3.Save(Not implemented yet)");
        System.out.println("4.Quit");
        createSpacing();
        System.out.print("Please write the number representing the option: ");
        int userInput = sc.nextInt();
        sc.nextLine();
        return userInput;
    }

    /**
     * This method handles the character creation process for the player.
     * It prompts the player to select a class and assigns the chosen class to the
     * hero variable.
     * It uses a while loop to repeat the process if the player inputs an invalid
     * class or if the hero variable is null.
     * The chosenHeroLogic method is called to handle the logic for creating a hero
     * based on the chosen class.
     */
    public void characterCreation() {
        while (hero == null) {
            System.out.println("Which class do you wish to play?");
            System.out.println("1.\u001B[36m Mage \u001B[0m");
            System.out.println("2.\u001B[32m Ranger \u001B[0m");
            System.out.println("3.\u001B[31m Rogue \u001B[0m");
            System.out.println("4.\u001B[35m Warrior \u001B[0m");
            createSpacing();
            System.out.print("Choose your class: ");
            int chosenClass = sc.nextInt();
            sc.nextLine();

            chosenHeroLogic(chosenClass);
        }
    }

    /**
     * This method handles the logic for creating a hero based on the class chosen
     * by the player.
     * It uses a switch statement to determine the chosen class and prompts the
     * player to enter a name for the hero.
     * The hero is then instantiated as one of the four class types (Mage, Ranger,
     * Rogue, Warrior).
     * If an invalid input is given, a message is printed and the character creation
     * process is repeated.
     * 
     * @param chosenClass user input.
     */
    public void chosenHeroLogic(int chosenClass) {
        switch (chosenClass) {
            case 1 -> {
                System.out.print("Chose a name for your hero: ");
                hero = new Mage(sc.nextLine());
            }
            case 2 -> {
                System.out.print("Chose a name for your hero: ");
                hero = new Ranger(sc.nextLine());
            }
            case 3 -> {
                System.out.print("Chose a name for your hero: ");
                hero = new Rogue(sc.nextLine());
            }
            case 4 -> {
                System.out.print("Chose a name for your hero: ");
                hero = new Warrior(sc.nextLine());
            }
            default -> System.out.println("Invalid input");
        }
        createSpacing();
        if (hero == null) {
            System.out.println("Please try again!");
            characterCreation();
        }
    }

    /**
     * 
     * This method is the main loop for the game. It starts by welcoming the player
     * and printing out their character name.
     * It then enters a while loop that continues until the game is over. Inside the
     * loop, it presents the player with 4 options:
     * Enter 1v1 arena
     * Display character details
     * Delete hero
     * Quit to Main Menu
     * It then uses a switch statement to handle the player's choice.
     * If the player chooses option 1, it calls the arenaLoop method.
     * If the player chooses option 2, it calls the display method of the hero
     * object.
     * If the player chooses option 3, it deletes the hero object and sets the
     * running variable to false to exit the loop.
     * If the player chooses option 4, it sets the running variable to false to exit
     * the loop.
     * If the player enters an invalid input, it prints a message to inform the
     * player of invalid input.
     */
    public void gameLoop() {
        System.out.printf("Welcome to the game\u001B[32m %s \u001B[0m %n", hero.getName());
        boolean running = true;
        while (running) {
            System.out.println("----- GAME OPTIONS -----");
            System.out.println("1. Enter 1v1 arena");
            System.out.println("2. Display character details");
            System.out.println("3. Delete hero");
            System.out.println("4. Quit to Main Menu");
            int playerChoice = sc.nextInt();
            sc.nextLine();
            createSpacing();
            switch (playerChoice) {
                case 1 -> arenaLoop();
                case 2 -> System.out.println(hero.display());
                case 3 -> {
                    hero = null;
                    running = false;
                }
                case 4 -> {
                    createSpacing();
                    running = false;
                }
                default -> System.out.println("Input not valid!");
            }
        }
    }

    /**
     * 
     * This method is the main loop for the battle arena. It starts by creating an
     * enemy and printing out the names of the hero and enemy.
     * It then enters a while loop that continues until the battle is over. Inside
     * the loop, it prints out the current health of both the hero and the enemy.
     * It also provides options for the player to do a light attack, heavy attack,
     * heal, or forfeit the battle.
     * It then calls the doCombatAction method to handle the player's choice and
     * checks the health of both the hero and the enemy to determine if the battle
     * is over.
     * If the battle is over, it will print the outcome and level up the hero if
     * they win the battle. It also resets the health of the hero after the battle.
     */
    public void arenaLoop() {
        boolean inBattle = true;
        enemy = new Warrior("Isildur");
        System.out.println("You, \u001B[32m" + hero.getName() + "\u001B[0m are now fighting \u001B[31m"
                + enemy.getName() + "\u001B[0m");

        while (inBattle) {
            System.out.println("Your HP [ " + roundAvoid(hero.getHealth(), 2) + "/" + hero.getMaxHealth() + " ]");
            System.out.println("Enemy HP [ " + roundAvoid(enemy.getHealth(), 2) + "/" + enemy.getMaxHealth() + " ]");
            System.out.println("1. Do a light attack, potentially dealing " + hero.damage() + " damage");
            System.out.println("2. Do a heavy attack, potentially dealing " + (hero.damage() * 1.5) + " damage");
            System.out.println("3. Heal, regaining 1-3 HP");
            System.out.println("4. Forfeit, and give up the win");
            createSpacing();

            System.out.print("Your action: ");
            int playerChoice = sc.nextInt();
            sc.nextLine();
            if (playerChoice == 4) {
                System.out.println("You forfeited, the battle is over");
                break;
            }
            doCombatAction(playerChoice);

            if (hero.getHealth() == 0 && enemy.getHealth() == 0) {
                // draw
                System.out.println("Its a draw");
                inBattle = false;
            } else if (hero.getHealth() == 0) {
                // loss
                System.out.println("You lost!");
                inBattle = false;
            } else if (enemy.getHealth() == 0) {
                // victory
                System.out.println("You won, And leveled up");
                if(random.nextFloat(0,1)>0.5){
                    generateDrop();
                }
                hero.levelUp();
                inBattle = false;
            }

        }
        hero.resetHealth();
    }

    /**
     * This method implements a combat action between the player and the enemy.
     * It determines the enemy's type of attack and assigns hit probabilities for
     * light and heavy attacks.
     * It uses random floats to determine if the hero and the enemy hit each other.
     * If the player chooses attack 1 and is allowed to hit, the enemy's health is
     * reduced by the hero's damage.
     * If the player chooses attack 2 and is allowed to hit, the enemy's health is
     * reduced by 1.5 * hero's damage.
     * If the player chooses to heal, the hero's health is increased by a random
     * amount.
     * If the enemy chooses attack 1 and is allowed to hit, the hero's health is
     * reduced by the enemy's damage.
     * If the enemy chooses attack 2 and is allowed to hit, the hero's health is
     * reduced by 1.5 * enemy's damage.
     * If the enemy chooses to heal, the enemy's health is increased by a random
     * amount.
     * 
     * @param playerChoice the type of attack chosen by the player.
     */
    public void doCombatAction(int playerChoice) {
        // Determines teh enemy's type of attack
        int enemyChoice = getEnemyChoice();
        // Probability of hitting a light attack is 75%
        float lightHitProbability = 0.75f;
        // Probability of hitting a heavy attack is 50%
        float heavyHitProbability = 0.5f;
        // float used to determine if the hero hits the enemy
        float heroHitPoint = random.nextFloat(0, 1);
        // Float used to determine if the enemy hits the hero
        float enemyHitPoint = random.nextFloat(0, 1);

        //Applies the logic for the player action
        playerAction(playerChoice, lightHitProbability, heavyHitProbability, heroHitPoint);
        //Applies the logic for the enemy action
        enemyAction(enemyChoice, lightHitProbability, heavyHitProbability, enemyHitPoint);
    }


    private void enemyAction(int enemyChoice, float lightHitProbability, float heavyHitProbability, float enemyHitPoint) {
        // If the enemy chooses attack 1 and is allowed to hit
        if (lightHitProbability >= enemyHitPoint && enemyChoice == 1) {
            hero.setHealth(hero.getHealth() - enemy.damage());
            System.out.println(
                    enemy.getName() + " hits you with a light attack for " + roundAvoid(enemy.damage(), 2) + " HP");
            
            // If the enemy chooses attack 2 and is allowed to hit
        } else if (heavyHitProbability >= enemyHitPoint && enemyChoice == 2) {
            hero.setHealth(hero.getHealth() - (enemy.damage() * 1.5));
            System.out.println(enemy.getName() + " hits you with a heavy attack for "
                    + roundAvoid(enemy.damage() * 1.5, 2) + " HP");

            // If the enemy choose 3 and is heals
        } else if (enemyChoice == 3) {
            double healAmnt = random.nextInt(1, 3);
            enemy.setHealth(enemy.getHealth() + healAmnt);
            System.out.println(enemy.getName() + " heals for " + healAmnt + " HP");
            
            // Everything else is a miss
        } else {
            System.out.println(enemy.getName() + " misses");
        }
    }


    private void playerAction(int playerChoice, float lightHitProbability, float heavyHitProbability, float heroHitPoint) {
        // If the player chooses attack 1 and is allowed to hit
        if (lightHitProbability >= heroHitPoint && playerChoice == 1) {
            enemy.setHealth(enemy.getHealth() - hero.damage());
            System.out.println(
                    "You hit " + enemy.getName() + " with a light attack for " + roundAvoid(hero.damage(), 2) + " HP");
            // If the player chooses attack 2 and is allowed to hit
        } else if (heavyHitProbability >= heroHitPoint && playerChoice == 2) {
            enemy.setHealth(enemy.getHealth() - (hero.damage() * 1.5));
            System.out.println("You hit " + enemy.getName() + " with a heavy attack for "
                    + roundAvoid(hero.damage() * 1.5, 2) + " HP");
            // If the player choose 3 and is heals
        } else if (playerChoice == 3) {
            double healAmnt = random.nextInt(1, 4);
            hero.setHealth(hero.getHealth() + healAmnt);
            System.out.println("You heal for " + healAmnt + " HP");
            // Everything else is a miss
        } else {
            System.out.println("You miss");
        }
    }

    /**
     * Generates the attack of the enemy
     * 
     * @return attack of the enemy.
     */
    public int getEnemyChoice() {
        return random.nextInt(1, 4);
    }

    /**
     * Used to create visual spacing in the console
     * when playing.
     */
    public void createSpacing() {
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void generateDrop(){
        try{
            Equipable newGear = availableDrops.get(random.nextInt(0, 13));
            System.out.print("Congratulation, you where dropped \u001B[32m"+ newGear.getName()+"\u001B[0m");
            if(newGear instanceof Armor){
                hero.equip((Armor) newGear);
            } else{
                hero.equip((Weapon) newGear);
            }
        } catch(Exception e){
            System.out.println("\u001B[31m but sadly you cant equip it \u001B[0m");
        }
        System.out.println();
    }

    /**
     * Utility method to round doubles to a specified
     * amount of digits behind comma
     * 
     * @param value  value to round
     * @param places amount of digits behind comma
     * @return rounded number.
     */
    public double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
