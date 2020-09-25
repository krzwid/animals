package agh.cs.lab1;

import agh.cs.lab2.Vector2d;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);
}
