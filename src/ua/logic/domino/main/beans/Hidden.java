package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Hidden {
    private static final int START_COUNT_BONES = 7;

    private final Random random = new Random();
    private List<Bone> hidden = new ArrayList<>();

    public Hidden() {
        hidden.addAll(Arrays.asList(Bone.values()));
    }

    public Bone getBone() {
        Bone bone = hidden.get(random.nextInt(hidden.size()));
        hidden.remove(bone);

        return bone;
    }

    public void printHidden() {
        hidden.forEach(System.out::println);
    }

    public List<Bone> getStartHand() {
        List<Bone> result = new ArrayList<>(START_COUNT_BONES);
        for (int i = 0; i < START_COUNT_BONES; i++) {
            result.add(getBone());
        }

        return result;
    }

    public boolean isEmpty() {
        return hidden.isEmpty();
    }
}
