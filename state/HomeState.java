package state;

/**
 * Represents the Home state of the TV.
 * 
 * @author Alex Chandarana
 */
public class HomeState implements State {

    private TV tv;

    /**
     * Creates a HomeState.
     * 
     * @param tv The TV context
     */
    public HomeState(TV tv) {
        this.tv = tv;
    }

    /**
     * Handles home button press.
     */
    @Override
    public void pressHomeButton() {
            System.out.println("TV is already on the Home screen");
        }

    /**
     * Switches to Netflix.
     */
    @Override
    public void pressNetflixButton() {
        tv.setState(tv.getNetflixState());
        System.out.println("Netflix Launched.");
    }

    /**
     * Switches to Hulu.
     */
    @Override
    public void pressHuluButton() {
        tv.setState(tv.getHuluState());
        System.out.println("Hulu Launched.");
    }

    /**
     * Handles movie button press.
     */
    @Override
    public void pressMovieButton() {
        System.out.println("You must open an app to view movies");
    }

    /**
     * Handles TV button press.
     */
    @Override
    public void pressTVButton() {
        System.out.println("You must open an app to view TV shows.");
    }

    /**
     * Attempts to watch a title.
     * 
     * @param title The title to watch
     */
    @Override
    public void watch(String title) {
        System.out.println("You must open an app and watch something");
    }

}
