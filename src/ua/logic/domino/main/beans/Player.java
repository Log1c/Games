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
    public Bone play() {
        for (Bone handBone : hand) {
            Bone bone = getTurn(handBone);
            if (bone != null) {
                hand.remove(bone);

                return bone;
            }
        }

//        while (!game.isHiddenEmpty()) {
//            Bone bone = getTurn(game.takeBone());
//            if (bone != null) {
//                hand.remove(bone);
//
//                return bone;
//            }
//
//        }

        return null;
    }

    private Bone getTurn(Bone bone) {
        Snake snake = game.getSnake();
        int leftSnakeConnect = snake.getLeftConnect();
        int rightSnakeConnect = snake.getRightConnect();
        if (leftSnakeConnect == bone.getDown()) {
            bone.reverse();
            return bone;
        } else if (leftSnakeConnect == bone.getUp()) {
            return bone;
        } else if (rightSnakeConnect == bone.getDown()) {
            bone.reverse();
            return bone;
        } else if (rightSnakeConnect == bone.getUp()) {
            return bone;
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

    public void addBoneToHand(Bone bone) {
        hand.add(bone);
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
