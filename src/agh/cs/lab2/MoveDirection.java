package agh.cs.lab2;

import agh.cs.lab1.Direction;

public enum MoveDirection {
    FORWARD, BACKWARD, RIGHT, LEFT;

    public static MoveDirection changeMoveDirection (String direction){
        switch (direction){
            case "f" : return MoveDirection.FORWARD;
            case "b" : return MoveDirection.BACKWARD;
            default: return null;
        }
    }
}
