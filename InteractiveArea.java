/**
 * Represents a clickable area in a room that can trigger minigames or interactions
 */
public class InteractiveArea {
    private double x, y; // Center coordinates
    private double width, height; // Dimensions
    private String action; // What happens when clicked (e.g., "start_minigame", "examine_object")
    private String description; // What this area represents
    private boolean visible; // Whether to show visual indicator
    
    public InteractiveArea(double x, double y, double width, double height, String action, String description) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.action = action;
        this.description = description;
        this.visible = true;
    }
    
    /**
     * Check if a point is within this interactive area
     */
    public boolean contains(double clickX, double clickY) {
        return clickX >= (x - width/2) && clickX <= (x + width/2) &&
               clickY >= (y - height/2) && clickY <= (y + height/2);
    }
    
    // Getters
    public double getX() { return x; }
    public double getY() { return y; }
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public String getAction() { return action; }
    public String getDescription() { return description; }
    public boolean isVisible() { return visible; }
    
    // Setters
    public void setVisible(boolean visible) { this.visible = visible; }
    public void setDescription(String description) { this.description = description; }
}
