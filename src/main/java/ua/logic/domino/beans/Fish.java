package main.java.ua.logic.domino.beans;

import java.util.*;

public class Fish {
    private Map<Integer, Integer> sumBones = new HashMap<>(Bone.values().length);

    public boolean isFish(int leftConnect, int rightConnect) {
        Set<Integer> valuesWithFish = new HashSet<>();
        for (Integer bone : sumBones.keySet()) {
            if (Bone.MAX_BONE == sumBones.get(bone)) {
                valuesWithFish.add(bone);
            }
        }

        return valuesWithFish.containsAll(Arrays.asList(leftConnect, rightConnect));
    }

    public void addBone(Bone bone) {
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
}
