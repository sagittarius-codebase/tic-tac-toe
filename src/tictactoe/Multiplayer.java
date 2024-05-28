package tictactoe;

/**
 * This class represents the TicTacToe game in multiplayer mode. It holds the different objects that are used to play the game.
 * The class also manages the play through and is generally responsible for the logic of the multiplayer game.
 *
 * @since 1.0.0
 */
public class Multiplayer {

    private final Player playerOneX;
    private final Player playerTwo0;
    private Player currentPlayer;
    private Board currentBoard;
    private final UserInput userInput;
    private final ConsoleOutput consoleOutput;
    private boolean anotherRound;
    private int scorePlayerOneX;
    private int scorePlayerTwo0;

    /**
     * Constructor for Class Multiplayer. It first initializes the userInput, consoleOutput objects.
     * Then it initializes the start language, player objects and the board. And last it sets playerOneX as the currentPlayer.
     */
    public Multiplayer(UserInput userinput, ConsoleOutput consoleOutput) {
        this.userInput = userinput;
        this.consoleOutput = consoleOutput;

        // Get name of the first player
        consoleOutput.printAskPlayerName(1);
        consoleOutput.printInputRequest();
        String playerOneName = userInput.getUserName();
        while (playerOneName.isEmpty()) {
            consoleOutput.printInvalidInputName();
            consoleOutput.printInputRequest();
            playerOneName = userInput.getUserName();
        }

        // Get name of the second player
        consoleOutput.printAskPlayerName(2);
        consoleOutput.printInputRequest();
        String playerTwoName = userInput.getUserName();
        while (playerTwoName.isEmpty() || playerTwoName.equals(playerOneName)) {
            consoleOutput.printInvalidInputName();
            consoleOutput.printInputRequest();
            playerTwoName = userInput.getUserName();
        }

        playerOneX = new Player(playerOneName);
        playerTwo0 = new Player(playerTwoName);

        currentBoard = new Board();

        currentPlayer = playerOneX;

        scorePlayerOneX = 0;
        scorePlayerTwo0 = 0;

        anotherRound = true;
    }

    /**
     * This method starts the game. It holds all the game logic and the main game loop.
     */
    public void start() {
        while (anotherRound) {
            boolean roundEnded = false;

            while (!roundEnded) {
                consoleOutput.printBoard(currentBoard);
                consoleOutput.printWhoseTurn(currentPlayer);

                String validInput = getValidInput();

                roundEnded = checkUserInput(validInput, roundEnded);
            } //end while-loop (!roundEnded)

            consoleOutput.printWinnerBoard(currentBoard);
            consoleOutput.printCurrScoreMessage();
            consoleOutput.printScore(playerOneX, playerTwo0, scorePlayerOneX, scorePlayerTwo0);

            // Ask user if he wants to play another round
            consoleOutput.printAskForAnotherRound();
            consoleOutput.printInputRequest();

            // Get valid user input for new round
            String answer = userInput.getNewRound();
            while (answer.isEmpty()) {
                consoleOutput.printInvalidInput();
                consoleOutput.printAskForAnotherRound();
                answer = userInput.getNewRound();
            }
            if (("n").equals(answer)) {
                anotherRound = false;
            } else {
                currentBoard = new Board();
            }
        } //end while-loop (anotherRound)

        // Print end message
        consoleOutput.printEndScoreMessage();
        consoleOutput.printScore(playerOneX, playerTwo0, scorePlayerOneX, scorePlayerTwo0);

        selectWinnerForOutputMessage();

        consoleOutput.printByeMsg();
    }

    /**
     * Selects the winner based on the score and prints the winner message.
     */
    private void selectWinnerForOutputMessage() {
        // Get winner and print winner message
        if (scorePlayerOneX > scorePlayerTwo0) {
            consoleOutput.printGameFinished(playerOneX, scorePlayerOneX);
        } else if (scorePlayerOneX < scorePlayerTwo0) {
            consoleOutput.printGameFinished(playerTwo0, scorePlayerTwo0);
        } else {
            consoleOutput.printGameDraw(scorePlayerOneX);
        }
    }

    /**
     * Check if validInput was either language change, exit command, help command or a field number
     *
     * @param validInput String that represents the valid input
     * @param roundEnded boolean that indicates if the game has ended
     * @return boolean that indicates if the game has ended (never {@code null})
     */
    private boolean checkUserInput(String validInput, boolean roundEnded) {
        switch (validInput) {
            case "de", "en" -> {
                consoleOutput.changeLanguage(validInput);
                consoleOutput.printChangeLanguage();
            }
            case "exit" -> {
                roundEnded = true;
                consoleOutput.printGameEnded();
            }
            case "help", "'help'" -> consoleOutput.printInstructions(false);
            default -> {
                int numValidInput = Integer.parseInt(validInput);

                // Try updating board, if it fails it will go into the next while-loop iteration
                if (currentBoard.updateBoard(numValidInput, currentPlayer.getPlayerId())) {
                    int gameState = currentBoard.checkForWinner();
                    if (gameState == playerOneX.getPlayerId()) { // PlayerOneX won
                        roundEnded = true;
                        consoleOutput.printWinner(playerOneX);
                        scorePlayerOneX++;
                    } else if (gameState == playerTwo0.getPlayerId()) { // PlayerTwoO won
                        roundEnded = true;
                        consoleOutput.printWinner(playerTwo0);
                        scorePlayerTwo0++;
                    } else if (gameState == -1) { // Draw
                        roundEnded = true;
                        consoleOutput.printDraw();
                    }
                    switchPlayer();
                } else {
                    consoleOutput.printFieldInputError(numValidInput, 2);
                }
            }
        } //end switch
        return roundEnded;
    }

    /**
     * Gets a valid input from the user.
     *
     * @return String that represents the valid input (never {@code null})
     */
    private String getValidInput() {
        // Get a valid player input
        consoleOutput.printInputRequest();
        String validInput = userInput.getUserInput();
        while (validInput.isEmpty()) {
            // Warning message for wrong input (with instructions and right input)
            consoleOutput.printFieldInputError(1, 0);
            consoleOutput.printInputRequest();
            validInput = userInput.getUserInput();
        }
        return validInput;
    }

    /**
     * Helper method to switch the current player.
     */
    private void switchPlayer() {
        currentPlayer = currentPlayer == playerOneX ? playerTwo0 : playerOneX;
    }
}
