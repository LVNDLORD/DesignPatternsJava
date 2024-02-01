package buttons;

import app.UIElement;

public abstract class Button extends UIElement {

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    public abstract void display();
}
