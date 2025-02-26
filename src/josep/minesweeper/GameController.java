package josep.minesweeper;

public class GameController {

    private View view;
    private Board board;

    GameController(){

        this.view = new View();
        this.board = new Board(8,8);

    }

    public void awake() {

    }

    private void update() {

    }

}
