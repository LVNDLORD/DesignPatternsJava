package org.example.command;

public class MoveCursorRightCommand implements Command {
    private final PixelArtEditor editor;

    public MoveCursorRightCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.moveCursorRight();
    }
}