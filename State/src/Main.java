import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Pick your character's name: ");
        String playerName = scanner.nextLine();

        GameCharacter character = new GameCharacter(playerName);

        while (!(character.getCurrentState() instanceof MasterState)) {
            character.displayStatus();

            System.out.print("Enter your action (train/meditate/fight): ");
            String action = scanner.nextLine().toLowerCase().trim();
            System.out.println("\n");

            switch (action.toLowerCase()) {
                case "train":
                    character.train();
                    break;
                case "meditate":
                    character.meditate();
                    break;
                case "fight":
                    character.fight();
                    break;
                default:
                    System.out.println("Invalid action. Please try again.");
            }
        }
    }
}
