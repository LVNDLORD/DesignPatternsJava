package main.java.org.flyweight;

public class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getDescription() {
        return "Swamp";
    }

    @Override
    public String getType() {
        return "Swamp";
    }

    @Override
    public String getIntrinsicState() {
        return getType();
    }
}
