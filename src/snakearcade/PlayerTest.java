
package snakearcade;

import snakearcade.model.Player;

public class PlayerTest {

    public static void main(String[] args) {

        Player player = new Player(1, "Alex", "Easy");

        System.out.println("Player ID: " + player.getPlayerId());
        System.out.println("Player Name: " + player.getName());
        System.out.println("Highest Score: " + player.getHighestScore());
        System.out.println("Difficulty: " + player.getDifficulty());

        player.setHighestScore(100);
        player.setDifficulty("Hard");

        System.out.println("\nAfter updating:");

        System.out.println("Highest Score: " + player.getHighestScore());
        System.out.println("Difficulty: " + player.getDifficulty());
    }
}
