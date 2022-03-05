public class PauseState implements State{

    public View view;
    public State savedState;

    public PauseState(View view, State state){
        this.view = view;
        this.savedState = state;
    }

    public State processTimeElapsed(){
        return this;
    }

    public State processKeyTyped(String event){
        if(event.equals("")){
            return savedState;
        }
        else
            return this;
    }

    public void paint(View view){
        view.putString("PAUSE",18,10);
    }
}