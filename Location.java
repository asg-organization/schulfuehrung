import java.util.ArrayList;

public class Location {
    private ArrayList<Pointer> pointers;
    private String name;
    private String description;

    private String image;

    public Location(String name, String description, String image) {
        this.name = name;
        this.description = description;

        this.image = image;
        this.pointers = new ArrayList<>();
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
}
