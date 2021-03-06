package main.java.ua.logic.domino.beans;

import main.java.ua.logic.domino.beans.realisation.PlayerDummy;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Game {
    private Hidden hidden;
    private Snake snake;
    private List<Player> players = new ArrayList<>();
    private PlayerIterable playerIterable;
    private static Logger log = Logger.getLogger(Game.class.getName());

    public Game(Hidden hidden, Snake snake, List<Player> players) {
        this.hidden = hidden;
        this.snake = snake;
        this.players = players;
        init();
    }

    private boolean addBoneToSnake(Player player, Bone bone) {
        if (!snake.addBone(bone)) {
            return false;
        }
        player.getHand().remove(bone);
        return true;
    }

    private void playFirst() {
        Player player = getFirst();
        log.info("first is " + player.toString());

        addBoneToSnake(player, player.getMinBone());
    }

    public void play() {
        playFirst();
        for (PlayerDummy player : playerIterable) {
            if (isFinish()) {
                break;
            }
            Bone bone = null;
            while (bone == null) {
                bone = player.getBoneFromHand(snake);
                if (bone != null || isHiddenEmpty()) {
                    break;
                }
                player.addBoneToHand(takeBone());
            }
            if (bone == null) {
                continue;
            }
            if (!addBoneToSnake(player, bone)) {
                throw new IllegalStateException();
            }
            log.info(snake.toString());
        }
        printScores();
    }

    private void init() {
        playerIterable = new PlayerIterable(players, getFirst());
    }

    public Bone takeBone() {
        return hidden.getBone();
    }

    private boolean isFinish() {
        if (snake.isFish()) {
            log.info(Fish.fishText);

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
            log.info(player.toString() + ": " + getScore(player));
        }
    }
}
