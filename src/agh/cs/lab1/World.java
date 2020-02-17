package agh.cs.lab1;
import agh.cs.lab2.MoveDirection;

import java.util.Objects;
import java.util.stream.Stream;



public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        /*Direction[] directions = Stream.of(args)
                .map(Direction::changeDirection)
                .filter(Objects::nonNull)
                .toArray(Direction[]::new);

        run(directions);*/
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


