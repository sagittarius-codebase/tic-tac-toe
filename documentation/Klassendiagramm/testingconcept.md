# Testing Konzept

## 1. Version



### Einzelne Klassen testen
#### UserInput():
- random Input, da output im Vorhinein klar ist

#### OutputPrinter():
- jede Methode einzeln aufrufen (Ausgabe ist deterministisch. Bei Sprachabhängigen Methoden -> mit beiden Sprachen

#### Translator():
ist bereits in OutputBoard() enthalten

#### Board():
- validate Move: Board und Input übergeben output ist deterministisch
- checkGameState: Board übergeben, Output ist deterministisch
- updateBoard: Board und Input übergeben, Output ist deterministisch

#### Player():
ist bereits in Game() und Board() enthalten

#### Game():
--> Frontend Testing

Spiel spielen und alle möglichen Ausgänge herbeiführen:
- Player 1 gewinnt
- Player 2 gewinnt
- untentschieden
- invalid Move
- invalid Input
- change Language


## 2. Version

Wir wollen auf valide und invalide inputs testen. Beim Testen von Methoden wollen ... (TODO)
Automatische tests und manuelle tests.

#### UserInput():
Bei der UserInput Klasse haben wir die getUserInput() die die User Eingabe verarbeitet und (TODO: define how the return datastructure is defined and how it is used). Die Methode nimmt also entweder eine Feldnummer ein Sprachkürzel oder den exit Befehl entgegen. Also müssen wir testen ob die Feldnummer im validen Bereich liegt, ob das eingegebene Sprachkürzel eine existierende Sprache representiert, ausserdem kann man das Sprachkürzel entweder in lower oder upper case eingeben, das man auch testen muss. Auch getestet werden muss der exit Befehl und ein ganz anderer input wie zum Beispiel ein Input von mehreren Worten.<br />
Mögliche Testing Werte: -3, 0, 1, 5, 9, 11, en, EN, dE, de, fr, exit, hello world

#### OutputPrinter():
Der OutputPrinter kann wenn nötig manuell getestet. Dabei kann man zum Beispiel die void printBoard(board: Board) methode testen und ob das Board richtig geprinted wird.

#### Translator():
Beim Translator kann man die String get() Methode testen wenn als currLanguage en und de ausgewählt ist. Und vielleicht wenn nötig kann man testen was passiert wenn currLanguage nicht existiert.

#### Board():
Bei der Board Klasse müssen wir die checkGameState() methode checken und zwar indem wir alle Möglichkeiten testen.<br />
Diese sind: 
- das Board ist noch nicht voll, das Spiel geht weiter
- das Board ist voll, das Spiel ist ein Draw
- das Board hat einen Gewinner (full row, full column, full diagonal left-up to right-down and full diagonal left-down to right-up)
Wenn es einen Gewinner hat, muss getestet werden ob die richtige playerId returned wird.

Die updateBoard(int field) Methode testet ob das gegeben Feld bereits belegt ist (mittels der validateMove() methode) und dann falls validateMove() true zurückgibt wird das Feld gesetzt. Hier testen wir zwei Möglichkeiten: man probiert auf ein belegtes Feld zu schreiben oder man probiert auf ein freies Feld zu schreiben. Man betrachtet das Board und schaut ob nachdem ein valides Feld gegeben wurde das Board geändert wurde und bei einem invaliden Feld ob das Board ungeändert bleibt.

#### Player():
Kann man wenn nötig die setter und getter Methoden testen.

#### Game():
Kann man wenn nötig die switchPlayer() Methode testen. Optional kann man die start() Methode manuell testen.

[testing_table](testing_table.png)
