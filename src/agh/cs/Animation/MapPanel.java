package agh.cs.Animation;

import agh.cs.lab1.IWorldMap;
import agh.cs.lab1.OptionsParser;
import agh.cs.lab2.MoveDirection;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    int height = 15;
    int width = 15;
    String finalMap;
    IWorldMap map;
    MoveDirection[] directions;
    JTextArea animalMap;

    public MapPanel(String[] args, IWorldMap map){
        this.map = map;
        this.directions = new OptionsParser().parse(args);
        finalMap = map.toString();
        this.animalMap = new JTextArea(finalMap, height, width+10);
        Font font = new Font("Consolas", Font.BOLD, 18);
        this.animalMap.setFont(font);
        add(animalMap);
    }

    public void playAll(){
        map.run(directions);
        animalMap.setText(map.toString());
        revalidate();
    }
}
