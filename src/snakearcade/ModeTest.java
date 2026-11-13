
package snakearcade;

import snakearcade.model.*;

public class ModeTest {

    public static void main(String[] args) {

        GameMode mode1 = new ClassicMode();
        GameMode mode2 = new TimedMode();

        System.out.println(mode1.getName());
        System.out.println("Points: " + mode1.calculatePoints(3));

        System.out.println();

        System.out.println(mode2.getName());
        System.out.println("Points: " + mode2.calculatePoints(3));
    }
}
