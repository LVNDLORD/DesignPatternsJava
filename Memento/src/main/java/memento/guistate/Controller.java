package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;

    // protected static for debug and visual Gui sout in console. private by default
    protected static List<IMemento> history; // Memento history
    protected static List<IMemento> redohistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redohistory = new ArrayList<>();

    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            saveToRedoHistory();
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }


    public void redo() {
        if (!redohistory.isEmpty()) {
            System.out.println("Redoing...");
            IMemento nextState = redohistory.remove(redohistory.size() - 1);
            model.restoreState(nextState);
            history.add(nextState); // Add the restored state back to the undo history
            gui.updateGui();
        } else {
            System.out.println("No more actions to redo.");
        }
    }


    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void saveToRedoHistory() {
        IMemento currentState = model.createMemento();
        redohistory.add(currentState);
    }
}