package test;

import agh.cs.lab1.Animal;
import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {
    @Test
    public void move_orientation() {
        Animal animal = new Animal();
        Assert.assertEquals(MapDirection.NORTH, animal.direction);

        animal.move(MoveDirection.RIGHT);
        Assert.assertEquals(MapDirection.EAST, animal.direction);

        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(MapDirection.NORTH, animal.direction);

        animal.move(MoveDirection.LEFT);
        Assert.assertEquals(MapDirection.WEST, animal.direction);

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
        Assert.assertEquals(4, animal.position.y);

        animal.move(MoveDirection.FORWARD);
        Assert.assertEquals(0, animal.position.x);
        Assert.assertEquals(4, animal.position.y);
    }
}
