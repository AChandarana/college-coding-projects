package strategy;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Defines shared movement logic for animals in the AnimalWorld program.
 *
 * @author Alex Chandarana
 */
public abstract class MoveBehavior {
    /**
     * The number of movement steps performed when an animal moves.
     */
    private int NUM_MOVES = 30;

    /**
     * The delay between each movement step.
     */
    private int speed;

    /**
     * The ASCII art for the character being moved.
     */
    private ArrayList<String> character = new ArrayList<>();

    /**
     * Constructs a MoveBehavior with the given character art and speed.
     *
     * @param character The ASCII art lines for the character
     * @param speed The delay in milliseconds between moves
     */
    public MoveBehavior(ArrayList<String> character, int speed) {
        this.character = character;
        this.speed = speed;
    }

    /**
     * Performs movement for the behavior.
     */
    public abstract void move();

    /**
     * Performs the core movement loop. If jump is true, the character briefly shifts upward.
     *
     * @param jump True if the movement should include jumping, false otherwise
     */
    protected void move(boolean jump) {
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < character.size(); ++i) {
            temp.add(character.get(i));
        }
        for (int i = 0; i < NUM_MOVES; ++i) {
            pushCharacterForward();
            if (jump && i % 2 == 1) {
                character.add(0, " ");
            }
            displayCharacter();
            if (jump && i % 2 == 1) {
                character.remove(0);
            }
            sleep(speed*75);
            clear();            
        }

        this.character = temp;
    }

    /**
     * Shifts each line of the character forward by adding a leading space.
     */
    private void pushCharacterForward() {
        for (int i = 0; i < character.size(); ++i) {
            char[] line = character.get(i).toCharArray();
            char[] temp = new char[line.length + 1];
            temp[0] = ' ';
            for (int ii = 0; ii < line.length; ++ii) {
                temp[ii + 1] = line[ii];
            }
            String tempString = new String(temp);
            character.set(i, tempString);
        }
    }

    /**
     * Prints the character's ASCII art to the console.
     */
    private void displayCharacter() {
        for (int i = 0; i < character.size(); ++i) {
            System.out.println(character.get(i));
        }
    }

    /**
     * Pauses execution for the given number of milliseconds.
     *
     * @param num The number of milliseconds to sleep
     */
    private void sleep(int num) {
        try {
            TimeUnit.MILLISECONDS.sleep(num);
        } catch (Exception e) {
            System.out.println("Timer error");
        }
    }

/**
 * Clears the console using ANSI escape codes.
 */
private void clear() {
    System.out.print("\033[H\033[2J");
}

}
