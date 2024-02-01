package buttons;

public class ButtonA extends Button {

    @Override
    public void display() {
        System.out.println("Button A");
        System.out.println("\u25D6" + "-".repeat(text.length() + 4) + "\u25D7");
        System.out.println("\u25D6  " + text + "  \u25D7");
        System.out.println("\u25D6" + "-".repeat(text.length() + 4) + "\u25D7");
    }
}
