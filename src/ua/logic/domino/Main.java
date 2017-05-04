package ua.logic.domino;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Player player1 = new Player("Smit", deck.getStartHand());
        Player player2 = new Player("Neo", deck.getStartHand());
        List<Player> players = new ArrayList<>();

        player1.printHand();
        player2.printHand();

        players.add(player1);
        players.add(player2);

        Game game = new Game(deck, players);
        game.play();
    }
}
