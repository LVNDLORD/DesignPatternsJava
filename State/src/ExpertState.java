public class ExpertState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
        checkLevelUp(character);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.increaseHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        character.decreaseHealth(20);
        character.increaseExperience(40);
        checkLevelUp(character);
    }

    @Override
    public void displayStatus(GameCharacter character) {
        System.out.println("Character: " + character.getName() + ", Level: Expert, Experience: " + character.getExperience() + ", Health: " + character.getHealth());
        System.out.println("Available actions: Train, Meditate, Fight");
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 200) {
            character.setLevel(new MasterState());
            System.out.println("Congratulations! You have reached the Master level!\n");
        }
    }
}

