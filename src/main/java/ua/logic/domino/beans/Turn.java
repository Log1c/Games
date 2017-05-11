package main.java.ua.logic.domino.beans;

public class Turn {
    private Player player;
    private Bone bone;

    public Turn(Player player, Bone bone) {
        this.player = player;
        this.bone = bone;
    }

    public Bone getBone() {
        return bone;
    }
}