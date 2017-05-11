package main.java.ua.logic.domino.beans;

import java.util.*;

public class Snake {
    private Deque<Bone> snake = new LinkedList<>();
    private Fish fish = new Fish();

    public int getLeftConnect() {
        Bone bone = snake.getFirst();
        if (bone == null) {
            throw new IllegalStateException();
        }

        return bone.getUp();
    }

    public int getRightConnect() {
        Bone bone = snake.getLast();
        if (bone == null) {
            throw new IllegalStateException();
        }

        return bone.getDown();
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
        } else if (getLeftConnect() == connector) {
            bone.reverse();
            snake.addFirst(bone);
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
