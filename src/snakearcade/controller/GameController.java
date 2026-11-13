
package snakearcade.controller;

import snakearcade.model.Snake;
import snakearcade.model.Food;
import snakearcade.model.GameMode;

import java.awt.Point;
import java.util.Random;

public class GameController {

    // Board dimensions
    public static final int BOARD_WIDTH = 30;
    public static final int BOARD_HEIGHT = 20;

    // Game objects
    private Snake snake;
    private Food food;
    private GameMode gameMode;

    // Game information
    private int score;
    private int directionX;
    private int directionY;

    private boolean gameOver;
    private boolean paused;

    private final Random random;

    // Constructor
    public GameController(GameMode gameMode) {

        this.gameMode = gameMode;
        this.random = new Random();

        startGame();
    }

    // Start or restart the game
    public void startGame() {

        snake = new Snake(10, 10);

        score = 0;

        directionX = 1;
        directionY = 0;

        gameOver = false;
        paused = false;

        generateFood();
    }

    // Generate food at a random position
    public void generateFood() {

        int x;
        int y;

        do {

            x = random.nextInt(BOARD_WIDTH);
            y = random.nextInt(BOARD_HEIGHT);

        } while (isSnakeAt(x, y));

        food = new Food(x, y);
    }

    // Check whether a position contains the snake
    private boolean isSnakeAt(int x, int y) {

        for (Point point : snake.getBody()) {

            if (point.x == x && point.y == y) {
                return true;
            }
        }

        return false;
    }

    // Change snake direction
    public void changeDirection(int dx, int dy) {

        // Prevent the snake from reversing direction
        if (dx == -directionX && dy == -directionY) {
            return;
        }

        directionX = dx;
        directionY = dy;
    }

    // Update game state
    public void update() {

        if (gameOver || paused) {
            return;
        }

        Point head = snake.getBody().get(0);

        int newX = head.x + directionX;
        int newY = head.y + directionY;

        // Check wall collision
        if (newX < 0 || newX >= BOARD_WIDTH ||
            newY < 0 || newY >= BOARD_HEIGHT) {

            gameOver = true;
            return;
        }

        // Check whether food is eaten
        boolean ateFood =
                newX == food.getX() &&
                newY == food.getY();

        // Move the snake
        snake.move(directionX, directionY, ateFood);

        // Check collision with its own body
        if (checkSelfCollision()) {
            gameOver = true;
            return;
        }

        // Update score
        if (ateFood) {

            int foodEaten = score / 10 + 1;

            score = gameMode.calculatePoints(foodEaten);

            generateFood();
        }
    }

    // Check collision with snake body
    private boolean checkSelfCollision() {

        Point head = snake.getBody().get(0);

        for (int i = 1; i < snake.getBody().size(); i++) {

            if (head.equals(snake.getBody().get(i))) {
                return true;
            }
        }

        return false;
    }

    // Pause or resume
    public void togglePause() {
        if (!gameOver) {
            paused = !paused;
        }
    }

    // Getters
    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isPaused() {
        return paused;
    }

    public GameMode getGameMode() {
        return gameMode;
    }
}
