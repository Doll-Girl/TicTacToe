package game;

import java.util.logging.Level;

public class TicTacToe extends Game {

    @Override
    public void processInput() {
        logger.log(Level.INFO, "waiting for input..");
    }

    @Override
    public void updateGameState() {
        logger.log(Level.INFO, "updating game state");
    }

    @Override
    public void drawGame() {
        logger.log(Level.INFO, "render game state");
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
