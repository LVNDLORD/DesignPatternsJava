package factories;

import buttons.Button;
import buttons.ButtonA;
import buttons.ButtonB;
import checkboxes.Checkbox;
import checkboxes.CheckboxA;
import checkboxes.CheckboxB;
import textfields.TextField;
import textfields.TextFieldA;
import textfields.TextFieldB;

public class BFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        ButtonB button = new ButtonB();
        button.text = text;
        return button;
    }

    @Override
    public Checkbox createCheckbox(String text) {
        CheckboxB checkbox = new CheckboxB();
        checkbox.text = text;
        return checkbox;

    }

    @Override
    public TextField createTextField(String text) {
        TextFieldB textField = new TextFieldB();
        textField.text = text;
        return textField;
    }

}
