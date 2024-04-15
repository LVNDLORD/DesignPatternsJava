package main.java.org.flyweight;

public class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getDescription() {
        return "Building";
    }

    @Override
    public String getType() {
        return "Building";
    }

    @Override
    public String getIntrinsicState() {
        return getType();
    }
}
