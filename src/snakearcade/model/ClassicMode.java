
package snakearcade.model;

public class ClassicMode extends GameMode {

    public ClassicMode() {
        super("Classic Mode", 140);
    }

    @Override
    public int calculatePoints(int foodEaten) {
        return foodEaten * 10;
    }

    @Override
    public int getTimeLimitSeconds() {
        return 0;
    }
}
