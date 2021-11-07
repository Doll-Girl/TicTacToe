package game;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Game implements IGame {

    private static int startTime;
    private static int frameTimes = 0;
    private static short frames = 0;

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

    public static void startCounter() {
        startTime = (int) System.currentTimeMillis();
    }

    public static Optional<Short> stopAndPost() {
        int endTime = (int) System.currentTimeMillis();
        frameTimes = frameTimes + endTime - startTime;
        ++frames;

        Optional<Short> result = Optional.empty();

        if (frameTimes >= 1000) {
            result = Optional.of(frames);
            frames = 0;
            frameTimes = 0;
        }
        return result;
    }

    @Override
    public void loop() {
        while (!isGameOver()) {
//            startCounter();
            processInput();
            updateGameState();
            drawGame();

//            stopAndPost().ifPresent(fps -> System.out.println("FPS: " + fps));
        }
    }
}
