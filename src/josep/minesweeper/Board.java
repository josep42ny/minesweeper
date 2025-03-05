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
        Tile tile = tiles[coords[1]][coords[0]];
        boolean mine = tile.reveal();
        if (tile.getValue() == 0) {
            floodReveal(coords[0], coords[1]);
        }
        return mine;
    }

    private void floodReveal(int x, int y) {

        int startX = Math.max(x - 1, 0);
        int endX = Math.min(x + 1, tiles[0].length - 1);
        int startY = Math.max(y - 1, 0);
        int endY = Math.min(y + 1, tiles.length - 1);

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if ((x == j && y == i) || !tiles[i][j].isHidden()) continue;
                tiles[i][j].reveal();
                if (tiles[i][j].getValue() == 0) {
                    floodReveal(j, i);
                }
            }
        }
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
        Tile[] neighbours = getNeighbours(x, y);

        for (Tile tile : neighbours) {
            tile.incrementValue();
        }
    }

    private Tile[] getNeighbours(int x, int y) {
        Tile[] out = new Tile[9];
        int startX = Math.max(x - 1, 0);
        int endX = Math.min(x + 1, tiles[0].length - 1);
        int startY = Math.max(y - 1, 0);
        int endY = Math.min(y + 1, tiles.length - 1);
        int counter = 0;
        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                out[counter] = tiles[i][j];
                counter++;
            }
        }

        return out;
    }

}
