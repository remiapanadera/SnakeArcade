
package snakearcade.manager;

import snakearcade.model.Player;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String PLAYER_FILE = "data/players.txt";

    // Create data folder if it doesn't exist
    public FileManager() {

        File folder = new File("data");

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Save players to a text file
    public void savePlayers(ArrayList<Player> players)
            throws IOException {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(PLAYER_FILE))) {

            for (Player player : players) {

                writer.write(
                    player.getPlayerId() + "," +
                    player.getName() + "," +
                    player.getHighestScore() + "," +
                    player.getDifficulty()
                );

                writer.newLine();
            }
        }
    }

    // Load players from a text file
    public ArrayList<Player> loadPlayers() throws IOException {

        ArrayList<Player> players = new ArrayList<>();

        File file = new File(PLAYER_FILE);

        if (!file.exists()) {
            return players;
        }

        try (BufferedReader reader =
                new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length != 4) {
                    continue;
                }

                try {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int score = Integer.parseInt(data[2]);
                    String difficulty = data[3];

                    Player player = new Player(id, name, difficulty);
                    player.setHighestScore(score);

                    players.add(player);

                } catch (IllegalArgumentException e) {

                    System.out.println(
                        "Skipping invalid player record: " + line
                    );
                }
            }
        }

        return players;
    }
}
