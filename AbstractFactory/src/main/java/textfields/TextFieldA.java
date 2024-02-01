package textfields;

public class TextFieldA extends TextField {


    @Override
    public void display() {
        System.out.println("TextField A");
        System.out.println("\u250F" + "-".repeat(20) + "\u2513");
        System.out.println("|" + text + " ".repeat(20 - text.length()) + "|");
        System.out.println("|"  + " ".repeat(20) +  "|");
        System.out.println("\u2517" + "-".repeat(20) + "\u251B");
    }
}
