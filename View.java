public class View {
    private char[][] screen; // [width][height] width x height
    private char[][] panel;
    private int width;
    private int height;
    private Model model;
    public final static int WIDTH = 40;
    public final static int HEIGHT = 20;
    public final static int PANEL_HEIGHT = 2;

    public View(Model model) {
        this(model, WIDTH, HEIGHT);
    }

    public View(Model model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;
        screen = new char[width][height];
        panel = new char[width][PANEL_HEIGHT];
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

    // 0########################################
    // 1########################################(PANEL_HEIGHT - 1)

    /*
     * Deletes everything on panel
     */
    public void clearPanel() {
        for (int y = 0; y < PANEL_HEIGHT; y++) {
            for (int x = 0; x < width; x++) {
                if (y == PANEL_HEIGHT - 1 || x == 0 || x == width - 1)
                    panel[x][y] = '#';
                else
                    panel[x][y] = ' ';
            }
        }
    }

    /*
     * Prints out everything in screen[][] on terminal
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
     * Prints out everything in panel[][] on terminal
     */
    public void paintScreenWithPanel() {
        StringBuffer s = new StringBuffer();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                s.append(screen[x][y]);
            s.append("\n");
        }
        for (int y = 0; y < PANEL_HEIGHT; y++) {
            for (int x = 0; x < width; x++)
                s.append(panel[x][y]);
            s.append("\n");
        }
        System.out.println(s);
    }

    public void put(char c, int x, int y) {
        if (x < 0 || width < x || y < 0 || height < y)
            return;
        screen[x][y] = c;
    }

    public void putString(String s, int x, int y) {
        if (x < 0 || width < x || y < 0 || height < y)
            return;
        for (int i = 0; i < s.length(); i++)
            screen[x + i][y] = s.charAt(i);
    }

    public void putStringInPanel(String s, int x, int y) {
        if (x < 0 || width < x || PANEL_HEIGHT < y)
            return;
        for (int i = 0; i < s.length(); i++)
            panel[x + i][y] = s.charAt(i);
    }

    /*
     * Clear everything on screen
     * Then prints out everything in screen[][] on terminal
     */
    public void update() {
        // Clears the entire terminal
        // According to
        // "https://www.delftstack.com/howto/java/java-clear-console/#:~:text=Use%20ANSI%20Escape%20Codes%20to%20Clear%20Console%20in%20Java,-We%20can%20use&text=To%20clear%20the%20console%20in,command%20to%20clean%20the%20console."
        System.out.print("\033[H\033[2J");
        System.out.flush();
        if (model.getState() instanceof GameState) {
            clear();
            clearPanel();
            model.getState().paint(this);
            paintScreenWithPanel();
        } else {
            clear();
            model.getState().paint(this);
            paint();
        }
    }

}