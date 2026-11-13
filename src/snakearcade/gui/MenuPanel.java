
package snakearcade.gui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(Runnable playAction) {

        setBackground(new Color(10, 25, 15));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(12, 0, 12, 0);

        // Game title
        JLabel title = new JLabel("SNAKE ARCADE");
        title.setFont(new Font("Arial", Font.BOLD, 42));
        title.setForeground(new Color(57, 255, 20));

        gbc.gridy = 0;
        add(title, gbc);

        // Subtitle
        JLabel subtitle = new JLabel("Classic Snake Game");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitle.setForeground(Color.WHITE);

        gbc.gridy = 1;
        add(subtitle, gbc);

        // Play button
        JButton playButton = new JButton("PLAY");
        playButton.setFont(new Font("Arial", Font.BOLD, 22));
        playButton.setForeground(Color.BLACK);
        playButton.setBackground(new Color(57, 255, 20));
        playButton.setFocusPainted(false);
        playButton.setPreferredSize(new Dimension(180, 50));

        playButton.addActionListener(e -> playAction.run());

        gbc.gridy = 2;
        gbc.insets = new Insets(35, 0, 12, 0);
        add(playButton, gbc);
    }
}
