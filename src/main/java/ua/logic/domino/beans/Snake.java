package main.java.ua.logic.domino.beans;

import java.util.*;

public class Snake {
    private Deque<Bone> snake = new LinkedList<>();
    private Map<Integer, Integer> sumBones = new HashMap<>(Bone.values().length);

    public boolean isFish() {
        if (snake.isEmpty()) {
            return false;
        }

        Set<Integer> valuesWithFish = new HashSet<>();
        for (Integer bone : sumBones.keySet()) {
            if (Bone.MAX_BONE == sumBones.get(bone)) {
                valuesWithFish.add(bone);
            }
        }

        return valuesWithFish.containsAll(Arrays.asList(getLeftConnect(), getRightConnect()));
    }

    public Bone getLeftBone() {
        if (snake.size() == 0) {
            return null;
        }

        return snake.getFirst();
    }

    public Bone getRightBone() {
        if (snake.size() == 0) {
            return null;
        }

        return snake.getLast();
    }

    public int getLeftConnect() {
        Bone bone = getLeftBone();
        if (bone == null) {
            throw new IllegalStateException();
        }

        return bone.getUp();
    }

    public int getRightConnect() {
        Bone bone = getRightBone();
        if (bone == null) {
            throw new IllegalStateException();
        }

        return bone.getDown();
    }

    public boolean addBone(Bone bone) {
        //connector only getUp()
        int connector = bone.getUp();

        if (!snake.isEmpty() && getLeftConnect() != connector && getRightConnect() != connector) {
            return false;
        }

        if (snake.isEmpty() || getRightConnect() == connector) {
            snake.addLast(bone);
        } else if (getLeftConnect() == connector) {
            bone.reverse();
            snake.addFirst(bone);
        }

        addToFish(bone);

        return true;
    }

    private void addToFish(Bone bone) {//TODO it's Observer
        int up = bone.getUp();
        int down = bone.getDown();

        if (sumBones.containsKey(up)) {
            Integer i = sumBones.get(up);
            sumBones.put(up, i+1);
        } else {
            sumBones.put(up, 1);
        }

        if (up == down) {
            return;
        }

        if (sumBones.containsKey(down)) {
            Integer i = sumBones.get(down);
            sumBones.put(down, i+1);
        } else {
            sumBones.put(down, 1);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Bone bone : snake) {
            result+= " " + bone.toString();
        }

        return result;
    }
}
