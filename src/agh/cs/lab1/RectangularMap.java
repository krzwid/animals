package agh.cs.lab1;

import agh.cs.lab2.Vector2d;

import java.util.Map;

public class RectangularMap extends AbstractWorldMap {
    int height;
    int width;

    public RectangularMap (int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!position.follows(new Vector2d(0, 0)) || !position.precedes(new Vector2d(width,height))){
            return false;
        }
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (animal.getKey().equals(position)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (animal.getKey().equals(position)) {
                return true;
            }
        }
        return false;
    }

    public Object objectAt(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (position.equals(animal.getKey())) {
                return animal.getValue();
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