package tictactoe;

import java.util.Scanner;

/**
 * This Class manages all the user inputs via the console.
 *
 * @version 1.0.1
 */
public class UserInput {

    private Scanner scanner;

    /**
     * The Constructor initializes the scanner object.
     */
    public UserInput() {
        scanner = new Scanner(System.in);
    }

    /**
     * This method is used to set a custom scanner. It is used in the UserInputTest Class, which contains
     * JUnit tests to test the behaviour of the UserInput Class with different input values.
     *
     * @param scanner defines a custom scanner object
     */
    public void setInputScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Reads any input that gets typed in. Also checks if the input meets our requirements that are:
     * (1) Coordinates from 1-9, (2) Keywords for language change, (2) Keywords for help message.
     *
     * @return empty String if was not a valid input, otherwise returns the input (never {@code null})
     */
    public String getUserInput() {
        String input = scanner.nextLine().toLowerCase();
        if (input.matches("[1-9]")) {
            return input;
        } else if (input.matches("de|en|exit|help|'help'")) {
            return input;
        } else {
            return "";
        }
    }

    /**
     * Reads the username from the user. Checks if the given value is empty (meaning only consists of spaces),
     * if yes it returns an empty String, else returns the given String
     *
     * @return empty string if given input value is empty, else returns input (never {@code null})
     */
    public String getUserName() {
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? "" : input;
    }

    /**
     * Reads the requested game mode from the user. Checks if the given value is ether single or multi.
     * If no it returns an empty String, else returns the given String
     *
     * @return empty string if given input value meets not our requirements, else returns input
     */
    public String getGameMode() {
        String input = scanner.nextLine().toLowerCase();
        return input.matches("single|multi|de|en") ? input : "";
    }

    /**
     * Reads the requested multiplayer difficulty mode from the user. Checks if the given value is ether easy or hard.
     * If no it returns an empty String, else returns the given String
     *
     * @return empty string if given input value meets not our requirements, else returns input
     */
    public String getDifficulty() {
        String input = scanner.nextLine().toLowerCase();
        return input.matches("easy|hard|de|en") ? input : "";
    }

    /**
     * Reads the user answer (y/n) to the question: Do you want to play another round.
     * Checks if the given value matches y or n
     * if not it returns an empty String, else returns the given String
     *
     * @return empty string if given input value is not matching our requirements, else returns input
     */
    public String getNewRound() {
        String input = scanner.nextLine().toLowerCase();
        return input.matches("[yn]|yes|no") ? input.substring(0,1) : "";
    }

}
