/**
 * Handles mouse clicks for arrow navigation and minigame interactions
 */
public class ArrowClickHandler implements MausKlickReagierbar {

    @Override
    public void klickReagieren(double x, double y) {
        System.out.println("Klick bei (" + x + ", " + y + ").");

        // First check if minigame should handle the click
        if (MinigameManager.handleClick(x, y)) {
            return; // Minigame consumed the click
        }

        // Check for interactive areas in current location
        String currentLocationId = Main.currentLocationId;
        Location currentLocation = Main.locations.get(currentLocationId);
        
        if (currentLocation != null) {
            // Check interactive areas (like minigame triggers)
            for (InteractiveArea area : currentLocation.getInteractiveAreas()) {
                if (area.contains(x, y)) {
                    handleInteractiveAreaClick(area, currentLocationId);
                    return;
                }
            }
        }

        // Check if an arrow was clicked and navigate
        String targetLocation = Arrows.getClickedArrowTarget(x, y);

        if (targetLocation != null) {
            System.out.println("Arrow clicked! Navigating to location: " + targetLocation);
            Main.changeLocation(targetLocation);
        } else {
            System.out.println("Background clicked, ignoring.");
        }
    }
    
    /**
     * Handle clicks on interactive areas
     */
    private void handleInteractiveAreaClick(InteractiveArea area, String locationId) {
        String action = area.getAction();
        System.out.println("Interactive area clicked: " + area.getDescription());
        
        switch (action) {
            case "start_minigame":
                if (MinigameManager.startMinigame(locationId)) {
                    System.out.println("Starting minigame for location: " + locationId);
                } else {
                    System.out.println("No minigame available for this location.");
                }
                break;
            case "examine_object":
                Main.displayText.setzeInhalt("You examine " + area.getDescription());
                Main.displayText.setzeMittelpunkt(0, 0);
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }

    @Override
    public void klickLosgelassenReagieren(double x, double y) {
        // Not needed for our use case
    }
}
