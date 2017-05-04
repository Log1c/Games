package ua.logic.domino.main;

import ua.logic.domino.main.beans.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hidden hidden = new Hidden();
        Snake snake = new Snake();
        Player player1 = new Player("Smit", hidden.getStartHand());
        Player player2 = new Player("Neo", hidden.getStartHand());
        List<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);

        Game game = new Game(hidden, snake, players);
        game.play();
    }
}
