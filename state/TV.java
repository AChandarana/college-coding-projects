package state;

/**
 * Represents the TV context using state transitions.
 * 
 * @author Alex Chandarana
 */
public class TV {

    private State homeState;
    private State netflixState;
    private State huluState;
    private State state;

    /**
     * Initializes TV states.
     */
    public TV() {
        homeState = new HomeState(this);
        netflixState = new NetflixState(this);
        huluState = new HuluState(this);

        state = homeState;
    }

    /**
     * Presses the home button.
     * 
     * @return Button confirmation message
     */
    public String pressHomeButton() {
        state.pressHomeButton();
        return "Home button pressed";
    }

    /**
     * Presses the Netflix button.
     * 
     * @return Button confirmation message
     */
    public String pressNetflixButton() {
        state.pressNetflixButton();
        return "Netflix button pressed";
    }

    /**
     * Presses the Hulu button.
     * 
     * @return Button confirmation message
     */
    public String pressHuluButton() {
        state.pressHuluButton();
        return "Hulu button pressed";
    }

    /**
     * Presses the movie button.
     * 
     * @return Button confirmation message
     */
    public String pressMovieButton() {
        state.pressMovieButton();
        return "Movie button pressed";
    }

    /**
     * Presses the TV button.
     * 
     * @return Button confirmation message
     */
    public String pressTVButton() {
        state.pressTVButton();
        return "TV button pressed";
    }

    /**
     * Plays a selected title.
     * 
     * @param title The title to watch
     */
    public void watch(String title) {
        state.watch(title);
    }

    /**
     * Sets the current state.
     * 
     * @param state The new state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Returns the home state.
     * 
     * @return Home state
     */
    public State getHomeState() {
        return homeState;
    }

    /**
     * Returns the Netflix state.
     * 
     * @return Netflix state
     */
    public State getNetflixState() {
        return netflixState;
    }

    /**
     * Returns the Hulu state.
     * 
     * @return Hulu state
     */
    public State getHuluState() {
        return huluState;
    }
}
