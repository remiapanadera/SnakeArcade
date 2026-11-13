
package snakearcade.manager;

import snakearcade.interfaces.Saveable;
import snakearcade.model.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class ScoreManager implements Saveable {

    private final ArrayList<Player> players;
    private final FileManager fileManager;

    public ScoreManager() {
        players = new ArrayList<>();
        fileManager = new FileManager();
    }

    // Add a player
    public void addPlayer(Player player) {

        if (player == null) {
            throw new IllegalArgumentException(
                "Player cannot be null."
            );
        }

        if (findPlayer(player.getName()) != null) {
            throw new IllegalArgumentException(
                "Player name already exists."
            );
        }

        players.add(player);
    }

    // Get all players
    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    // Search for a player
    public Player findPlayer(String name) {

        if (name == null) {
            return null;
        }

        for (Player player : players) {

            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }

        return null;
    }

    // Update highest score
    public void updateScore(String name, int newScore) {

        Player player = findPlayer(name);

        if (player == null) {
            throw new IllegalArgumentException(
                "Player not found."
            );
        }

        if (newScore < 0) {
            throw new IllegalArgumentException(
                "Score cannot be negative."
            );
        }

        if (newScore > player.getHighestScore()) {
            player.setHighestScore(newScore);
        }
    }

    // Sort leaderboard
    public ArrayList<Player> getLeaderboard() {

        ArrayList<Player> leaderboard = getPlayers();

        leaderboard.sort(
            Comparator.comparingInt(Player::getHighestScore)
                      .reversed()
        );

        return leaderboard;
    }

    // Load saved players
    public void loadPlayers() throws IOException {

        players.clear();
        players.addAll(fileManager.loadPlayers());
    }

    // Save players
    @Override
    public void save() throws IOException {

        fileManager.savePlayers(players);
    }
}
