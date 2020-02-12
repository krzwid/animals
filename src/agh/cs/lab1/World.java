package agh.cs.lab1;
import java.util.stream.Stream;


public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        Direction[] directions = Stream.of(args)
                .map(Direction::changeDirection)
                .filter(direction -> direction != null)
                .toArray(Direction[]::new);

        run(directions);

        System.out.println("Stop");
    }
    public static void run (Direction[] directions){
        for(Direction direction: directions){
            switch (direction){
                case F :
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case B :
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case R :
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case L :
                    System.out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }
}
