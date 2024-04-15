package main.java.org.flyweight;

import java.util.Random;

public class WildernessMap implements Map {
    public WildernessMap() {
        System.out.println("RPG Map Generator");
        System.out.println("Created wilderness map\n");
    }

    @Override
    public Tile createTile() {
        Random random = new Random();
        int randomValue = random.nextInt(3);

        return switch (randomValue) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> throw new IllegalStateException("Unexpected value: " + randomValue);
        };
    }

    @Override
    public void display() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + "");
            }
            System.out.println();
        }
    }
}
