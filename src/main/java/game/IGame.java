package game;


public interface IGame {

    default void init() {
    }

    void loop();

    void processInput();

    void updateGameState();

    void drawGame();

    boolean isGameOver();

}
