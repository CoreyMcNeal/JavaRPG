import java.util.Scanner;

public class Training {
    private Character player;
    private Scanner reader;

    public Training(Character player, Scanner reader) {
        this.player = player;
        this.reader = reader;
    }

    public void start() {
        
        UserInterface.pause(1000);
        System.out.println("Enter how many seconds you would like to train.\n" +
                           "10 seconds of training is 1 EXP: ");
        
        int seconds;
        while (true){
            try {
                seconds = Integer.valueOf(reader.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number...");
                UserInterface.pause(2000);
                continue;
            }
        }

        trainLevelExp(seconds);
            
    }

    public void trainLevelExp(int seconds) {
        String playerName = this.player.getName();
        int secondsToMilliseconds = seconds * 1000;

        System.out.println(playerName + " is training...");
        UserInterface.pause(secondsToMilliseconds);
        
        int exp = (seconds / 10);
        this.player.addExp(exp);
        
        System.out.println(playerName + " gained " + exp + " EXP");
        System.out.println();
        UserInterface.pause(1500);
    }
}
