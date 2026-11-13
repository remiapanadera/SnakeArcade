package snakearcade.model;

import snakearcade.interfaces.Saveable;
import java.io.IOException;

public class Player implements Saveable {

    // Private fields
    private final int playerId;
    private String name;
    private int highestScore;
    private String difficulty;

    // Constructor
    public Player(int playerId, String name, String difficulty) {

        if (playerId <= 0) {
            throw new IllegalArgumentException("Invalid player ID.");
        }

        this.playerId = playerId;
        setName(name);
        setDifficulty(difficulty);
        this.highestScore = 0;
    }

    // Getters
    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public String getDifficulty() {
        return difficulty;
    }

    // Setters with validation
    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be empty.");
        }

        this.name = name;
    }

    public void setDifficulty(String difficulty) {

        if (difficulty == null ||
            !(difficulty.equalsIgnoreCase("Easy") ||
              difficulty.equalsIgnoreCase("Medium") ||
              difficulty.equalsIgnoreCase("Hard"))) {

            throw new IllegalArgumentException("Invalid difficulty.");
        }

        this.difficulty = difficulty;
    }

    public void setHighestScore(int highestScore) {

        if (highestScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative.");
        }

        this.highestScore = highestScore;
    }

    @Override
public void save() throws IOException {
    System.out.println("Player data is ready to be saved.");
}
}
