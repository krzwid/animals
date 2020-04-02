package agh.cs.lab1;
import agh.cs.Animation.BasicSwing;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

// TODO
// Ustawić odstępy miedzy literami na mapie

public class Main {
    public static void main(String[] args) {

        System.out.println("Start");

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(15, 15);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.place(new Animal(map,new Vector2d(1,5)));
        map.place(new Animal(map,new Vector2d(4,8)));
        new BasicSwing(args, map);
//        map.run(directions);
        System.out.println(map.toString());



/*
        Direction[] directions = Stream.of(args)
                .map(Direction::changeDirection)
                .filter(Objects::nonNull)
                .toArray(Direction[]::new);

        run(directions);
        Animal animal = new Animal();
        System.out.println(animal.toString());
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.FORWARD);
        System.out.println(animal.toString());

        MoveDirection[] moveDirections = OptionsParser.parse(args);

        for (MoveDirection moveDirection: moveDirections){
            animal.move(moveDirection);
        }
        System.out.println(animal.toString());
*/
        System.out.println("Stop");

    }

    public static void run(Direction[] directions) {
        for (Direction direction : directions) {
            switch (direction) {
                case F:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case B:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case R:
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case L:
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }
}


