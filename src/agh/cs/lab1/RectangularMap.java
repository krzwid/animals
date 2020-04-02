package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    int height;
    int width;
    List<Animal> animals = new ArrayList<>();

    public RectangularMap (int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!position.follows(new Vector2d(0, 0)) || !position.precedes(new Vector2d(width,height))){
            return false;
        }
        for (Animal animal : animals) {
            if (animal.position.x == position.x && animal.position.y == position.y) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        if(isOccupied(animal.position)){
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i = 0;
        for (MoveDirection direction : directions){
            animals.get(i).move(direction);
            i = (i+1)%animals.size();
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.position.equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (position.equals(animal.position)) {
                return animal;
            }
        }
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(width-1, height-1);
        return visualizer.draw(lowerLeft, upperRight);
    }
}


