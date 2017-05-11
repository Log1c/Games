package main.java.ua.logic.domino.beans;

import main.java.ua.logic.domino.beans.realisation.PlayerDummy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Hidden hidden;
    private Snake snake;
    private List<Player> players = new ArrayList<>();
    private PlayerIterable playerIterable;

    public Game(Hidden hidden, Snake snake, List<Player> players) {
        this.hidden = hidden;
        this.snake = snake;
        this.players = players;
        init();
    }

    public boolean addBoneToSnake(Player player, Bone bone) {
        if (!snake.addBone(bone)) {
            return false;
        }
        player.getHand().remove(bone);
        return true;
    }

    public void playFirst() {
        Player player = getFirst();
        addBoneToSnake(player, player.getMinBone());
    }

    public void play() {
        playFirst();
        for (PlayerDummy player : playerIterable) {
            if (isFinish()) {
                break;
            }
            Bone bone = null;
            while (bone == null && !isHiddenEmpty()) {
                bone = player.getBoneFromHand(snake);
                if (bone == null) {
                    player.addBoneToHand(takeBone());
                }
            }
            if (bone == null) {
                continue;
            }
            if (!addBoneToSnake(player, bone)) {
                throw new IllegalStateException();
            }
            //TODO it's Logger
        }
        System.out.println(snake);
        printScores();
    }

    private void init() {
        playerIterable = new PlayerIterable(players, getFirst());
    }

    public Bone takeBone() {
        return hidden.getBone();
    }

    public boolean isFinish() {
        if (snake.isFish()) {
            System.out.println(Fish.fishText);
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
