package strategy;

import java.util.ArrayList;

/**
 * Movement behavior that makes an animal walk forward.
 *
 * @author Alex Chandarana
 */
public class WalkBehavior extends MoveBehavior {

    /**
     * Constructs a WalkBehavior with the given character art and speed.
     *
     * @param character The ASCII art lines for the character
     * @param speed The delay in milliseconds between moves
     */
    public WalkBehavior(ArrayList<String> character, int speed) {
        super(character, speed);

        
    }

    /**
     * Moves the character forward using walking behavior (no jumping).
     */
    public void move() {
        move(false);
    }
    
}
