package josep.minesweeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private int sizeX;
    private int sizeY;
    private Tile[][] tiles;
    private final Random random = new Random();

    public Board(int sizeY, int sizeX, int mineAmount) {
        this.sizeY = sizeY;
        this.sizeX = sizeX;
        this.tiles = new Tile[sizeY][sizeX];

        fillBoard();
        armMines(mineAmount);
        setNumbers();
    }

    private void fillBoard() {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                tiles[y][x] = new Tile(y, x);
            }
        }
    }

    private void armMines(int mines) {
        int ranX;
        int ranY;

        for (int i = 0; i < mines; i++) {
            do {
                ranX = random.nextInt(sizeX - 1);
                ranY = random.nextInt(sizeY - 1);
            } while (tiles[ranY][ranX].isMine());
            tiles[ranY][ranX].armMine();
        }
    }

    private void setNumbers() {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                if (tiles[y][x].isMine()) {
                    incrementNeighbours(y, x);
                }
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public boolean isTileHidden(int[] coords) {
        return tiles[coords[1]][coords[0]].isHidden();
    }

    public boolean reveal(int y, int x) {
        Tile tile = tiles[y][x];
        boolean mine = tile.reveal();

        if (tile.getValue() != 0 || tile.isMine()) {
            return mine;
        }

        Tile[] neigbours = getNeighbours(y, x);
        for (Tile neighbour : neigbours) {
            if (!neighbour.isHidden() || neighbour.isFlagged()) {
                continue;
            }
            if (neighbour.getValue() == 0) {
                reveal(neighbour.getPosY(), neighbour.getPosX());
            } else {
                neighbour.reveal();
            }
        }

        return mine;
    }

    public void revealAll() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                tile.reveal();
            }
        }
    }

    private void incrementNeighbours(int y, int x) {
        Tile[] neighbours = getNeighbours(y, x);

        for (Tile tile : neighbours) {
            tile.incrementValue();
        }
    }

    private Tile[] getNeighbours(int inY, int inX) {
        List<Tile> out = new ArrayList<>();
        int startX = Math.max(inX - 1, 0);
        int endX = Math.min(inX + 1, tiles[0].length - 1);
        int startY = Math.max(inY - 1, 0);
        int endY = Math.min(inY + 1, tiles.length - 1);

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                if (inX == x && inY == y) {
                    continue;
                }
                out.add(tiles[y][x]);
            }
        }

        return out.toArray(new Tile[0]);
    }

    public boolean onlyMinesLeft() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                if (!tile.isMine() && tile.isHidden()) {
                    return false;
                }
            }
        }

        return true;
    }

    public void flagAll() {
        for (Tile[] row : tiles) {
            for (Tile tile : row) {
                if (tile.isHidden()) {
                    tile.setFlagged();
                }
            }
        }
    }

    public void flag(int[] coords) {
        tiles[coords[1]][coords[0]].flag();
    }

    public boolean isTileFlagged(int[] coords) {
        return tiles[coords[1]][coords[0]].isFlagged();
    }

    public int getSizeX() {
        return sizeX;
    }

}
