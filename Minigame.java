/**
 * Interface for all minigames in the school navigation system
 */
public interface Minigame {
    /**
     * Starts the minigame
     */
    void start();
    
    /**
     * Stops/exits the minigame and returns to room
     */
    void stop();
    
    /**
     * Updates the minigame (called on each frame)
     */
    void update();
    
    /**
     * Handles mouse clicks within the minigame
     */
    void handleClick(double x, double y);
    
    /**
     * Handles key presses within the minigame
     */
    void handleKeyPress(int keyCode);
    
    /**
     * Returns true if the minigame is currently active
     */
    boolean isActive();
    
    /**
     * Gets the name/title of the minigame
     */
    String getName();
    
    /**
     * Called when minigame is completed successfully
     */
    void onComplete();
}
