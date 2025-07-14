import java.util.ArrayList;

public class Main {
    public static int currentLocationId = 0;
    public static ArrayList<Location> locations = Locations.getLocations();
    public static void main(String[] args) {
        // This is the main method. The program starts here.
        // You can create instances of classes and call methods here.
        SPIEL spiel = new SPIEL();
        Locations.fillList(); // Fill the locations list with predefined locations
        spiel.setzeHintergrundgrafik(locations.get(currentLocationId).getImage());
    }
}
