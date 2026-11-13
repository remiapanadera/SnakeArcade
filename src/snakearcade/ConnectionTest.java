
package snakearcade;

import snakearcade.manager.ScoreManager;
import snakearcade.model.Player;

public class ConnectionTest {

    public static void main(String[] args) {

        ScoreManager manager = new ScoreManager();

        try {

            // Load previously saved players
            manager.loadPlayers();

            System.out.println("Loaded players: "
                    + manager.getPlayers().size());

            // Add a new player
            if (manager.findPlayer("Taylor") == null) {

                Player newPlayer =
                        new Player(3, "Taylor", "Medium");

                manager.addPlayer(newPlayer);
            }

            // Update Taylor's score
            manager.updateScore("Taylor", 300);

            // Save everything
            manager.save();

            System.out.println("\n=== UPDATED LEADERBOARD ===");

            for (Player player : manager.getLeaderboard()) {

                System.out.println(
                    player.getName() + " - "
                    + player.getHighestScore()
                );
            }

            System.out.println("\nData saved successfully!");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        } finally {

            System.out.println("Connection test finished.");
        }
    }
}
