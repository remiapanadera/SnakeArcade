
package snakearcade;

import snakearcade.model.Player;
import snakearcade.interfaces.Saveable;

public class InterfaceTest {

    public static void main(String[] args) throws Exception {

        Saveable player = new Player(1, "Alex", "Easy");

        player.save();
    }
}
