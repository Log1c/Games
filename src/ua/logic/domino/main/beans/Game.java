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

    //TODO refactor me
    private Player getFirst() {
        List<Bone> firstBone = new ArrayList<>(players.size());

        for (Player player : players) {
            firstBone.add(player.getMinBone());
        }
        Bone first = firstBone.stream().sorted().findFirst().orElse(null);
        for (Player player : players) {
            if (player.getHand().contains(first)) {
                return player;
            }
        }

        throw new IllegalStateException();
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
