package testing;

import org.junit.Before;
import org.junit.Test;
import tictactoe.UserInput;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the UserInput Class with different input values.
 *
 * @version 1.0.1
 */
public class UserInputTest {

    private UserInput userInput;
    /**
     * This methode initialise the userinput class for all tests
     */
    @Before
    public void setUp() {
        userInput = new UserInput();
    }
    /**
     * This methode tests a correct edge case user input for field number
     */
    @Test
    public void testUserInput_1() {
        userInput.setInputScanner(new Scanner("1\n"));
        String input = userInput.getUserInput();
        assertEquals("1", input);
    }
    /**
     * This methode tests a correct user input for field number
     */
    @Test
    public void testUserInput_5() {
        userInput.setInputScanner(new Scanner("5\n"));
        String input = userInput.getUserInput();
        assertEquals("5", input);
    }
    /**
     * This methode tests an incorrect very low user input for field number
     */
    @Test
    public void testUserInput_neg3() {
        userInput.setInputScanner(new Scanner("-3\n"));
        String input = userInput.getUserInput();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect low user input for field number
     */
    @Test
    public void testUserInput_0() {
        userInput.setInputScanner(new Scanner("0\n"));
        String input = userInput.getUserInput();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect high user input for field number
     */
    @Test
    public void testUserInput_10() {
        userInput.setInputScanner(new Scanner("10\n"));
        String input = userInput.getUserInput();
        assertEquals("", input);
    }
    /**
     * This methode tests a correct user input for change language to english
     */
    @Test
    public void testUserInput_en() {
        userInput.setInputScanner(new Scanner("en\n"));
        String input = userInput.getUserInput();
        assertEquals("en", input);
    }
    /**
     * This methode tests a correct user input for change language to german
     */
    @Test
    public void testUserInput_de() {
        userInput.setInputScanner(new Scanner("dE\n"));
        String input = userInput.getUserInput();
        assertEquals("de", input);
    }
    /**
     * This methode tests a correct user input for exit game
     */
    @Test
    public void testUserInput_exit() {
        userInput.setInputScanner(new Scanner("exit\n"));
        String input = userInput.getUserInput();
        assertEquals("exit", input);
    }
    /**
     * This methode tests an incorrect user input
     */
    @Test
    public void testUserInput_hello_world() {
        userInput.setInputScanner(new Scanner("hello world\n"));
        String input = userInput.getUserInput();
        assertEquals("", input);
    }
    /**
     * This methode tests a correct user input for username
     */
    @Test
    public void testGetUserName() {
        userInput.setInputScanner(new Scanner("my Name\n"));
        String input = userInput.getUserName();
        assertEquals("my Name", input);
    }
    /**
     * This methode tests an incorrect user input for username
     */
    @Test
    public void testGetUserName_empty() {
        userInput.setInputScanner(new Scanner("\n"));
        String input = userInput.getUserName();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect user input for username
     */
    @Test
    public void testGetUserName_spaces() {
        userInput.setInputScanner(new Scanner("   \n"));
        String input = userInput.getUserName();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect user input for username
     */
    @Test
    public void testGetUserName_tabs() {
        userInput.setInputScanner(new Scanner("\t\t\t\n"));
        String input = userInput.getUserName();
        assertEquals("", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetGameMode_single() {
        userInput.setInputScanner(new Scanner("single\n"));
        String input = userInput.getGameMode();
        assertEquals("single", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetGameMode_multi() {
        userInput.setInputScanner(new Scanner("multi\n"));
        String input = userInput.getGameMode();
        assertEquals("multi", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetGameMode_single_uppercase() {
        userInput.setInputScanner(new Scanner("SINGLE\n"));
        String input = userInput.getGameMode();
        assertEquals("single", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetGameMode_multi_uppercase() {
        userInput.setInputScanner(new Scanner("MULTI\n"));
        String input = userInput.getGameMode();
        assertEquals("multi", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetGameMode_single_mixedcase() {
        userInput.setInputScanner(new Scanner("sInGlE\n"));
        String input = userInput.getGameMode();
        assertEquals("single", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetGameMode_multi_mixedcase() {
        userInput.setInputScanner(new Scanner("mUlTi\n"));
        String input = userInput.getGameMode();
        assertEquals("multi", input);
    }
    /**
     * This methode tests an incorrect user input
     */
    @Test
    public void testGetGameMode_empty() {
        userInput.setInputScanner(new Scanner("\n"));
        String input = userInput.getGameMode();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect user input for username
     */
    @Test
    public void testGetGameMode_spaces() {
        userInput.setInputScanner(new Scanner("   \n"));
        String input = userInput.getGameMode();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect user input for username
     */
    @Test
    public void testGetGameMode_tabs() {
        userInput.setInputScanner(new Scanner("\t\t\t\n"));
        String input = userInput.getGameMode();
        assertEquals("", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetDifficulty_easy() {
        userInput.setInputScanner(new Scanner("easy\n"));
        String input = userInput.getDifficulty();
        assertEquals("easy", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetDifficulty_hard() {
        userInput.setInputScanner(new Scanner("hard\n"));
        String input = userInput.getDifficulty();
        assertEquals("hard", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetDifficulty_easy_uppercase() {
        userInput.setInputScanner(new Scanner("EASY\n"));
        String input = userInput.getDifficulty();
        assertEquals("easy", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetDifficulty_hard_uppercase() {
        userInput.setInputScanner(new Scanner("HARD\n"));
        String input = userInput.getDifficulty();
        assertEquals("hard", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetDifficulty_easy_mixedcase() {
        userInput.setInputScanner(new Scanner("eAsY\n"));
        String input = userInput.getDifficulty();
        assertEquals("easy", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetDifficulty_hard_mixedcase() {
        userInput.setInputScanner(new Scanner("hArD\n"));
        String input = userInput.getDifficulty();
        assertEquals("hard", input);
    }
    /**
     * This methode tests an incorrect user input
     */
    @Test
    public void testGetDifficulty_empty() {
        userInput.setInputScanner(new Scanner("\n"));
        String input = userInput.getDifficulty();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect user input
     */
    @Test
    public void testGetDifficulty_spaces() {
        userInput.setInputScanner(new Scanner("   \n"));
        String input = userInput.getDifficulty();
        assertEquals("", input);
    }
    /**
     * This methode tests an incorrect user input
     */
    @Test
    public void testGetDifficulty_tabs() {
        userInput.setInputScanner(new Scanner("\t\t\t\n"));
        String input = userInput.getDifficulty();
        assertEquals("", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetNewRound_n() {
        userInput.setInputScanner(new Scanner("n\n"));
        String input = userInput.getNewRound();
        assertEquals("n", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetNewRound_y() {
        userInput.setInputScanner(new Scanner("y\n"));
        String input = userInput.getNewRound();
        assertEquals("y", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetNewRound_n_uppercase() {
        userInput.setInputScanner(new Scanner("N\n"));
        String input = userInput.getNewRound();
        assertEquals("n", input);
    }
    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetNewRound_y_uppercase() {
        userInput.setInputScanner(new Scanner("Y\n"));
        String input = userInput.getNewRound();
        assertEquals("y", input);
    }

    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetNewRound_yes() {
        userInput.setInputScanner(new Scanner("Yes\n"));
        String input = userInput.getNewRound();
        assertEquals("y", input);
    }

    /**
     * This methode tests a correct user input
     */
    @Test
    public void testGetNewRound_no() {
        userInput.setInputScanner(new Scanner("No\n"));
        String input = userInput.getNewRound();
        assertEquals("n", input);
    }
}
