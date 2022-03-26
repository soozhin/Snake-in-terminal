public class GameState implements State {

    public View view;
    private Snake snake;
    private Food food;

    private int foodEaten;
    private int time;
    private int life;
    private Boolean invulnerability;
    private Boolean autoPilot = true;

    public GameState(View view) {
        this.view = view;
        snake = new Snake(5);
        food = new Food(30, 10);
        time = 0;
        foodEaten = 0;
        invulnerability = false;
        life = 1;
    }

    public State processTimeElapsed() {
        Object snakeHead = snake.getSnakeBody().peekFirst();

        time += Controller.getDelay();

        if (snake.getSnakeBody().size() >= ((View.WIDTH - 2) * (View.HEIGHT - 2) - 1))
            return new GameOverState(view);

        if (life <= 0)
            return new GameOverState(view);
        /*
         * Check if snake is out of bound
         * Check if snake collided with itself
         */
        if (invulnerability) {
            if (Collision.isOutOfBound(snakeHead))
                return new GameOverState(view);
        } else {
            if (Collision.isOutOfBound(snakeHead))
                return new GameOverState(view);
            else if (Collision.checkBodyCollision(snakeHead, snake)) {
                life--;
            }
        }

        if (Collision.checkCollision(snakeHead, food)) {
            snake.increaseLength();
            food.generateFoodPosition(snake);
            foodEaten++;
        }

        /**
         * ########################################
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * # oooo> X #(20,10)
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * # #
         * ########################################
         * # X: 0 TIME PASSED: 00:00 #
         * ########################################
         */
        if (autoPilot)
            snake.autoPilot();
        snake.continueMoving();
        return this;
    }

    public State processKeyTyped(String event) {
        if (!autoPilot) {
            switch (event) {
                case ("up"):
                    snake.setSnakeDirection(90);
                    break;
                case ("down"):
                    snake.setSnakeDirection(270);
                    break;
                case ("left"):
                    snake.setSnakeDirection(180);
                    break;
                case ("right"):
                    snake.setSnakeDirection(0);
                    break;
                case ("z"):
                    toggleInvulnerability();
                    break;
                case ("x"):
                    snake.increaseLength();
                    break;
                case ("c"):
                    snake.increaseSpeed();
                    break;
                case ("v"):
                    snake.decreaseSpeed();
                    break;
                case ("b"):
                    life += 3;
                    break;
                case ("n"):
                    snake.toggleWarping();
                    break;
                // Pause game
                case (""):
                    return new PauseState(view, this);
            }
        }
        return this;
    }

    public void toggleInvulnerability() {
        invulnerability = !invulnerability;
    }

    /*
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * # #
     * ########################################
     * # X: 10 TIME PASSED: xx:xx # (2,0)
     * ########################################
     */
    public void paint(View view) {
        for (SnakeBody snakeBody : snake.getSnakeBody())
            snakeBody.paint(view);
        food.paint(view);
        int minute = time / 60000;
        int second = (time / 1000) % 60;
        String score = "X: " + foodEaten + " TIME PASSED: " + String.format("%02d", minute) + ":"
                + String.format("%02d", second);
        view.putStringInPanel(score, 2, 0);
        // String temp;
        // for (int i = 0; i < food.getSpawnableFoodPosition().size(); i++) {
        // temp = "";
        // for (int j = 0; j < food.getSpawnableFoodPosition().get(i).size(); j++) {
        // temp += "(" + food.getSpawnableFoodPosition().get(i).get(j).x + "," +
        // food.getSpawnableFoodPosition().get(i).get(j).y + "), ";
        // }
        // if (temp != "")
        // System.out.println(temp);
        // }

    }
    
}