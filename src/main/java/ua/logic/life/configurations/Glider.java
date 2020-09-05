package main.java.ua.logic.life.configurations;

public class Glider implements Configuration {
    @Override
    public boolean[][] get() {
        boolean[][] cells = new boolean[size][size];
        cells[1][0] = true;
        cells[2][1] = true;
        cells[0][2] = true;
        cells[1][2] = true;
        cells[2][2] = true;

        return cells;
    }
}
