public class Weapon extends Item{
    private int attackBonus;
    private int levelRequirement;

    public Weapon(String name, String type, int attackBonus, int levelRequirement) {
        super(name, type);
        
        this.attackBonus = attackBonus;
        this.levelRequirement = levelRequirement;
    }


    public int getAttackBonus() {
        return this.attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

}
