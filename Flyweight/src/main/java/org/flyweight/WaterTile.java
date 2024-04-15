package main.java.org.flyweight;

public class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getDescription() {
        return "Water";
    }

    @Override
    public String getType() {
        return "Water";
    }

    @Override
    public String getIntrinsicState() {
        return getType();
    }
}
