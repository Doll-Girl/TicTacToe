package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe extends Game {

    private Board board;

    private PlayerTurn pt = PlayerTurn.PLAYER_ONE;

    private List<Object> winning = new ArrayList<>();

    public TicTacToe() {
        board = new Board();
        winning.add(List.of(Position.TOP_LEFT, Position.TOP, Position.TOP_RIGHT));

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

    private Tile tileToUpdate;

    private boolean parseUserInput() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        try {
            c = (char) reader.read();
            Position position = Position.getDirection(c);
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
//        board.getTiles().stream().filter(tile -> tile.pt.mark.isPresent());
        return false;
    }


}
