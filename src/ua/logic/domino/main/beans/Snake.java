package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Snake {
    private List<Bone> snake = new ArrayList<>();
    private Map<Integer, Integer> sumBones = new HashMap<>(Bone.values().length);

    public boolean isFish() {
        for (Integer sumBone : sumBones.values()) {
            if (Bone.MAX_BONE == sumBone) {
                return true;
            }
        }
        return false;
    }

    public Bone getFirstBone() {
        if (snake.size() == 0) {
            return null;
        }

        return snake.get(0);
    }

    public Bone getLastBone() {
        if (snake.size() == 0) {
            return null;
        }

        return snake.get(snake.size() - 1);
    }

    public int getFirstConnect() {
        Bone bone = getFirstBone();
        if (bone == null) {
            throw new IllegalStateException();
        }

        return bone.getDown();
    }

    public int getLastConnect() {
        Bone bone = getLastBone();
        if (bone == null) {
            throw new IllegalStateException();
        }

        return bone.getDown();
    }

    public boolean addBone(Bone bone, LinkType linkType) {
        addToFish(bone);

        if (linkType == LinkType.FIRST) {
            snake.add(0, bone);
        } else {
            snake.add(bone);
        }

        return true;
    }

    private void addToFish(Bone bone) {
        int up = bone.getUp();
        int down = bone.getDown();

        if (sumBones.containsKey(up)) {
            Integer i = sumBones.get(up);
            sumBones.put(up, i+1);
        } else {
            sumBones.put(up, 1);
        }

        if (sumBones.containsKey(down)) {
            Integer i = sumBones.get(down);
            sumBones.put(down, i+1);
        } else {
            sumBones.put(down, 1);
        }
    }

    public boolean isEmpty() {
        return snake.isEmpty();
    }
}
