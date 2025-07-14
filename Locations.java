import java.util.ArrayList;

public class Locations {
    private static ArrayList<Location> locations = new ArrayList<>();

    public static void fillList() {
        locations.add(new Location("Forest", "A dense forest with towering trees.", 1, "himmel.jpg"));
        locations.add(new Location("Castle", "An ancient castle with a dark history.", 2, "castle.png"));
        locations.add(new Location("Village", "A small village with friendly inhabitants.", 3, "village.png"));
        // Add more locations as needed
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

}
