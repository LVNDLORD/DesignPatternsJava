package org.example.command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {

    private final int SIZE = 8;
    private int[][] grid = new int[SIZE][SIZE];
    private int cursorX = 0;
    private int cursorY = 0;
    private GridPane gridPane;

    @Override
    public void start(Stage primaryStage) {
        gridPane = new GridPane();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button pixel = createPixel(i, j);
                gridPane.add(pixel, i, j);
            }
        }


        Button generateCodeButton = new Button("Generate Code");
        generateCodeButton.setOnAction(e -> generateCode());
        gridPane.add(generateCodeButton, 0, SIZE);

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pixel Art Editor");
        primaryStage.show();


    }

    private Button createPixel(int x, int y) {
        Button pixel = new Button();
        pixel.setMinSize(30, 30);
        pixel.setOnAction(e -> togglePixel(x, y));
        return pixel;
    }

    private void togglePixel(int x, int y) {
        grid[x][y] = (grid[x][y] == 0) ? 1 : 0;
    }

    private void generateCode() {
        StringBuilder code = new StringBuilder("int[][] pixelArt = {\n");
        for (int i = 0; i < SIZE; i++) {
            code.append("{");
            for (int j = 0; j < SIZE; j++) {
                code.append(grid[i][j]);
                if (j < SIZE - 1) code.append(", ");
            }
            code.append("}");
            if (i < SIZE - 1) code.append(",\n");
        }
        code.append("\n};");
        System.out.println(code.toString());
    }

    public void moveCursorUp() {
        if (cursorY > 0) {
            cursorY--;
        }
    }

    public void moveCursorDown() {
        if (cursorY < SIZE - 1) {
            cursorY++;
        }
    }

    public void moveCursorLeft() {
        if (cursorX > 0) {
            cursorX--;
        }
    }

    public void moveCursorRight() {
        if (cursorX < SIZE - 1) {
            cursorX++;
        }
    }


}
