package checkboxes;

public class CheckboxA extends Checkbox {

    @Override
    public void display() {
        System.out.println("Checkbox A");
        System.out.println(" [ ] " + text);
    }
}
