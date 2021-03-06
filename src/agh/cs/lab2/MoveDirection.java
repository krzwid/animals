package agh.cs.lab2;

public enum MoveDirection {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static MoveDirection changeMoveDirection (String direction){
        switch (direction){
            case "f" : return MoveDirection.FORWARD;
            case "b" : return MoveDirection.BACKWARD;
            case "l" : return MoveDirection.LEFT;
            case "r" : return MoveDirection.RIGHT;
            default: return null;
        }
    }
}
