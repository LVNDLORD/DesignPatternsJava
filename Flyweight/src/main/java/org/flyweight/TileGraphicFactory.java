package main.java.org.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, String> tileGraphics = new HashMap<>();

    public static String getTileGraphic(String type) {
        // Check if the graphic for this tile type already exists
        if (!tileGraphics.containsKey(type)) {
            String graphic = generateGraphicForTile(type);
            tileGraphics.put(type, graphic);
        }
        return tileGraphics.get(type);
    }

    private static String generateGraphicForTile(String type) {
        return switch (type) {
            case "Road" -> "road";
            case "Forest" -> "forest";
            case "Building" -> "building";
            case "Water" -> "water";
            case "Swamp" -> "swamp";
            default -> "?"; // Default representation for unknown tiles
        };
    }
}