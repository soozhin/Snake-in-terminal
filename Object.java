public class Object {

    private int x;
    private int y;
    private char image;

    public Object(int x, int y, char image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    // Get x-coordinate
    public int getX() {
        return x;
    }

    // Get y-coordinate
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Paint
    public void paint(View view) {
        view.put(image, (int) x, (int) y);
    }
}