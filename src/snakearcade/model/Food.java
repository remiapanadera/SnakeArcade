
package snakearcade.model;

import snakearcade.interfaces.Drawable;
import java.awt.Color;
import java.awt.Graphics;

public class Food implements Drawable {

    private int x;
    private int y;

    private static final int CELL_SIZE = 20;

    // Constructor
    public Food(int x, int y) {
        setPosition(x, y);
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Update food position
    public void setPosition(int x, int y) {

        if (x < 0 || y < 0) {
            throw new IllegalArgumentException(
                "Food position cannot be negative."
            );
        }

        this.x = x;
        this.y = y;
    }

    // Draw the food
    @Override
    public void draw(Graphics g) {

        g.setColor(Color.RED);

        g.fillOval(
            x * CELL_SIZE + 2,
            y * CELL_SIZE + 2,
            CELL_SIZE - 4,
            CELL_SIZE - 4
        );
    }
}
