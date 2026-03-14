package strategy;

import java.util.ArrayList;

/**
 * Movement behavior that makes an animal jump.
 * @author Alex Chandarana
 */
public class JumpBehavior extends MoveBehavior {
    
    /**
     * Constructs a JumpBehavior with the given character art and speed.
     *
     * @param character The ASCII art lines for the character
     * @param speed The delay in milliseconds between moves
     */
    public JumpBehavior(ArrayList<String> character, int speed) {
        super(character, speed);
        
    }

    /**
     * Moves the character forward using jumping behavior.
     */
    public void move() {
        move(true);
    }

}
