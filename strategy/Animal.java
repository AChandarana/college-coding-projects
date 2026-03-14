package strategy;

import java.util.ArrayList;

/**
 * Represents an Animal in the AnimalWorld program.
 *
 * @author Alex Chandarana
 */
public abstract class Animal {
    
    /**
     * The ASCII art for the animal, stored as a list of Strings (one per line).
     */
    protected ArrayList<String> character = new ArrayList<>();

    /**
     * The name of the animal.
     */
    protected String name;

    /**
     * The movement behavior used by this animal.
     */
    protected MoveBehavior moveBehavior;
    
    /**
     * Constructs an Animal with the given name.
     *
     * @param name The name of the animal
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Moves the animal using its assigned movement behavior.
     */
    public void move() {
        moveBehavior.move();
    }

    /**
     * Returns the name of the animal.
     *
     * @return The animal name
     */
    public String toString() {
        return name;
    }

}
