package main.java.org.flyweight;

public interface Tile {
    char getCharacter();
    String getDescription();
    String getType();
    String getIntrinsicState(); // New method for intrinsic state (tile type)
}