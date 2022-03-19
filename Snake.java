import java.util.LinkedList;

public class Snake {

    private int length;
    private double speed;
    private double movementInterval;
    private String currentSnakeMovingDirection;
    private String inputSnakeMovingDirection;
    private LinkedList<SnakeBody> snakeBody = new LinkedList<SnakeBody>();
    private final static int INITIAL_LENGTH = 5;

    public Snake() {
        this(INITIAL_LENGTH);
    }

    public Snake(int length) {
        this.length = length;
        this.speed = 0.5;
        this.movementInterval = 0;
        currentSnakeMovingDirection = "right";
        for (int i = 0; i < length; i++) {
            snakeBody.add(new SnakeBody(20 - i, 10));
        }
    }

    public void moveUp() {
        // Check if can move up
        // Remove last, push at up
        // Set current direction as up
        if (currentSnakeMovingDirection.equals("down")) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX, headY - 1));
            currentSnakeMovingDirection = "up";
        }
    }

    public void moveDown() {
        // Check if can move down
        // Remove last, push at down
        // Set current direction as down
        if (currentSnakeMovingDirection.equals("up")) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX, headY + 1));
            currentSnakeMovingDirection = "down";
        }
    }

    public void moveLeft() {
        // Check if can move left
        // Remove last, push at left
        // Set current direction as left
        if (currentSnakeMovingDirection.equals("right")) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX - 1, headY));
            currentSnakeMovingDirection = "left";
        }
    }

    public void moveRight() {
        // Check if can move right
        // Remove last, push at right
        // Set current direction as right
        if (currentSnakeMovingDirection.equals("left")) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX + 1, headY));
            currentSnakeMovingDirection = "right";
        }
    }

    public void continueMoving() {
        switch (inputSnakeMovingDirection) {
            case ("up"):
                moveUp();
                break;
            case ("down"):
                moveDown();
                break;
            case ("left"):
                moveLeft();
                break;
            case ("right"):
                moveRight();
                break;
        }
    }

    public void setSnakeDirection(String direction) {
        inputSnakeMovingDirection = direction;
    }

    public LinkedList<SnakeBody> getSnakeBody() {
        return snakeBody;
    }
}
