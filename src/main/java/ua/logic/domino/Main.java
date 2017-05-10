package main.java.ua.logic.domino;

import main.java.ua.logic.domino.beans.*;
import main.java.ua.logic.domino.beans.realisation.PlayerDummy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hidden hidden = new Hidden();
        Snake snake = new Snake();
        PlayerDummy player1 = new PlayerDummy("Smit", hidden.getStartHand());
        PlayerDummy player2 = new PlayerDummy("Neo", hidden.getStartHand());
        List<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);

        Game game = new Game(hidden, snake, players);
        game.play();
    }
}
