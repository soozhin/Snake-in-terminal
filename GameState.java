public class GameState implements State {

    public View view;
    private Snake snake;

    public GameState(View view) {
        this.view = view;
        snake = new Snake(5);
    }

    public State processTimeElapsed() {
        snake.continueMoving();
        return this;
    }

    public State processKeyTyped(String event) {
        switch (event) {
            case ("up"):
                snake.setSnakeDirection("up");
                break;
            case ("down"):
                snake.setSnakeDirection("down");
                break;
            case ("left"):
                snake.setSnakeDirection("left");
                break;
            case ("right"):
                snake.setSnakeDirection("right");
                break;
            // Pause game
            case (""):
                return new PauseState(view, this);
        }
        return this;
    }

    public void paint(View view) {
        for (SnakeBody snakeBody : snake.getSnakeBody())
            snakeBody.paint(view);
    }

}