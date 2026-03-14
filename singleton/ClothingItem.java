package singleton;

import java.util.ArrayList;

/**
 * Represents a clothing item with name, color, and seasons.
 * @author Alex Chandarana
 */
public class ClothingItem {

    private String name;
    private String color;
    private ArrayList<Season> seasons;

    /**
     * Constructs a clothing item with name and color.
     * @param name the item name
     * @param color the item color
     */
    public ClothingItem(String name, String color) {
        this.name = name;
        this.color = color;
        seasons = new ArrayList<Season>();
    }

    /**
     * Checks if the item is valid for a season.
     * @param season the season to check
     * @return true if available in that season
     */
    public boolean hasSeason(Season season) {
        return seasons.contains(season);
    }

    /**
     * Adds a season to this item.
     * @param season the season to add
     */
    public void addSeason(Season season) {
        seasons.add(season);
    }

    /**
     * Returns formatted name of the clothing item.
     * @return the color and name
     */
    public String toString() {
        return color + " " + name;
    }
}
