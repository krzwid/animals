package test;

import agh.cs.lab1.Animal;
import agh.cs.lab1.IWorldMap;
import agh.cs.lab1.RectangularMap;
import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;

import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void move_orientation() {
        IWorldMap map = new RectangularMap(4,4);
        Vector2d position = new Vector2d(2,2);
        Animal animal = new Animal(map, position);
        Assert.assertEquals(MapDirection.NORTH, animal.getDirection());

        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(MapDirection.EAST, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(MapDirection.NORTH, animal.getDirection());

        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(MapDirection.WEST, animal.getDirection());

        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(1, animal.position.x);
        Assert.assertEquals(2, animal.position.y);


        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(0, animal.position.x);
        Assert.assertEquals(2, animal.position.y);

        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(0, animal.position.x);
        Assert.assertEquals(2, animal.position.y);

        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(0, animal.position.x);
        Assert.assertEquals(3, animal.position.y);

        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(0, animal.position.x);
        Assert.assertEquals(3, animal.position.y);
        Assert.assertEquals(MapDirection.NORTH, animal.getDirection());

        animal.move(MoveDirection.BACKWARD);
        Assert.assertEquals(0, animal.position.x);
        Assert.assertEquals(2, animal.position.y);
        Assert.assertEquals(MapDirection.NORTH, animal.getDirection());
    }
}
