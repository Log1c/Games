package main.java.ua.logic.domino;

import main.java.ua.logic.domino.beans.Game;
import main.java.ua.logic.domino.beans.Hidden;
import main.java.ua.logic.domino.beans.Player;
import main.java.ua.logic.domino.beans.Snake;
import main.java.ua.logic.domino.beans.realisation.PlayerDummy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Hidden hidden = new Hidden();
        Snake snake = new Snake();
        Player player1 = new PlayerDummy("Smit", hidden.getStartHand());
        Player player2 = new PlayerDummy("Neo", hidden.getStartHand());
        List<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);

        Game game = new Game(hidden, snake, players);
        game.play();
    }
}
