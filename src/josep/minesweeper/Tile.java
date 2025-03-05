package josep.minesweeper;

public class Tile {

    private boolean mine;
    private boolean flagged;
    private boolean hidden;
    private int value;

    public Tile(boolean isMine) {
        this.mine = isMine;
        this.hidden = true;
    }

    public Tile(int value) {
        this.value = value;
        this.hidden = true;
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

    public void armMine() {
        this.mine = true;
    }

    public void incrementValue() {
        this.value++;
    }

    public boolean reveal() {
        this.hidden = false;
        return mine;
    }

    public void flag() {
        this.flagged = !this.flagged;
    }

    public void setFlagged() {
        this.flagged = true;
    }

    @Override
    public String toString() {
        if (flagged) {
            return "!";
        }
        if (hidden) {
            return "#";
        }
        if (mine) {
            return "x";
        }
        if (value == 0) {
            return "·";
        }
        return value + "";
    }
}
