package josep.minesweeper;

public class InputHandler {

    public PlayerAction askForAction() {

        System.out.println("[R]eveal | [F]lag | [Q]uit :");

        PlayerAction action = askForChar();

        System.out.print("\033[A\033[2K");
        System.out.flush();
        return action;

    }

    public int[] askForCoordinates() {

        int[] out = new int[2];
        out[0] = askForInteger("Column:");
        System.out.print("\033[A\033[2K");
        System.out.flush();
        out[1] = askForInteger("Row:");
        System.out.print("\033[A\033[2K");
        System.out.flush();
        return out;

    }

    private String ask() {
        String input;

        do {
            input = System.console().readLine();
            System.out.print("\033[A\033[2K");
            System.out.flush();
        } while (input.isEmpty());

        return input;
    }

    private int askForInteger(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(ask());
            } catch (NumberFormatException nfe) {
            }
        }
    }

    private PlayerAction askForChar() {
        while (true) {
            String input = ask();

            if (input.length() != 1) {
                continue;
            }

            for (PlayerAction action : PlayerAction.values()) {
                if (action.getKey() == input.charAt(0)) {
                    return action;
                }
            }

        }
    }

}
