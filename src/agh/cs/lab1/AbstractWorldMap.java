package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    List<Animal> animals = new ArrayList<>();

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.position)) {
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int i = 0;
        for (MoveDirection direction : directions) {
            animals.get(i).move(direction);
            i = (i + 1) % animals.size();
        }
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = lowerLeft(animals);
        Vector2d upperRight = upperRight(animals);
        return visualizer.draw(lowerLeft, upperRight);
    }

    Vector2d upperRight(List<Animal> animals) {
        int maxX = animals.get(0).position.x;
        int maxY = animals.get(0).position.y;
        for (Animal animal : animals) {
            if (animal.position.x > maxX) maxX = animal.position.x;
            if (animal.position.y > maxY) maxY = animal.position.y;
        }
        return new Vector2d(maxX, maxY);
    }

    Vector2d lowerLeft(List<Animal> animals) {
        int minX = animals.get(0).position.x;
        int minY = animals.get(0).position.y;
        for (Animal animal : animals) {
            if (animal.position.x < minX) minX = animal.position.x;
            if (animal.position.y < minY) minY = animal.position.y;
        }
        return new Vector2d(minX, minY);
    }
}