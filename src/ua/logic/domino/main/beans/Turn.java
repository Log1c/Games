package ua.logic.domino.main.beans;

public class Turn {
    private Playable player;
    private Bone bone;

    public Turn(Playable player, Bone bone) {
        this.player = player;
        this.bone = bone;
    }

    public Bone getBone() {
        return bone;
    }
}
