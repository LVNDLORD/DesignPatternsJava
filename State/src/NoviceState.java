public class NoviceState implements CharacterState {

    // Novice char can only train
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Sorry, at the Novice level you can only train.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Sorry, at the Novice level you can only train .");
    }

    @Override
    public void displayStatus(GameCharacter character) {
        System.out.println("Character: " + character.getName() + ", Level: Novice, Experience: " + character.getExperience() + ", Health: " + character.getHealth());
        System.out.println("Available actions: Train");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 30) {
            character.setLevel(new IntermediateState());
            System.out.println("Congratulations! You have reached the Intermediate level!\n");
        }
    }
}

