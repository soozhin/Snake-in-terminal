public class GameOverState implements State{

    private View view;

    public GameOverState(View view){
        this.view = view;
    }

    @Override
    public State processTimeElapsed() {
        return this;
    }

    @Override
    public State processKeyTyped(String event) {
        switch(event){
            case(""):
                return new StartMenu(view);
            case("r"):
                return new GameState(view);
            case("q"):
                System.exit(0);
        }
        return this;
    }

    /*
    ########################################
    #                                      #
    #                                      #
    #               GAME OVER              #(16,3)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    #          PRESS R TO RESTART          #(11,10)
    #                                      #
    #  PRESS ENTER TO RETURN TO MAIN MENU  #(3,12)
    #                                      #
    #           PRESS Q TO EXIT            #(13,14)
    #                                      #
    #                                      #
    #                                      #
    #                                      #
    ########################################
    */
    @Override
    public void paint(View view) {
        String gameover = "GAME OVER";
        String restart = "PRESS R TO RESTART";
        String menu = "PRESS ENTER TO RETURN TO MAIN MENU";
        String exit = "PRESS Q TO EXIT";
        view.putString(gameover,16,3);
        view.putString(restart,11,10);
        view.putString(menu,3,12);
        view.putString(exit,13,14);        
    }
    
}
