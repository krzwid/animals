package agh.cs.lab1;

import agh.cs.lab2.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.StrictMath.sqrt;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    int grassNumber;
    List<Grass> grassList = new ArrayList<>();
    public Map<Vector2d, Animal> getAnimals() {
        return animals;
    }
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
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (animal.getKey().equals(position)) {
                return false;
            }
        }
        if (objectAt(position) instanceof Grass) {
            ((Grass) objectAt(position)).position = randomGrassPosition();
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
        for(Grass grass: grassList) {
            if (grass.position.equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Map.Entry<Vector2d, Animal> animal : animals.entrySet()) {
            if (position.equals(animal.getKey())) {
                return animal.getValue();
            }
        }
        for (Grass grass: grassList) {
            if (position.equals(grass.position)){
                return grass;
            }
        }
        return null;
    }

    private Vector2d randomGrassPosition() {
        int tries = 0;
        while(tries < 1000) {

            Random a = new Random();
            Random b = new Random();
            int x = a.nextInt((int) sqrt(grassNumber * 10));
            int y = b.nextInt((int) sqrt(grassNumber * 10));
            Vector2d position = new Vector2d(x, y);
            if(objectAt(position) == null) {
                return position;
            }
            tries ++;
        }
        return null;
    }


}
