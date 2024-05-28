package tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the TicTacToe play board.
 * For each field the board saves either 0 that stands for a not set field or
 * the playerId which is either 1 or 2 which represents the field that was set
 * by the corresponding player.
 *
 * @since 1.0.0
 */
public class Board {
    /*
    Visualisation of the Board:
     +---+---+---+
     | 0 | 1 | 2 |
     +---+---+---+
     | 3 | 4 | 5 |
     +---+---+---+
     | 6 | 7 | 8 |
     +---+---+---+
    */
    private final int[] board;

    /**
     * Constructor for Class Board.
     */
    public Board() {
        this.board = new int[9];
    }

    /**
     * Constructor for Class Board.
     *
     * @param inputBoard defines the board that should be used
     */
    public Board(int[] inputBoard) {
        this.board = inputBoard;
    }

    /**
     * This method returns the board value at a given position.
     * Precondition: The given field is a valid value.
     *
     * @param field defines which field on the board (1-9)
     * @return 0: empty field, else: id of player that has set this field
     */
    public int getPlayerAtPosition(int field) {
        return board[field - 1];
    }

    /**
     * This method returns the board value at a given position.
     * Precondition: The given coordinates are valid values.
     *
     * @param x defines x coordinate (row) of field on the board (0-2)
     * @param y defines y coordinate (column) of field on the board (0-2)
     * @return 0: empty field, else: id of player that has set this field
     */
    public int getPlayerAtPosition(int x, int y) {
        return board[x * 3 + y];
    }

    /**
     * This method sets the board value at a given field position with a given playerId.
     * Precondition: The given field is a valid value.
     *
     * @param field    defines which field on the board (1-9)
     * @param playerId defines the value that should be set on the corresponding field
     * @return if the value was set successfully
     */
    public boolean updateBoard(int field, int playerId) {
        if (board[field - 1] != 0) {
            return false;
        } else {
            board[field - 1] = playerId;
            return true;
        }
    }

    /**
     * This method sets the board value at a given position using coordinates with a given playerId.
     * Precondition: The given field is a valid value.
     *
     * @param x        defines x coordinate (row) of field on the board (0-2)
     * @param y        defines y coordinate (column) of field on the board (0-2)
     * @param playerId defines the value that should be set on the corresponding field
     * @return if the value was set successfully
     */
    public boolean updateBoard(int x, int y, int playerId) {
        int field = x * 3 + y;
        if (board[field] != 0) {
            return false;
        } else {
        board[field] = playerId;
        return true;
        }
    }

    /**
     * This method resets the board value to 0 at a given field position.
     * Precondition: The given field is a valid value.
     *
     * @param field        defines which field on the board (1-9)
     */
    public void resetField(int field) {
        board[field] = 0;
    }

    /**
     * This method resets the board value to 0 at a given position using coordinates.
     * Precondition: The given field is a valid value.
     *
     * @param x        defines x coordinate (row) of field on the board (0-2)
     * @param y        defines y coordinate (column) of field on the board (0-2)
     */
    public void resetField(int x, int y) {
        int field = x * 3 + y;
        board[field] = 0;
    }

    /**
     * This method checks if there is a winner in the current board state. If there is it will return the id of
     * the winning player, if it is a draw (meaning the board is full) it will return -1 and if the board is not full
     * and there is no winner it will return 0 which stands for not finished.
     *
     * @return -1: draw, 0: not finished, else: id of winning player
     */
    public int checkForWinner() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (equals3(board[i * 3], board[i * 3 + 1], board[i * 3 + 2])) {
                return board[i * 3];
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (equals3(board[i], board[i + 3], board[i + 6])) {
                return board[i];
            }
        }

        // check diagonals
        if (equals3(board[0], board[4], board[8])) {
            return board[0];
        }
        if (equals3(board[2], board[4], board[6])) {
            return board[2];
        }

        // check if board is full
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                return 0;
            }
        }

        return -1;
    }

    /**
     * This method checks if a field is part of the 3 winning fields. It is used to highlight the winning fields.
     *
     * @param field to check
     * @return true: field is a winner field, else: false
     */
    public boolean checkIfFieldIsWinnerField(int field) {
        field -= 1;

        // check rows
        for (int i = 0; i < 3; i++) {
            if (equals3(board[i * 3], board[i * 3 + 1], board[i * 3 + 2])) {
                return field == i * 3 || field == i * 3 + 1 || field == i * 3 + 2;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (equals3(board[i], board[i + 3], board[i + 6])) {
                return field == i || field == i + 3 || field == i + 6;
            }
        }

        // check diagonals
        if (equals3(board[0], board[4], board[8])) {
                return field == 0 || field == 4 || field == 8;
        }
        if (equals3(board[2], board[4], board[6])) {
            return field == 2 || field == 4 || field == 6;
        }

        return false;
    }

    /**
     * This method checks if the board is full.
     *
     * @return true: board is full, else: false
     */
    public boolean isBoardFull(){
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method returns an array of all free fields on the board.
     *
     * @return array of free fields
     */
    public int[] getFreeFields(){
        List<Integer> freeFields = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if (board[i] == 0) {
                freeFields.add(i+1);
            }
        }
        return freeFields.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Helper method for checkForWinner() method.
     *
     * @param a first value
     * @param b second value
     * @param c third value
     * @return false: given values differ from one another or are all 0, else: true
     */
    private boolean equals3(int a, int b, int c) {
        return a == b && b == c && a != 0;
    }

}