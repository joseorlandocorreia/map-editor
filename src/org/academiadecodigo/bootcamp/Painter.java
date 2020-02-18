package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Painter implements KeyboardHandler {

    private int numberOfRows;
    private int numberOfColumns;
    private int cellSize;
    private Cursor cursor;
    private Grid grid;

    private boolean painting = false;

    private final int PADDING = 10;

    public Painter(int numberOfRows, int numberOfColumns, int cellSize) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.cellSize = cellSize;

        grid = new Grid(numberOfRows, numberOfColumns, cellSize);
        cursor = new Cursor(PADDING, PADDING, cellSize, Color.RED);

        Keyboard keyboard = new Keyboard(this);
        KeyBinder keybinder = new KeyBinder(keyboard);
    }

    private String getCurrentCellKey() {
        return cursor.getCurrentCol().toString() + "-" + cursor.getCurrentRow().toString();
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        boolean alreadyPainted = grid.editorMap.get(getCurrentCellKey()).isFilled();
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (cursor.getCurrentRow() == 0) {
                    break;
                }
                if (painting && alreadyPainted) {
                    cursor.redrawCell(grid.editorMap.get(getCurrentCellKey()));
                }
                if (painting && !alreadyPainted) {
                    cursor.paintCell(grid.editorMap.get(getCurrentCellKey()), Color.BLUE);
                }
                cursor.moveUp();
                break;

            case KeyboardEvent.KEY_DOWN:
                if (cursor.getCurrentRow() == numberOfRows - 1) {
                    break;
                }
                if (painting && alreadyPainted) {
                    cursor.redrawCell(grid.editorMap.get(getCurrentCellKey()));
                }
                if (painting && !alreadyPainted) {
                    cursor.paintCell(grid.editorMap.get(getCurrentCellKey()), Color.BLUE);
                }
                cursor.moveDown();
                break;

            case KeyboardEvent.KEY_LEFT:
                if (cursor.getCurrentCol() == 0) {
                    break;
                }
                if (painting && alreadyPainted) {
                    cursor.redrawCell(grid.editorMap.get(getCurrentCellKey()));
                }
                if (painting && !alreadyPainted) {
                    cursor.paintCell(grid.editorMap.get(getCurrentCellKey()), Color.BLUE);
                }
                cursor.moveLeft();
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (cursor.getCurrentCol() == numberOfColumns - 1) {
                    break;
                }
                if (painting && alreadyPainted) {
                    cursor.redrawCell(grid.editorMap.get(getCurrentCellKey()));
                }
                if (painting && !alreadyPainted) {
                    cursor.paintCell(grid.editorMap.get(getCurrentCellKey()), Color.BLUE);
                }
                cursor.moveRight();
                break;

            case KeyboardEvent.KEY_T:
                painting = !painting;
                break;
            case KeyboardEvent.KEY_SPACE:
                painting = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                painting = false;
        }
    }
}
