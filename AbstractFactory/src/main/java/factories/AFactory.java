package factories;

import buttons.Button;
import buttons.ButtonA;
import checkboxes.Checkbox;
import checkboxes.CheckboxA;
import textfields.TextField;
import textfields.TextFieldA;

public class AFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        ButtonA button = new ButtonA();
        button.setText(text);
        return button;
    }

    @Override
    public Checkbox createCheckbox(String text) {
        CheckboxA checkbox = new CheckboxA();
        checkbox.setText(text);
        return checkbox;

    }

    @Override
    public TextField createTextField(String text) {
        TextFieldA textField = new TextFieldA();
        textField.setText(text);
        return textField;
    }

}
