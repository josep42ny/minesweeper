package josep.minesweeper;

public class Board {

    private int sizeX;
    private int sizeY;
    private Tile[][] tiles;

    public Board(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.tiles = new Tile[sizeY][sizeX];

        //todo: remove
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile(2);
            }
        }

    }

    public Tile[][] getTiles() {
        return tiles;
    }

}
