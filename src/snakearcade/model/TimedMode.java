
package snakearcade.model;

public class TimedMode extends GameMode {

    public TimedMode() {
        super("Timed Mode", 110);
    }

    @Override
    public int calculatePoints(int foodEaten) {
        return foodEaten * 15;
    }

    @Override
    public int getTimeLimitSeconds() {
        return 60;
    }
}
