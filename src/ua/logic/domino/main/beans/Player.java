package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.List;

public class Player implements Playable{
    private String name;
    private Game game;
    private List<Bone> hand = new ArrayList<>(7);

    public Player(String name, List<Bone> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public Turn play() {
        LinkType linkType = null;
        Bone bone = null;
        Snake snake = game.getSnake();
        if (snake.isEmpty()) {
            Bone firstTurnBone = getMinBone();
            hand.remove(firstTurnBone);
            System.out.println(firstTurnBone);

            return new Turn(this, linkType, firstTurnBone);
        }
;
        for (Bone handBone : hand) {
            Turn turn = getTurn(handBone);
            if (turn != null) {
                hand.remove(bone);

                return turn;
            }
        }

        while (bone == null && !game.isHiddenEmpty()) {
            Turn turn = getTurn(game.takeBone());
            if (turn != null) {
                hand.remove(bone);

                return turn;
            }

        }

        return null;
    }

    private Turn getTurn(Bone bone) {
        Snake snake = game.getSnake();
        int leftSnakeConnect = snake.getLeftConnect();
        int rightSnakeConnect = snake.getRightConnect();
        if (leftSnakeConnect == bone.getDown()) {
            return new Turn(this, LinkType.LEFT, bone);
        } else if (leftSnakeConnect == bone.getUp()) {
            bone.reverse();
            return new Turn(this, LinkType.LEFT, bone);
        } else if (rightSnakeConnect == bone.getDown()) {
            bone.reverse();
            return new Turn(this, LinkType.RIGHT, bone);
        } else if (rightSnakeConnect == bone.getUp()) {
            return new Turn(this, LinkType.RIGHT, bone);
        }

        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Bone> getHand() {
        return hand;
    }

    public void printHand() {
        System.out.println(name);
        hand.forEach(System.out::println);
    }

    public Bone getMinBone() {
        return hand.stream().sorted().findFirst().orElse(null);
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
