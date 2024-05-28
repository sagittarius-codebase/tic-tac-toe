package testing;

import org.junit.Before;
import org.junit.Test;
import tictactoe.Board;
import tictactoe.Opponent;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class contains JUnit tests to test the behaviour of the Board Class with different input values.
 *
 * @since 1.0.0
 */
public class OpponentTest {


    private Opponent easyOpponent;
    private Opponent hardOpponent;
    /**
     * This methode initialise the Board class for all tests
     */
    @Before
    public void setUp() {
        int humanId = 1;
        int aiId = 2;
        easyOpponent = new Opponent(aiId, humanId, false);
        hardOpponent = new Opponent(aiId, humanId, true);
    }
    /**
     * This methode tests the easy mode (random) in different play situations and edge cases
     * the output is defined by all free fields in the 4 situations below
     */
    @Test
    public void testEasyMode() {
        Board board = new Board(new int[]{
                1, 2, 1,
                2, 2, 1,
                0, 0, 0});
        Integer[] freeFields = {7, 8, 9};
        Board board2 = new Board(new int[]{
                2, 1, 2,
                1, 1, 2,
                2, 0, 1});
        Board board3 = new Board(new int[]{
                0, 0, 0,
                0, 0, 0,
                0, 0, 0});
        Board board4 = new Board(new int[]{
                1, 2, 1,
                2, 2, 1,
                2, 1, 2});
        Integer[] freeFields3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertTrue(Arrays.asList(freeFields).contains(easyOpponent.getMove(board)));
        assertEquals(8, easyOpponent.getMove(board2));
        assertTrue(Arrays.asList(freeFields3).contains(easyOpponent.getMove(board3)));
        assertEquals(-1, easyOpponent.getMove(board4));
    }
    /**
     * This methode tests the hard mode (minimax) in different play situations and edge cases
     * the output is defined by the best possible move for the 3 situations below
     */
    @Test
    public void testHardMode() {
        Board board = new Board(new int[]{
                1, 2, 1,
                2, 2, 1,
                0, 0, 0});
        Board board2 = new Board(new int[]{
                2, 1, 2,
                1, 1, 2,
                0, 0, 0});
        Board board3 = new Board(new int[]{
                0, 0, 0,
                0, 0, 0,
                0, 0, 0});

        assertEquals(8, hardOpponent.getMove(board));
        assertEquals(9, hardOpponent.getMove(board2));
        assertEquals(1, hardOpponent.getMove(board3));
    }
}
