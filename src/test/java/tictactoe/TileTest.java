package tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@ExtendWith(MockitoExtension.class)
class TileTest {

    @ParameterizedTest
    @EnumSource(Position.class)
    void newTile(Position p) {
        Tile tile = new Tile(p);
        assertThat(tile, is(notNullValue()));
        assertThat(tile.getPlayerTurn(), is(PlayerTurn.PLAYER_NONE));
        assertThat(tile.getDirection(), is(p));
        assertThat(tile.isValid(), is(true));
    }

    @Test
    void toString_RIGHT() {
        Stream.of(Position.values())
                .filter(pos -> pos.name().endsWith("RIGHT"))
                .forEach(pos -> assertThat(new Tile(pos).toString(), is(" \n")));
    }

    @Test
    void toString_MIDDLE_LEFT() {
        Stream.of(Position.values())
                .filter(pos -> !pos.name().endsWith("RIGHT"))
                .forEach(pos -> assertThat(new Tile(pos).toString(), is(" ")));
    }

    @Nested
    class Method {

        private Tile tile;
        private Random rnd = new Random(System.currentTimeMillis());

        @BeforeEach
        void setUp() {
            tile = new Tile(Position.values()[rnd.nextInt(Position.values().length + 1)]);
        }

        @Test
        void setMarkOnEmptyTileNone() {
            assertThat(tile.setMark(PlayerTurn.PLAYER_NONE), is(true));
        }

        @Test
        void setMarkOnEmptyTile1() {
            assertThat(tile.setMark(PlayerTurn.PLAYER_ONE), is(true));
        }


        @Test
        void setMarkOnEmptyTile2() {
            assertThat(tile.setMark(PlayerTurn.PLAYER_TWO), is(true));
        }


        @Test
        void setMarkOnNonEmptyTile() {
            tile.setMark(PlayerTurn.PLAYER_ONE);

            assertThat(tile.setMark(PlayerTurn.PLAYER_NONE), is(false));
            assertThat(tile.setMark(PlayerTurn.PLAYER_ONE), is(false));
            assertThat(tile.setMark(PlayerTurn.PLAYER_TWO), is(false));
        }
    }
}