package test;

import agh.cs.lab1.Grass;
import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class GrassTest {
    Vector2d position = new Vector2d(2,2);
    Grass grass = new Grass(position);

    @Test
    public void getPositionTest() {
        Assert.assertEquals(position, grass.getPosition());
    }

    @Test
    public void toStringTest() {
        Assert.assertEquals("*", grass.toString());
    }
}
