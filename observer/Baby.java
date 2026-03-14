package observer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Baby cries in three different ways and responds to treatements differently.
 * @author Alex Chandarana
 */
public class Baby implements Subject {

    private String name;
    private ArrayList<Observer> observers;
    private Random rand;

    /**
     * @param name is the name of the baby
     */
    public Baby(String name) {
        this.name = name;
        observers = new ArrayList<>();
        rand = new Random();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Causes the baby to cry because it is mad and notifies all observers.
     */
    public void angryCry() {
        System.out.println("Waaaaaaaaa! " + getName() + " is feeling abandoned and angry.");
        notifyObservers(Cry.ANGRY);
    }

    /**
     * Causes the baby to cry because it is wet and notifies all observers.
     */
    public void wetCry() {
        System.out.println("Aaaaaa! " + getName() + " is WET!");
        notifyObservers(Cry.WET);
    }

    /**
     * Causes the baby to cry because it is hungry and notifies all observers.
     */
    public void hungryCry() {
        System.out.println("Neh Neh Neh! " + getName() + " is starving!!!");
        notifyObservers(Cry.HUNGRY);
    }

    /**
     * Simulates the baby being fed, with a random chance of acceptance or rejection.
     */
    public void eat() {
        boolean acceptance = rand.nextBoolean();
        if (acceptance) {
            System.out.println(getName() + " has a happy full tummy.");
        } else {
            System.out.println(getName() + " throws all the food on the floor");
        }
    }

    /**
     * Simulates the baby receiving love, with a random chance of calming down.
     */
    public void receiveLove() {
        boolean acceptance = rand.nextBoolean();
        if (acceptance) {
            System.out.println(getName() + " feels appreciated and loved.");
        } else {
            System.out.println(getName() + " pushes everyone away and continues to cry.");
        }
    }

    /**
     * Simulates the baby getting a diaper change.
     */
    public void getChanged() {
        System.out.println(getName() + " is having a diaper change.");
    }

    /**
     * Registers an observer to be notified when the baby cries.
     * @param observer the observer to register
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Removes a previously registered observer.
     * @param observer the observer to remove
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all registered observers of the specified cry.
     * @param cry the type of cry emitted by the baby
     */
    @Override
    public void notifyObservers(Cry cry) {
        for (Observer observer : observers) {
            observer.update(cry, this);
        }
    }

}
