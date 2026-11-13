
package snakearcade.model;

public abstract class GameMode {

    private final String name;
    private final int initialDelay;

    public GameMode(String name, int initialDelay) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Game mode name cannot be empty.");
        }

        if (initialDelay <= 0) {
            throw new IllegalArgumentException("Game speed must be positive.");
        }

        this.name = name;
        this.initialDelay = initialDelay;
    }

    public String getName() {
        return name;
    }

    public int getInitialDelay() {
        return initialDelay;
    }

    public abstract int calculatePoints(int foodEaten);

    public abstract int getTimeLimitSeconds();
}
