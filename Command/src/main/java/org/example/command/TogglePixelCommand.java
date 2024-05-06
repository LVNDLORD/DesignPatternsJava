package org.example.command;

public class TogglePixelCommand implements Command {
    private final PixelArtEditor editor;
    private final int x, y;

    public TogglePixelCommand(PixelArtEditor editor, int x, int y) {
        this.editor = editor;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        editor.togglePixel(x, y);
    }
}