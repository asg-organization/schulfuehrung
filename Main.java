import java.util.HashMap;

public class Main {
    public static String currentLocationId = "entrance";
    public static HashMap<String, Location> locations = Locations.getLocations();
    public static SPIEL spiel = new SPIEL(false); // Disable automatic mouse support
    public static TEXT displayText = new TEXT(0, 0, 10, "");

    public static void main(String[] args) {
        // This is the main method. The program starts here.
        // You can create instances of classes and call methods here.
        Locations.fillList(); // Fill the locations list with predefined locations
        
        // Initialize minigames
        initializeMinigames();
        
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
     * Resets the game to the starting location (entrance)
     */
    public static void resetToStart() {
        System.out.println("Resetting to starting location...");
        currentLocationId = "entrance";
        
        // Reset arrows and background to starting location
        Arrows.setPointers(locations.get(currentLocationId).getPointers());
        spiel.setzeHintergrundgrafik(locations.get(currentLocationId).getImage());
        
        // Clear any error messages
        displayText.setzeInhalt("");
        
        System.out.println("Reset complete! Now at location: " + currentLocationId);
    }

    public static void changeLocation(String newLocationId) {
        if (locations.containsKey(newLocationId)) {
            currentLocationId = newLocationId;
            Arrows.setPointers(locations.get(currentLocationId).getPointers());
            spiel.setzeHintergrundgrafik(locations.get(currentLocationId).getImage());
            
            // Check if this location has a minigame and show prompt
            Location newLocation = locations.get(newLocationId);
            if (newLocation.hasMinigame()) {
                displayText.setzeInhalt(newLocation.getMinigamePrompt());
                displayText.setzeMittelpunkt(0, 0);
            } else {
                displayText.setzeInhalt(""); // Clear any previous message
            }
        } else {
            System.out.println("Invalid location ID: " + newLocationId);
            spiel.entferneHintergrundgrafik();
            displayText.setzeInhalt("Location not found: " + newLocationId);
            // Re-center the text after changing content
            displayText.setzeMittelpunkt(0, 0);
            Arrows.setPointers(new java.util.ArrayList<>()); // Clear pointers if location is invalid
        }
    }
    
    /**
     * Initialize all minigames for different locations
     */
    private static void initializeMinigames() {
        // Register minigames for specific locations
        MinigameManager.registerMinigame("chemistry_inside", new ChemistryQuizMinigame());
        
        // Add interactive areas to locations that have minigames
        Location chemLab = locations.get("chemistry_inside");
        if (chemLab != null) {
            chemLab.setMinigame("Click on the experiment table to start a chemistry quiz!");
            // Add clickable area for the experiment table
            chemLab.addInteractiveArea(new InteractiveArea(20, 0, 30, 20, "start_minigame", "experiment table"));
        }
        
        // TODO: Add more minigames for other classrooms
        // MinigameManager.registerMinigame("physics_inside", new PhysicsLabMinigame());
        // MinigameManager.registerMinigame("biology_inside", new BiologyQuizMinigame());
    }
}
