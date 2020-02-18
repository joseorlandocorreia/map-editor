package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private int cursorSize;
    private Color color;

    private Rectangle rectangle;

    public Cursor(int startXPos, int startYPos, int cursorSize, Color color) {
        this.cursorSize = cursorSize;
        this.color = color;

        rectangle = new Rectangle(startXPos + 1, startYPos + 1, cursorSize - 1, cursorSize - 1);
        rectangle.setColor(color);

        showCursor();
    }

    public void redrawCursor() {
        int lastXPos = rectangle.getX();
        int lastYPos = rectangle.getY();

        rectangle.delete();
        rectangle = new Rectangle(lastXPos, lastYPos, cursorSize, cursorSize);
        rectangle.setColor(color);

        showCursor();
    }

    public void paintCell(Rectangle rectangle, Color color) {
        rectangle.setColor(color);
        rectangle.fill();
    }

    public void redrawCell(Rectangle rectangle) {
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

    public Integer getCurrentRow() {
        return rectangle.getY() / cursorSize;
    }

    public Integer getCurrentCol() {
        return rectangle.getX() / cursorSize;
    }

    private void showCursor() {
        rectangle.fill();
    }


    public void moveUp() {
        rectangle.translate(0, -cursorSize);
    }

    public void moveDown() {
        rectangle.translate(0, cursorSize);
    }

    public void moveLeft() {
        rectangle.translate(-cursorSize, 0);
    }

    public void moveRight() {
        rectangle.translate(cursorSize, 0);
    }
}
