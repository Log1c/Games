package ua.logic.domino.main.beans;

public class Turn {
    private Playable player;
    private LinkType linkType;
    private Bone bone;

    public Turn(Playable player, LinkType linkType, Bone bone) {
        this.player = player;
        this.linkType = linkType;
        this.bone = bone;
    }

    public Bone getBone() {
        return bone;
    }

    public LinkType getLinkType() {
        return linkType;
    }
}
