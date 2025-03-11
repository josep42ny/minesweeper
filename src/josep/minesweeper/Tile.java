package josep.minesweeper;

public class Tile {

    private boolean mine;
    private boolean flagged;
    private boolean hidden;
    private int value;

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
            return "\033[1;32m" + "△"  + "\033[0m";
        }
        if (hidden) {
            return "\033[1;37m" + "#"  + "\033[0m";
        }
        if (mine) {
            return "\033[1;31m" + "▲"  + "\033[0m";
        }
        if (value == 0) {
            return "\033[1;37m" + "·"  + "\033[0m";
        }
        return "\033[1;37m" + value + "\033[0m";
    }
}
