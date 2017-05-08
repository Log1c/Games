package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    public String name = "";
    public List<Bone> hand = new ArrayList<>(7);

    protected abstract Bone play(Snake snake);

    List<Bone> getHand() {
        return hand;
    }

    Bone getMinBone() {
        return hand.stream().sorted().findFirst().orElse(null);
    }

    public void printHand() {
        System.out.println(name);
        hand.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return name;
    }

    public void addBoneToHand(Bone bone) {
        hand.add(bone);
    }
}
