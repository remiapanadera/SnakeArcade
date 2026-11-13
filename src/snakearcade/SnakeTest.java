
package snakearcade;

import snakearcade.model.Snake;
import snakearcade.model.Food;
import snakearcade.interfaces.Drawable;

public class SnakeTest {

    public static void main(String[] args) {

        Snake snake = new Snake(10, 10);
        Food food = new Food(15, 10);

        System.out.println("Initial snake length: "
                + snake.getBody().size());

        // Move right without growing
        snake.move(1, 0, false);

        System.out.println("After moving: "
                + snake.getBody().size());

        // Move right and grow
        snake.move(1, 0, true);

        System.out.println("After eating food: "
                + snake.getBody().size());

        // Demonstrate interface implementation
        Drawable object1 = snake;
        Drawable object2 = food;

        System.out.println(object1.getClass().getSimpleName() + " and "
                + object2.getClass().getSimpleName() + " implement Drawable.");
    }
}
