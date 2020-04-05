package test;

import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class Vector2dTest {

    @Test
    public void equals() {
        Vector2d v1 = new Vector2d (1,1);
        Vector2d v2 = new Vector2d (1,1);
        Vector2d v3 = new Vector2d (1,4);
        Assert.assertEquals(v1, v2);
        Assert.assertNotEquals(v1, v3);
    }

    @Test
    public void String() {
        Vector2d v1 = new Vector2d (1,1);
        Vector2d v2 = new Vector2d (1,4);
        Assert.assertEquals("(1,1)", v1.toString());
        Assert.assertEquals("(1,4)", v2.toString());
    }

    @Test
    public void precedes() {
        Vector2d v1 = new Vector2d (1,1);
        Vector2d v2 = new Vector2d (1,1);
        Vector2d v3 = new Vector2d (1,4);
        Vector2d v4 = new Vector2d (-1,4);
        Assert.assertFalse(v1.precedes(v2));
        Assert.assertFalse(v1.precedes(v3));
        Assert.assertFalse(v1.precedes(v4));
    }

    @Test
    public void follows() {
        Vector2d v1 = new Vector2d (1,1);
        Vector2d v2 = new Vector2d (10,1);
        Vector2d v3 = new Vector2d (-1,-4);
        Vector2d v4 = new Vector2d (0,-4);
        Assert.assertFalse(v1.follows(v2));
        Assert.assertTrue(v1.follows(v3));
        Assert.assertTrue(v1.follows(v4));
    }

    @Test
    public void upperRight() {
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(1,0);
        Vector2d v3 = new Vector2d(1,1);
        Assert.assertEquals(v3, v1.upperRight(v2));
    }

    @Test
    public void lowerLeft() {
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(1,0);
        Vector2d v3 = new Vector2d(0,0);
        Assert.assertEquals(v3, v1.lowerLeft(v2));
    }

    @Test
    public void add() {
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(1,0);
        Vector2d v3 = new Vector2d(1,1);
        Assert.assertEquals(v3, v1.add(v2));
    }

    @Test
    public void subtract() {
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(1,0);
        Vector2d v3 = new Vector2d(-1,1);
        Assert.assertEquals(v3, v1.subtract(v2));
    }

    @Test
    public void opposite() {
        Vector2d v1 = new Vector2d(-5,1);
        Vector2d v2 = new Vector2d(5,-1);
        Assert.assertEquals(v2, v1.opposite());
    }
}
