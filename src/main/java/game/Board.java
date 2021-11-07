package game;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.MoreCollectors.onlyElement;

public class Board {

    private List<Tile> tiles = new ArrayList<>(9);

    public Board() {
        for (Position value : Position.values()) {
            tiles.add(new Tile(value));
        }

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
}