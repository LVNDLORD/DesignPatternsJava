import java.util.Random;

public class Game {

    public Map createMap() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Map map = game.createMap();
        map.display();
    }


}
