import java.util.Scanner;

public class UserInterface {
    Scanner reader= new Scanner(System.in);
    
    public void start() {
        System.out.println("Welcome to Temp RPG!");
        pause(1000);

        Character player = buildCharacter();    // Builds the user's character

        while (true){
            System.out.println("You're now at Yanesdale, what would you like to do?");  // town options
            System.out.println("1 - Battle: Adventure and Battle Monsters\n" + 
                                "2 - Training: Train skills\n" + 
                                "3 - Barracks: Manage Equipment\n");


            int menuChoice = townMenu();
            if (menuChoice == 1) {  // Battle
                //Need to add more creatures, and randomize the encounter along with the hasmap inventory.
                Creature creature = new Creature("Goblin");
                Battle battleNow = new Battle(player, creature, reader);
                battleNow.start();

            } else if (menuChoice == 2) { // Training
                Training trainingSession = new Training(player, reader);
                trainingSession.start();

            } else if (menuChoice == 3) {  // Barracks
                Barracks barracksSession = new Barracks(player, reader);
                barracksSession.start();

            } else {
                System.out.println("Invalid choice");
                reader.nextLine();

            }
        }


        
    }

    public int townMenu() {         // ensures the input is a valid option
        while (true) {
            try {
                int menuChoice = Integer.valueOf(reader.nextLine());
                if (!(menuChoice == 1) && (!(menuChoice == 2)) && (!(menuChoice == 3))) {
                    continue;
                } else {
                    return menuChoice;
                }
                
            } catch (Exception e) {
                System.out.println("Use one of the given options...");
                continue;
            }
        }
    }












    public Character buildCharacter() {                 // Asks for a String name and type, to be issued a starting weapon.
        System.out.print("Enter your name: ");          // Returns a successfully created character object.
        String name = reader.nextLine();

        while (true) {
            System.out.println("Style: Melee, Magic, or Archery?");
            String style = reader.nextLine();
            System.out.println();

            if (!(style.equals("Melee")) && (!(style.equals("Magic"))) && (!(style.equals("Archery")))) {
                System.out.println("Please enter one of the options");
                pause(1000);
                continue;
            }

            Weapon weapon;
            if (style.equals("Melee")) {
                weapon = new Weapon("Bronze Sword", "Melee", 3, 1);
                                                                
            } else if (style.equals("Magic")) {
                weapon = new Weapon("Wind Staff", "Magic", 3 ,1);

            } else if (style.equals("Archery")) {
                weapon = new Weapon("Shortbow", "Archery", 3 , 1);

            } else {
                continue;
            }

            Character player = new Character(name, weapon);  //creating character using given vars and adding the weapon
            player.addToInventory(weapon, 1);
            return player;
        }
    }


    public static void pause(int milliseconds) {                                   // Pause method to let the program have some flow
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
