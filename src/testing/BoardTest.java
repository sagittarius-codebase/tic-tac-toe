package testing;

import org.junit.Before;
import org.junit.Test;
import tictactoe.Board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class contains JUnit tests to test the behaviour of the Board Class with different input values.
 *
 * @since 1.0.0
 */
public class BoardTest {

    private Board board;
    /**
     * This methode initialise the Board class for all tests
     */
    @Before
    public void setUp() {
        board = new Board();
    }
    /**
     * This methode tests that the playertwo can win.
     */
    @Test
    public void testCheckForWinnerPlayer2() {
        board.updateBoard(1, 2);
        board.updateBoard(2, 2);
        board.updateBoard(3, 2);
        assertEquals(2, board.checkForWinner());
    }
    /**
     * This methode tests that the playerone can win.
     */
    @Test
    public void testCheckForWinnerPlayer1() {
        board.updateBoard(1, 1);
        board.updateBoard(2, 1);
        board.updateBoard(3, 1);
        assertEquals(1, board.checkForWinner());
    }
    /**
     * This methode is a addition to testCheckForWinnerPlayer2 & testCheckForWinnerPlayer1 methode
     */
    @Test
    public void testCheckForWinner2() {
        board.updateBoard(1, 1);
        board.updateBoard(2, 1);
        board.updateBoard(6, 1);
        board.updateBoard(7, 1);
        board.updateBoard(9, 1);
        assertEquals(0, board.checkForWinner());
    }
    /**
     * This methode tests that the game can end in a draw.
     */
    @Test
    public void testCheckForDraw() {
        board.updateBoard(1, 1);
        board.updateBoard(2, 1);
        board.updateBoard(6, 1);
        board.updateBoard(7, 1);
        board.updateBoard(9, 1);
        board.updateBoard(4, 2);
        board.updateBoard(3, 2);
        board.updateBoard(5, 2);
        board.updateBoard(8, 2);
        assertEquals(-1, board.checkForWinner());
    }
    /**
     * This methode tests that an occupied fiel is managed correctly.
     */
    @Test
    public void testOccupiedField() {
        board.updateBoard(1, 1);
        assertFalse(board.updateBoard(1, 2));
    }
    /**
     * This methode tests that an unoccupied fiel is managed correctly.
     */
    @Test
    public void testUnoccupiedField() {
        board.updateBoard(1, 1);
        assertTrue(board.updateBoard(2, 1));
    }
    /**
     * This methode tests that the winning row mark works
     */
    @Test
    public void testFieldIsWinnerFieldRow() {
        board.updateBoard(1, 1);
        board.updateBoard(2, 1);
        board.updateBoard(3, 1);
        board.updateBoard(8, 1);
        board.updateBoard(4, 2);
        board.updateBoard(6, 2);
        assertTrue(board.checkIfFieldIsWinnerField(1));
        assertTrue(board.checkIfFieldIsWinnerField(2));
        assertTrue(board.checkIfFieldIsWinnerField(3));
        assertFalse(board.checkIfFieldIsWinnerField(4));
        assertFalse(board.checkIfFieldIsWinnerField(5));
        assertFalse(board.checkIfFieldIsWinnerField(6));
        assertFalse(board.checkIfFieldIsWinnerField(7));
        assertFalse(board.checkIfFieldIsWinnerField(8));
        assertFalse(board.checkIfFieldIsWinnerField(9));
    }
    /**
     * This methode tests that the winning Column mark works
     */
    @Test
    public void testFieldIsWinnerFieldColumn() {
        board.updateBoard(1, 1);
        board.updateBoard(4, 1);
        board.updateBoard(7, 1);
        board.updateBoard(2, 1);
        board.updateBoard(3, 2);
        board.updateBoard(9, 2);
        assertTrue(board.checkIfFieldIsWinnerField(1));
        assertFalse(board.checkIfFieldIsWinnerField(2));
        assertFalse(board.checkIfFieldIsWinnerField(3));
        assertTrue(board.checkIfFieldIsWinnerField(4));
        assertFalse(board.checkIfFieldIsWinnerField(5));
        assertFalse(board.checkIfFieldIsWinnerField(6));
        assertTrue(board.checkIfFieldIsWinnerField(7));
        assertFalse(board.checkIfFieldIsWinnerField(8));
        assertFalse(board.checkIfFieldIsWinnerField(9));
    }
    /**
     * This methode tests that the winning row diagonal mark works
     */
    @Test
    public void testFieldIsWinnerFieldDiagonal() {
        board.updateBoard(1, 1);
        board.updateBoard(5, 1);
        board.updateBoard(9, 1);
        board.updateBoard(6, 1);
        board.updateBoard(7, 1);
        board.updateBoard(2, 1);
        board.updateBoard(3, 2);
        board.updateBoard(8, 2);
        assertTrue(board.checkIfFieldIsWinnerField(1));
        assertFalse(board.checkIfFieldIsWinnerField(2));
        assertFalse(board.checkIfFieldIsWinnerField(3));
        assertFalse(board.checkIfFieldIsWinnerField(4));
        assertTrue(board.checkIfFieldIsWinnerField(5));
        assertFalse(board.checkIfFieldIsWinnerField(6));
        assertFalse(board.checkIfFieldIsWinnerField(7));
        assertFalse(board.checkIfFieldIsWinnerField(8));
        assertTrue(board.checkIfFieldIsWinnerField(9));
    }
    /**
     * This methode is an addition to testFieldIsWinnerFieldDiagonal methode
     */
    @Test
    public void testFieldIsWinnerFieldDiagonal2() {
        board.updateBoard(1, 2);
        board.updateBoard(5, 2);
        board.updateBoard(9, 2);
        board.updateBoard(6, 2);
        board.updateBoard(7, 2);
        board.updateBoard(2, 2);
        board.updateBoard(3, 1);
        board.updateBoard(8, 1);
        assertTrue(board.checkIfFieldIsWinnerField(1));
        assertFalse(board.checkIfFieldIsWinnerField(2));
        assertFalse(board.checkIfFieldIsWinnerField(3));
        assertFalse(board.checkIfFieldIsWinnerField(4));
        assertTrue(board.checkIfFieldIsWinnerField(5));
        assertFalse(board.checkIfFieldIsWinnerField(6));
        assertFalse(board.checkIfFieldIsWinnerField(7));
        assertFalse(board.checkIfFieldIsWinnerField(8));
        assertTrue(board.checkIfFieldIsWinnerField(9));
    }
}
