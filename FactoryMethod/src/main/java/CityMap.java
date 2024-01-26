import java.util.Random;

public class CityMap extends Map {

    public CityMap() {
        System.out.println("City map created\n");
    }

    @Override
    public Tile createTile() {
        Tile[] tileTypes = {new RoadTile(), new ForestTile(), new BuildingTile()};
        return tileTypes[new Random().nextInt(tileTypes.length)];
    }

}
