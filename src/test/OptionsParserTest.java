package test;

import agh.cs.lab1.OptionsParser;
import agh.cs.lab2.MoveDirection;
import org.junit.Assert;
import org.junit.Test;

public class OptionsParserTest {
    @Test
    public void parse(){
        String[] tab = new String[] {"f", "q", "r", "x", "b", "l", "g"};
        MoveDirection[] directions = new MoveDirection[]
                {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.LEFT};
        Assert.assertArrayEquals(directions, OptionsParser.parse(tab));
    }
}
