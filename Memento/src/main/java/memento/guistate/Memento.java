package memento.guistate;

import java.util.Arrays;
import java.time.LocalTime;

public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;
    private String time;

    public Memento(int[] options, boolean isSelected, String time) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.time = String.valueOf(LocalTime.now());
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options.clone(); // Return a copy of options array
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getStateMetadata() {
        // History: color state, checkbox status, timestamp
        return "Boxes: " + Arrays.toString(options) + ", Checkbox ticked: " + isSelected() + ", time " + time;
    }
}