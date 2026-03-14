package singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Singleton class that creates outfits based on season.
 * @author Alex Chandarana
 */
public class OutfitCreator {

    private HashMap<ClothingPart, ArrayList<ClothingItem>> clothing;
    private Random rand;
    private static OutfitCreator outfitCreator;

    /**
     * Private constructor that loads clothing items.
     */
    private OutfitCreator() {
        rand = new Random();
        clothing = new HashMap<ClothingPart, ArrayList<ClothingItem>>();

        clothing.put(ClothingPart.TOP, FileReader.getTops());
        clothing.put(ClothingPart.BOTTOM, FileReader.getBottoms());
        clothing.put(ClothingPart.WHOLE, FileReader.getWholes());
    }

    /**
     * Returns the single instance of OutfitCreator.
     * @return the singleton instance
     */
    public static OutfitCreator getInstance() {
        if (outfitCreator == null) {
            outfitCreator = new OutfitCreator();
        }
        return outfitCreator;
    }

    /**
     * Generates a random outfit for the given season.
     * @param season the season to filter clothing by
     * @return a formatted outfit string
     */
    public String getOutfit(Season season) {

        ArrayList<ClothingItem> tops = new ArrayList<ClothingItem>();
        ArrayList<ClothingItem> bottoms = new ArrayList<ClothingItem>();
        ArrayList<ClothingItem> wholes = new ArrayList<ClothingItem>();

        for (ClothingItem item : clothing.get(ClothingPart.TOP)) {
            if (item.hasSeason(season)) {
                tops.add(item);
            }
        }

        for (ClothingItem item : clothing.get(ClothingPart.BOTTOM)) {
            if (item.hasSeason(season)) {
                bottoms.add(item);
            }
        }

        for (ClothingItem item : clothing.get(ClothingPart.WHOLE)) {
            if (item.hasSeason(season)) {
                wholes.add(item);
            }
        }

        ClothingItem top = tops.get(rand.nextInt(tops.size()));
        ClothingItem bottom = bottoms.get(rand.nextInt(bottoms.size()));

        return top.toString() + "\n" + bottom.toString();
    }
}
