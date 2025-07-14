import java.util.ArrayList;

public class Locations {
    private static ArrayList<Location> locations = new ArrayList<>();

    public static void fillList() {
        // Entrance location
        Location entrace = new Location("Eingang", "A dense forest with towering trees.", "images/entrance.jpeg");
        ArrayList<Pointer> pointersEntrance = new ArrayList<>();
        pointersEntrance.add(new Pointer(1, -20, -1));
        pointersEntrance.add((new Pointer(40, -30, -2)).setRotation(-45));
        entrace.setPointers(pointersEntrance);
        locations.add(entrace);

    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

}
