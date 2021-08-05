public class Armor extends Item{
    private int defenseBonus;
    private int levelRequirement;

    public Armor(String name, String type, int defenseBonus, int levelRequirement) {
        super(name, type);
        this.defenseBonus = defenseBonus;
        this.levelRequirement = levelRequirement;
    }


    public int getDefenseBonus() {
        return this.defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public int getLevelRequirement() {
        return this.levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

}
