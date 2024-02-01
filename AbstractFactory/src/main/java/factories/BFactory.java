package factories;

import buttons.Button;
import buttons.ButtonB;
import checkboxes.Checkbox;
import checkboxes.CheckboxB;
import textfields.TextField;
import textfields.TextFieldB;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        ButtonB button = new ButtonB();
        button.setText(text);
        return button;
    }

    @Override
    public Checkbox createCheckbox(String text) {
        CheckboxB checkbox = new CheckboxB();
        checkbox.setText(text);
        return checkbox;

    }

    @Override
    public TextField createTextField(String text) {
        TextFieldB textField = new TextFieldB();
        textField.setText(text);
        return textField;
    }

}
