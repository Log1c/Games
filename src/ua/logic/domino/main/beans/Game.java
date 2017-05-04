package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Hidden hidden;
    private Snake snake;
    private List<Player> players = new ArrayList<>();
    private List<Turn> turns = new ArrayList<>();

    public Game(Hidden hidden, Snake snake, List<Player> players) {
        this.hidden = hidden;
        this.snake = snake;
        this.players = players;
        initPlayers();
    }

    private void initPlayers() {
        for (Player player : players) {
            player.setGame(this);
        }
    }

    public Bone takeBone() {
        return hidden.getBone();
    }

    public boolean isFinish() {
        if (snake.isFish()) {
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
            Turn turn = player.play();
            turns.add(turn);
            if (turn.getBone() != null) {
                snake.addBone(turn.getBone(), turn.getLinkType());
            }

            if (startPlayer == players.size()) {
                startPlayer = 0;
            }
        }
    }

    public Snake getSnake() {
        return snake;
    }

    public boolean isHiddenEmpty() {
        return hidden.isEmpty();
    }
}
