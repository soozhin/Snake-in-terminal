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
        switch(event){
            case (""):
                return savedState;
            case ("q"):
                // Back to main menu
                return new StartMenu(view);
            case ("r"):
                return new RuleState(view, this);
        }
        return this;
    }

    /*
    ########################################
    #                                      #
    #                                      #
    #                PAUSED                #(17,3)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #        PRESS R TO CHECK RULES        #(9,10)
    #                                      #
    #        PRESS ENTER TO CONTINUE       #(9,12)
    #                                      #
    #    PRESS Q TO RETURN TO MAIN MENU    #(5,14)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    ########################################
    */
    public void paint(View view){
        String pause = "PAUSED";
        String game = "PRESS ENTER TO CONTINUE";
        String menu = "PRESS Q TO RETURN TO MAIN MENU";
        String rules = "PRESS R TO CHECK RULES";
        view.putString(pause,17,3);
        view.putString(game,9,12);
        view.putString(menu,5,14);
        view.putString(rules,9,10);
    }
}