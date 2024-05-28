package tictactoe;

/**
 * This class represents a player and saves a name and a playerId.
 * The playerId starts at 1 and is incremented internally.
 *
 * @version 1.0.1
 */
public class Player {
    private static int globalIdCounter = 0;
    private final int playerId;
    private String playerName;

    /**
     * Constructor. It sets the playerName based on the parameter and the playerId gets set automatically.
     *
     * @param playerName defines the name that should be given to this player object
     */
    public Player(String playerName) {
        setPlayerName(playerName);
        this.playerId = ++globalIdCounter;
    }

    /**
     * Set method for the Name.
     *
     * @param playerName defines the new name of this player object
     */
    private void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Get method for the ID.
     *
     * @return id of the player
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * Get method for the Name.
     *
     * @return playerName of this player object
     */
    public String getPlayerName() {
        return playerName;
    }
}
