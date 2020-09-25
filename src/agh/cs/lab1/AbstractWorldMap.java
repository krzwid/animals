package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    Map<Vector2d,Animal> animals = new LinkedHashMap<>();

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.position)) {
            throw new IllegalArgumentException("Cannot place animal on " + animal.position + " position");
        }
        animals.put(animal.position, animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }

    @Override
    public void run(MoveDirection[] directions) {
        try {
            Animal[] animalsTab = this.animals.values().toArray(new Animal[0]);
            for(int i = 0; i < directions.length; i++) {
                animalsTab[i % animalsTab.length].move(directions[i]);
            }
        }
        catch (IllegalArgumentException argument) {
            System.out.println(argument+ "is not legal move specification");
        }
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = lowerLeft(animals);
        Vector2d upperRight = upperRight(animals);
        return visualizer.draw(lowerLeft, upperRight);
    }

    Vector2d upperRight(Map<Vector2d, Animal> animals) {
        int maxX = 0;
        int maxY = 0;

        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (animal.getKey().x > maxX) {
                maxX = animal.getKey().x;
            }
            if (animal.getKey().y > maxY) {
                maxY = animal.getKey().y;
            }
        }
        return new Vector2d(maxX, maxY);
    }

    Vector2d lowerLeft(Map<Vector2d, Animal> animals) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (animal.getKey().x < minX) {
                minX = animal.getKey().x;
            }
            if (animal.getKey().y < minY) {
                minY = animal.getKey().y;
            }
        }
        return new Vector2d(minX, minY);
    }
}