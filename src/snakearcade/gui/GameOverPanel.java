
package snakearcade.gui;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {

    public GameOverPanel(
            int finalScore,
            Runnable playAgainAction,
            Runnable menuAction
    ) {

        setBackground(new Color(10, 25, 15));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(12, 0, 12, 0);

        // Game Over title
        JLabel title = new JLabel("GAME OVER");
        title.setFont(new Font("Arial", Font.BOLD, 42));
        title.setForeground(Color.RED);

        gbc.gridy = 0;
        add(title, gbc);

        // Final score
        JLabel scoreLabel = new JLabel("Your Score: " + finalScore);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);

        gbc.gridy = 1;
        add(scoreLabel, gbc);

        // Play Again button
        JButton playAgainButton = new JButton("PLAY AGAIN");
        styleButton(playAgainButton);

        playAgainButton.addActionListener(
                e -> playAgainAction.run()
        );

        gbc.gridy = 2;
        gbc.insets = new Insets(30, 0, 12, 0);
        add(playAgainButton, gbc);

        // Back to Menu button
        JButton menuButton = new JButton("BACK TO MENU");
        styleButton(menuButton);

        menuButton.addActionListener(
                e -> menuAction.run()
        );

        gbc.gridy = 3;
        gbc.insets = new Insets(12, 0, 12, 0);
        add(menuButton, gbc);
    }

    private void styleButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(57, 255, 20));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 45));
    }
}
