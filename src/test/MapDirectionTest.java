package test;

import agh.cs.lab2.MapDirection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class MapDirectionTest {
    MapDirection south = MapDirection.SOUTH;
    MapDirection north = MapDirection.NORTH;
    MapDirection east = MapDirection.EAST;
    MapDirection west = MapDirection.WEST;

    @Test
    public void next() {
        Assert.assertEquals(west, MapDirection.SOUTH.next());
        Assert.assertEquals(east, MapDirection.NORTH.next());
        Assert.assertEquals(north, MapDirection.WEST.next());
        Assert.assertEquals(south, MapDirection.EAST.next());
    }

    @Test
    public void previous() {
        Assert.assertEquals(east, MapDirection.SOUTH.previous());
        Assert.assertEquals(west, MapDirection.NORTH.previous());
        Assert.assertEquals(south, MapDirection.WEST.previous());
        Assert.assertEquals(north, MapDirection.EAST.previous());
    }
}
