
package snakearcade.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.CardLayout;

import snakearcade.controller.GameController;
import snakearcade.model.ClassicMode;
import snakearcade.model.TimedMode;
import snakearcade.model.GameMode;

public class GameWindow extends JFrame {

    private GameController game;
    private GamePanel gamePanel;
    private GameOverPanel gameOverPanel;
    private Timer timer;

    private CardLayout cardLayout;
    private JPanel mainContainer;

    public GameWindow() {

        setTitle("Snake Arcade");

        cardLayout = new CardLayout();
        mainContainer = new JPanel(cardLayout);

        // Create Main Menu with two mode choices
        MenuPanel menuPanel = new MenuPanel(
                () -> startSelectedMode(new ClassicMode()),
                () -> startSelectedMode(new TimedMode())
        );

        mainContainer.add(menuPanel, "MENU");

        add(mainContainer);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(650, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startSelectedMode(GameMode selectedMode) {

        // Stop previous timer if one exists
        if (timer != null) {
            timer.stop();
        }

        // Create a new game using the selected mode
        game = new GameController(selectedMode);

        // Create game panel
        gamePanel = new GamePanel(
                game,
                this::restartGame
        );

        // Replace old game screen
        mainContainer.add(gamePanel, "GAME");

        // Create timer
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

        cardLayout.show(mainContainer, "GAME");

        mainContainer.revalidate();
        mainContainer.repaint();

        timer.start();
    }

    private void restartGame() {

        game.startGame();

        cardLayout.show(mainContainer, "GAME");

        timer.start();
        gamePanel.repaint();
    }

    private void showGameOverScreen() {

        gameOverPanel = new GameOverPanel(
                game.getScore(),
                this::restartGame,
                this::returnToMenu
        );

        mainContainer.add(gameOverPanel, "GAME_OVER");

        cardLayout.show(mainContainer, "GAME_OVER");

        mainContainer.revalidate();
        mainContainer.repaint();
    }

    private void returnToMenu() {

        if (timer != null) {
            timer.stop();
        }

        cardLayout.show(mainContainer, "MENU");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new GameWindow();
        });
    }
}
