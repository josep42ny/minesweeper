package josep.minesweeper;

import java.io.IOException;

public class View {

    public void drawBoard(Board board) {
        System.out.print(Ansi.CLEAR_CONSOLE);
        System.out.flush();
        Tile[][] grid = board.getTiles();
        System.out.println();
        for (int h = 0; h < board.getSizeX(); h++) {
            System.out.print(Ansi.paint(Ansi.BOLD_WHITE, h + " "));
        }
        System.out.print("\n\n");
        int row = 0;
        for (Tile[] tileRow : grid) {
            for (Tile tile : tileRow) {
                System.out.print(tile + " ");
            }
            System.out.print(Ansi.paint(Ansi.BOLD_WHITE, " " + row));
            row++;
        }
        System.out.print("\n");
    }

}
