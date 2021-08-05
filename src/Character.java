import java.util.HashMap;
import java.util.Scanner;

public class Character {
    private String name;
    private int level;
    private int exp;
    private HashMap <Item,Integer> Inventory;
    private Item weapon;
    private Item armor;

    private int health;
    private int fullHealth;
    private int strength;
    private int magic;
    private int archery;



    public Character(String name, Weapon weapon) {      // constructor which includes base information for the player, and relevant levels
        this.name = name;
        this.level = 3;
        this.weapon = weapon;
        this.armor = null;
        this.exp = 0;
        this.Inventory = new HashMap<>();
        

        this.health = 10;
        this.fullHealth = 10;

        this.strength = 1;
        this.archery = 1;
        this.strength = 1;

        
    }

    public void lootMonster(Creature creature, Scanner reader) {        // Loops through creatures inventory (hashmap) and adds what isn't already had

        HashMap <Item,Integer> creatureInv = creature.getMonsterDroptable();
        System.out.println("Which drop would you like to choose:\n" +
                            "Enter blank to exit");

        while (true) {
            if (creatureInv.size() > 0) {
                creature.printDropTable();
            } else {
                System.out.println("--Drop Table is now empty, enter blank to exit--");
                System.out.println();
                UserInterface.pause(1000);
            }
            

            System.out.print("Pick: ");
            String itemChoice = reader.nextLine();
            if (itemChoice.isBlank()) {
                this.printInventory();
                break;
            }

            if (creatureInv.keySet().toString().contains(itemChoice)){
                for (Item entry: creatureInv.keySet()) {
                    String entryName = entry.getName();
                    if (entryName.equals(itemChoice) && this.Inventory.containsKey(entry)) {
                        int currentAmount = this.Inventory.get(entry);
                        int toBeAdded = creatureInv.get(entry);
                        int finalAmount = currentAmount + toBeAdded;
                    
                        this.Inventory.put(entry, finalAmount);
                        System.out.println("Looted " + entry);
                        System.out.println();
                        creature.removeFromDropTable(entry);
                        reader.nextLine();
                        break;
                    } else if (entryName.equals(itemChoice) && !(this.Inventory.containsKey(entry))) {

                        this.Inventory.put(entry, creatureInv.get(entry));
                        System.out.println("Looted " + entry);
                        System.out.println();
                        creature.removeFromDropTable(entry);
                        reader.nextLine();
                        break;
                    }
                }
            } else {
                System.out.println("Item not on drop table...");
                reader.nextLine();
                continue;
            }
        }   
    }

    public void levelUpChecker(int gainedExp, Scanner reader) { // checks if the experience received is enought to grant a level
        if (this.exp + gainedExp >= 10) {
            this.exp = (this.exp + gainedExp) % 10;
            this.level += 1;
            this.fullHealth += 1;
            System.out.println("You are now level " + this.level + "!\n" +
                                "+1 to Max Health");
            reader.nextLine();
            return;
        }

        this.exp += gainedExp;
    }

    public void addToInventory(Item item, int amount) {       // Adds an item (String) and amount (int) to the players inventory.
        this.Inventory.put(item, amount);
    }

    public void printInventory() {                      // prints inventory of player out if needed
        System.out.println("Current Inventory:");
        for (Item item: this.Inventory.keySet()) {
            System.out.println(item.getName() + ": " + this.Inventory.get(item));
        }
    }

    // Getters and setters for various attributes


    public Item getArmor() {
        return this.armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    public Item getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int getFullHealth() {
        return this.fullHealth;
    }

    public void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getMagic() {
        return this.magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getArchery() {
        return this.archery;
    }

    public void setArchery(int archery) {
        this.archery = archery;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void addExp(int amount) {
        this.exp += amount;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public HashMap<Item,Integer> getInventory() {
        return this.Inventory;
    }

    public void setInventory(HashMap<Item,Integer> Inventory) {
        this.Inventory = Inventory;
    }
}
