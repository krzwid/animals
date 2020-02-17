package agh.cs.lab1;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

public class Animal {
    public MapDirection direction = MapDirection.NORTH;
    public Vector2d position = new Vector2d(2,2);

    public String toString() {
        return this.direction.toString() + " " + this.position.toString();
    }

    public void move(MoveDirection dir) {
        if(dir.equals(MoveDirection.LEFT)) {
            switch (this.direction){
                case NORTH :
                    this.direction = MapDirection.WEST;
                    break;
                case SOUTH :
                    this.direction = MapDirection.EAST;
                    break;
                case WEST :
                    this.direction = MapDirection.SOUTH;
                    break;
                case EAST :
                    this.direction = MapDirection.NORTH;
                    break;
            }
        }
        if(dir.equals(MoveDirection.RIGHT)) {
            switch (this.direction){
                case NORTH :
                    this.direction = MapDirection.EAST;
                    break;
                case SOUTH :
                    this.direction = MapDirection.WEST;
                    break;
                case WEST :
                    this.direction = MapDirection.NORTH;
                    break;
                case EAST :
                    this.direction = MapDirection.SOUTH;
                    break;
            }
        }

        if(dir == MoveDirection.FORWARD){
            if(this.direction == MapDirection.NORTH){
                if(this.position.y + 1 <= 4){
                    this.position.y +=1;
                }
            }
            if(this.direction == MapDirection.SOUTH){
                if(0 <= this.position.y - 1){
                    this.position.y -=1;
                }
            }
            if(this.direction == MapDirection.WEST){
                if(0 <= this.position.x - 1 ){
                    this.position.x -=1;
                }
            }
            if(this.direction == MapDirection.EAST){
                if(this.position.x + 1 <= 4){
                        this.position.x +=1;
                }
            }
        }

        if(dir == MoveDirection.BACKWARD){
            if(this.direction == MapDirection.NORTH){
                if(0 <= this.position.y - 1){
                    this.position.y -=1;
                }
            }
            if(this.direction == MapDirection.SOUTH) {
                if(this.position.y + 1 <= 4){
                    this.position.y +=1;
                }
            }
            if(this.direction == MapDirection.WEST) {
                if(this.position.x + 1 <= 4){
                    this.position.x +=1;
                }
            }
            if(this.direction == MapDirection.EAST) {
                if(0 <= this.position.x - 1 ){
                    this.position.x -=1;
                }
            }
        }
    }
}