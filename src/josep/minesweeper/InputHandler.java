package josep.minesweeper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputHandler {

    private final Map<Character, PlayerAction> ACTION_MAP = new HashMap<>(Map.ofEntries(
            Map.entry('r', PlayerAction.REVEAL),
            Map.entry('f', PlayerAction.FLAG),
            Map.entry('q', PlayerAction.QUIT)
    ));


    public PlayerAction askForAction() {

        System.out.println("[R]eveal | [F]lag | [Q]uit :");
        char actionKey = askForChar(ACTION_MAP.keySet());
        System.out.print("\033[A\033[2K");
        System.out.flush();

        return ACTION_MAP.get(actionKey);

    }

    public int[] askForCoordinates() {

        int[] out = new int[2];
        out[0] = askForInteger("Column:");
        out[1] = askForInteger("Row:");
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

    private char askForChar(Set<Character> validValues) {
        while (true) {
            String input = ask();

            if (input.length() > 1 && validValues.contains(input.charAt(0))) {
                return input.charAt(0);
            }
        }
    }

}
