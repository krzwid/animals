package agh.cs.lab1;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static agh.cs.lab2.MapDirection.NORTH;

public class Animal implements IMapElement, IPositionChangeSubject{
    public MapDirection direction = NORTH;
    public Vector2d position = new Vector2d(0, 0);
    private final AbstractWorldMap map;
    private List<IPositionChangeObserver> positionChangeObservers;

    @Override
    public void addObserver(IPositionChangeObserver observer) {
        positionChangeObservers.add(observer);
    }

    @Override
    public void removeObserver(IPositionChangeObserver observer) {
        positionChangeObservers.remove(observer);
    }

    public MapDirection getDirection() {
        return direction;
    }

    public Animal(AbstractWorldMap map) {
        this.map = map;
        this.positionChangeObservers = new ArrayList<>();
    }

    public Animal(AbstractWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.positionChangeObservers = new ArrayList<>();

    }

    @Override
    public Vector2d getPosition() {
        return new Vector2d(this.position.x, this.position.y);
    }

    @Override
    public String toString(){
        return this.direction.toAbbr();
    }

    public void move(MoveDirection dir) {
        switch (dir) {
            case LEFT:
                this.direction = this.direction.previous();
                break;
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case FORWARD:
                Vector2d place = this.position.add(Objects.requireNonNull(this.direction.toUnitVector()));
                if (map.canMoveTo(place)) {
                    map.positionChanged(this.position, place);
                    this.position = place;
                }
                break;
            case BACKWARD:
                Vector2d place2 = this.position.subtract(Objects.requireNonNull(this.direction.toUnitVector()));
                if (map.canMoveTo(place2)) {
                    this.position = place2;
                }
                break;
        }
    }
}