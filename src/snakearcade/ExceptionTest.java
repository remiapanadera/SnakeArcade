
package snakearcade;

import snakearcade.exceptions.InvalidPlayerException;
import snakearcade.exceptions.InvalidGameSettingsException;

public class ExceptionTest {

    public static void validatePlayerName(String name)
            throws InvalidPlayerException {

        if (name == null || name.isBlank()) {
            throw new InvalidPlayerException(
                "Player name cannot be empty."
            );
        }
    }

    public static void validateGameSpeed(int speed)
            throws InvalidGameSettingsException {

        if (speed < 50 || speed > 300) {
            throw new InvalidGameSettingsException(
                "Game speed must be between 50 and 300."
            );
        }
    }

    public static void main(String[] args) {

        try {

            validatePlayerName("");
            validateGameSpeed(400);

        } catch (InvalidPlayerException |
                 InvalidGameSettingsException e) {

            System.out.println("Validation error: " + e.getMessage());

        } finally {

            System.out.println("Validation process finished.");
        }
    }
}
