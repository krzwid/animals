package agh.cs.lab1;



public class World {
    public static void main(String[] args) {
        System.out.println("Start");
        Direction[] directions = new Direction[7];
        String[] direction_s = {"f", "r", "r", "l", "b", "f", "r"};
        for (int i=0; i<direction_s.length; i++){
            switch (direction_s[i]){
                case "f" :
                    directions[i] = Direction.f;
                    break;
                case "b" :
                    directions[i] = Direction.b;
                case "r" :
                    directions[i] = Direction.r;
                    break;
                case "l" :
                    directions[i] = Direction.l;
                    break;
            }
        }
        run(directions);
        System.out.println("\nKoniec");
    }
    public static void run (Direction[] directions){
        System.out.println("Zwierzak idzie do przodu");
        for(int i=0; i<directions.length; i++){
            switch (directions[i]){
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
                    System.out.println("Zwierzak skręca w lewo,");
                    break;
            }
        }
    }
}
