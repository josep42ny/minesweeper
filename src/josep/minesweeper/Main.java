package josep.minesweeper;

public class Main {

    public static void main(String[] args) {

        //GameController controller = new GameController();
        //controller.awake();

        new InputHandler().askForAction();
        new InputHandler().askForCoordinates();

    }

}
