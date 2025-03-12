package josep.minesweeper;

public enum Ansi {

    CLEAR_CONSOLE("\033[H\033[2J"),
    CLEAR_LINE("\033[A\033[2K"),
    RESET("\033[0m"),
    BOLD_WHITE("\u001B[37;1m"),
    WHITE("\033[1;37m"),
    GREEN("\033[1;32m"),
    RED("\033[1;31m");

    private final String code;

    private Ansi(String code){
        this.code = code;
    }

    public static String getCode(Ansi ansi) {
        return ansi.code;
    }

    public static String paint(Ansi ansi, String text) {
        return getCode(ansi) + text + getCode(RESET);
    }

    public static String paint(Ansi ansi, int text) {
        return getCode(ansi) + text + getCode(RESET);
    }

}
