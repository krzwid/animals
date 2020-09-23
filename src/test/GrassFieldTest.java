package test;

import agh.cs.lab1.Animal;
import agh.cs.lab1.Grass;
import agh.cs.lab1.GrassField;
import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Objects;
import java.util.stream.Stream;

public class GrassFieldTest {

    GrassField grassField = new GrassField(0);

    @Test
    public void isOccupied(){
        Vector2d grass1position = new Vector2d(0,1);
        Vector2d grass2position = new Vector2d(2,2);

        Grass grass1 = new Grass(grass1position);
        Grass grass2 = new Grass(grass2position);

        Assert.assertFalse(grassField.isOccupied(grass1.getPosition()));
        Assert.assertFalse(grassField.isOccupied(grass2.getPosition()));
    }

    Vector2d animal1position = new Vector2d(2, 2);
    Vector2d animal2position = new Vector2d(1, 0);
    Vector2d animal3position = new Vector2d(1, 0);
    Animal animal1 = new Animal(grassField, animal1position);
    Animal animal2 = new Animal(grassField, animal2position);
    Animal animal3 = new Animal(grassField, animal3position);

    @Test
    public void place() {
        Assert.assertTrue(grassField.place(animal1));
        Assert.assertTrue(grassField.place(animal2));
        Assert.assertFalse(grassField.place(animal3));
    }
    MoveDirection[] directions =
            Stream.of("f", "f", "r", "l", "f", "f", "x", "x")
                    .map(MoveDirection::changeMoveDirection)
                    .filter(Objects::nonNull)
                    .toArray(MoveDirection[]::new);


    @Test
    public void run() {
        grassField.place(animal1);
        grassField.place(animal2);
        grassField.run(directions);
        Assert.assertEquals(MapDirection.EAST, animal1.getDirection());
        Assert.assertEquals(MapDirection.WEST, animal2.getDirection());
        Vector2d animal1position = new Vector2d(3,3);
        Vector2d animal2position = new Vector2d(0,1);

        Assert.assertEquals(animal1position, animal1.getPosition());
        Assert.assertEquals(animal2position, animal2.getPosition());
    }
}
