package game;

public class Tile {
    PlayerTurn playerTurn;
    Position position;

    public Tile(Position position) {
        this.playerTurn = PlayerTurn.PLAYER_NONE;
        this.position = position;
    }

    public boolean setMark(PlayerTurn playerTurn) {
        if (isValid()) {
            this.playerTurn = playerTurn;
            return true;
        } else {
            return false;
        }
    }

    public Position getDirection() {
        return position;
    }

    public boolean isValid() {
        return playerTurn.mark.isEmpty();
    }

    @Override
    public String toString() {
        String s = playerTurn.mark.orElse(' ').toString();
        if (position == Position.TOP_RIGHT || position == Position.MIDDLE_RIGHT || position == Position.BOTTOM_RIGHT) {
            s += "\n";
        }
        return s;
    }
}