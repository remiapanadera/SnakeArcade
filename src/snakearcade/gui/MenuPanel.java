
package snakearcade.gui;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(
            Runnable classicAction,
            Runnable timedAction
    ) {

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
        JLabel subtitle = new JLabel("SELECT YOUR GAME MODE");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitle.setForeground(Color.WHITE);

        gbc.gridy = 1;
        add(subtitle, gbc);

        // Classic Mode button
        JButton classicButton = new JButton("CLASSIC MODE");
        styleButton(classicButton);

        classicButton.addActionListener(
                e -> classicAction.run()
        );

        gbc.gridy = 2;
        gbc.insets = new Insets(30, 0, 12, 0);
        add(classicButton, gbc);

        // Timed Mode button
        JButton timedButton = new JButton("TIMED MODE");
        styleButton(timedButton);

        timedButton.addActionListener(
                e -> timedAction.run()
        );

        gbc.gridy = 3;
        gbc.insets = new Insets(12, 0, 12, 0);
        add(timedButton, gbc);
    }

    private void styleButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(57, 255, 20));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(220, 50));
    }
}
