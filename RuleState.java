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
    #        USE ARROW KEYS TO MOVE        #(9,10)
    #                                      #
    #         PRESS ENTER TO PAUSE         #(10,12)
    #                                      #
    #    COMSUMPTION OF FOOD WILL RESULT   #(5,14)
    #      IN INCREMENT OF BODY LENGTH     #(7,15)
    #                                      #
    #          <ENTER TO GO BACK>          #(11,17)
    #                                      #
    ########################################
    */

    @Override
    public void paint(View view) {
        // TODO Auto-generated method stub
        String rules = "RULES";
        String arrowkeys = "USE ARROW KEYS TO MOVE";
        String pause = "PRESS ENTER TO PAUSE";
        String food1 = "COMSUMPTION OF FOOD WILL RESULT";
        String food2 = "IN INCREMENT OF BODY LENGTH";
        String back = "<ENTER TO GO BACK>";
        view.putString(rules, 17, 3);
        view.putString(arrowkeys, 9, 10);
        view.putString(pause, 10, 12);
        view.putString(food1, 5, 14);
        view.putString(food2, 7, 15);
        view.putString(back, 11, 17);
    }

}
