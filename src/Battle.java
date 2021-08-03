import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Character player;
    private Creature creature;
    private Random draw = new Random();
    private Scanner reader;

    public Battle(Character player, Creature creature, Scanner reader) {
        this.player = player;
        this.creature = creature;
        this.reader = reader;
    }

    public boolean start() {       // Logic for battle flow. Each hit affects the other objects health attributes
        System.out.println("You encountered a " + this.creature.getName() + "!");
        reader.nextLine();

        while (true) {
            System.out.println(this.player.getName() + ": " + this.player.getHealth() + " HP");
            System.out.println(this.creature.getName() + ": " + this.creature.getHealth() + " HP");
            reader.nextLine();

            playerHitsCreature();
            if (this.creature.getHealth() <= 0) {
                System.out.println(this.player.getName() + " gained " + this.creature.getExpGiven() + " EXP");
                reader.nextLine();
                this.player.levelUpChecker(this.creature.getExpGiven(), reader);
                this.player.lootMonster(creature, reader);
                this.player.setHealth(this.player.getFullHealth());


                System.out.println("Returning to town...");
                System.out.println();
                UserInterface.pause(3000);
                return true;
            }

            creatureHitsPlayer();
            if (this.player.getHealth() <= 0) {
                return false;
            }
        }



    }

    public void playerHitsCreature() {                  // Delivers the hit received from the "getPlayersHit" method.
        String playerName = this.player.getName();
        String creatureName = this.creature.getName();

        int hit = getPlayersHit();
        if (hit >= this.creature.getHealth()) {
            System.out.println(playerName + " deals " + hit + " damage with a " + this.player.getWeapon().getName());
            System.out.println(playerName + " has defeated " + creatureName);
            reader.nextLine();
            this.creature.setHealth(0);
        } else {
            System.out.println(playerName + " deals " + hit + " damage with a " + this.player.getWeapon().getName());
            reader.nextLine();
            this.creature.setHealth(this.creature.getHealth() - hit);
        }
    }

    public void creatureHitsPlayer() {                  // Delivers the hit received from the "getCreaturesHit" method
        String creatureName = this.creature.getName();

        int hit = getCreaturesHit();
        if (hit >= this.player.getHealth()) {
            System.out.println(creatureName + " deals " + hit + " damage");
            System.out.println("You've Died!");
            reader.nextLine();
            this.player.setHealth(0);
        } else {
            System.out.println(creatureName + " deals " + hit + " damage");
            reader.nextLine();
            this.player.setHealth(this.player.getHealth() - hit);
        }
    }

    public int getCreaturesHit() {                      // calculates a random number from 0 to the strength of the creature
        int maxHit = this.creature.getStrength() + 1;
        int finalHit = draw.nextInt(maxHit);

        return finalHit;
    }

    public int getPlayersHit() {                        // calculates a random number from 0 to the strength of the weapon
        int maxHit = this.player.getWeapon().getAttackBonus() + this.player.getLevel();
        int finalHit = draw.nextInt(maxHit);

        return finalHit;
    }


}
