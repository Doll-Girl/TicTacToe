package game;

import com.google.common.collect.MoreCollectors;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.MoreCollectors.onlyElement;
import static game.Position.BOTTOM;
import static game.Position.BOTTOM_LEFT;
import static game.Position.BOTTOM_RIGHT;
import static game.Position.MIDDLE;
import static game.Position.MIDDLE_LEFT;
import static game.Position.MIDDLE_RIGHT;
import static game.Position.TOP;
import static game.Position.TOP_LEFT;
import static game.Position.TOP_RIGHT;

public class Board {

    private List<Tile> tiles = new ArrayList<>(9);
    private List<List<Position>> winning = new ArrayList<>();
    private PlayerTurn winner;

    public Board() {
        for (Position value : Position.values()) {
            tiles.add(new Tile(value));
        }

        winning.add(List.of(TOP_LEFT, TOP, TOP_RIGHT));
        winning.add(List.of(MIDDLE_LEFT, MIDDLE, MIDDLE_RIGHT));
        winning.add(List.of(BOTTOM_LEFT, BOTTOM, BOTTOM_RIGHT));

        winning.add(List.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT));
        winning.add(List.of(TOP, MIDDLE, BOTTOM));
        winning.add(List.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT));

        winning.add(List.of(TOP_LEFT, MIDDLE, BOTTOM_RIGHT));
        winning.add(List.of(TOP_RIGHT, MIDDLE, BOTTOM_LEFT));

    }

    public boolean win() {
        return winning.stream()
                .map(positions -> positions.stream()
                        .map(this::getTile).toList())
                .map(this::hasWon)
                .filter(win -> win)
                .collect(MoreCollectors.toOptional())
                .orElse(false);
    }

    private boolean hasWon(List<Tile> winningTiles) {
        PlayerTurn last = null;
        for (Tile tile : winningTiles) {
            if (last == null) {
                last = tile.playerTurn;
            } else {
                if (tile.playerTurn.equals(PlayerTurn.PLAYER_NONE) ||
                        !last.equals(tile.playerTurn)) {
                    return false;
                }
            }
        }
        winner = last;
        return true;
    }

    public Tile getTile(Position d) {
        return tiles.stream().filter(t -> t.getDirection().equals(d)).collect(onlyElement());
    }


//    public boolean setTile(Position d, PlayerTurn pt) {
//        return getTile(d).setMark(pt);
//    }


    public List<Tile> getTiles() {
        return tiles;
    }


    public void print() {
        tiles.forEach(tile -> System.out.print(tile.toString()));
    }

    public PlayerTurn getWinner() {
        return winner;
    }
}