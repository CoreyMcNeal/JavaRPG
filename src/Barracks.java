import java.util.Scanner;

public class Barracks {
    private Scanner reader;
    private Character player;

    public Barracks(Character player, Scanner reader) {
        this.reader = reader;
        this.player = player;
    }

    public void start() {
        System.out.println("Welcome to the barracks! Here you can manage the items in your inventory: ");

        while (true) {
            System.out.println("1 - Change Armor\n" + 
                                "2 - Change Weapon\n" + 
                                "3 - Remove from inventory\n" +
                                "0 - Return to Town");
            int choice;
            try {
                choice = Integer.valueOf(reader.nextLine());
                if (!(choice == 1) && (!(choice == 2)) && (!(choice == 3))) {
                    System.out.println("Choose one of the available options..");
                    System.out.println();
                }
            } catch (Exception e) {
                System.out.println("Choose one of the available options..");
                System.out.println();
                continue;
            }

            if (choice == 1) {
                equipArmor();
            } else if (choice == 2) {
                equipWeapon();
            } else if (choice == 3) {
                removeItem();
            } else if (choice == 0) {
                break;
            }
        }
        
        
    }   

    public void equipWeapon() {
        while (true) {
            System.out.println("Which to equip?");

            boolean isEmpty = true;
            for (Item entry: this.player.getInventory().keySet()) {             // loops through inventory printing any weapons
                if (entry.getType().equals("Melee") ||
                    entry.getType().equals("Archery") ||
                    entry.getType().equals("Magic")){

                        isEmpty = false;
                        System.out.println("-" + entry);
                }
            }
            System.out.println();

            if (isEmpty == true) {                                     //checks if inventory is empty using a boolean value
                System.out.println("--No weapons in inventory---");
                System.out.println();
                break;
            }

            if (isOnlyAndEquipped(this.player)) {
                System.out.println("This is your only and equipped weapon, cannot swap...");;
                return;
            }
            
            System.out.println();
            try {                        
                System.out.println("Enter blank to exit-");   
                System.out.print("Pick: ");                                            // Tries to equipt chosen weapon from inventory
                String choice = reader.nextLine();
                if (choice.isBlank()) {
                    return;
                }
                if (!(this.player.getInventory().keySet().toString().contains(choice))) {   
                    System.out.println("Item not in list...");
                    return;
                }

                for (Item weapon: this.player.getInventory().keySet()) {
                    if (weapon.getName().equals(choice)) {
                        this.player.addToInventory(this.player.getWeapon(), 1);
                        this.player.setWeapon(weapon);
                        System.out.println(weapon + " was equipped!");
                        System.out.println();
                        return;
                    }
                }
                
                
            } catch (Exception e) {
                System.out.println("Please enter the name of the item...");
                break;
            }
        }
    }

    public void equipArmor() {
        while (true) {
            System.out.println("Which to equip?");

            boolean isEmpty = true;
            for (Item entry: this.player.getInventory().keySet()) {             // loops through inventory printing any weapons
                if (entry.getType().equals("Armor") || entry.getType().equals("Shield")){
                        isEmpty = false;
                        System.out.println("-" + entry);
                }
            }
            System.out.println();

            if (isEmpty == true) {                                     //checks if inventory is empty using a boolean value
                System.out.println("--No armor in inventory---");
                System.out.println();
                break;
            }

            if (isEquippedArmor(this.player)) {
                System.out.println("This is your equipped armor, cannot swap...");
                reader.nextLine();
                System.out.println();
                return;
            }
            
            System.out.println();
            try {                  
                System.out.println("Enter blank to exit-");
                System.out.print("Pick: ");                                                     // Tries to equipt chosen weapon from inventory
                String choice = reader.nextLine();
                if (!(this.player.getInventory().keySet().toString().contains(choice))) {   
                    System.out.println("Item not in list...");
                }

                for (Item armor: this.player.getInventory().keySet()) {
                    if (armor.getName().equals(choice)) {
                        this.player.setArmor(armor);
                        System.out.println(armor + " was equipped!");
                        System.out.println();
                        return;
                    }
                }
                
                
            } catch (Exception e) {
                System.out.println("Please enter the name of the item...");
                break;
            }
        }
    }



    public void removeItem() {
        while (true){

            System.out.println("Enter blank to exit-");
            System.out.println("Current Inventory:");
            boolean isEmpty = true;
            for (Item entry: this.player.getInventory().keySet()) {             // loops through inventory printing any weapons
                System.out.println("-" + entry);
                isEmpty = false;
            }
            System.out.println();

            if (isEmpty == true) {                                     //checks if inventory is empty using a boolean value
                System.out.println("--No items in inventory---");
                System.out.println();
                return;
            }

            System.out.print("Pick:");
            String itemName = reader.nextLine();
            if (this.player.getWeapon().getName().equals(itemName) && howManyOfItem(player, itemName) == 1) {
                System.out.println("Cant remove item, it is equipped");
                reader.nextLine();
                return;
            }

            if (this.player.getArmor().getName().equals(itemName) && howManyOfItem(player, itemName) == 1) {
                System.out.println("Cant remove item, it is equipped");
                reader.nextLine();
                return;
            }



            for (Item item: this.player.getInventory().keySet()) {
                if (item.getName().equals(itemName)) {
                    this.player.getInventory().remove(item);
                    System.out.println(item + " removed");
                    System.out.println();
                    return;
                }
            }

            
            System.out.println("Could not find item...");
            System.out.println();
            return;
        }
    }

    public int howManyOfItem(Character player, String itemName) {
        int counter = 0;
        for (Item entry: player.getInventory().keySet()) {
            if (entry.getName().equals(itemName)) {
                counter += 1;
            }
        }

        return counter;
    }

    public boolean isOnlyAndEquipped(Character player) {

        if (player.getInventory().containsKey(player.getWeapon()) && player.getInventory().size() == 1) {
            return true;
        }
        return false;
    }


    // need to add the armor system into the game.
    public boolean isEquippedArmor(Character player) {

        if (player.getInventory().containsKey(player.getArmor())) {
            return true;
        }
        return false;
    }

    //need armor system in order to check if player has armor and has it equipped
    public boolean isOnlyArmorAndWeapon(Character player) {
        return true;

    }
}
