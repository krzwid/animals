package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.StrictMath.sqrt;

public class GrassField implements IWorldMap {
    int grassNumber;
    List<Animal> animals = new ArrayList<>();
    List<Grass> grassList = new ArrayList<>();

    public GrassField (int grassNumber) {
        this.grassNumber = grassNumber;
        int tries = 0;
        for(int i=0; i<grassNumber; i++){

            boolean placed = false;
            while(!placed) {
                if (tries++ > 1000) {
                    break;
                }
                Random a = new Random();
                Random b = new Random();
                int x = a.nextInt((int) sqrt(grassNumber * 10));
                int y = b.nextInt((int) sqrt(grassNumber * 10));
                Vector2d position = new Vector2d(x, y);
                Grass grass = new Grass(position);
                if (!isOccupied(position)) {
                    grassList.add(grass);
                    placed = true;
                }
            }
                if(tries>1000) {
                    break;
                }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.position.equals(position)) {
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
        for(Grass grass: grassList) {
            if (grass.position.equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (position.equals(animal.position)) {
                return animal;
            }
        }
        for (Grass grass: grassList) {
            if (position.equals(grass.position)){
                return grass;
            }
        }
        return null;
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = lowerLeft(animals);
        Vector2d upperRight = upperRight(animals);
        return visualizer.draw(lowerLeft,upperRight);
    }

    Vector2d upperRight(List<Animal> animals){
        int maxX = animals.get(0).position.x;
        int maxY = animals.get(0).position.y;
        for (Animal animal: animals){
            if (animal.position.x > maxX) maxX = animal.position.x;
            if (animal.position.y > maxY) maxY = animal.position.y;
        }
        return new Vector2d(maxX, maxY);
    }

    Vector2d lowerLeft(List<Animal> animals) {
        int minX = animals.get(0).position.x;
        int minY = animals.get(0).position.y;
        for (Animal animal: animals) {
            if (animal.position.x < minX) minX = animal.position.x;
            if (animal.position.y < minY) minY = animal.position.y;
        }
        return new Vector2d(minX, minY);
    }
}
