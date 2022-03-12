public class StartMenu implements State {

    private View view;

    public StartMenu(View view){
        this.view = view;
    }

    @Override
    public State processTimeElapsed() {
        // TODO Auto-generated method stub
        return this;
    }

    @Override
    public State processKeyTyped(String event) {
        switch (event) {
            case ("s"):
                // Start game
                return new GameState(view);
            case ("r"):
                // TODO
                // Check rules
                return new RuleState(view, this);
            case ("q"):
                // Quit game
                System.exit(0);
        }
        return this;
    }


    /*
    ########################################
    #                                      #
    #                                      #
    #              SNAKE GAME              #(15,3)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #            PRESS S TO START          #(13,10)
    #                                      #
    #         PRESS R TO CHECK RULES       #(10,12)
    #                                      #
    #            PRESS Q TO QUIT           #(13,14)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    ########################################
    */
    @Override
    public void paint(View view) {
        // TODO Auto-generated method stub
        String title = "START GAME";
        String start = "PRESS S TO START";
        String rule = "PRESS R TO CHECK RULES";
        String quit = "PRESS Q TO QUIT";
        view.putString(title, 15, 3);
        view.putString(start, 13, 10);
        view.putString(rule, 10, 12);
        view.putString(quit, 13, 14);
    }

}
