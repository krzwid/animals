package agh.cs.lab1;

import agh.cs.Animation.MainApplication;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        //using GrassFieldMap
        try {

            MoveDirection[] directions = OptionsParser.parse(args);
            GrassField map = new GrassField(1);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(1, 1)));
            map.place(new Animal(map, new Vector2d(3, 3)));
            map.place(new Animal(map, new Vector2d(5, 5)));
            System.out.println(map.toString());
            map.run(directions);
//            map.getAnimals().forEach( (k,v)->{
//                    System.out.println(k + " -> " + v);
//            });
            System.out.println(map.toString());

//            launching window application
//            new MainApplication(args, map);

        }
        catch (IllegalArgumentException message) {
            System.out.println("Cannot launch application because: " + message);
        }

        System.out.println("Stop");

/*
        //using RectangularMap (without grass)
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(15, 15);
        map.place(new Animal(map));
        map.place(new Animal(map,new Vector2d(3,4)));
        map.place(new Animal(map,new Vector2d(1,5)));
        map.place(new Animal(map,new Vector2d(10,8)));
        System.out.println(map.toString());
        map.run(directions);
        System.out.println(map.toString());

        //launching window application
        new MainApplication(args, map);
        System.out.println("Stop");
*/
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