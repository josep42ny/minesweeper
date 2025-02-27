package josep.minesweeper;

public class InputHandler {

    public char askForAction() {
        String input = ask("[R]eveal | [F]lag | [Q]uit :");
        return input.charAt(0);
    }

    public int[] askForCoordinates() {

        int[] out = new int[2];
        out[0] = askForInteger("Column:");
        out[1] = askForInteger("Row:");
        return out;

    }

    private String ask(String prompt) {
        String input;

        do {
            System.out.println(prompt);
            input = System.console().readLine();
            System.out.print("\033[2F\033[K");
            System.out.flush();
        } while (input.isEmpty());

        return input;
    }

    private int askForInteger(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(ask(prompt));
            } catch (NumberFormatException nfe) {
            }
        }
    }

}
