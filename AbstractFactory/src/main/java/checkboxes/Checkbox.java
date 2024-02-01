package checkboxes;

import app.UIElement;

public abstract class Checkbox extends UIElement {

    @Override
    public void setText(String text) {
        super.setText(text);
    }


    public abstract void display();
}
