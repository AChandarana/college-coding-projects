package observer;

import java.util.ArrayList;

/**
 * Dad does 1 of 3 random actions when updated.
 * @author Alex Chandarana
 */
public class Dad extends Observer{

    /**
     * Constructor registers babies as observers.
     * @param babies an array list of all the babies the user enters
     */
    public Dad(ArrayList<Baby> babies) {
        super(babies);
        for (Baby b : babies) {
            b.registerObserver(this);
        }
    }

    /**
     * Uses a randomizer to choose a random action.
     * @param cry type of cry the baby does
     * @param baby the baby that the user chooses
     */
    @Override
    public void update(Cry cry, Baby baby) {
        
        int choice = rand.nextInt(3);

        if (choice == 0) {
            System.out.println("Dad puts a pillow over their head");
        } else if (choice == 1) {
            System.out.println("Dad nudges mom");
        } else {
            System.out.println("Dad screams: \"AAAAAAAAAA\"");
        }
    }

}
