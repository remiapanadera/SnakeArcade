
package snakearcade.model;

import snakearcade.interfaces.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Snake implements Drawable {

    private final ArrayList<Point> body;
    private static final int CELL_SIZE = 20;

    // Constructor
    public Snake(int startX, int startY) {

        body = new ArrayList<>();

        // Create the initial snake body
        body.add(new Point(startX, startY));
        body.add(new Point(startX - 1, startY));
        body.add(new Point(startX - 2, startY));
    }

    // Move the snake
    public void move(int dx, int dy, boolean grow) {

        Point head = body.get(0);

        int newX = head.x + dx;
        int newY = head.y + dy;

        body.add(0, new Point(newX, newY));

        if (!grow) {
            body.remove(body.size() - 1);
        }
    }

    // Get a copy of the snake body
    public ArrayList<Point> getBody() {

        ArrayList<Point> copy = new ArrayList<>();

        for (Point point : body) {
            copy.add(new Point(point));
        }

        return copy;
    }

    // Draw the snake
    @Override
    public void draw(Graphics g) {

        g.setColor(new Color(57, 255, 20));

        for (Point point : body) {

            g.fillRoundRect(
                point.x * CELL_SIZE,
                point.y * CELL_SIZE,
                CELL_SIZE,
                CELL_SIZE,
                5,
                5
            );
        }
    }
}
