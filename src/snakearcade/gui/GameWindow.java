
package snakearcade.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import snakearcade.controller.GameController;
import snakearcade.model.ClassicMode;

public class GameWindow extends JFrame {

    private GameController game;
    private GamePanel gamePanel;
    private Timer timer;

    public GameWindow() {

        setTitle("Snake Arcade");

        // Create the game controller
        game = new GameController(new ClassicMode());

        // Create the timer
        timer = new Timer(
                game.getGameMode().getInitialDelay(),
                e -> {

                    game.update();
                    gamePanel.repaint();

                    // Stop timer when game ends
                    if (game.isGameOver()) {
                        timer.stop();
                    }
                }
        );

        // Create the game panel
        gamePanel = new GamePanel(game, this::restartGame);

        add(gamePanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Start the game
        timer.start();
    }

    // Restart the game
    private void restartGame() {

        game.startGame();

        timer.start();

        gamePanel.repaint();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new GameWindow();
        });
    }
}
