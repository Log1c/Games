package main.java.ua.logic.domino.beans;

import java.util.*;

public class Snake {
    private int leftConnect = -1;
    private int rightConnect = -1;
    private Deque<Bone> snake = new LinkedList<>();
    private Fish fish = new Fish();

    public int getLeftConnect() {
        return leftConnect;
    }

    public int getRightConnect() {
        return rightConnect;
    }

    public boolean addBone(Bone bone) {
        //connector only getUp()
        int connector = bone.getUp();

        if (!snake.isEmpty() && getLeftConnect() != connector
                && getRightConnect() != connector) {
            return false;
        }

        if (snake.isEmpty() || getRightConnect() == connector) {
            snake.addLast(bone);
            rightConnect = bone.getDown();
        } else if (getLeftConnect() == connector) {
            bone.reverse();
            snake.addFirst(bone);
            leftConnect = bone.getUp();
        }

        fish.addBone(bone);
        return true;
    }



    @Override
    public String toString() {
        String result = "";
        for (Bone bone : snake) {
            result+= " " + bone.toString();
        }

        return result;
    }

    public boolean isFish() {
        if (snake.isEmpty()) {
            return false;
        }

        return fish.isFish(getLeftConnect(), getRightConnect());
    }
}
