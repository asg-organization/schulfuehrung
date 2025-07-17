public class Pointer {
    private int x;
    private int y;
    private String pointer;
    private int rotation;

    public Pointer(int x, int y, String pointer) {
        this.x = x;
        this.y = y;
        this.pointer = pointer;
        this.rotation = 0; // Default rotation
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public int getRotation() {
        return rotation;
    }

    public Pointer setRotation(int rotation) {
        this.rotation = rotation;
        return this; // Return the current instance for method chaining
    }
}