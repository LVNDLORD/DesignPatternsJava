import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleOfWizards extends Game {
    private List<Wizard> wizards;
    private Random random = new Random();

    @Override
    public void initializeGame(int numberOfPlayers) {
        wizards = new ArrayList<>();
        // Initialize wizards with random health between 90 and 100
        wizards.add(new Wizard("Merlin", 90 + random.nextInt(11)));
        wizards.add(new Wizard("Gandalf", 90 + random.nextInt(11)));
        // wizards.add(new Wizard("Wizard of Oz", 90 + random.nextInt(11))); // UNCOMMENT IT IF YOU WANT TO HAVE 3 WIZARDS.
        // Optionally add more wizards
        // wizards.add(new Wizard("Wizard of Oz", 90 + random.nextInt(11)));
        System.out.println("Battle of Wizards has started!");
    }

    @Override
    public boolean endOfGame() {
        // The game ends when only one or none of the wizards have more than 0 health
        return wizards.stream().filter(wizard -> wizard.getHealth() > 0).count() <= 1;
    }

    @Override
    public void playSingleTurn(int player) {
        System.out.println("\n--- New Round ---"); // Adds a newline and a separator before each round

        // Create a temporary structure to hold damage values for each wizard
        int[] damages = new int[wizards.size()];
        for (int i = 0; i < wizards.size(); i++) {
            // Calculate damage for each wizard without applying it immediately
            damages[i] = 8 + random.nextInt(8); // Random damage between 8 and 15
        }

        // Apply the calculated damages to each wizard
        for (int i = 0; i < wizards.size(); i++) {
            Wizard currentWizard = wizards.get(i);
            Wizard opponentWizard = wizards.get((i + 1) % wizards.size());
            opponentWizard.reduceHealth(damages[i]);
            System.out.println(currentWizard.getName() + " casts a spell on " + opponentWizard.getName() + ". Damage: " + damages[i] + ". " + opponentWizard.getName() + "'s remaining health: " + opponentWizard.getHealth());
        }
    }


    @Override
    public void displayWinner() {
        List<Wizard> aliveWizards = wizards.stream().filter(wizard -> wizard.getHealth() > 0).toList();
        if (aliveWizards.size() == 1) {
            Wizard winner = aliveWizards.get(0);
            System.out.println("The winner is " + winner.getName() + " with " + winner.getHealth() + " health remaining!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
