package agh.cs.Animation;

import javax.swing.*;

public class Options extends JPanel{
    JButton nextMove = new JButton("Next move");
    JButton playAll = new JButton("Play all");
    JButton addbut = new JButton("I'm funny button added here");
    boolean activePlayAll = true;

    public Options(MapPanel map) {
        add(nextMove);
        nextMove.addActionListener(e -> {
            System.out.println("Some time in the future after many years of coding!");
            add(addbut);
            addbut.setVisible(true);
            revalidate();
        });

        add(playAll);
        playAll.addActionListener(e -> {
            if (activePlayAll){
                map.playAll();
                activePlayAll = false;
            }
        });
    }
}