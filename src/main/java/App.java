import com.google.inject.Guice;
import com.google.inject.Injector;
import game.IGame;

public class App {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Initializer());

        IGame game = injector.getInstance(IGame.class);

        game.loop();
    }
}