package state;

import java.util.ArrayList;

/**
 * Represents a streaming application with movies and TV shows.
 * 
 * @author Alex Chandarana
 */
public class Application {

    protected ArrayList<String> movies;
    protected ArrayList<String> tvShows;

    /**
     * Initializes default movies and TV shows.
     */
    public Application() {
        movies = new ArrayList<String>();
        tvShows = new ArrayList<String>();

        movies.add("Inception");
        movies.add("Interstellar");
        movies.add("The Dark Knight");

        tvShows.add("Stranger Things");
        tvShows.add("Breaking Bad");
        tvShows.add("The Office");
    }

    /**
     * Plays the selected title.
     * 
     * @param title The title to watch
     */
        public void watch(String title) {
        if (movies.contains(title) || tvShows.contains(title)) {
            System.out.println("Now watching: " + title);
        } else {
            System.out.println("\"" + title + "\" is not available in this application");
        }
    }

    /**
     * Displays available movies.
     */
    public void displayMovies() {
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(movies.get(i));
        }
    }

    /**
     * Displays available TV shows.
     */
    public void displayTVShows() {
        for (int i = 0; i < tvShows.size(); i++) {
            System.out.println(tvShows.get(i));
        }
    }
}
