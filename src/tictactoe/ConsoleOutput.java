package tictactoe;

/**
 * The Class ConsoleOutput is responsible for printing messages to the console.
 * It contains all the information and methods needed for the output of the game board,
 * languages, and information required to play the game.
 *
 * @version 1.0.1
 */
public class ConsoleOutput {
    // Reset Text Color
    private static final String RESET = "\033[0m";

    // Regular Text Colors
    private static final String BLACK = "\033[0;30m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String PURPLE = "\033[0;35m";
    private static final String CYAN = "\033[0;36m";

    // Bold Text Colors
    private static final String BLACK_BOLD = "\033[1;30m";
    private static final String RED_BOLD = "\033[1;31m";
    private static final String GREEN_BOLD = "\033[1;32m";
    private static final String BLUE_BOLD = "\033[1;34m";
    private static final String PURPLE_BOLD = "\033[1;35m";

    // Underline Text Colors
    private static final String YELLOW_UNDERLINED = "\033[4;33m";

    // Background Text Colors
    private static final String RED_BACKGROUND = "\033[41m";
    private static final String YELLOW_BACKGROUND = "\033[43m";
    private static final String BLUE_BACKGROUND = "\033[44m";
    private final Translator translator;

    /**
     * The Constructor initializes the translator object and sets english as initial language.
     */
    public ConsoleOutput() {
        this.translator = new Translator("EN");
    }

    /**
     * Method to change language.
     *
     * @param newLanguage defines the new language that should be displayed from now on
     */
    public void changeLanguage(String newLanguage) {
        this.translator.setCurrentLanguage(newLanguage);
    }

    /**
     * Method for displaying the game title.
     */
    public void printTitle() {
        System.out.println(GREEN_BOLD + translator.translate("title") + RESET);
    }

    /**
     * Method for displaying the game instructions and start information.
     *
     * @param gameBeginning Boolean to determine if the game has startet or is running
     */
    public void printInstructions(boolean gameBeginning) {
        if (gameBeginning) {
            System.out.println(PURPLE + translator.translate("welcome_msg") + RESET);
        }
        System.out.println(PURPLE + translator.translate("instructions_msg") + RESET);
    }

    /**
     * Method for displaying the user-friendly input field.
     */
    public void printInputRequest() {
        System.out.print(CYAN + translator.translate("input_msg") + RESET);
    }

    /**
     * Method to display question that asks for the player name depending on the current player.
     *
     * @param currentPlayer defines for which player object is the name asked for
     */
    public void printAskPlayerName(int currentPlayer) {
        if (currentPlayer == 0) {
            System.out.println(CYAN + translator.translate("ask_player_msg") + RESET);      //Singleplayer
        } else if (currentPlayer == 1) {
            System.out.println(CYAN + translator.translate("ask_player1_msg") + RESET);     //multiplayer
        } else {
            System.out.println(CYAN + translator.translate("ask_player2_msg") + RESET);     //multiplayer
        }
    }

    /**
     * Method to display question that asks for the language at the beginning.
     */
    public void printAskStartLanguage() {
        System.out.println(CYAN + translator.translate("ask_start_msg") + RESET);
    }

    /**
     * Method to display question that asks for the game mode (single or multiplayer) at beginning.
     */
    public void printAskGameMode() {
        System.out.println(CYAN + translator.translate("ask_game_mode") + RESET);
    }

    /**
     * Method for printing out the game board.
     *
     * @param board passes the current game board.
     */
    public void printBoard(Board board) {
        System.out.println("   +---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print(CYAN + "  " + RESET + " | ");              //Print a | at the start of each line
            for (int j = 0; j < 3; j++) {
                System.out.print(                                       //Fill each field with either a number or an X or O
                        board.getPlayerAtPosition(i, j) == 0 ? (i * 3 + j + 1) :
                                board.getPlayerAtPosition(i, j) == 1 ?
                                        BLUE_BOLD + "X" + RESET :
                                        RED_BOLD + "O" + RESET
                );
                if (j < 2) {                                            //Print a | at the end of each line:
                    System.out.print(" | ");
                } else {
                    System.out.println(" |");
                }
            }
            if (i < 2) {
                System.out.println("   +---+---+---+");
            }
        }
        System.out.println("   +---+---+---+");
        System.out.println();
    }

    /**
     * Method for printing new round request.
     */
    public void printAskForAnotherRound() {
        System.out.println(CYAN + translator.translate("new_round_msg") + RESET);
    }

    /**
     * Method for printing the scoreboard for multiplayer
     *
     * @param playerOne       first player
     * @param playerTwo       second player
     * @param scorePlayerOneX first player score
     * @param scorePlayerTwo0 second  player score
     */
    public void printScore(Player playerOne, Player playerTwo, int scorePlayerOneX, int scorePlayerTwo0) {
        System.out.println(playerOne.getPlayerName() + ": " + scorePlayerOneX);
        System.out.println(playerTwo.getPlayerName() + ": " + scorePlayerTwo0 + "\n");
    }

    /**
     * Method for printing the scoreboard for singleplayer
     *
     * @param player           player
     * @param scoreHumanPlayer human player score
     * @param scoreAI          AI score
     */
    public void printScoreSingle(Player player, int scoreHumanPlayer, int scoreAI) {
        System.out.println(player.getPlayerName() + ": " + scoreHumanPlayer);
        System.out.println(translator.translate("artificial_intelligence") + ": " + scoreAI + "\n");
    }

    /**
     * Method for printing the current score
     */
    public void printCurrScoreMessage() {
        System.out.println(CYAN + translator.translate("current_score_msg") + RESET);
    }

    /**
     * Method for printing the final score at the end of the game
     */
    public void printEndScoreMessage() {
        System.out.println(PURPLE_BOLD + translator.translate("end_score_msg") + RESET);
    }

    /**
     * Method for printing the draw message.
     */
    public void printDraw() {
        System.out.println(YELLOW_UNDERLINED + translator.translate("draw_msg") + RESET);
    }

    /**
     * Method for printing the winner of the round.
     *
     * @param player the player object that has won the round
     */
    public void printWinner(Player player) {
        System.out.println(BLACK + YELLOW_BACKGROUND + "☆☆☆☆☆ " + player.getPlayerName() + translator.translate("player_won_msg") + RESET);
    }

    /**
     * Method for printing the winner if winner is AI.
     */
    public void printWinnerAi() {
        System.out.println(BLACK + YELLOW_BACKGROUND + translator.translate("ai_won_msg") + RESET);
    }

    /**
     * Method for printing the player whose turn it is.
     *
     * @param player the player whose turn it is
     */
    public void printWhoseTurn(Player player) {
        System.out.println(GREEN + translator.translate("whose_turn_1_msg") + player.getPlayerName() + translator.translate("whose_turn_2_msg") + RESET);
    }

    /**
     * Method for displaying the input error.
     *
     * @param field     input field that caused the error
     * @param errorCase occurring error case
     */
    public void printFieldInputError(int field, int errorCase) {
        switch (errorCase) {
            case 1 -> // outOfBound coordinates
                    System.out.println(RED + translator.translate("invalid_field_error_msg") + field + RESET);
            case 2 -> // field occupied
                    System.out.println(RED + translator.translate("occupied_field_1_error_msg") + field + translator.translate("occupied_field_2_error_msg") + RESET);
            default -> // invalid input
                    System.out.println(RED + translator.translate("invalid_input_error_msg") + RESET);
        }
    }

    /**
     * Method for displaying the game ended message (ended by user input).
     */
    public void printGameEnded() {
        System.out.println(RED + translator.translate("game_ended_msg") + RESET);
    }

    /**
     * Method for displaying the game goodbye message.
     */
    public void printByeMsg() {
        System.out.println(PURPLE_BOLD + translator.translate("goodbye_msg") + RESET);
    }

    /**
     * Method for displaying that the language has been changed.
     */
    public void printChangeLanguage() {
        System.out.println(CYAN + translator.translate("lang_changed_msg") + RESET);
    }

    /**
     * Method for ask what difficulty the AI should have.
     */
    public void printAskDifficulty() {
        System.out.println(CYAN + translator.translate("question_difficulty") + RESET);
    }

    /**
     * Method for displaying that the name entered is too short.
     */
    public void printInvalidInputName() {
        System.out.println(RED + translator.translate("name_input_error_msg") + RESET);
    }

    /**
     * Shorter version of printInvalidInputName
     */
    public void printInvalidInput() {
        System.out.println(RED + translator.translate("short_invalid_input") + RESET);
    }

    /**
     * Method for displaying that the Game is Finish
     *
     * @param winner      won player id
     * @param winnerScore score of the player
     */
    public void printGameFinished(Player winner, int winnerScore) {
        System.out.println(PURPLE_BOLD + winner.getPlayerName() + translator.translate("winner_msg") + winnerScore + translator.translate("pt") + RESET);
    }

    /**
     * Method for displaying that the Game is Finished and that the AI has won the game
     *
     * @param winnerScore score of the player
     */
    public void printGameFinishedAI(int winnerScore) {
        System.out.println(PURPLE_BOLD + translator.translate("artificial_intelligence") + translator.translate("winner_msg") + winnerScore + translator.translate("pt") + RESET);
    }

    /**
     * Method for displaying that the Game ended with a draw
     *
     * @param score of both players in one parameter as it is a draw.
     */
    public void printGameDraw(int score) {
        System.out.println(PURPLE_BOLD + translator.translate("end_draw_msg") + score + translator.translate("pt") + RESET);
    }

    /**
     * Method for displaying the winner board, with highlighting of the winner fields.
     *
     * @param board defines the current game board
     */
    public void printWinnerBoard(Board board) {
        int fieldCounter = 1;
        System.out.println("   +---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print(CYAN + "  " + RESET + " |");
            for (int j = 0; j < 3; j++) {
                System.out.print(
                        board.getPlayerAtPosition(i, j) == 0 ?
                                " " + (i * 3 + j + 1) + " " :
                                board.getPlayerAtPosition(i, j) == 1 ?
                                        //highlighting of the winner fields by changing the background color.
                                        board.checkIfFieldIsWinnerField(fieldCounter) ? BLUE_BACKGROUND + " " + BLACK_BOLD + "X " + RESET : BLUE_BOLD + " X " + RESET :
                                        board.checkIfFieldIsWinnerField(fieldCounter) ? RED_BACKGROUND + " " + BLACK_BOLD + "O " + RESET : RED_BOLD + " O " + RESET
                );
                if (j < 2) {
                    System.out.print("|");
                } else {
                    System.out.println("|");
                }
                fieldCounter++;
            }
            if (i < 2) {
                System.out.println("   +---+---+---+");
            }
        }
        System.out.println("   +---+---+---+");
        System.out.println();
    }
}