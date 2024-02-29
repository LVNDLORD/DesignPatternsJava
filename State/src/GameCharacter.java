public class GameCharacter {
    private final String name;
    private int level;
    private int experience;
    private int health;
    private CharacterState currentState;

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.health = 100;
        this.currentState = new NoviceState();
    }

    public void train() {
        currentState.train(this);
    }

    public void meditate() {
        currentState.meditate(this);
    }

    public void fight() {
        currentState.fight(this);
    }

    public void displayStatus() {
        currentState.displayStatus(this);
    }

    public void setLevel(CharacterState newState) {
        this.currentState = newState;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public CharacterState getCurrentState() {
        return currentState;
    }

    public void increaseExperience(int points) {
        experience += points;
    }

    public void increaseHealth(int points) {
        health += points;
    }

    public void decreaseHealth(int points) {
        health -= points;
    }
}
