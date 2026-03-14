package observer;

import java.util.ArrayList;

/**
 * Mom picks an action based on the type of cry.
 * @author Alex Chandarana
 */
public class Mom extends Observer {

    /**
     * Constructor registers babies as observers
     * @param babies the list of babies the user inputs
     */
    public Mom(ArrayList<Baby> babies) {
        super(babies);
        for (Baby b : babies) {
            b.registerObserver(this);
        }
    }

    /**
     * @param cry the type of crying the baby did
     * @param baby a baby the user inputed
     */
    @Override
    public void update(Cry cry, Baby baby) {
        if (cry.equals(Cry.HUNGRY)) {
            System.out.println("Mom feeds " + baby.getName());
            baby.eat();
        } else if (cry.equals(Cry.ANGRY)) {
            System.out.println("Mom hugs " + baby.getName());
            baby.receiveLove();
        } else if (cry.equals(Cry.WET)) {
            System.out.println("Mom changes " + baby.getName());
            baby.getChanged();
        }
    }

}
