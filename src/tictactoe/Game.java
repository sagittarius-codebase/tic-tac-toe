package tictactoe;

/**
 * The Game class introduces the game to the user, gets the language and the game mode from the user
 * and calls the start method of the singleplayer or multiplayer class.
 *
 * @version 1.0.0
 */
public class Game {

    private final UserInput userInput;
    private final ConsoleOutput consoleOutput;
    private boolean isSingleplayer;

    /**
     * Constructor for Class Game. It first initializes the userInput, consoleOutput objects.
     * Then it initializes the start language and the game mode by getting them from the user.
     */
    public Game() {
        this.userInput = new UserInput();
        this.consoleOutput = new ConsoleOutput();

        consoleOutput.printTitle();
        consoleOutput.printAskStartLanguage();
        consoleOutput.printInputRequest();

        String startLanguage = getStartLanguage();

        consoleOutput.changeLanguage(startLanguage);
        consoleOutput.printChangeLanguage();
        consoleOutput.printInstructions(true);

        String mode = getGameMode();

        setSingleMultiPlayer(mode);
    }

    /**
     * This method gets the start language from the user and validates it.
     * If it is not valid it asks the user again until a valid input is given.
     * Valid inputs are "de" and "en" (case-insensitive).
     *
     * @return the start language (never {@code null})
     */
    private String getStartLanguage() {
        String startLanguage = userInput.getUserInput();
        while (!startLanguage.matches("de|en")) {
            consoleOutput.printInvalidInput();
            startLanguage = userInput.getUserInput();
            consoleOutput.printInputRequest();
        }
        return startLanguage;
    }

    /**
     * This method gets the game mode from the user and validates it.
     * If it is not valid it asks the user again until a valid input is given.
     * Valid inputs are "single" and "multi" (case-insensitive).
     *
     * @return the game mode (never {@code null}
     */
    private String getGameMode() {
        consoleOutput.printAskGameMode();
        String mode = userInput.getGameMode();
        while (mode.isEmpty() || ((mode.equals("de") || mode.equals("en")))) {
            if (mode.equals("de") || mode.equals("en"))
            {
                consoleOutput.changeLanguage(mode);
                consoleOutput.printChangeLanguage();
            }
            else {consoleOutput.printInvalidInput();}
            consoleOutput.printInputRequest();
            mode = userInput.getGameMode();
        }
        return mode;
    }

    /**
     * This method sets the singleplayer or multiplayer object depending on the given mode.
     *
     * @param mode defines the game mode (single or multi)
     */
    private void setSingleMultiPlayer(String mode) {
        isSingleplayer = "single".equals(mode);
    }

    /**
     * The method startGame starts the game by calling the start method of the singleplayer or multiplayer object.
     */
    public void startGame() {
        if (isSingleplayer) {
            new Singleplayer(userInput, consoleOutput).start();
        } else {
            new Multiplayer(userInput, consoleOutput).start();
        }
    }
}
