import java.io.IOException;

public class Model {

    private Controller controller;
    private View view;
    private State state;

    public Model() {
        controller = new Controller(this);
        view = new View(this);
        state = new GameState(view);
    }

    /*
    *   Update game data
    */
    public synchronized void process(String event){
        if(event.equals("TIME_ELAPSED")){
            state = state.processTimeElapsed();
        }
        else{
            state = state.processKeyTyped(event);
        }
        view.update();
    }

    public State getState(){
        return state;
    }

    /*
    *   Start ActionListener
    */
    public void run() throws IOException{
        controller.run();
    }

    /*
    *   Start game
    */
    public static void main(String[] args) throws InterruptedException, IOException{
        Model model = new Model();
        model.run();
    }

}
