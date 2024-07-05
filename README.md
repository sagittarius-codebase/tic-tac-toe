# Tic-Tac-Toe (Student Programming Project December 2023)

## How to start the game
To start the game, you have to run the main method in the Main class of the Project. <br />

## How to run the Unit Tests
To run the Unit Tests, you can right-click on the test folder and select "Run 'Tests in 'testing''". <br />

## Game Instructions
To play the game, you have to enter the number of the field you want to place your symbol in. <br />
                The field-numbers are as follows: <br />
                """<br />
                   +-+--+-+<br />
                   | 1 | 2 | 3 |<br />
                   +-+--+-+<br />
                   | 4 | 5 | 6 |<br />
                   +-+--+-+<br />
                   | 7 | 8 | 9 |<br />
                   +-+--+-+<br />
                """ <br />
                To change the language, enter these commands:<br />
                   de  --> for german or<br />
                   en  --> for english.<br />
                To exit the game, enter:<br />
                    exit<br />
                
## Game flow
The game starts by asking the user which language is preferred (german / english). <br />
The user can then select if he wants to play in Singleplayer mode or in Multiplayer moder.<br />
In the singelplayer mode the player can choose between two difficulty settings (easy / hard) <br />
After set a playername the player will be play a game against a easy or hard computer opponent.<br />
At the end of each game the player can choose to play another round or to leave the game.<br />
In the multiplayer mode the two player can choose a own name. <br />
Following the two player will play a game against each other.<br />
At the end of each game the two player can choose to play another round or to leave the game.<br />
In case of another round always the player lost the previous round can start the game.<br />
In order to change between the two Gamemodes, the difficulty settings (in Singelplayer mode only) or the playername the game has to be restarted.<br />
In most situations can the command "help" be used to show the Game Instructions and valid inputs.<br />
Also in most situations can the command "exit" be used to leave the game.<br />

## Classmodell

[Klassenmodell](./documentation/Klassendiagramm/Klassenmodell.md)

Difference from the class diagram:<br />
- The Game class has been fundamentally revised and narrowed down:<br />
  A large part of the content of the Game class was divided and converted into 2 new classes:<br />
  Multiplayer class has the same features as the former Game class.<br />
  Single player class contains some of the same components as the multiplayer class, but also includes the control and management of the
  of the minimax algorithm (our AI opponent).<br />
- The game class now only manages the start of the game and the call whether a single player game or a multiplayer game should be played.<br />
- The Opponent class has been added. It contains the same features as the Player class but optimized for AI. it also includes <br />
  the implementation of the minimax algorithm (which is responsible for the next best move).<br />
- 4 different test classes were also added:<br />
  Board test includes JUnit test for the behavior of the board class with different input values.<br />
  TranslatorTest contains JUnit tests to test the behavior of the Translator class with different input values.<br />
  UserInputTest contains JUnit tests to test the behavior of the UserInput class with different input values.<br />
  OpponentTest contains JUnit tests to test the behavior of the Opponent class with different input values in different game situations.<br />
<br />
Description of the new / changed classes:<br />
- The Game class takes over the administration and the call when starting the Multiplayer & Singleplayer classes.<br />
  Game interacts with the classes: UserInput, Singleplayer, Multiplayer and OutputPrinter.<br /><br />
      UserInput: Query the input via the UserInput<br /> class
      OutputPrinter: Delegation of console output<br />
      Multiplayer: Call the multiplayer class<br />
      Singleplayer: Calling the singleplayer class<br /><br />
 - The Multiplayer class takes over the “organization” of the game.<br />
   Multiplayer interacts with the classes: Game, Player, Board, UserInput and OutputPrinter.<br /><br />
      Game: Called by Game<br />
      Player: Query and manage player variables<br />
      Board: Control of the playing field<br />
      UserInput: Query the input via the UserInput<br /> class
      OutputPrinter: Delegation of console output<br /><br />
 - The Singleplayer class takes over the “organization” of the Singleplayer Spies in combination with the AI.<br />
   Singleplayer interacts with the classes: Game, Opponent, Player, Board, UserInput and OutputPrinter.<br /><br />
      Game: Called by Game<br />
      Opponent: Query and manage player variables<br />
      Player: Query and manage player variables<br />
      Board: Control of the playing field<br />
      UserInput: Query the input via the UserInput<br /> class
      OutputPrinter: Delegation of console output<br /><br />
- The Opponent class stores the information of the player and the AI, and also contains the implementation of the minimax algorithm.<br />
   Opponent Does not interact with any other class. is simply called.<br />


## Testingkonzept

[Testingkonzept](./documentation/Klassendiagramm/testingconcept.md)

Note:
In this code println together with \n is used.

This is a copy of my group project work, which was carried out at the Zurich University of Applied Sciences (ZHAW)
