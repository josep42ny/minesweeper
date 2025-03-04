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
                tiles[i][j] = new Tile(false);
            }
        }

    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public boolean isTileHidden(int[] coords) {
        return tiles[coords[1]][coords[0]].isHidden();
    }

    public boolean reveal(int[] coords) {
        return tiles[coords[1]][coords[0]].reveal();
    }

    public void revealAll() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.reveal();
            }
        }
    }

}
