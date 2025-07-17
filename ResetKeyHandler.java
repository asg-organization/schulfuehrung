/**
 * Handles keyboard input for reset functionality and minigame controls
 */
public class ResetKeyHandler implements TastenReagierbar {
    
    @Override
    public void tasteReagieren(int taste) {
        // First check if minigame should handle the key
        if (MinigameManager.handleKeyPress(taste)) {
            return; // Minigame consumed the key press
        }
        
        // Check if R key was pressed (for Reset)
        if (taste == TASTE.R) {
            if (MinigameManager.isMinigameActive()) {
                System.out.println("Escape key pressed! Exiting minigame...");
                MinigameManager.stopCurrentMinigame();
            } else {
                System.out.println("Reset key (R) pressed! Resetting to starting location...");
                Main.resetToStart();
            }
        }
        
        // ESC key to exit minigames
        if (taste == 27) { // ESC key code
            if (MinigameManager.isMinigameActive()) {
                System.out.println("Escape key pressed! Exiting minigame...");
                MinigameManager.stopCurrentMinigame();
            }
        }
    }
    
    @Override
    public void tasteLosgelassenReagieren(int taste) {
        // Not needed for our use case
    }
}
