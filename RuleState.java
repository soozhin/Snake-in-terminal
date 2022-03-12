public class RuleState implements State {

    private View view;
    private State state;

    public RuleState(View view, State state) {
        this.view = view;
        this.state = state;
    }

    @Override
    public State processTimeElapsed() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public State processKeyTyped(String event) {
        // TODO Auto-generated method stub
        switch (event) {
            case (""):
                return state;
        }
        return this;
    }

    /*
    ########################################
    #                                      #
    #                                      #
    #                RULES                 #(17,3)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #        PRESS ENTER TO CONTINUE       #(9,13)
    #                                      #
    #    PRESS Q TO RETURN TO MAIN MENU    #(5,15)
    #                                      #
    #                                      #
    #                                      #
    ########################################
    */

    @Override
    public void paint(View view) {
        // TODO Auto-generated method stub
        String rules = "RULES";
        view.putString(rules, 17, 3);
    }

}
