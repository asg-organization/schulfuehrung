import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Arrows {
    private static ArrayList<FIGUR> arrowPool = new ArrayList<>(); // Pool of reusable arrows
    private static ArrayList<FIGUR> activeArrows = new ArrayList<>(); // Currently visible arrows
    private static Map<FIGUR, Integer> arrowToLocationMap = new HashMap<>(); // Maps arrows to their target locations

    public static void setPointers(ArrayList<Pointer> pointers) {
        // Hide all currently active arrows and return them to the pool
        for (FIGUR figur : activeArrows) {
            figur.setzeSichtbar(false);
            arrowToLocationMap.remove(figur); // Remove from mapping
            arrowPool.add(figur);
        }
        activeArrows.clear();
        
        // Set up arrows for new pointers
        for (Pointer pointer : pointers) {
            FIGUR figur;
            
            // Reuse existing arrow from pool if available, otherwise create new one
            if (!arrowPool.isEmpty()) {
                figur = arrowPool.remove(arrowPool.size() - 1); // Take from end for efficiency
            } else {
                figur = new FIGUR("images/arrow.png");
            }
            
            // Configure the arrow
            figur.setzeMittelpunkt(pointer.getX(), pointer.getY());
            figur.setzeDrehwinkel(pointer.getRotation());
            figur.setzeSichtbar(true);
            
            // Map this arrow to its target location
            arrowToLocationMap.put(figur, pointer.getPointer());
            
            activeArrows.add(figur);
        }
    }
    
    /**
     * Check if a click at the given coordinates hits any arrow and return the target location ID
     * @param x Click x-coordinate
     * @param y Click y-coordinate
     * @return Target location ID if an arrow was clicked, -1 if no arrow was clicked
     */
    public static int getClickedArrowTarget(double x, double y) {
        for (FIGUR figur : activeArrows) {
            if (figur.beinhaltetPunkt(x, y)) {
                return arrowToLocationMap.get(figur);
            }
        }
        return -1; // No arrow was clicked
    }
}
