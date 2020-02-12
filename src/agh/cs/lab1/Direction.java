package agh.cs.lab1;

public enum Direction {
    F, B, R, L;

    public static Direction changeDirection (String direction){
        switch (direction){
            case "f" : return Direction.F;
            case "b" : return Direction.B;
            case "l" : return Direction.L;
            case "r" : return Direction.R;
            default: return null;
        }
    }
}
