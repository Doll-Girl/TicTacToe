package game;

public class Tile {
    PlayerTurn pt;
    Position position;

    public Tile(Position position) {
        this.pt = PlayerTurn.PLAYER_NONE;
        this.position = position;
    }

    public boolean setMark(PlayerTurn pt) {
        if (isValid()) {
            this.pt = pt;
            return true;
        } else {
            return false;
        }
    }

    public Position getDirection() {
        return position;
    }

    public boolean isValid() {
        return pt.mark.isEmpty();
    }

    @Override
    public String toString() {
        String s = pt.mark.orElse(' ').toString();
        if (position == Position.TOP_RIGHT || position == Position.MIDDLE_RIGHT || position == Position.BOTTOM_RIGHT) {
            s += "\n";
        }
        return s;
    }
}