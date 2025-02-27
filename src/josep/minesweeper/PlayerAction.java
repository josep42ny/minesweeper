package josep.minesweeper;

public enum PlayerAction {

    REVEAL('r'),
    FLAG('f'),
    QUIT('q');

    private final char key;

    private PlayerAction(char key) {
        this.key = key;
    }

    public char getKey() {
        return key;
    }

}
