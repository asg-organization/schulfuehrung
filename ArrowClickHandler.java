/**
 * Handles mouse clicks for arrow navigation
 */
public class ArrowClickHandler implements MausKlickReagierbar {

    @Override
    public void klickReagieren(double x, double y) {
        System.out.println("Klick bei (" + x + ", " + y + ").");

        // Check if an arrow was clicked and navigate
        int targetLocation = Arrows.getClickedArrowTarget(x, y);

        System.out.println("Arrow clicked! Navigating to location: " + targetLocation);
        Main.changeLocation(targetLocation);

    }

    @Override
    public void klickLosgelassenReagieren(double x, double y) {
        // Not needed for our use case
    }
}
