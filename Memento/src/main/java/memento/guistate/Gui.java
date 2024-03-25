package memento.guistate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.List;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        Label undo = new Label("Press Ctrl-Z to undo the last change.");
        Label redo = new Label("Press Ctrl-Y to redo the last change.");
        undo.setPadding(insets);
        redo.setPadding(insets);

        // Create "Show History" button
        Button showHistoryButton = new Button("Show History");

        // Set the action for the button
        showHistoryButton.setOnAction(event -> HistoryWindow());

        // Create a VBox for the button
        VBox buttonBox = new VBox(showHistoryButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(10));

        // create a VBox that contains the HBox, the CheckBox, undo, redo, and the "Show History" button
        VBox vBox = new VBox(hBox, checkBox, undo, redo, buttonBox);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            } else {
                System.out.println("Command not found");
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }


    public void HistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("history");

        ListView<String> listView = new ListView<>();
        List<String> historyDescriptions = controller.getStateHistoryMetadata();

        // Add state to each item in the list
        for (int i = 0; i < historyDescriptions.size(); i++) {
            String descriptionWithIndex = "State " + i + " : " + historyDescriptions.get(i);
            listView.getItems().add(descriptionWithIndex);
        }

        listView.setOnMouseClicked(event -> {
            int i = listView.getSelectionModel().getSelectedIndex();
            if (i >= 0) {
                // restore selected state
                controller.restoreStateFromHistory(i);
                updateGui();
            }
        });

        VBox vbox = new VBox(listView);
        Scene scene = new Scene(vbox, 400, 400);
        historyStage.setScene(scene);
        historyStage.show();
    }


    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
