package app;

import buttons.Button;
import checkboxes.Checkbox;
import factories.UIFactory;
import textfields.TextField;

public class Application {
    private Button button;
    private Checkbox checkbox;
    private TextField textField;

    public Application(UIFactory factory) {
        button = factory.createButton("Click me");
        checkbox = factory.createCheckbox("Check me");
        textField = factory.createTextField("Enter text here");
    }

    public void display() {
        button.display();
        checkbox.display();
        textField.display();
    }
}
