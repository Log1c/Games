package tests.java.ua.logic.domino.beans;

import main.java.ua.logic.domino.beans.Bone;
import main.java.ua.logic.domino.beans.Snake;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SnakeTest {
    @Test
    public void isNotFish1() {
        Snake snake = new Snake();

        Assert.assertTrue(!snake.isFish());
    }

    @Test
    public void isNotFish2() {
        Snake snake = new Snake();
        snake.addBone(Bone.BONE21);

        Assert.assertTrue(!snake.isFish());
    }

    @Test
    public void isNotFish3() {
        Snake snake = new Snake();
        snake.addBone(Bone.BONE66);
        snake.addBone(Bone.BONE65);

        snake.addBone(Bone.BONE54);
        Bone bone1 = Bone.BONE64;
        bone1.reverse();
        snake.addBone(bone1);

        Bone bone2 = Bone.BONE63;
        snake.addBone(bone2);

        snake.addBone(Bone.BONE32);

        Bone bone3 = Bone.BONE62;
        bone3.reverse();
        snake.addBone(bone3);

        snake.addBone(Bone.BONE61);
        snake.addBone(Bone.BONE10);

        Assert.assertTrue(!snake.isFish());
    }

    @Test
    public void isFish() {
        Snake snake = new Snake();
        snake.addBone(Bone.BONE66);
        snake.addBone(Bone.BONE65);

        snake.addBone(Bone.BONE54);
        Bone bone1 = Bone.BONE64;
        bone1.reverse();
        snake.addBone(bone1);

        Bone bone2 = Bone.BONE63;
        snake.addBone(bone2);

        snake.addBone(Bone.BONE32);

        Bone bone3 = Bone.BONE62;
        bone3.reverse();
        snake.addBone(bone3);

        snake.addBone(Bone.BONE61);
        snake.addBone(Bone.BONE10);

        Bone bone4 = Bone.BONE60;
        bone4.reverse();
        snake.addBone(bone4);

        Assert.assertTrue(snake.isFish());
    }

    @Test
    void getLeftBone() {
        Snake snake = new Snake();

        Assert.assertTrue(snake.getLeftBone() == null);
    }

    @Test
    void getRightBone() {
        Snake snake = new Snake();

        Assert.assertTrue(snake.getRightBone() == null);
    }

    @Test
    void getLeftConnect() {
        Snake snake = new Snake();

        snake.addBone(Bone.BONE21);
        Assert.assertTrue(snake.getLeftConnect() == 2);
        snake.addBone(Bone.BONE32);
        Assert.assertTrue(snake.getLeftConnect() == 2);
        Bone bone1 = Bone.BONE42;
        bone1.reverse();
        snake.addBone(bone1);
        Assert.assertTrue(snake.getLeftConnect() == 4);
    }

    @Test
    void getRightConnect() {
        Snake snake = new Snake();

        snake.addBone(Bone.BONE21);
        Assert.assertTrue(snake.getRightConnect() == 1);
        snake.addBone(Bone.BONE10);
        Assert.assertTrue(snake.getRightConnect() == 0);

    }

}