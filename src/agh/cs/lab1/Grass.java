package agh.cs.lab1;

import agh.cs.lab2.Vector2d;

public class Grass implements IMapElement{
    public Vector2d position = new Vector2d(0,0);
    public Grass (Vector2d position){
        this.position = position;
    }

    @Override
    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String toString(){
        return "*";
    }
}

