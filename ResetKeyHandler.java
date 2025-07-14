/**
 * Handles keyboard input for reset functionality
 */
public class ResetKeyHandler implements TastenReagierbar {
    
    @Override
    public void tasteReagieren(int taste) {
        // Check if R key was pressed (for Reset)
        if (taste == TASTE.R) {
            System.out.println("Reset key (R) pressed! Resetting to starting location...");
            Main.resetToStart();
        }
    }
    
    @Override
    public void tasteLosgelassenReagieren(int taste) {
        // Not needed for our use case
    }
}
