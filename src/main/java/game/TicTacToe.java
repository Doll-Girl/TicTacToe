package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static game.Position.getPosition;

public class TicTacToe extends Game {

    private Board board;

    private PlayerTurn pt = PlayerTurn.PLAYER_ONE;

    private Tile tileToUpdate;

    public TicTacToe() {
        board = new Board();
    }

    @Override
    public void processInput() {
        String valid = "789\n456\n123";
        pt.mark.ifPresentOrElse(mark -> System.out.println("Player " + mark + ":s turn!"), RuntimeException::new);
        System.out.println("Choose a tile with the corresponding number:\n" + valid);
        boolean shouldStop = false;
        while (!shouldStop) {
            shouldStop = parseUserInput();
            if (!shouldStop) {
                System.out.println("Please input a valid tile.\n" + valid);
            }
        }

    }

    private boolean parseUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        try {
            c = (char) reader.read();
            Position position = getPosition(c);
            System.out.println("Read: " + position.name());
            tileToUpdate = board.getTile(position);
            return tileToUpdate.isValid();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateGameState() {
        tileToUpdate.setMark(pt);
        pt = pt == PlayerTurn.PLAYER_ONE ? PlayerTurn.PLAYER_TWO : PlayerTurn.PLAYER_ONE;
    }

    @Override
    public void drawGame() {
        board.print();
    }

    @Override
    public boolean isGameOver() {
        return board.win();
    }

    @Override
    public void loop() {
        super.loop();
        System.out.println("Congratulations player: " + board.getWinner().name());
    }
}
