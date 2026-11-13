
package snakearcade.gui;

import javax.swing.JPanel;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import snakearcade.controller.GameController;
import snakearcade.interfaces.Drawable;

public class GamePanel extends JPanel {

    private final GameController game;
    private final Runnable restartAction;

    private static final int CELL_SIZE = 20;

    private static final Color BACKGROUND =
            new Color(15, 20, 15);

    public GamePanel(GameController game, Runnable restartAction) {

        this.game = game;
        this.restartAction = restartAction;

        setBackground(BACKGROUND);

        setPreferredSize(
            new java.awt.Dimension(
                GameController.BOARD_WIDTH * CELL_SIZE,
                GameController.BOARD_HEIGHT * CELL_SIZE + 40
            )
        );

        // Activate keyboard controls
        setupControls();
    }

    // Set up keyboard controls
    private void setupControls() {

        InputMap inputMap = getInputMap(
                JPanel.WHEN_IN_FOCUSED_WINDOW
        );

        ActionMap actionMap = getActionMap();

        // UP
        inputMap.put(
                KeyStroke.getKeyStroke("UP"),
                "moveUp"
        );

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.changeDirection(0, -1);
            }
        });

        // DOWN
        inputMap.put(
                KeyStroke.getKeyStroke("DOWN"),
                "moveDown"
        );

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.changeDirection(0, 1);
            }
        });

        // LEFT
        inputMap.put(
                KeyStroke.getKeyStroke("LEFT"),
                "moveLeft"
        );

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.changeDirection(-1, 0);
            }
        });

        // RIGHT
        inputMap.put(
                KeyStroke.getKeyStroke("RIGHT"),
                "moveRight"
        );

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.changeDirection(1, 0);
            }
        });

        // SPACEBAR - Pause or Resume
        inputMap.put(
                KeyStroke.getKeyStroke("SPACE"),
                "togglePause"
        );

        actionMap.put("togglePause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.togglePause();
                repaint();
            }
        });

        // R - Restart game
        inputMap.put(
                KeyStroke.getKeyStroke("R"),
                "restartGame"
        );

        actionMap.put("restartGame", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartAction.run();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        // Draw the score
        g.setColor(Color.WHITE);
        g.drawString("Score: " + game.getScore(), 15, 20);

        // Move drawing area below the score
        Graphics boardGraphics = g.create();

        boardGraphics.translate(0, 40);

        // Draw the grid
        boardGraphics.setColor(
                new Color(35, 50, 35)
        );

        for (int x = 0;
             x <= GameController.BOARD_WIDTH;
             x++) {

            boardGraphics.drawLine(
                    x * CELL_SIZE, 0,
                    x * CELL_SIZE,
                    GameController.BOARD_HEIGHT * CELL_SIZE
            );
        }

        for (int y = 0;
             y <= GameController.BOARD_HEIGHT;
             y++) {

            boardGraphics.drawLine(
                    0, y * CELL_SIZE,
                    GameController.BOARD_WIDTH * CELL_SIZE,
                    y * CELL_SIZE
            );
        }

        // Draw snake and food using polymorphism
        for (Drawable object : new Drawable[] {
                game.getSnake(), game.getFood()
        }) {

            object.draw(boardGraphics);
        }

        boardGraphics.dispose();

        // Game over message
        if (game.isGameOver()) {

            g.setColor(Color.RED);
            g.drawString(
                    "GAME OVER",
                    250,
                    230
            );
        }

        // Pause message
        if (game.isPaused()) {

            g.setColor(Color.YELLOW);
            g.drawString(
                    "PAUSED",
                    270,
                    230
            );
        }
    }
}
