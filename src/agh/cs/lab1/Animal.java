package agh.cs.lab1;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import static agh.cs.lab2.MapDirection.NORTH;

public class Animal{
    public MapDirection direction = NORTH;
    public Vector2d position = new Vector2d(0,0);
    private IWorldMap map;

    public MapDirection getDirection() {
        return direction;
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }

    public Animal (IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        if (!this.map.isOccupied(initialPosition)){
            this.position = initialPosition;
        }
    }

    public Vector2d getPosition() {
       return new Vector2d(this.position.x, this.position.y);
    }

    public String toString() {
        switch (this.direction){
            case NORTH : return "N";
            case WEST: return "W";
            case SOUTH: return "S";
            case EAST: return "E";
        }
        return null;
    }

    public void move(MoveDirection dir) {
        if(dir.equals(MoveDirection.LEFT)) {
            this.direction = this.direction.previous();
        }

        if(dir.equals(MoveDirection.RIGHT)) {
            this.direction = this.direction.next();
        }

        if(dir == MoveDirection.FORWARD){
            if(this.direction == NORTH){
                if(this.position.y + 1 <= 4){
                    Vector2d place = new Vector2d(position.x, position.y+1);
                    if (this.map.canMoveTo(place)){
                        this.position.y +=1;
                    }
                }
            }
            if(this.direction == MapDirection.SOUTH){
                if(0 <= this.position.y - 1){
                    Vector2d place = new Vector2d(position.x, position.y-1);
                    if(this.map.canMoveTo(place)){
                        this.position.y -=1;
                    }
                }
            }
            if(this.direction == MapDirection.WEST){
                if(0 <= this.position.x - 1 ){
                    Vector2d place = new Vector2d(position.x-1, position.y);
                    if(this.map.canMoveTo(place)){
                        this.position.x -=1;
                    }

                }
            }
            if(this.direction == MapDirection.EAST){
                if(this.position.x + 1 <= 4){
                    Vector2d place = new Vector2d(position.x+1, position.y);
                    if(this.map.canMoveTo(place)){
                        this.position.x +=1;
                    }
                }
            }
        }

        if(dir == MoveDirection.BACKWARD){
            if(this.direction == NORTH){
                if(0 <= this.position.y - 1){
                    Vector2d place = new Vector2d(position.x, position.y-1);
                    if(this.map.canMoveTo(place)){
                        this.position.y -=1;
                    }
                }
            }
            if(this.direction == MapDirection.SOUTH) {
                if(this.position.y + 1 <= 4){
                    Vector2d place = new Vector2d(position.x, position.y+1);
                    if(this.map.canMoveTo(place)){
                        this.position.y +=1;
                    }
                }
            }
            if(this.direction == MapDirection.WEST) {
                if(this.position.x + 1 <= 4){
                    Vector2d place = new Vector2d(position.x+1, position.y);
                    if(this.map.canMoveTo(place)){
                        this.position.x +=1;
                    }
                }
            }
            if(this.direction == MapDirection.EAST) {
                if(0 <= this.position.x - 1 ){
                    Vector2d place = new Vector2d(position.x-1, position.y);
                    if(this.map.canMoveTo(place)){
                        this.position.x -=1;
                    }
                }
            }
        }
    }
}