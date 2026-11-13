
package snakearcade;

import snakearcade.model.Player;
import snakearcade.manager.ScoreManager;

public class ScoreManagerTest {

    public static void main(String[] args) {

        ScoreManager manager = new ScoreManager();

        // Create players
        Player p1 = new Player(1, "Alex", "Easy");
        Player p2 = new Player(2, "Sam", "Hard");
        Player p3 = new Player(3, "Jamie", "Medium");

        // Add players
        manager.addPlayer(p1);
        manager.addPlayer(p2);
        manager.addPlayer(p3);

        // Update scores
        manager.updateScore("Alex", 100);
        manager.updateScore("Sam", 250);
        manager.updateScore("Jamie", 80);

        // Display leaderboard
        System.out.println("=== LEADERBOARD ===");

        for (Player player : manager.getLeaderboard()) {

            System.out.println(
                player.getName() + " - "
                + player.getHighestScore()
            );
        }

        // Search for a player
        Player result = manager.findPlayer("Alex");

        if (result != null) {
            System.out.println("\nFound: " + result.getName());
        }
    }
}
