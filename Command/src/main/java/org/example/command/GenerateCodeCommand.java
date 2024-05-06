package org.example.command;

public class GenerateCodeCommand implements Command {
    private final PixelArtEditor editor;

    public GenerateCodeCommand(PixelArtEditor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        editor.generateCode();
    }
}