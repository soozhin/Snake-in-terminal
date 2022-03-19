import java.util.LinkedList;

public class Snake {

    private int length;
    private int speed;
    private int movementInterval;
    private Boolean lockDirection;
    private int currentSnakeMovingDirection;
    private LinkedList<SnakeBody> snakeBody = new LinkedList<SnakeBody>();
    private final static int INITIAL_LENGTH = 5;
    private SnakeBody previousTail;

    public Snake() {
        this(INITIAL_LENGTH);
    }

    public Snake(int length) {
        this.length = length;
        this.speed = 25;
        this.movementInterval = 0;
        lockDirection = false;
        currentSnakeMovingDirection = 0;
        for (int i = 0; i < length; i++) {
            snakeBody.add(new SnakeBody(20 - i, 10));
        }
    }

    public void moveRight() {
        // Check if can move right
        // Remove last, push at right
        // Set current direction as right
        if (currentSnakeMovingDirection == 180) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX + 1, headY));
            currentSnakeMovingDirection = 0;
        }
    }

    public void moveUp() {
        // Check if can move up
        // Remove last, push at up
        // Set current direction as up
        if (currentSnakeMovingDirection == 270) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX, headY - 1));
            currentSnakeMovingDirection = 90;
        }
    }

    public void moveLeft() {
        // Check if can move left
        // Remove last, push at left
        // Set current direction as left
        if (currentSnakeMovingDirection == 0) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX - 1, headY));
            currentSnakeMovingDirection = 180;
        }
    }

    public void moveDown() {
        // Check if can move down
        // Remove last, push at down
        // Set current direction as down
        if (currentSnakeMovingDirection == 90) {
            continueMoving();
        } else {
            snakeBody.removeLast();
            int headX = (int) snakeBody.peekFirst().getX();
            int headY = (int) snakeBody.peekFirst().getY();
            snakeBody.addFirst(new SnakeBody(headX, headY + 1));
            currentSnakeMovingDirection = 270;
        }
    }

    public void continueMoving() {
        if (movementInterval >= 100) {
            previousTail = snakeBody.getLast();
            switch (currentSnakeMovingDirection) {
                case (0):
                    moveRight();
                    break;
                case (90):
                    moveUp();
                    break;
                case (180):
                    moveLeft();
                    break;
                case (270):
                    moveDown();
                    break;
            }
            movementInterval = 0;
            lockDirection = false;
        }
        movementInterval += speed;
    }

    /*
     * 0 = right
     * 90 = up
     * 180 = left
     * 270 = down
     */
    public void setSnakeDirection(int direction) {
        // If the input is not directly opposite of the currentSnakeMovingDirection
        if (Math.abs(direction - currentSnakeMovingDirection) != 180 && !lockDirection) {
            currentSnakeMovingDirection = direction;
            lockDirection = true;
        }
    }

    public void increaseLength() {
        int previousTailX = previousTail.getX();
        int previousTailY = previousTail.getY();
        snakeBody.add(new SnakeBody(previousTailX, previousTailY));
    }

    public void increaseSpeed() {
        speed *= 2;
    }

    public void decreaseSpeed() {
        speed /= 2;
    }

    public LinkedList<SnakeBody> getSnakeBody() {
        return snakeBody;
    }

}
