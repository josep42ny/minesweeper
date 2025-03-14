package josep.minesweeper;

public class Tile {

    private boolean mine;
    private boolean flagged;
    private boolean hidden;
    private int value;
    private int posY;
    private int posX;

    public Tile(int y, int x) {
        this.hidden = true;
        this.posY = y;
        this.posX = x;
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

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    @Override
    public String toString() {
        if (flagged) {
            return Ansi.paint(Ansi.GREEN, "△");
        }
        if (hidden) {
            return Ansi.paint(Ansi.WHITE, "#");
        }
        if (mine) {
            return Ansi.paint(Ansi.RED, "▲");
        }
        if (value == 0) {
            return Ansi.paint(Ansi.WHITE, "·");
        }
        return Ansi.paint(Ansi.BOLD_WHITE, value);
    }
}
