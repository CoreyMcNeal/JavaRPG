public class Item {
    private String name;
    private int attackBonus;
    private int defenseBonus;
    private int levelRequirement;
    private String type;
    private boolean isWeapon;
    private boolean isArmor;

    public Item (String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void makeIntoWeapon(int attackBonus, int levelRequirement) { // makes the item into a weapon (adds weapon traits)
        this.isWeapon = true;
        this.attackBonus = attackBonus;
        this.levelRequirement = levelRequirement;
    }

    public Item makeIntoArmor(int defenseBonus, int levelRequirement) { // makes the item into armor (adds armor traits)
        this.isArmor = true;
        this.defenseBonus = defenseBonus;
        this.levelRequirement = levelRequirement;
        return this;
    }


    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;

        if (!(this.name.equals(item.name))) {
            return false;
        }

        return true;
    }


    @Override
    public String toString() {
        return this.name;
    }

    public int getDefenseBonus() {
        return this.defenseBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public boolean getIsWeapon() {
        return this.isWeapon;
    }

    public void setIsWeapon(boolean isWeapon) {
        this.isWeapon = isWeapon;
    }

    public boolean getIsArmor() {
        return this.isArmor;
    }

    public void setIsArmor(boolean isArmor) {
        this.isArmor = isArmor;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
