public class Wizard {
    private String name;
    private int health;

    public Wizard(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Ensure health does not go below 0
        }
    }
}
