package ua.logic.domino.main.beans;

import java.util.ArrayList;
import java.util.List;

public class Player implements Playable{
    private String name;
    private List<Bone> hand = new ArrayList<>(7);

    public Player(String name, List<Bone> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public Bone play() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<Bone> getHand() {
        return hand;
    }

    public void printHand() {
        System.out.println(name);
        hand.forEach(System.out::println);
    }

    public Bone getMinBone() {
        return hand.stream().sorted().findFirst().orElse(null);
    }
}
