package main.java.ua.logic.life.configurations;

public class H implements Configuration {
    @Override
    public boolean[][] get() {
        boolean[][] cells = new boolean[size][size];
        cells[1][1] = true;
        cells[1][2] = true;
        cells[1][3] = true;
        cells[2][2] = true;
        cells[3][1] = true;
        cells[3][2] = true;
        cells[3][3] = true;

        return cells;
    }
}
