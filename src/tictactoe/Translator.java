package tictactoe;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class Translator is responsible for translating the game into different languages.
 * It holds two HashMaps with the same keys but different values (one for english and one for german).
 *
 * @version 1.0.1
 */
public class Translator {
    private String currentLanguage; // Possible Values: EN, DE
    // 2 identical Maps with two languages (de and en) for every output used by this Game
    public static Map<String, String> en_UK = new HashMap<>() {{
        put("title", """
                 _____          _____            _____         \s
                |_   _(_) ___  |_   _|_ _  ___  |_   _|__   ___\s
                  | | | |/ __|   | |/ _  |/ __|   | |/ _ \\ / _ \\
                  | | | | (__    | | (_| | (__    | | (_) |  __/
                  |_| |_|\\___|   |_|\\__,_|\\___|   |_|\\___/ \\___|

                """);
        put("ask_player_msg", "Please enter the name of the Player");
        put("ask_player1_msg", "Please enter the name of the first Player");
        put("ask_player2_msg", "Please enter the name of the second Player");
        put("draw_msg", "This round was a draw !");
        put("player_won_msg", " won the round ☆☆☆☆☆");
        put("whose_turn_1_msg", "It is ");
        put("whose_turn_2_msg", "'s turn");
        put("invalid_field_error_msg", "Invalid field numbers: ");
        put("occupied_field_1_error_msg", "The field: ");
        put("occupied_field_2_error_msg", " is already occupied");
        put("ask_start_msg", "Welcome please set your language.\nWillkommen bitte wählen sie ihre Sprache\n(de/en)");
        put("invalid_input_error_msg", "Your input is invalide, please try again. \n(Type 'help' for a list of validate inputs)");
        put("game_ended_msg", "\nGame was terminate by user\n");
        put("lang_changed_msg", "Language was changed to english");
        put("welcome_msg", "\nWelcome to TicTacToe.\nFollowing you will find the Instructions.\nHave fun playing TicTacToe!!! \n");
        put("instructions_msg", "To play the game, you have to enter the number of the field you want to place your symbol in. \n" +
                "The field-numbers are as follows: \n" +
                """
                   +---+---+---+
                   | 1 | 2 | 3 |
                   +---+---+---+
                   | 4 | 5 | 6 |
                   +---+---+---+
                   | 7 | 8 | 9 |
                   +---+---+---+
                """ +
                "To change the language, enter these commands:\n" +
                "   de  --> for german or\n" +
                "   en  --> for english. \n\n" +
                "To exit the game, enter:\n" +
                "   exit\n");
        put("input_msg", "Your input: ");
        put("name_input_error_msg", "Name must be different and at least 1 character long, spaces do not count");
        put("new_round_msg", "Do you want to play another round? (y/n)");
        put("current_score_msg", "Current Score: ");
        put("end_score_msg", "\nFinal Score: ");
        put("winner_msg", " won the game with a score of: ");
        put("end_draw_msg", "The game ended in a draw! Both players have a score of: ");
        put("goodbye_msg", "Thank you for playing, see you next time!");
        put("pt", " point/s");
        put("short_invalid_input", "Your input is invalid");
        put("plr", "Player");
        put("question_difficulty", "Do you want to play easy or hard mode? (easy/hard)");
        put("ai_won_msg", "☆☆☆☆☆ AI has won the game ☆☆☆☆☆");
        put("ask_game_mode", "Single or Multiplayer? (single/multi)");
        put("artificial_intelligence", "AI");
    }};
    public static Map<String, String> de_DE = new HashMap<>() {{
        put("title", """
                 _____          _____            _____         \s
                |_   _(_) ___  |_   _|_ _  ___  |_   _|__   ___\s
                  | | | |/ __|   | |/ _  |/ __|   | |/ _ \\ / _ \\
                  | | | | (__    | | (_| | (__    | | (_) |  __/
                  |_| |_|\\___|   |_|\\__,_|\\___|   |_|\\___/ \\___|

                """);
        put("input_msg", "Ihre Eingabe: ");
        put("ask_player_msg", "Bitte geben sie den Namen des Spielers ein");
        put("ask_player1_msg", "Bitte geben sie den Namen des ersten Spielers ein");
        put("ask_player2_msg", "Bitte geben sie den Namen des zweiten Spielers ein");
        put("draw_msg", "Diese Runde ist ein Unentschieden");
        put("player_won_msg", " hat die Runde gewonnen ☆☆☆☆☆");
        put("whose_turn_1_msg", "Es ist ");
        put("whose_turn_2_msg", " an der Reihe");
        put("invalid_field_error_msg", "Invalide Feld Nummer: ");
        put("occupied_field_1_error_msg", "Das Feld: ");
        put("occupied_field_2_error_msg", " ist bereits belegt");
        put("ask_start_msg", "Welcome please set your language. Willkommen bitte wählen sie ihre Sprache (de/en)");
        put("invalid_input_error_msg", "Ihre Eingabe ist ungültig. Bitte versuchen Sie es erneut.\n(Verwenden Sie 'help' für eine Liste von möglichen Eingaben)");
        put("game_ended_msg", "\nDas Spiel wurde vom Spieler beendet\n");
        put("lang_changed_msg", "Die Sprache wurde auf Deutsch geändert");
        put("welcome_msg", "\nWillkommen bei Tic-Tac-Toe.\nNachfolgend findest du die Spielanleitung.\nViel Spaß beim Spielen von Tic-Tac-Toe!!!");
        put("instructions_msg", "Um das Spiel zu spielen, müssen Sie die Nummer des Feldes eingeben, in dem Sie Ihr Symbol platzieren möchten. \n" +
                "Die Feldnummern sind wie folgt: \n" +
                """
                   +---+---+---+
                   | 1 | 2 | 3 |
                   +---+---+---+
                   | 4 | 5 | 6 |
                   +---+---+---+
                   | 7 | 8 | 9 |
                   +---+---+---+
                """ +
                "Um die Sprache zu ändern, geben sie eine der folgenden Befehle ein:\n" +
                "   de  --> für Deutsch oder\n" +
                "   en  --> für Englisch. \n\n" +
                "um das Spiel zu verlassen, geben sie eine der folgenden Befehle ein:\n" +
                "   exit\n");
        put("name_input_error_msg", "Name müssen unterschiedlich und mindestens 1 Zeichen lang sein, Leerzeichen zählen nicht");
        put("new_round_msg", "Möchten Sie eine weitere Runde spielen? (y/n)");
        put("current_score_msg", "Aktueller Spielstand: ");
        put("end_score_msg", "\nEndergebnis: ");
        put("winner_msg", " hat das Spiel gewonnen mit einem Punktestand von: ");
        put("end_draw_msg", "Das Spiel endete unentschieden! Beide Spieler haben einen Punktestand von: ");
        put("goodbye_msg", "Vielen Dank fürs Spielen, bis zum nächsten Mal!");
        put("pt", " Punkt/e");
        put("short_invalid_input", "Ihre Eingabe ist ungültig");
        put("plr", "Spieler");
        put("question_difficulty", "Wollen Sie im easy oder hard Modus spielen? (easy/hard)");
        put("ai_won_msg", "☆☆☆☆☆ Die KI hat das Spiel gewonnen ☆☆☆☆☆");
        put("ask_game_mode", "Einzel- oder Mehrspieler? (single/multi)");
        put("artificial_intelligence", "KI");
    }};

    /**
     * The Constructor sets the current language to the given language.
     *
     * @param language current language
     */
    public Translator(String language) {
        setCurrentLanguage(language);
    }

    /**
     * Sets the language to a new language given by the parameter.
     *
     * @param currentLanguage the language to set, if currentLanguage is an invalid String EN will be set as currentLanguage
     */
    public void setCurrentLanguage(String currentLanguage) {
        this.currentLanguage = currentLanguage.equalsIgnoreCase("de") ? "DE" : "EN";
    }

    /**
     * Return the current language.
     *
     * @return the current language (EN, DE, ...) (never {@code null})
     */
    public String getCurrentLanguage() {
        return currentLanguage;
    }

    /**
     * Translates a given key into the current language.
     *
     * @param key the key to translate, that is used in the Hashmap.
     * @return the translated String using the currentLanguage, if key does not exist it returns an empty String (never {@code null})
     */
    public String translate(String key) {
        if (!en_UK.containsKey(key) || !de_DE.containsKey(key)) {
            return "";
        }
        return currentLanguage.equals("DE") ? de_DE.get(key) : en_UK.get(key);
    }
}
