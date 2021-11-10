package tictactoe;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PositionTest {

    @Test
    void invalidChar() {
        assertThat(Position.getPosition('0'), is(Optional.empty()));
    }


    @Test
    void validChars() {
        assertThat(Position.getPosition('1'), is(Optional.of(Position.BOTTOM_LEFT)));
        assertThat(Position.getPosition('2'), is(Optional.of(Position.BOTTOM)));
        assertThat(Position.getPosition('3'), is(Optional.of(Position.BOTTOM_RIGHT)));
        assertThat(Position.getPosition('4'), is(Optional.of(Position.MIDDLE_LEFT)));
        assertThat(Position.getPosition('5'), is(Optional.of(Position.MIDDLE)));
        assertThat(Position.getPosition('6'), is(Optional.of(Position.MIDDLE_RIGHT)));
        assertThat(Position.getPosition('7'), is(Optional.of(Position.TOP_LEFT)));
        assertThat(Position.getPosition('8'), is(Optional.of(Position.TOP)));
        assertThat(Position.getPosition('9'), is(Optional.of(Position.TOP_RIGHT)));
    }
}