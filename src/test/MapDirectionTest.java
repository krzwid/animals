package test;

import agh.cs.lab2.MapDirection;
import org.junit.Assert;
import org.junit.Test;

public class MapDirectionTest {

    @Test
    public void next() {
        Assert.assertEquals("Zachód", MapDirection.SOUTH.next());
        Assert.assertEquals("Wschód", MapDirection.NORTH.next());
        Assert.assertEquals("Północ", MapDirection.WEST.next());
        Assert.assertEquals("Południe", MapDirection.EAST.next());
    }

    @Test
    public void previous() {
        Assert.assertEquals("Wschód", MapDirection.SOUTH.previous());
        Assert.assertEquals("Zachód", MapDirection.NORTH.previous());
        Assert.assertEquals("Południe", MapDirection.WEST.previous());
        Assert.assertEquals("Północ", MapDirection.EAST.previous());
    }
}
