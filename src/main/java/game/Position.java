package game;

import com.google.common.collect.MoreCollectors;

import java.util.Arrays;

public enum Position {
    TOP_LEFT('7'),
    TOP('8'),
    TOP_RIGHT('9'),
    MIDDLE_LEFT('4'),
    MIDDLE('5'),
    MIDDLE_RIGHT('6'),
    BOTTOM_LEFT('1'),
    BOTTOM('2'),
    BOTTOM_RIGHT('3');


    private final char c;

    Position(char c) {
        this.c = c;
    }

    public static Position getDirection(char c) {
        return Arrays.stream(Position.values())
                .filter(d -> d.c == c)
                .collect(MoreCollectors.onlyElement());
    }

    public char getChar() {
        return c;
    }

}