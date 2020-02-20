package agh.cs.lab1;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import static agh.cs.lab2.MapDirection.NORTH;

public class Animal {
    public MapDirection direction = NORTH;
    public Vector2d position = new Vector2d(0, 0);
    private IWorldMap map;

    public MapDirection getDirection() {
        return direction;
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        if (!this.map.isOccupied(initialPosition)) {
            this.position = initialPosition;
        }
    }

    public Vector2d getPosition() {
        return new Vector2d(this.position.x, this.position.y);
    }

    public String toString() {
        switch (this.direction) {
            case NORTH:
                return "N";
            case WEST:
                return "W";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
        }
        return null;
    }

    public void move(MoveDirection dir) {
        if (dir.equals(MoveDirection.LEFT)) {
            this.direction = this.direction.previous();
        }

        if (dir.equals(MoveDirection.RIGHT)) {
            this.direction = this.direction.next();
        }
        Vector2d destination = this.position.add(direction.toUnitVector());

        if (this.map.canMoveTo(destination)) {
            this.position = destination;
        }
    }

}