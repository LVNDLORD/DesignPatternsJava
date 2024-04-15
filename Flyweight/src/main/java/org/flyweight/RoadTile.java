package main.java.org.flyweight;

public class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getDescription() {
        return "Road";
    }

    @Override
    public String getType() {
        return "Road";
    }

    @Override
    public String getIntrinsicState() {
        return getType();
    }
}