package agh.cs.lab1;

import agh.cs.lab2.MoveDirection;

import java.util.Objects;
import java.util.stream.Stream;

public class OptionsParser {
    public static MoveDirection[] parse (String[] tab) {
        return Stream.of(tab)
            .map(MoveDirection::changeMoveDirection)
            .filter(Objects::nonNull)
            .toArray(MoveDirection[]::new);
    }
}
