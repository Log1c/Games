package main.java.ua.logic.life.beans;


public class Area {
    private final int size;
    private boolean[][] cells;

    Area(boolean[][] cells) {
        this.cells = cells;
        size = cells.length;
    }

    Area turn() {
        boolean[][] result = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int neighbors = getNeighbors(i, j);
                result[i][j] = isGenerate(cells[i][j], neighbors);
            }
        }
        cells = result;

        return this;
    }

    private boolean isGenerate(boolean isAlive, int neighbors) {
        if (!isAlive && neighbors == 3) {
            return true;
        }

        if (isAlive && neighbors == 2) {
            return true;
        }

        if (isAlive && neighbors == 3) {
            return true;
        }

        return false;
    }

    private int getNeighbors(int i, int j) {
        int result = 0;

        //7
        if (isAlive(i - 1, j - 1)) {
            result++;
        }

        //8
        if (isAlive(i, j - 1)) {
            result++;
        }

        //9
        if (isAlive(i+1, j-1)) {
            result++;
        }

        //4
        if (isAlive(i-1, j)) {
            result++;
        }

        //6
        if (isAlive(i+1, j)) {
            result++;
        }

        //1
        if (isAlive(i-1, j+1)) {
            result++;
        }

        //2
        if (isAlive(i, j+1)) {
            result++;
        }

        //3
        if (isAlive(i + 1, j + 1)) {
            result++;
        }

        return result;
    }

    void print() {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (cells[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private boolean isAlive(int i, int j) {
        i = changeBordersIfNeeded(i);
        j = changeBordersIfNeeded(j);

        return cells[i][j];
    }

    private int changeBordersIfNeeded(int index) {
        if (index >= size) {
            return  0;
        } else if (index < 0) {
            return size - 1;
        }

        return index;
    }

    boolean isEmpty() {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (cells[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
