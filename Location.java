import java.util.ArrayList;

public class Location {
    private ArrayList<Pointer> pointers;
    private String name;
    private String description;
    private String image;
    private boolean hasMinigame;
    private String minigamePrompt; // Text to show when minigame is available

    // Interactive areas for minigames (clickable regions)
    private ArrayList<InteractiveArea> interactiveAreas;

    public Location(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.pointers = new ArrayList<>();
        this.interactiveAreas = new ArrayList<>();
        this.hasMinigame = false;
        this.minigamePrompt = "";
    }

    public ArrayList<Pointer> getPointers() {
        return pointers;
    }

    public void setPointers(ArrayList<Pointer> pointers) {
        this.pointers = pointers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // Minigame-related methods
    public void setMinigame(String prompt) {
        this.hasMinigame = true;
        this.minigamePrompt = prompt;
    }

    public boolean hasMinigame() {
        return hasMinigame;
    }

    public String getMinigamePrompt() {
        return minigamePrompt;
    }

    // Interactive areas for clicking on objects/items in rooms
    public void addInteractiveArea(InteractiveArea area) {
        interactiveAreas.add(area);
    }

    public ArrayList<InteractiveArea> getInteractiveAreas() {
        return interactiveAreas;
    }
}
