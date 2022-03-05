public class View {
    private char[][] screen; // [width][height] width x height
    private int width;
    private int height;
    private Model model;
    private final static int WIDTH = 100;
    private final static int HEIGHT = 100;

    public View(Model model) {
        this(model, WIDTH, HEIGHT);
    }

    public View(Model model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;
        screen = new char[width][height];
        clear();
    }

    /*
     * Deletes everything on screen
     */
    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (y == 0 || y == height - 1 || x == 0 || x == width - 1)
                    screen[x][y] = '#';
                else
                    screen[x][y] = ' ';
            }
        }
    }

    /*
    Prints out everything in screen[][] on terminal
    */
    public void paint() {
        StringBuffer s = new StringBuffer();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                s.append(screen[x][y]);
            s.append("\n");
        }
        System.out.println(s);
    }

    /*
    Clear everything on screen
    Then prints out everything in screen[][] on terminal
    */
    public void update(){
        clear();
        paint();
    }

}