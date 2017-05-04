package ua.logic.domino.main.beans;

import java.util.*;

public class Deck {
    private static final int MAX_BONE = 6;
    private static final int START_COUNT_BONES = 7;

    private List<Bone> snake = new ArrayList<>();
    private List<Bone> hidden = new ArrayList<>();

    final Random random = new Random();

    public Deck() {
        fillHidden();
//        printHidden();
    }

    public Bone getBone() {
        return hidden.get(random.nextInt(hidden.size()));
    }

    public boolean isFish() {
        return false;
    }

    private void fillHidden() {
        hidden.addAll(Arrays.asList(Bone.values()));
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
}
