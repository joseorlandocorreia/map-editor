package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    private final int PADDING = 10;

    private int numberOfRows;
    private int numberOfColumns;
    private int cellSize;

    //<Key = "row"-"col", Color>
    public Map<String, Rectangle> editorMap = new HashMap<>();

    public Grid(int numberOfRows, int numberOfColumns, int cellSize) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.cellSize = cellSize;

        initGrid();
    }

    public void initGrid() {
        String cellKey;
        for (Integer rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            for (Integer colNumber = 0; colNumber < numberOfColumns; colNumber++) {

                Rectangle rectangle = new Rectangle((rowNumber * cellSize) + PADDING, (colNumber * cellSize) + PADDING, cellSize, cellSize);
                rectangle.setColor(Color.BLACK);
                rectangle.draw();

                cellKey = rowNumber.toString() + "-" + colNumber.toString();
                editorMap.put(cellKey, rectangle);

            }
        }
    }
}
