package main.java.ua.logic.domino.beans;

public enum Bone {
    BONE11(1, 1), BONE22(2, 2), BONE33(3, 3), BONE44(4, 4), BONE55(5, 5), BONE66(6, 6), BONE00(0, 0),
    BONE65(6, 5), BONE64(6, 4), BONE63(6, 3), BONE62(6, 2), BONE61(6, 1), BONE60(6, 0),
    BONE54(5, 4), BONE53(5, 3), BONE52(5, 2), BONE51(5, 1), BONE50(5, 0),
    BONE43(4, 3), BONE42(4, 2), BONE41(4, 1), BONE40(4, 0),
    BONE32(3, 2), BONE31(3, 1), BONE30(3, 0),
    BONE21(2, 1), BONE20(2, 0),
    BONE10(1, 0);

    private int up;
    private int down;
    private final int cost;
    private final boolean isDouble;
    private final boolean isDummy;

    public static int MAX_BONE = 6 + 1;

    Bone(int up, int down) {
        this.up = up;
        this.down = down;
        cost = up + down;
        isDouble = up == down;
        isDummy = isDouble() || contains(0);
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public void reverse() {
        int temp = up;
        up = down;
        down = temp;
    }

    public boolean contains(int number) {
        return (up == number || down == number);
    }

    public int getCost() {
        return cost;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public boolean isDummy() {
        return isDummy;
    }

    @Override
    public String toString() {
        return "" + up + down;
    }
}
