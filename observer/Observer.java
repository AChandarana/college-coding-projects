package observer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Creates random number variable and creates template for updates.
 * @author Alex Chandarana
 */
public abstract class Observer {
    
    protected Random rand;

    /**
     * @param babies the list of babies the user inputed
     */
    public Observer(ArrayList<Baby> babies) {
        rand = new Random();
    }

    /**
     * @param cry the type of crying the baby did
     * @param baby a baby the user inputed
     */
    public abstract void update(Cry cry, Baby baby);

}
