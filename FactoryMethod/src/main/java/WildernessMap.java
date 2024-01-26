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


}
