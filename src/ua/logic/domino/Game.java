package ua.logic.domino;

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

        return false;
    }

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
        Player player = getFirst();
        System.out.println(player);
    }
}
