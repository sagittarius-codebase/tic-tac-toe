package tictactoe;

/**
 * This class represents the TicTacToe game in singleplayer mode. It holds the different objects that are used to play the game.
 * The class also manages the play through and is generally responsible for the logic of the singleplayer game.
 *
 * @since 1.0.0
 */

public class Singleplayer {

    private final UserInput userInput;
    private final ConsoleOutput consoleOutput;
    private final Opponent ai;
    private final int aiId;
    private final Player human;
    private Board board;
    private boolean anotherRound;
    private int scoreHumanPlayer;
    private int scoreAI;


    /**
     * Constructor for the Singleplayer class.
     *
     * @param userInput     UserInput object that is used to get the user input
     * @param consoleOutput ConsoleOutput object that is used to print messages to the console
     */
    public Singleplayer(UserInput userInput, ConsoleOutput consoleOutput) {
        this.userInput = userInput;
        this.consoleOutput = consoleOutput;

        // Ask for difficulty
        consoleOutput.printAskDifficulty();
        String mode = userInput.getDifficulty();
        while (mode.isEmpty() || ((mode.equals("de") || mode.equals("en")))) {
            if (mode.equals("de") || mode.equals("en"))
            {
                consoleOutput.changeLanguage(mode);
                consoleOutput.printChangeLanguage();
            }
            else {consoleOutput.printInvalidInput();}
            consoleOutput.printInputRequest();
            mode = userInput.getDifficulty();
        }

        // Get name of the first player and create player object
        consoleOutput.printAskPlayerName(0);
        consoleOutput.printInputRequest();
        String playerName = userInput.getUserName();
        while (playerName.isEmpty()) {
            consoleOutput.printInvalidInputName();
            consoleOutput.printInputRequest();
            playerName = userInput.getUserName();
        }
        human = new Player(playerName);

        // Get AI ID by increasing humanId by 1
        aiId = human.getPlayerId() + 1;
        ai = new Opponent(aiId, human.getPlayerId(), mode.equals("hard"));

        board = new Board();

        scoreHumanPlayer = 0;
        scoreAI = 0;

        anotherRound = true;
    }

    /**
     * This method starts the game. It holds all the game logic and the main game loop.
     */
    public void start() {
        while (anotherRound) {
            boolean roundEnded = false;

            while (!roundEnded) {
                consoleOutput.printBoard(board);
                consoleOutput.printWhoseTurn(human);

                String validInput = getValidInput();

                roundEnded = checkRoundState(validInput, roundEnded);
            }
            consoleOutput.printWinnerBoard(board);
            consoleOutput.printCurrScoreMessage();
            consoleOutput.printScoreSingle(human, scoreHumanPlayer, scoreAI);

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
                board = new Board();
            }
        }

        // Print end message
        consoleOutput.printEndScoreMessage();
        consoleOutput.printScoreSingle(human, scoreHumanPlayer, scoreAI);

        selectWinnerForOutputMessage();

        consoleOutput.printByeMsg();
    }

    /**
     * Selects the winner based on the score and prints the winner message.
     */
    private void selectWinnerForOutputMessage() {
        // Get winner and print winner message
        if (scoreHumanPlayer > scoreAI) {
            consoleOutput.printGameFinished(human, scoreHumanPlayer);
        } else if (scoreHumanPlayer < scoreAI) {
            consoleOutput.printGameFinishedAI(scoreAI);
        } else {
            consoleOutput.printGameDraw(scoreHumanPlayer);
        }
    }

    /**
     * Checks if the round has ended and prints the winner or a draw message.
     *
     * @param validInput String that represents the valid input
     * @param roundEnded boolean that indicates if the game has ended
     * @return boolean that indicates if the game has ended (never {@code null})
     */
    private boolean checkRoundState(String validInput, boolean roundEnded) {
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

                boolean successFullUpdate = board.updateBoard(numValidInput, human.getPlayerId());

                if (successFullUpdate) {
                    // Check board state
                    roundEnded = isRoundEnded(roundEnded);

                    if (!roundEnded) {
                        // AI makes its move
                        int nextMoveAi = ai.getMove(board);
                        board.updateBoard(nextMoveAi, aiId);
                        // Check game state
                        roundEnded = isRoundEnded(roundEnded);
                    }
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
        consoleOutput.printInputRequest();
        String validInput = userInput.getUserInput();
        while (validInput.isEmpty()) {
            // Warning message for wrong input (with instructions and right input)
            consoleOutput.printFieldInputError(1, 0);
            validInput = userInput.getUserInput();
        }
        return validInput;
    }

    /**
     * Checks if the game has ended and prints the winner or a draw message.
     *
     * @param roundEnded boolean that indicates if the game has ended
     * @return boolean that indicates if the game has ended
     */
    private boolean isRoundEnded(boolean roundEnded) {
        int boardState = board.checkForWinner();
        if (boardState == -1) {
            roundEnded = true;
            consoleOutput.printDraw();
        } else if (boardState == aiId) {
            roundEnded = true;
            consoleOutput.printWinnerAi();
            scoreAI++;
        } else if (boardState == human.getPlayerId()) {
            roundEnded = true;
            consoleOutput.printWinner(human);
            scoreHumanPlayer++;
        }
        return roundEnded;
    }

}
