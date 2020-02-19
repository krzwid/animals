package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        if (width < position.x || height < position.y) {
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
            animals.get(i%animals.size()).move(direction);
            i++;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.position.x == position.x && animal.position.y == position.y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }

    public String toString(){
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0,0);
        Vector2d upperRight = new Vector2d(width, height);
        return visualizer.draw(lowerLeft, upperRight);
    }
}

