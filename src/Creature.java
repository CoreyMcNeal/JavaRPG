import java.util.HashMap;

public class Creature {
    private String name;
    private int health;
    private int fullHealth;
    private int expGiven;
    private int level;
    private int strength;
    
    
    private HashMap <Item, Integer> monsterDroptable;

    public Creature(String name) {                  // Constructor which includes taking in a name. Depending on the name, different 
        this.name = name;                          // instance variables are created.
        
        this.strength = 0;
        this.level = 0;
        this.expGiven = 0;
        this.monsterDroptable = new HashMap<>();

        if (name.equals("Goblin")) {
            this.health = 10;
            this.fullHealth = 10;
            this.level = 2;
            this.expGiven = 5;
            this.strength = 2;
            this.monsterDroptable = CreaturesDropTable.GoblinDropTable(this);
        }
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpGiven() {
        return this.expGiven;
    }

    public void setExpGiven(int expGiven) {
        this.expGiven = expGiven;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HashMap<Item,Integer> getMonsterDroptable() {
        return this.monsterDroptable;
    }

    public void setMonsterDroptable(HashMap<Item,Integer> monsterDroptable) {
        this.monsterDroptable = monsterDroptable;
    }

    public void printDropTable() {
        for (Item item: this.monsterDroptable.keySet()) {
            System.out.println(item + ": " + this.monsterDroptable.get(item));
        }
        System.out.println();
    }

    public void removeFromDropTable(Item entry) {
        this.monsterDroptable.remove(entry);
    }
    
}
