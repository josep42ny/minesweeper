package josep.minesweeper;

public class GameController {

    private View view;
    private Board board;
    private InputHandler inputHandler;

    public void awake() {

        this.view = new View();
        this.board = new Board(8,8);
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
                    } while (!board.isTileHidden(coords));
                    boolean mine = board.reveal(coords);
                    if (mine) {
                        gameover();
                    }
                    break;
                case FLAG:
                    do {
                        coords = inputHandler.askForCoordinates();
                    } while (!board.isTileHidden(coords));
                    //board.flag(coords);
                    break;
                case QUIT:
                    System.exit(0);
                default:
            }

        }

    }

    private void gameover() {
        board.revealAll();
        view.drawBoard(board);
        System.exit(0);
    }

}
