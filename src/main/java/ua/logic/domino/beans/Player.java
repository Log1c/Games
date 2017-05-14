package main.java.ua.logic.domino.beans;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected String name = "";
    protected List<Bone> hand = new ArrayList<>(7);

    protected abstract Bone getBoneFromHand(Snake snake);

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

    protected void addBoneToHand(Bone bone) {
        hand.add(bone);
    }
}
