import java.util.HashMap;

public class CreaturesDropTable {           // Class to house the drop tables for various monsters. 
    
    public static HashMap <Item,Integer> GoblinDropTable(Creature creature) {
        HashMap <Item,Integer> dropTable = creature.getMonsterDroptable();
        
        dropTable.put(new Item("Bones", "Item"), 1);
        dropTable.put(new Weapon("Iron Sword", "Melee", 3, 1), 1);
        dropTable.put(new Armor("Bronze Shield", "Shield", 3, 1), 1);
 
        return dropTable;
    }    
}
