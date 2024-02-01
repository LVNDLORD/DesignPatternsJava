package textfields;

public class TextFieldB extends TextField {

    @Override
    public void display() {
        System.out.println("TextField B");
        System.out.println("\u250F" + "\u2550".repeat(30) + "\u2513");
        System.out.println("\u2551" + text + " ".repeat(30 - text.length()) + "\u2551");
        System.out.println("\u2551"  + " ".repeat(30) +  "\u2551");
        System.out.println("\u2517" + "\u2550".repeat(30) + "\u251B");
    }
}
