import java.util.Random;

public class WildernessMap extends Map {

    public WildernessMap() {
        System.out.println("Wilderness map created\n");
    }

    @Override
    public Tile createTile() {
        Tile[] tileTypes = {new SwampTile(), new WaterTile(), new ForestTile()};
        return tileTypes[new Random().nextInt(tileTypes.length)];
    }

    @Override
    public void display() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(createTile().getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
