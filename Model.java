import java.io.IOException;

public class Model {

    private Controller controller;
    private View view;

    public Model() {
        controller = new Controller(this);
        view = new View(this);
    }

    /*
    *   Update game data
    */
    public synchronized void process(String event){
        if(event.equals("TIME_ELAPSED")){
            ;
        }
        else{
            ;
        }
        view.update();
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
