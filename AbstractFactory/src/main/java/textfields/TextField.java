package textfields;


import app.UIElement;

public abstract class TextField extends UIElement {

    @Override
    public void setText(String text) {
        super.setText(text);
    }


    public abstract void display();
}
