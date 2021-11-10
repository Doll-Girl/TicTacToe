package tictactoe;

import java.util.Optional;

enum PlayerTurn {
    PLAYER_NONE(Optional.empty()),
    PLAYER_ONE(Optional.of('X')),
    PLAYER_TWO(Optional.of('O'));

    public final Optional<Character> mark;

    PlayerTurn(Optional<Character> mark) {
        this.mark = mark;
    }
}