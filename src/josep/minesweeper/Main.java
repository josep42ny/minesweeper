package josep.minesweeper;

public class Main {

    public static void main(String[] args) {

        //GameController controller = new GameController();
        //controller.awake();

        new View().drawBoard(new Board(8,8));
        System.out.println(new InputHandler().askForAction());

    }

}
