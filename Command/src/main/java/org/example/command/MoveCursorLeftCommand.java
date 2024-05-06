package org.example.command;

public class MoveCursorLeftCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorLeftCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorLeft();
    }
}