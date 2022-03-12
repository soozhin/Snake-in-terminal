import java.io.IOException;

public class Model {

    private Controller controller;
    private View view;
    private State state;

    public Model() {
        controller = new Controller(this);
        view = new View(this);
        state = new StartMenu(view);
    }

    /*
     * Update game data
     */
    public synchronized void process(String event) {
        if (event.equals("TIME_ELAPSED")) {
            state = state.processTimeElapsed();
        } else {
            state = state.processKeyTyped(event);
        }
        view.update();
    }

    public State getState() {
        return state;
    }

    /*
     * Start ActionListener
     */
    public void run() throws IOException {
        controller.run();
    }

    /*
     * Start game
     * TODO
     * Do we need to add a try and catch here? Bcaz we might have an exception
     * thrown at this main
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        Model model = new Model();
        try {
            model.run();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
