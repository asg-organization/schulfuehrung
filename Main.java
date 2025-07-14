import java.util.ArrayList;

public class Main {
    public static int currentLocationId = 2;
    public static ArrayList<Location> locations = Locations.getLocations();
    public static SPIEL spiel = new SPIEL(false); // Disable automatic mouse support
    public static TEXT displayText = new TEXT(0, 0, 10, "");

    public static void main(String[] args) {
        // This is the main method. The program starts here.
        // You can create instances of classes and call methods here.
        Locations.fillList(); // Fill the locations list with predefined locations
        Arrows.setPointers(locations.get(currentLocationId).getPointers()); // Set pointers for the current location
        spiel.setzeKamerazoom(7); // Use proper zoom for coordinate system
        spiel.setzeHintergrundgrafik(locations.get(currentLocationId).getImage());
        
        // Center the text on screen (assuming 900x600 window size)
        displayText.setzeMittelpunkt(0, 0); // Center at coordinate origin
        
        // Register our custom click handler for arrow navigation
        ArrowClickHandler clickHandler = new ArrowClickHandler();
        spiel.registriereMausKlickReagierbar(clickHandler);
        
        // Register keyboard handler for reset functionality
        ResetKeyHandler keyHandler = new ResetKeyHandler();
        spiel.registriereTastenReagierbar(keyHandler);
    }
    
    /**
     * Resets the game to the starting location (location 0)
     */
    public static void resetToStart() {
        System.out.println("Resetting to starting location...");
        currentLocationId = 0;
        
        // Reset arrows and background to starting location
        Arrows.setPointers(locations.get(currentLocationId).getPointers());
        spiel.setzeHintergrundgrafik(locations.get(currentLocationId).getImage());
        
        // Clear any error messages
        displayText.setzeInhalt("");
        
        System.out.println("Reset complete! Now at location: " + currentLocationId);
    }

    public static void changeLocation(int newLocationId) {
        if (newLocationId >= 0 && newLocationId < locations.size()) {
            currentLocationId = newLocationId;
            Arrows.setPointers(locations.get(currentLocationId).getPointers());
            spiel.setzeHintergrundgrafik(locations.get(currentLocationId).getImage());
            displayText.setzeInhalt(""); // Clear any error message
        } else {
            System.out.println("Invalid location ID: " + newLocationId);
            spiel.entferneHintergrundgrafik();
            displayText.setzeInhalt("Location not found: " + newLocationId);
            // Re-center the text after changing content
            displayText.setzeMittelpunkt(0, 0);
            Arrows.setPointers(new ArrayList<>()); // Clear pointers if location is invalid
        }
    }
}
