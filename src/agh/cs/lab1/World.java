package agh.cs.lab1;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        Direction[] directions = new Direction[args.length];
        int j = 0;
        for (String arg: args){
            switch (arg){
                case "f" :
                    directions[j] = Direction.f;
                    j++;
                    break;
                case "b" :
                    directions[j] = Direction.b;
                    j++;
                    break;
                case "r" :
                    directions[j] = Direction.r;
                    j++;
                    break;
                case "l" :
                    directions[j] = Direction.l;
                    j++;
                    break;
                default:
                    break;
            }
        }
        run(directions);
        System.out.println("\nStop");
    }
    public static void run (Direction[] directions){
        int j = 0;
        for(Direction direction: directions){
            switch (directions[j]){
                case f :
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case b :
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case r :
                    System.out.println("Zwierzak skręca w prawo");
                    break;
                case l :
                    System.out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    break;
            }
            j++;
        }
    }
}
