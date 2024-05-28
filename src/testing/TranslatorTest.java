package testing;

import org.junit.Before;
import org.junit.Test;
import tictactoe.Translator;

import static org.junit.Assert.assertEquals;

/**
 * This class contains JUnit tests to test the behaviour of the Translator Class with different input values.
 *
 * @version 1.0.1
 */
public class TranslatorTest {
    private Translator translator;

    /**
     * This methode initialise the translator class for all tests
     */
    @Before
    public void setUp() {
        translator = new Translator("en");
    }
    /**
     * This methode tests a console output from the user (defoult english)
     */
    @Test
    public void testUserInput_1() {
        String consoleOutput = translator.translate("game_ended_msg");
        assertEquals("\nGame was terminate by user\n", consoleOutput);
    }
    /**
     * This methode tests that the language can be changed to german
     */
    @Test
    public void testUserInput_2() {
        translator.setCurrentLanguage("de");
        String consoleOutput = translator.getCurrentLanguage();
        assertEquals("DE", consoleOutput);
    }
    /**
     * This methode tests a console output from the user (in german)
     */
    @Test
    public void testUserInput_3() {
        translator.setCurrentLanguage("de");
        String consoleOutput = translator.translate("game_ended_msg");
        assertEquals("\nDas Spiel wurde vom Spieler beendet\n", consoleOutput);
    }
    /**
     * This methode tests that the language can be changed to english
     */
    @Test
    public void testUserInput_4() {
        translator.setCurrentLanguage("en");
        String consoleOutput = translator.getCurrentLanguage();
        assertEquals("EN", consoleOutput);
    }
    /**
     * This methode tests a console output from the user (in english)
     */
    @Test
    public void testUserInput_5() {
        translator.setCurrentLanguage("en");
        String consoleOutput = translator.translate("game_ended_msg");
        assertEquals("\nGame was terminate by user\n", consoleOutput);
    }
    /**
     * This methode tests the translator in german by asking for a non-existing key (Key from the Map in translator)
     */
    @Test
    public void testTranslatorWithInvalidKey() {
        translator.setCurrentLanguage("de");
        String consoleOutput = translator.translate("non_existing_key");
        assertEquals("", consoleOutput);
    }
}
