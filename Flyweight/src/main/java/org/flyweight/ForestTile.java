package main.java.org.flyweight;

public class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getDescription() {
        return "Forest";
    }

    @Override
    public String getType() {
        return "Forest";
    }
    @Override
    public String getIntrinsicState() {
        return getType();
    }
}
