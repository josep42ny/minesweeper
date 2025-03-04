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

        tiles[4][4].armMine();
        tiles[4][5].armMine();
        tiles[3][3].armMine();

        setNumbers();

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

    private void setNumbers() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].isMine()) {
                    incrementNeighbours(i, j);
                }
            }
        }
    }

    private void incrementNeighbours(int x, int y) {
        int startX = Math.max(x - 1, 0);
        int endX = Math.min(x + 1, tiles[0].length - 1);
        int startY = Math.max(y - 1, 0);
        int endY = Math.min(y + 1, tiles.length - 1);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                tiles[i][j].incrementValue();
            }
        }
    }

}
