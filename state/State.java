package state;

/**
 * Interface defining TV state behavior.
 * 
 * @author Alex Chandarana
 */
public interface State {
    
    /**
     * Handles home button press.
     */
    public void pressHomeButton();

    /**
     * Handles Netflix button press.
     */
    public void pressNetflixButton();

    /**
     * Handles Hulu button press.
     */
    public void pressHuluButton();

    /**
     * Handles movie button press.
     */
    public void pressMovieButton();

    /**
     * Handles TV button press.
     */
    public void pressTVButton();

    /**
     * Plays a selected title.
     * 
     * @param title The title to watch
     */
    public void watch(String title);

}
