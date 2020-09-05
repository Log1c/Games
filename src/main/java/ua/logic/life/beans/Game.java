package main.java.ua.logic.life.beans;

public class Game {
    private Area area;

    public Game(boolean[][] cells) {
        area = new Area(cells);
        start();
    }

    private void start() {
        int finish = 10;
        while (finish-- != 0) {
            area.print();
            turn();

            if (area.isEmpty()) {
                break;
            }
            System.out.println();
            System.out.println();
        }
    }

    private void turn() {
        this.area = area.turn();
    }

}
