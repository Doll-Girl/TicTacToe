package game;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Game implements IGame {

    protected Logger logger = Logger.getAnonymousLogger();

    protected Game() {
        init();
        try {
            Handler fileHandler = new FileHandler("log.txt");
            fileHandler.setLevel(Level.FINE);
            logger.addHandler(fileHandler);
            logger.setUseParentHandlers(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loop() {
        while (!isGameOver()) {
            processInput();
            updateGameState();
            drawGame();
        }
    }
}
