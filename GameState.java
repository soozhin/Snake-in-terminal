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
                snake.moveUp();
                break;
            case ("down"):
                snake.moveDown();
                break;
            case ("left"):
                snake.moveLeft();
                break;
            case ("right"):
                snake.moveRight();
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