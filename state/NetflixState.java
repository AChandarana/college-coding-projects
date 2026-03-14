package state;

/**
 * Represents the Netflix state of the TV.
 * 
 * @author Alex Chandarana
 */
public class NetflixState extends Application implements State {

    private TV tv;

    /**
     * Creates a NetflixState.
     * 
     * @param tv The TV context
     */
    public NetflixState(TV tv) {
    super();
    this.tv = tv;

    movies.clear();
    tvShows.clear();

    movies.add("The Irishman");
    movies.add("Don't Look Up");
    movies.add("Extraction");

    tvShows.add("Stranger Things");
    tvShows.add("The Witcher");
    tvShows.add("Wednesday");
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
     * Handles Netflix button press.
     */
    @Override
    public void pressNetflixButton() {
        System.out.println("Already in Netflix.");
    }

    /**
     * Switches to Hulu.
     */
    @Override
    public void pressHuluButton() {
        System.out.println("Launching Hulu.");
        tv.setState(tv.getHuluState());
    }

    /**
     * Displays Netflix movies.
     */
    @Override
    public void pressMovieButton() {
        displayMovies();
    }

    /**
     * Displays Netflix TV shows.
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