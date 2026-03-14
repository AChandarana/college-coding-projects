package observer;

/**
 * The Subject interface represents the baby
 */
public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers(Cry cry);
}
