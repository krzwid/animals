package test;

import agh.cs.lab1.Direction;
import org.junit.Assert;
import org.junit.Test;

import static agh.cs.lab1.Direction.changeDirection;

public class DirectionTest {
    @Test
    public void changeDirectionTest() {
        Direction forward = Direction.F;
        Direction backward = Direction.B;
        Direction left = Direction.L;
        Direction right = Direction.R;

        String f = "f";
        String b = "b";
        String l = "l";
        String r = "r";
        String x = "x";

        Assert.assertEquals(forward, changeDirection(f));
        Assert.assertEquals(backward, changeDirection(b));
        Assert.assertEquals(left, changeDirection(l));
        Assert.assertEquals(right, changeDirection(r));
        Assert.assertNull(changeDirection(x));
    }
}