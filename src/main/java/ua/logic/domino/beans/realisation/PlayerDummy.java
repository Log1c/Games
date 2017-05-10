package main.java.ua.logic.domino.beans.realisation;

import main.java.ua.logic.domino.beans.Bone;
import main.java.ua.logic.domino.beans.Player;
import main.java.ua.logic.domino.beans.Snake;

import java.util.List;

public class PlayerDummy extends Player {
    public PlayerDummy(String name, List<Bone> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public Bone getBoneFromHand(Snake snake) {
        for (Bone handBone : hand) {
            Bone bone = getTurn(snake, handBone);
            if (bone != null) {
                return bone;
            }
        }

        return null;
    }

    private Bone getTurn(Snake snake, Bone bone) {
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

}
