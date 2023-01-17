package dev.roder;

import dev.roder.characters.*;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private Scanner sc;
    private Hero hero;
    private Hero enemy;
    //For use if the enemy is determined by the current stage.
    private int currentStage;
    private Random random;

    /**
     * Creates instance of Engine, initializing scanner and random number generator.
     */
    public Engine(){
        sc = new Scanner(System.in);
        currentStage = 0;
        random = new Random();
    }

    /**
     * Creates the initial game-loop, and contains main-menu logic.
     */
    public void run(){
        boolean running = true;
        while(running) {
            switch (initialGameState()) {
                case 1 -> {
                    //Starts Character creation.
                    characterCreation();
                    //Starts the main game loop
                    gameLoop();
                }
                case 2 -> {
                    //Checks if a hero exist, if it does the game continues.
                    if (hero != null) gameLoop();
                    else System.out.println("You have not created a hero, please start with that");
                }
                case 3 -> System.out.println("Not yet implemented");
                case 4 -> running = false;
                default -> System.out.println("Not a valid input, please try again");
            }
        }

    }

    /**
     * Displays the main menu options and takes the users input choice.
     * @return users input choice
     */
    public int initialGameState(){
        System.out.println("----- MAIN MENU -----");
        System.out.println("1.Start New Game");
        System.out.println("2.Continue");
        //System.out.println("3.Save(Not implemented yet)");
        System.out.println("4.Quit");
        createSpacing();
        System.out.print("Please write the number representing the option: ");
        int userInput = sc.nextInt();
        sc.nextLine();
        return userInput;
    }

    /**
     * Runs through character creation set up. Choosing class and name.
     */
    public void characterCreation(){
        while(hero == null){
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
     * Initiates the right hero class based on the user input
     * @param chosenClass user input.
     */
    public void chosenHeroLogic(int chosenClass){
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
        if(hero == null){
            System.out.println("Please try again!");
            characterCreation();
        }
    }


    /**
     * Main game loop running through, and potentially
     * initializing the main functions of the game
     */
    public void gameLoop(){
        System.out.printf("Welcome to the game\u001B[32m %s \u001B[0m\n",hero.getName());
        boolean running = true;
        while(running){
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
     * Creates the loop for fighting in the 1v1 battle arena.
     */
    public void arenaLoop(){
        boolean inBattle = true;
        enemy = new Warrior("Isildur");
        System.out.println("You, \u001B[32m"+hero.getName()+"\u001B[0m are now fighting \u001B[31m"+enemy.getName()+"\u001B[0m");

        while(inBattle){
            System.out.println("Your HP [ "+roundAvoid(hero.getHealth(),2)+"/"+hero.getMaxHealth()+" ]");
            System.out.println("Enemy HP [ "+roundAvoid(enemy.getHealth(),2)+"/"+enemy.getMaxHealth()+" ]");
            System.out.println("1. Do a light attack, potentially dealing "+hero.damage()+" damage");
            System.out.println("2. Do a heavy attack, potentially dealing "+(hero.damage()*1.5)+" damage");
            System.out.println("3. Heal, regaining 10-15 HP");
            System.out.println("4. Forfeit, and give up the win");
            createSpacing();

            System.out.print("Your action: ");
            int playerChoice = sc.nextInt();
            sc.nextLine();
            if(playerChoice == 4){
                System.out.println("You forfeited, the battle is over");
                break;
            }
            doCombatAction(playerChoice);


            if(hero.getHealth() == 0 && enemy.getHealth() == 0){
                //draw
                System.out.println("Its a draw");
                inBattle=false;
            } else if(hero.getHealth() == 0){
                //loss
                System.out.println("You lost!");
                inBattle=false;
            } else if (enemy.getHealth() == 0) {
                //victory
                System.out.println("You won, And leveled up");
                hero.levelup();
                inBattle=false;
            }

        }
        hero.resetHealth();
    }

    /**
     * Applies the battle logic for different attacks and heal.
     * @param playerChoice the type of attack chosen by the player.
     */
    public void doCombatAction(int playerChoice){
        //Determines teh enemy's type of attack
        int enemyChoice = getEnemyChoice();
        //Probability of hitting a light attack is 75%
        float lightHitProbability = 0.75f;
        //Probability of hitting a heavy attack is 50%
        float heavyHitProbability = 0.5f;
        //float used to determine if the hero hits the enemy
        float heroHitPoint = random.nextFloat(0,1);
        //Float used to determine if the enemy hits the hero
        float enemyHitPoint = random.nextFloat(0,1);

        //If the player chooses attack 1 and is allowed to hit
        if(lightHitProbability>= heroHitPoint && playerChoice == 1){
            enemy.setHealth(enemy.getHealth()-hero.damage());
            System.out.println("You hit "+enemy.getName()+" with a light attack for "+ roundAvoid(hero.damage(),2)+" HP");
            //If the player chooses attack 3 and is allowed to hit
        }else if(heavyHitProbability>= heroHitPoint && playerChoice == 2){
            enemy.setHealth(enemy.getHealth()-(hero.damage()*1.5));
            System.out.println("You hit "+enemy.getName()+" with a heavy attack for "+ roundAvoid(hero.damage()*1.5,2)+" HP");
            //If the player choose 3 and is heals
        }else if(playerChoice == 3){
            double healAmnt = random.nextInt(1,3);
            hero.setHealth(hero.getHealth()+healAmnt);
            System.out.println("You heal for "+healAmnt+" HP");
            //Everything else is a miss
        }else{
            System.out.println("You miss");
        }

        //If the enemy chooses attack 1 and is allowed to hit
        if(lightHitProbability >= enemyHitPoint && enemyChoice == 1){
            hero.setHealth(hero.getHealth()-enemy.damage());
            System.out.println(enemy.getName()+" hits you with a light attack for "+ roundAvoid(enemy.damage(),2)+" HP");
            //If the enemy chooses attack 2 and is allowed to hit
        }else if(heavyHitProbability >= enemyHitPoint && enemyChoice == 2){
            hero.setHealth(hero.getHealth()-(enemy.damage()*1.5));
            System.out.println(enemy.getName()+" hits you with a heavy attack for "+ roundAvoid(enemy.damage()*1.5,2)+" HP");
            //If the enemy choose 3 and is heals
        }else if(enemyChoice == 3){
            double healAmnt = random.nextInt(1,3);
            enemy.setHealth(enemy.getHealth()+healAmnt);
            System.out.println(enemy.getName()+" heals for "+healAmnt+" HP");
            //Everything else is a miss
        }else{
            System.out.println(enemy.getName()+" misses");
        }
    }

    /**
     * Generates the attack of the enemy
     * @return attack of the enemy.
     */
    public int getEnemyChoice(){
        return random.nextInt(1,4);
    }

    /**
     * Used to create visual spacing in the console
     * when playing.
     */
    public void createSpacing(){
        System.out.println();
        System.out.println();
        System.out.println();
    }

    /**
     * Utility method to round doubles to a specified
     * amount of digits behind comma
     * @param value value to round
     * @param places amount of digits behind comma
     * @return rounded number.
     */
    public double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
