package josep.minesweeper;

public class Tile {

    private boolean mine;
    private boolean flagged;
    private boolean hidden;
    private int value;

    public Tile(boolean isMine) {
        this.mine = true;
    }

    public Tile(int value) {
        this.value = value;
    }

    public boolean isMine() {
        return mine;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean isHidden() {
        return hidden;
    }

    public int getValue() {
        return value;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    @Override
    public String toString() {
        if (hidden) {
            return "#";
        }
        return mine ? "X" : value + "";
    }
}
