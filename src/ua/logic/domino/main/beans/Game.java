package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players = new ArrayList<>();
    private List<Turn> turns = new ArrayList<>();

    public Game(Deck deck, List<Player> players) {
        this.deck = deck;
        this.players = players;
    }

    public Bone takeBone() {
        return deck.getBone();
    }

    public boolean isFinish() {
        if (deck.isFish()) {
            return true;
        }

        for (Player p : players) {
            if (p.getHand().size() == 0) {
                return true;
            }
        }

        return false;
    }

    private Player getFirst() {
        Player firstPlayer = players.get(0);
        for (Player player : players) {
            if (player.getMinBone().compareTo(firstPlayer.getMinBone()) < 0) {
                firstPlayer = player;
            }
        }

        return firstPlayer;
    }

    public void play() {
        Player player;
        int startPlayer = players.indexOf(getFirst());
        while (!isFinish()) {
            player = players.get(startPlayer++);
            player.play();
            if (startPlayer == players.size()) {
                startPlayer = 0;
            }
        }
    }
}
