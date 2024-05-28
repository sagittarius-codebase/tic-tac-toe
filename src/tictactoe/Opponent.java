package tictactoe;

/**
 * This class represents the Algorithms (called AI) which asks as the opponent for the Player in singleplayer mode.
 * Its saves the ID of both (AI and player) and a boolean for easy or hard game mode.
 *
 * @since 1.0.0
 */

import java.util.Random;

public class Opponent {
    private final int aiId;
    private final int humanId;

    private final boolean isHardMode;

    /**
     * Constructor. It sets the playerId, aiId and hard or easy mode.
     *
     * @param aiId       defines the ID that should be given to the AI
     * @param humanId    defines the ID that should be given to the player
     * @param isHardMode the difficulty of the Game mode
     */
    public Opponent(int aiId, int humanId, boolean isHardMode) {
        this.aiId = aiId;
        this.humanId = humanId;
        this.isHardMode = isHardMode;
    }

    /**
     * Method to evaluate the next AI move (the best possible for hard mode and random for easy mode)
     *
     * @param board current Board
     * @return if board is full it returns -1, else if hard mode: field number of the best possible move. If easy mode: random free field number.
     */
    public int getMove(Board board) {
        if (board.isBoardFull()) {
            return -1;
        }
        if (isHardMode) {
            return getBestPossibleMove(board);
        } else {
            return getRandomMove(board);
        }
    }

    /**
     * Method to generate random field number for random move (only in easy mode)
     *
     * @param board current Board
     * @return random field number of a free field.
     */
    private int getRandomMove(Board board) {
        int[] freeFields = board.getFreeFields();
        return freeFields[new Random().nextInt(freeFields.length)];
    }

    /**
     * Method to generate field number for best possible move (only in hard mode)
     *
     * @param board current Board
     * @return field number of the best possible move.
     */
    private int getBestPossibleMove(Board board) {
        int bestScore = -1000; // number that is lower than 0 and 10
        int bestMove_X = -1;
        int bestMove_Y = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Check if current field is empty
                if (board.getPlayerAtPosition(i, j) == 0) {
                    // Make the move
                    board.updateBoard(i, j, aiId);

                    // Evaluate score of this move by using the minimax algorithm
                    int currMoveValue = minimax(board, 0, false);

                    // Reset the move
                    board.resetField(i, j);

                    // Update best move and bestScore
                    if (currMoveValue > bestScore) {
                        bestMove_X = i;
                        bestMove_Y = j;
                        bestScore = currMoveValue;
                    }
                }
            }
        }

        return bestMove_X * 3 + bestMove_Y + 1;
    }

    /**
     * The minimax algorithm goes through each possible move and evaluates which move has the highest score.
     * Based on that score he chooses which move to make.
     * The time complexity of the algorithm is O(b^d) with b being the number of branches and d the depth of the tree.
     * Because both values are fixed values in our implementation, the final time complexity is O(1).
     *
     * @param board        represents the board object with a given state
     * @param depth        defines the depth of the tree (has no use in this implementation)
     * @param isMaximizing defines if the algorithm should return the maximizing result
     * @return the best possible score possible with the current board state
     */
    private int minimax(Board board, int depth, boolean isMaximizing) {
        int score = evaluateScore(board);

        // Return 10 if ai won, return -10 if human won
        if (score == 10 || score == -10)
            return score;

        // Return 0 if game is a draw
        if (board.isBoardFull())
            return 0;

        if (isMaximizing) {
            int bestScore = -1000; // number that is lower than 0 and 10
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if current field is empty
                    if (board.getPlayerAtPosition(i, j) == 0) {
                        // Make the move
                        board.updateBoard(i, j, aiId);

                        // Call minimax recursively and choose the maximum value
                        bestScore = Math.max(bestScore,
                                minimax(board, depth + 1, false));

                        // Reset the move
                        board.resetField(i, j);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 1000; // number that is higher than 0 and -10
            // Go through each empty field
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Check if field is empty
                    if (board.getPlayerAtPosition(i, j) == 0) {
                        // Make the move
                        board.updateBoard(i, j, humanId);

                        // Call minimax recursively and choose the minimum value
                        bestScore = Math.min(bestScore,
                                minimax(board, depth + 1, true));

                        // Reset the move
                        board.resetField(i, j);
                    }
                }
            }
            return bestScore;
        }
    }

    /**
     * Method to evaluate the score of each move from the AI.
     * It returns a positive number if the score equals a good AI move, and
     * it returns a negative number if the score equals a bad AI move.
     *
     * @param board current Board
     * @return positive or negative number depending on the usability of the AI move.
     */
    private int evaluateScore(Board board) {
        int boardState = board.checkForWinner();

        if (boardState == aiId)
            return +10;
        else if (boardState == humanId)
            return -10;
        else
            return 0;
    }
}
