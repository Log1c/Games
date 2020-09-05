package main.java.ua.logic.life;


import main.java.ua.logic.life.beans.Game;
import main.java.ua.logic.life.configurations.Glider;
import main.java.ua.logic.life.configurations.H;

public class Main {
    public static void main(String[] args) {
//        new Game(new Glider().get());
        new Game(new H().get());
    }
}
