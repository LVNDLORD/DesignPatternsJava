package main.java.org.flyweight;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class MapRenderer extends Application {
    private static final int TILE_SIZE = 70;
    private static final int MAP_WIDTH = 6;
    private static final int MAP_HEIGHT = 5;

    private static final Map map = new WildernessMap(); // default map

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPG Map Renderer");

        Group root = new Group();
        Canvas canvas = new Canvas(TILE_SIZE * MAP_WIDTH, TILE_SIZE * MAP_HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        renderMap(gc);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void renderMap(GraphicsContext gc) {
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                Tile tile = map.createTile();
                String tileGraphic = TileGraphicFactory.getTileGraphic(tile.getType());
                drawTile(gc, tileGraphic, x * TILE_SIZE, y * TILE_SIZE);
            }
        }
    }

    private void drawTile(GraphicsContext gc, String tileType, double x, double y) {
        Image tileImage = loadImageForTile(tileType);
        gc.drawImage(tileImage, x, y, TILE_SIZE, TILE_SIZE);
    }

    private Image loadImageForTile(String tileType) {
        String imagePath = "/org/flyweight/images" + tileType + ".png";
        return new Image(imagePath);
    }

    public static void main(String[] args) {
        launch(args);
    }
}