package agh.cs.Animation;

import agh.cs.lab1.IWorldMap;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;

public class MainApplication extends JFrame {
    JPanel panel = new JPanel();

    public MainApplication(String[] args, IWorldMap map) {
        super("Animals");
        setSize(700, 700);
        Dimension size = new Dimension(300, 300);
        setMinimumSize(size);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(panel);
        MapPanel mapPanel = new MapPanel(args, map);
        Options options = new Options(mapPanel);
        this.add(options, BorderLayout.NORTH);

        add(mapPanel, CENTER);
        setVisible(true);
    }
}
