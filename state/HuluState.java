package state;

/**
 * Represents the Hulu state of the TV.
 * 
 * @author Alex Chandarana
 */
public class HuluState extends Application implements State {

    private TV tv;

    /**
     * Creates the HuluState.
     * 
     * @param tv The TV context
     */
    public HuluState(TV tv) {
    super();
    this.tv = tv;

    movies.clear();
    tvShows.clear();

    movies.add("Palm Springs");
    movies.add("Prey");
    movies.add("Fresh");

    tvShows.add("The Handmaid's Tale");
    tvShows.add("Only Murders in the Building");
    tvShows.add("The Bear");
}

    /**
     * Returns to the home state.
     */
    @Override
    public void pressHomeButton() {
        System.out.println("Going home.");
        tv.setState(tv.getHomeState());
    }

    /**
     * Switches to Netflix.
     */
    @Override
    public void pressNetflixButton() {
        System.out.println("Launching Netflix.");
        tv.setState(tv.getNetflixState());
    }

    /**
     * Handles Hulu button press.
     */
    @Override
    public void pressHuluButton() {
        System.out.println("Already in Hulu.");
    }

    /**
     * Displays Hulu movies.
     */
    @Override
    public void pressMovieButton() {
        displayMovies();
    }

    /**
     * Displays Hulu TV shows.
     */
    @Override
    public void pressTVButton() {
        displayTVShows();
    }

    /**
     * Plays the selected title.
     * 
     * @param title The title to watch
     */
    @Override
    public void watch(String title) {
        super.watch(title);
    }
}
