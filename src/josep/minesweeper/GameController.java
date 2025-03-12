package josep.minesweeper;

public class GameController {

    private View view;
    private Board board;
    private InputHandler inputHandler;

    public void awake() {

        this.view = new View();
        this.board = new Board(8, 8, 10);
        this.inputHandler = new InputHandler();
        update();

    }

    private void update() {

        while (true) {

            view.drawBoard(board);
            PlayerAction action = inputHandler.askForAction();
            int[] coords;
            switch (action) {

                case REVEAL:
                    do {
                        coords = inputHandler.askForCoordinates();
                    } while (board.tileNotExists(coords)
                            || board.isTileShown(coords)
                            || board.isTileFlagged(coords));
                    boolean mine = board.reveal(coords[1], coords[0]);
                    if (mine) {
                        gameOver();
                    }
                    if (board.onlyMinesLeft()) {
                        board.flagAll();
                        gameOver();
                    }
                    break;

                case FLAG:
                    do {
                        coords = inputHandler.askForCoordinates();
                    } while (board.tileNotExists(coords)
                            || board.isTileShown(coords));
                    board.flag(coords);
                    break;

                case QUIT:
                    gameOver();
                default:
            }

        }


    }

    private void gameOver() {
        board.revealAll();
        view.drawBoard(board);
        System.out.println();
        System.exit(0);
    }

}
