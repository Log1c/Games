package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Hidden hidden;
    private Snake snake;
    private List<Player> players = new ArrayList<>();//TODO erase it
    private List<Turn> turns = new ArrayList<>();
    PlayerIterable playerLoopIteratorable;

    public Game(Hidden hidden, Snake snake, List<Player> players) {
        this.hidden = hidden;
        this.snake = snake;
        this.players = players;
        init();
    }

    public void play() {
        for (Player player : playerLoopIteratorable) {
            if (isFinish()) {
                break;
            }
            Turn turn = player.play();
            turns.add(turn);//TODO it's Observer
            if (turn.getBone() != null) {
                snake.addBone(turn.getBone(), turn.getLinkType());
            }
        }
        System.out.println(snake);
        printScores();
    }

    private void init() {
        for (Player player : players) {
            player.setGame(this);
        }

        playerLoopIteratorable = new PlayerIterable(players, getFirst());
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
//        System.out.println("first is " + firstPlayer);
        return firstPlayer;
    }

    public Snake getSnake() {
        return snake;
    }

    public boolean isHiddenEmpty() {
        return hidden.isEmpty();
    }

    public int getScore(Player player) {
        int score = 0;
        List<Bone> playerHand = player.getHand();

        if (playerHand.size() == 1 && playerHand.get(0).isDummy()) {
            return 10;
        }

        for (Bone bone : player.getHand()) {
            score += bone.getCost();
        }

        return score;
    }

    public void printScores() {
        for (Player player : players) {
            System.out.println(player.toString() + ": " + getScore(player));
        }
    }
}
