
package snakearcade.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.CardLayout;

import snakearcade.controller.GameController;
import snakearcade.model.ClassicMode;

public class GameWindow extends JFrame {

    private GameController game;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;
    private Timer timer;

    private CardLayout cardLayout;
    private JPanel mainContainer;

    public GameWindow() {

        setTitle("Snake Arcade");

        game = new GameController(new ClassicMode());

        // Set up CardLayout
        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        // Create screens
        MenuPanel menuPanel =
                new MenuPanel(this::startGameFromMenu);

        gamePanel =
                new GamePanel(game, this::restartGame);

        // Add screens
        mainContainer.add(menuPanel, "MENU");
        mainContainer.add(gamePanel, "GAME");

        add(mainContainer);

        // Game timer
        timer = new Timer(
                game.getGameMode().getInitialDelay(),
                e -> {
                    game.update();
                    gamePanel.repaint();

                    if (game.isGameOver()) {
                        timer.stop();
                        showGameOverScreen();
                    }
                }
        );

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startGameFromMenu() {

        game.startGame();

        cardLayout.show(mainContainer, "GAME");

        timer.start();
        gamePanel.repaint();
    }

    private void restartGame() {

        game.startGame();

        timer.start();
        gamePanel.repaint();

        cardLayout.show(mainContainer, "GAME");
    }

    private void showGameOverScreen() {

        // Create Game Over screen using final score
        gameOverPanel = new GameOverPanel(
                game.getScore(),
                this::restartGame,
                this::returnToMenu
        );

        // Add the new screen
        mainContainer.add(gameOverPanel, "GAME_OVER");

        // Display it
        cardLayout.show(mainContainer, "GAME_OVER");

        // Refresh layout
        mainContainer.revalidate();
        mainContainer.repaint();
    }

    private void returnToMenu() {

        timer.stop();

        cardLayout.show(mainContainer, "MENU");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new GameWindow();
        });
    }
}
