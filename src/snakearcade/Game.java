
package snakearcade;

import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake Arcade");

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(15, 20, 18));

        JLabel title = new JLabel("SNAKE ARCADE");
        title.setForeground(new Color(57, 255, 20));
        title.setFont(new Font("Arial", Font.BOLD, 36));

        panel.add(title);

        frame.add(panel);
        frame.setVisible(true);
    }
}
