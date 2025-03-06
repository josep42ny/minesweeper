package josep.minesweeper;

import java.io.IOException;

public class View {

    public void drawBoard(Board board) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Tile[][] grid = board.getTiles();
        System.out.println();
        for (int h = 0; h < board.getSizeX(); h++) {
            System.out.print("\u001B[37;1m" + h + " " + "\033[0m");
        }
        System.out.print("\n\n");
        int row = 0;
        for (Tile[] tileRow : grid) {
            for (Tile tile : tileRow) {
                System.out.print(tile + " ");
            }
            System.out.print("\u001B[37;1m" + " " + row + "\033[0m" + "\n");
            row++;
        }
        System.out.print("\n");
    }

}
