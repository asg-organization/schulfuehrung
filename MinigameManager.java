import java.util.HashMap;
import java.util.Map;

/**
 * Manages all minigames and their states
 */
public class MinigameManager {
    private static Map<String, Minigame> locationMinigames = new HashMap<>();
    private static Minigame currentMinigame = null;
    private static String currentLocation = null;
    
    /**
     * Register a minigame for a specific location
     */
    public static void registerMinigame(String locationId, Minigame minigame) {
        locationMinigames.put(locationId, minigame);
    }
    
    /**
     * Check if a location has a minigame available
     */
    public static boolean hasMinigame(String locationId) {
        return locationMinigames.containsKey(locationId);
    }
    
    /**
     * Start the minigame for the current location
     */
    public static boolean startMinigame(String locationId) {
        if (hasMinigame(locationId) && currentMinigame == null) {
            currentMinigame = locationMinigames.get(locationId);
            currentLocation = locationId;
            currentMinigame.start();
            return true;
        }
        return false;
    }
    
    /**
     * Stop the current minigame and return to room navigation
     */
    public static void stopCurrentMinigame() {
        if (currentMinigame != null) {
            currentMinigame.stop();
            currentMinigame = null;
            currentLocation = null;
        }
    }
    
    /**
     * Update the current minigame (called each frame)
     */
    public static void update() {
        if (currentMinigame != null && currentMinigame.isActive()) {
            currentMinigame.update();
        }
    }
    
    /**
     * Handle clicks - route to minigame if active, otherwise to navigation
     */
    public static boolean handleClick(double x, double y) {
        if (currentMinigame != null && currentMinigame.isActive()) {
            currentMinigame.handleClick(x, y);
            return true; // Consumed by minigame
        }
        return false; // Let navigation handle it
    }
    
    /**
     * Handle key presses - route to minigame if active
     */
    public static boolean handleKeyPress(int keyCode) {
        if (currentMinigame != null && currentMinigame.isActive()) {
            currentMinigame.handleKeyPress(keyCode);
            return true; // Consumed by minigame
        }
        return false; // Let navigation handle it
    }
    
    /**
     * Check if any minigame is currently active
     */
    public static boolean isMinigameActive() {
        return currentMinigame != null && currentMinigame.isActive();
    }
    
    /**
     * Get the name of the available minigame for a location
     */
    public static String getMinigameName(String locationId) {
        if (hasMinigame(locationId)) {
            return locationMinigames.get(locationId).getName();
        }
        return null;
    }
}
