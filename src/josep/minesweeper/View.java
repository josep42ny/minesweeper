package josep.minesweeper;

public class View {

    public void drawBoard(Board board) {
        Tile[][] grid = board.getTiles();
        System.out.println();
        for (Tile[] tileRow : grid) {
            for (Tile tile : tileRow) {
                System.out.print(tile + " ");
            }
            System.out.println();
        }

    }

}
