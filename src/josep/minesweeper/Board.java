package josep.minesweeper;

public class Board {

    private int sizeX;
    private int sizeY;
    private Tile[][] tiles;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

}
