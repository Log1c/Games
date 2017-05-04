package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.LinkedList;
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
            return new Turn(this, linkType, this.getMinBone());
        }
        int firstSnakeConnect = snake.getFirstConnect();
        int lastSnakeConnect = snake.getLastConnect();
        for (Bone handBone : hand) {
            if (firstSnakeConnect == handBone.getDown()) {
                linkType = LinkType.FIRST;
                bone = handBone;
            } else if (firstSnakeConnect == handBone.getUp()) {
                handBone.reverse();
                linkType = LinkType.FIRST;
                bone = handBone;
            } else if (lastSnakeConnect == handBone.getDown()) {
                linkType = LinkType.LAST;
                bone = handBone;
            } else if (lastSnakeConnect == handBone.getUp()) {
                handBone.reverse();
                linkType = LinkType.LAST;
                bone = handBone;
            }
        }

        while (bone == null && !game.isHiddenEmpty()) {
            Bone boneFromHidden = game.takeBone();

            if (firstSnakeConnect == boneFromHidden.getDown()) {
                linkType = LinkType.FIRST;
                bone = boneFromHidden;
            } else if (firstSnakeConnect == boneFromHidden.getUp()) {
                boneFromHidden.reverse();
                linkType = LinkType.FIRST;
                bone = boneFromHidden;
            } else if (lastSnakeConnect == boneFromHidden.getDown()) {
                linkType = LinkType.LAST;
                bone = boneFromHidden;
            } else if (lastSnakeConnect == boneFromHidden.getUp()) {
                boneFromHidden.reverse();
                linkType = LinkType.LAST;
                bone = boneFromHidden;
            }
        }
        if (bone != null) {
            hand.remove(bone);
        }

        return new Turn(this, linkType, bone);
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
