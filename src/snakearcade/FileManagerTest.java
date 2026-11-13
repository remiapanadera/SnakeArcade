
package snakearcade;

import snakearcade.manager.FileManager;
import snakearcade.model.Player;

import java.util.ArrayList;

public class FileManagerTest {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player(1, "Alex", "Easy"));
        players.add(new Player(2, "Sam", "Hard"));

        try {

            // Save players
            fileManager.savePlayers(players);

            System.out.println("Players saved successfully!");

            // Load players
            ArrayList<Player> loadedPlayers =
                    fileManager.loadPlayers();

            System.out.println("\n=== LOADED PLAYERS ===");

            for (Player player : loadedPlayers) {

                System.out.println(
                    player.getName() + " - "
                    + player.getDifficulty()
                );
            }

        } catch (Exception e) {

            System.out.println("File error: " + e.getMessage());

        } finally {

            System.out.println("\nFile operation finished.");
        }
    }
}
