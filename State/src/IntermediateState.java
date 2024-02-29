public class IntermediateState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(15);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.increaseHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Sorry, at the Intermediate level you can only train and meditate .");
    }

    @Override
    public void displayStatus(GameCharacter character) {
        System.out.println("Character: " + character.getName() + ", Level: Intermediate, Experience: " + character.getExperience() + ", Health: " + character.getHealth());
        System.out.println("Available actions: Train, Meditate");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 70) {
            character.setLevel(new ExpertState());
            System.out.println("Congratulations! You have reached the Expert level!\n");
        }
    }
}

