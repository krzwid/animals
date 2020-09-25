package test;

import agh.cs.lab1.*;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.stream.Stream;

//Sprawdź czy zwierzęta poruszają się poprawnie dla ciągu: f b r l f f r r f f f f f f f f.

public class RectangularMapTest {
    @Test
    public void place() {
        AbstractWorldMap map = new RectangularMap(10, 5);
        Animal animal1 = new Animal(map);
        Animal falseAnimal1 = new Animal(map);
        Animal animal2 = new Animal(map,new Vector2d(3,4));
        Assert.assertTrue(map.place(animal1));
        Assert.assertFalse(map.place(falseAnimal1));
        Assert.assertTrue(map.place(animal2));
//        MoveDirection[] directions = new OptionsParser().parse(args);
        MoveDirection[] direction = Stream.of("f", "b" ,"r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f", "x", "x")
                .map(MoveDirection::changeMoveDirection)
                .filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);

        map.run(direction);
        Assert.assertFalse(map.place(new Animal(map,new Vector2d(1,0))));
        Assert.assertFalse(map.place((new Animal(map, new Vector2d(2,7)))));
        Assert.assertEquals(animal1.position.toString(),"(1,0)");
        Assert.assertEquals(animal2.position.toString(),"(2,7)");
        Assert.assertEquals(animal1.direction.toString(), "Południe");
        Assert.assertEquals(animal2.direction.toString(), "Północ");
    }
}