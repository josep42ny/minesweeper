package josep.minesweeper;

public abstract class Tile {

    private boolean mine;
    private boolean flagged;
    private boolean revealed;
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

    public boolean isRevealed() {
        return revealed;
    }

    public int getValue() {
        return value;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

}
