import com.google.inject.AbstractModule;
import game.IGame;
import game.TicTacToe;

public class Initializer extends AbstractModule {

    @Override
    protected void configure() {
        bind(IGame.class).to(TicTacToe.class);
    }
}
