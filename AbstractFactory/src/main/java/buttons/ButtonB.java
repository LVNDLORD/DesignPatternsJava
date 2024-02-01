package buttons;

public class ButtonB extends Button {


    @Override
    public void display() {
        System.out.println("Button B");
        System.out.println("*" + "=".repeat(text.length() + 4) + "*");
        System.out.println("!  " + text +"  !");
        System.out.println("*" + "=".repeat(text.length() + 4) + "*");
    }
}
